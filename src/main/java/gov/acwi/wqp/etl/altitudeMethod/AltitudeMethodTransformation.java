package main.java.gov.acwi.wqp.etl.altitudeMethod;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.core.job.flow.support.SimpleFlow;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import main.java.gov.acwi.wqp.etl.GwReflist;


@Configuration
public class AltitudeMethodTransformation {

	@Autowired
    public StepBuilderFactory stepBuilderFactory;
	/*
	@Autowired
	@Qualifier("wqpDataSource")
	DataSource wqpDataSource;
	
	@Autowired
	@Qualifier("natdbDataSource")
	DataSource natdbDataSource;
	
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
    
    @Bean
    public Step transformAltitudeMethod() {
        return stepBuilderFactory.get("transformAltitudeMethodStep")
            .<GwReflist, AltitudeMethod> chunk(10)
            .reader(reader())
            .processor(processor())
            .writer(writer())
            .build();
    }
	*/
    
    @Autowired
    @Qualifier("deleteAltitudeMethod")
    private Tasklet deleteAltitudeMethod;
    
    
    
    @Bean 
    public Step deleteAltitudeMethodStep() {
    	return stepBuilderFactory.get("deleteAltitudeMethodStep")
    			.tasklet(deleteAltitudeMethod)
    			.build();
    }
    
    @Autowired
    @Qualifier("gwReflistAltitudeMethodReader")
    private JdbcCursorItemReader<GwReflist> gwReflistAltitudeMethodReader;
    
    @Autowired
    @Qualifier("altitudeMethodProcessor")
    private AltitudeMethodProcessor altitudeMethodProcessor;
    
    @Autowired
    @Qualifier("altitudeMethodWriter")
    private JdbcBatchItemWriter<AltitudeMethod> altitudeMethodWriter;
    
    @Bean
    public Step transformAltitudeMethodStep() {
    	return stepBuilderFactory.get("transformAltitudeMethodStep")
    			.<GwReflist, AltitudeMethod> chunk(10)
                .reader(gwReflistAltitudeMethodReader)
                .processor(altitudeMethodProcessor)
                .writer(altitudeMethodWriter)
                .build();	
    }
    
    @Bean
    public Flow altitudeMethodFlow() {
    	return new FlowBuilder<SimpleFlow>("altitudeMethodFlow")
    			.start(deleteAltitudeMethodStep())
    			.next(transformAltitudeMethodStep())
    			.build();
    }
}
