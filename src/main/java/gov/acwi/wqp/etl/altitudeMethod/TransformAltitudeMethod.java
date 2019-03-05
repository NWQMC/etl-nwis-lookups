package main.java.gov.acwi.wqp.etl.altitudeMethod;

import javax.sql.DataSource;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import main.java.gov.acwi.wqp.etl.GwReflist;
import main.java.gov.acwi.wqp.etl.GwReflistRowMapper;

@Component
public class TransformAltitudeMethod {
	
	@Autowired
	@Qualifier("wqpDataSource")
	DataSource wqpDataSource;
	
	@Autowired
	@Qualifier("natdbDataSource")
	DataSource natdbDataSource;
	
	@Autowired
    public StepBuilderFactory stepBuilderFactory;
	
	@Bean
    public JdbcCursorItemReader<GwReflist> gwReflistAltitudeMethodReader() {
        return new JdbcCursorItemReaderBuilder<GwReflist>()
            .dataSource(natdbDataSource)
            .name("natdbGwReflist")
            .sql(new String("select * from gw_reflist where gw_ed_tbl_nm = 'saltmt'"))
            .rowMapper(new GwReflistRowMapper())
            .build();
    }

    @Bean
    public AltitudeMethodProcessor altitudeMethodProcessor() {
        return new AltitudeMethodProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<AltitudeMethod> altitudeMethodWriter() {
        return new JdbcBatchItemWriterBuilder<AltitudeMethod>()
            .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
            .sql("INSERT INTO altitude_method (code, name, sort_order, description, valid_flag) VALUES (:code, :name, :sortOrder, :description, :validFlag)")
            .dataSource(wqpDataSource)
            .build();
    }

}
