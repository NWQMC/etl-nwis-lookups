package gov.acwi.wqp.etl.tu;

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
public class TransformTu {
	
	@Autowired
	@Qualifier("wqpDataSource")
	DataSource wqpDataSource;

	@Autowired
	@Qualifier("natdbDataSource")
	DataSource natdbDataSource;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	public TransformTu() {
	}
	
	@Bean
	public JdbcCursorItemReader<Tu> tuReader() {
		return new JdbcCursorItemReaderBuilder<Tu>()
				.dataSource(natdbDataSource)
				.name("natdbTu")
				.sql("select tu_id, tu_1_cd, tu_1_nm, tu_2_cd, tu_2_nm, tu_3_cd, tu_3_nm, tu_4_cd, tu_4_nm, tu_unnm_cd, tu_use_cd, tu_unaccp_rsn_tx, "
						+ "tu_cred_rat_tx, tu_cmplt_rat_cd, tu_curr_rat_cd, tu_phyl_srt_nu, tu_cr, tu_par_id, tu_tax_auth_id, tu_hybr_auth_id, "
						+ "tu_king_id, tu_rnk_id, tu_md from tu")
				.rowMapper(new TuRowManager())
				.build();
	}

	@Bean
	public TuProcessor tuProcessor() {
		return new TuProcessor();
	}

	@Bean
	public JdbcBatchItemWriter<Tu> tuWriter() {
		return new JdbcBatchItemWriterBuilder<Tu>()
				.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
				.sql("INSERT INTO tu (tu_id, tu_1_cd, tu_1_nm, tu_2_cd, tu_2_nm, tu_3_cd, tu_3_nm, tu_4_cd, tu_4_nm, tu_unnm_cd, tu_use_cd, tu_unaccp_rsn_tx, "
						+ "tu_cred_rat_tx, tu_cmplt_rat_cd, tu_curr_rat_cd, tu_phyl_srt_nu, tu_cr, tu_par_id, tu_tax_auth_id, tu_hybr_auth_id, "
						+ "tu_king_id, tu_rnk_id, tu_md) VALUES "
						+ "(:tuId, :tu1Cd, :tu1Nm, :tu2Cd, :tu2Nm, :tu3Cd, :tu3Nm, :tu4Cd, :tu4Nm, :tuUnnmCd, :tuUseCd, :tuUnaccpRsnTx, "
						+ ":tuCredRatTx, :tuCmpltRatCd, :tuCurrRatCd, :tuPhylSrtNu, :tuCr, :tuParId, :tuTaxAuthId, :tuHybrAuthId, "
						+ ":tuKingId, :tuRnkId, :tuMd)")
				.dataSource(wqpDataSource)
				.build();
	}
}
