package gov.acwi.wqp.etl.hydCondCd;

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
public class TransformHydCondCd {
	
	@Autowired
	@Qualifier("wqpDataSource")
	DataSource wqpDataSource;

	@Autowired
	@Qualifier("natdbDataSource")
	DataSource natdbDataSource;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	public TransformHydCondCd() {
	}
	
	@Bean
	public JdbcCursorItemReader<HydCondCd> hydCondCdReader() {
		return new JdbcCursorItemReaderBuilder<HydCondCd>()
				.dataSource(natdbDataSource)
				.name("natdbHydCondCd")
				.sql("select hyd_cond_cd, hyd_cond_srt_nu, hyd_cond_vld_fg, hyd_cond_nm, hyd_cond_ds from hyd_cond_cd")
				.rowMapper(new HydCondCdRowMapper())
				.build();
	}

	@Bean
	public HydCondCdProcessor hydCondCdProcessor() {
		return new HydCondCdProcessor();
	}

	@Bean
	public JdbcBatchItemWriter<HydCondCd> hydCondCdWriter() {
		return new JdbcBatchItemWriterBuilder<HydCondCd>()
				.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
				.sql("INSERT INTO hyd_cond_cd" + 
						" (hyd_cond_cd, hyd_cond_srt_nu, hyd_cond_vld_fg, hyd_cond_nm, hyd_cond_ds) VALUES (:hydCondCd, :hydCondSrtNu, :hydCondVldFg, :hydCondNm, :hydCondDs)")
				.dataSource(wqpDataSource)
				.build();
	}
}
