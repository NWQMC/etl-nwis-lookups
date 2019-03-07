package gov.acwi.wqp.etl.county;

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

@Component
public class TransformCounty {
	
	@Autowired
	@Qualifier("wqpDataSource")
	DataSource wqpDataSource;

	@Autowired
	@Qualifier("natdbDataSource")
	DataSource natdbDataSource;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	public TransformCounty() {
	}
	
	@Bean
	public JdbcCursorItemReader<County> countyReader() {
		return new JdbcCursorItemReaderBuilder<County>()
				.dataSource(natdbDataSource)
				.name("natdbCounty")
				.sql(new String("select country_cd, state_cd, county_cd, county_nm, county_max_lat_va, county_min_lat_va, county_max_long_va, county_min_long_va, county_max_alt_va, county_min_alt_va, county_md from county"))
				.rowMapper(new CountyRowMapper())
				.build();
	}

	@Bean
	public CountyProcessor countyProcessor() {
		return new CountyProcessor();
	}

	@Bean
	public JdbcBatchItemWriter<County> countyWriter() {
		return new JdbcBatchItemWriterBuilder<County>()
				.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
				.sql("INSERT INTO county" + 
						" (country_cd, state_cd, county_cd, county_nm, county_max_lat_va, county_min_lat_va, county_max_long_va, county_min_long_va, county_max_alt_va, county_min_alt_va, county_md) VALUES (:countryCd, :stateCd, :countyCd, :countyNm, :countyMaxLatVa, :countyMinLatVa, :countyMaxLongVa, :countyMinLongVa, :countyMaxAltVa, :countyMinAltVa, :countyMd)")
				.dataSource(wqpDataSource)
				.build();
	}
}
