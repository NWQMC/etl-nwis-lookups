package gov.acwi.wqp.etl.state;

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
public class TransformState {

	@Autowired
	@Qualifier("wqpDataSource")
	private DataSource wqpDataSource;

	@Autowired
	@Qualifier("natdbDataSource")
	private DataSource natdbDataSource;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	
	@Bean
	public JdbcCursorItemReader<State> stateReader() {
		return new JdbcCursorItemReaderBuilder<State>().dataSource(natdbDataSource).name("natdbState").sql(
				"select country_cd, state_cd, state_nm, state_post_cd, state_max_lat_va, state_min_lat_va, state_max_long_va, state_min_long_va, state_max_alt_va, state_min_alt_va, state_md from state")
				.rowMapper(new StateRowMapper()).build();
	}

	@Bean
	public StateProcessor stateProcessor() {
		return new StateProcessor();
	}

	@Bean
	public JdbcBatchItemWriter<State> stateWriter() {
		return new JdbcBatchItemWriterBuilder<State>()
				.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
				.sql("INSERT INTO state"
						+ " (country_cd, state_cd, state_nm, state_post_cd, state_max_lat_va, state_min_lat_va, state_max_long_va, state_min_long_va, state_max_alt_va, state_min_alt_va, state_md) "
						+ "VALUES (:countryCd, :stateCd, :stateNm, :statePostCd, :stateMaxLatVa, :stateMinLatVa, :stateMaxLongVa, :stateMinLongVa, :stateMaxAltVa, :stateMinAltVa, :stateMd)")
				.dataSource(wqpDataSource).build();
	}
}
