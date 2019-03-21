package gov.acwi.wqp.etl.country;

import javax.sql.DataSource;

import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import gov.acwi.wqp.etl.aqfr.AqfrRowMapper;

@Component
public class TransformCountry {
	
	@Autowired
	@Qualifier("wqpDataSource")
	private DataSource wqpDataSource;

	@Autowired
	@Qualifier("natdbDataSource")
	private DataSource natdbDataSource;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	
	@Bean
	public JdbcCursorItemReader<Country> countryReader() {
		// STORET still has CN as Canada, all but a few NWIS sites have been migrated, 
		// and we never expect data for China, so do not include any CN in NWIS dat
		return new JdbcCursorItemReaderBuilder<Country>()
				.dataSource(natdbDataSource)
				.name("natdbAqfr")
				.sql("select country_cd, country_nm from country where regexp_replace(country_cd, '(^[[:space:]]*|[[:space:]]*$)') != 'CN'")
				.rowMapper(new CountryRowMapper())
				.build();
	}

	@Bean
	public CountryProcessor countryProcessor() {
		return new CountryProcessor();
	}

	@Bean
	public JdbcBatchItemWriter<Country> countryWriter() {
		return new JdbcBatchItemWriterBuilder<Country>()
				.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
				.sql("INSERT INTO country" + 
						" (country_cd, country_nm) VALUES (:countryCd, :countryNm)")
				.dataSource(wqpDataSource)
				.build();
	}
}
