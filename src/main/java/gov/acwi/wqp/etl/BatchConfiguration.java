package main.java.gov.acwi.wqp.etl;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.core.job.flow.support.SimpleFlow;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
	
	@Autowired
	@Qualifier("wqpDataSource")
	DataSource wqpDataSource;
	
	@Autowired
	@Qualifier("natdbDataSource")
	DataSource natdbDataSource;
	
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;
    
    @Autowired
    @Qualifier("deleteAltitudeMethod")
    private Tasklet deleteAltitudeMethod;
    
    @Bean
    public JdbcCursorItemReader<GwReflist> reader() {
        return new JdbcCursorItemReaderBuilder<GwReflist>()
            .dataSource(natdbDataSource)
            .name("natdbGwReflist")
            .sql(new String("select * from gw_reflist where gw_ed_tbl_nm = 'saltmt'"))
            .rowMapper(new GwReflistRowMapper())
            .build();
    }

    @Bean
    public AltitudeMethodProcessor processor() {
        return new AltitudeMethodProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<AltitudeMethod> writer() {
        return new JdbcBatchItemWriterBuilder<AltitudeMethod>()
            .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
            .sql("INSERT INTO altitude_method (code, name, sort_order, description, valid_flag) VALUES (:code, :name, :sortOrder, :description, :validFlag)")
            .dataSource(wqpDataSource)
            .build();
    }
    // end::readerwriterprocessor[]
    
    
    @Bean 
    public Step deleteAltitudeMethodStep() {
    	return stepBuilderFactory.get("deleteAltitudeMethodStep")
    			.tasklet(deleteAltitudeMethod)
    			.build();
    }
    
    @Bean
    public Step transformAltitudeMethodStep() {
        return stepBuilderFactory.get("transformAltitudeMethod")
            .<GwReflist, AltitudeMethod> chunk(10)
            .reader(reader())
            .processor(processor())
            .writer(writer())
            .build();
    }
    

    // tag::jobstep[]
    @Bean
    public Job importUserJob(JobCompletionNotificationListener listener) {
        return jobBuilderFactory.get("importUserJob")
            .listener(listener)
            .start(deleteAltitudeMethodStep())
            .next(transformAltitudeMethodStep())
            .build();
    }

    
    // end::jobstep[]
}
