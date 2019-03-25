package gov.acwi.wqp.etl.valQualCd;

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
public class TransformValQualCd {
	
	@Autowired
	@Qualifier("wqpDataSource")
	private DataSource wqpDataSource;

	@Autowired
	@Qualifier("natdbDataSource")
	private DataSource natdbDataSource;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	
	@Bean
	public JdbcCursorItemReader<ValQualCd> valQualCdReader() {
		return new JdbcCursorItemReaderBuilder<ValQualCd>()
				.dataSource(natdbDataSource)
				.name("natdbValQualCd")
				.sql("select val_qual_cd, val_qual_tp, val_qual_srt_nu, val_qual_vld_fg, val_qual_nm, val_qual_ds from val_qual_cd")
				.rowMapper(new ValQualCdRowManager())
				.build();
	}

	@Bean
	public ValQualCdProcessor valQualCdProcessor() {
		return new ValQualCdProcessor();
	}

	@Bean
	public JdbcBatchItemWriter<ValQualCd> valQualCdWriter() {
		return new JdbcBatchItemWriterBuilder<ValQualCd>()
				.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
				.sql("INSERT INTO val_qual_cd (val_qual_cd, val_qual_tp, val_qual_srt_nu, val_qual_vld_fg, val_qual_nm, val_qual_ds) "
						+ "VALUES (:valQualCd, :valQualTp, :valQualSrtNu, :valQualVldFg, :valQualNm, :valQualDs)")
				.dataSource(wqpDataSource)
				.build();
	}
}
