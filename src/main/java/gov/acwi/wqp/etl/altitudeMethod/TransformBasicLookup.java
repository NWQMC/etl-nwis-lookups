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

public abstract class TransformBasicLookup {
	
	private String sourceTableName;
	private String destTableName;
	
	public String getSourceTableName() {
		return sourceTableName;
	}

	public void setSourceTableName(String sourceTableName) {
		this.sourceTableName = sourceTableName;
	}

	public String getDestTableName() {
		return destTableName;
	}

	public void setDestTableName(String destTableName) {
		this.destTableName = destTableName;
	}
	
	@Autowired
	@Qualifier("wqpDataSource")
	DataSource wqpDataSource;
	
	@Autowired
	@Qualifier("natdbDataSource")
	DataSource natdbDataSource;
	
	@Autowired
    public StepBuilderFactory stepBuilderFactory;
	
	public TransformBasicLookup(String sourceTableName, String destTableName) {
		this.sourceTableName = sourceTableName;
		this.destTableName = destTableName;
	}
	
	@Bean
    public JdbcCursorItemReader<GwReflist> gwReflistReader() {
        return new JdbcCursorItemReaderBuilder<GwReflist>()
            .dataSource(natdbDataSource)
            .name("natdbGwReflist")
            .sql(new String("select * from gw_reflist where gw_ed_tbl_nm = '" + sourceTableName + "'"))
            .rowMapper(new GwReflistRowMapper())
            .build();
    }

	@Bean
    public BasicLookupProcessor basicLookupProcessor() {
        return new BasicLookupProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<BasicLookup> basicLookupWriter() {
        return new JdbcBatchItemWriterBuilder<BasicLookup>()
            .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
            .sql("INSERT INTO " + destTableName + " (code, name, sort_order, description, valid_flag) VALUES (:code, :name, :sortOrder, :description, :validFlag)")
            .dataSource(wqpDataSource)
            .build();
    }

}
