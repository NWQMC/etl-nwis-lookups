package gov.acwi.wqp.etl.fxd;

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
public class TransformFxd {
	
	@Autowired
	@Qualifier("wqpDataSource")
	DataSource wqpDataSource;

	@Autowired
	@Qualifier("natdbDataSource")
	DataSource natdbDataSource;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	public TransformFxd() {
	}
	
	@Bean
	public JdbcCursorItemReader<Fxd> fxdReader() {
		return new JdbcCursorItemReaderBuilder<Fxd>()
				.dataSource(natdbDataSource)
				.name("natdbFxd")
				.sql("select parm_cd, fxd_va, fxd_nm, fxd_tx, fxd_init_dt, fxd_init_nm, fxd_rev_dt, fxd_rev_nm from fxd")
				.rowMapper(new FxdRowMapper())
				.build();
	}

	@Bean
	public FxdProcessor fxdProcessor() {
		return new FxdProcessor();
	}

	@Bean
	public JdbcBatchItemWriter<Fxd> fxdWriter() {
		return new JdbcBatchItemWriterBuilder<Fxd>()
				.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
				.sql("INSERT INTO fxd" + 
						" (parm_cd, fxd_va, fxd_nm, fxd_tx, fxd_init_dt, fxd_init_nm, fxd_rev_dt, fxd_rev_nm) VALUES (:parmCd, :fxdVa, :fxdNm, :fxdTx, :fxdInitDt, :fxdInitNm, :fxdRevDt, :fxdRevNm)")
				.dataSource(wqpDataSource)
				.build();
	}
}
