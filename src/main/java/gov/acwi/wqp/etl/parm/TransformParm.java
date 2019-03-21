package gov.acwi.wqp.etl.parm;

import javax.sql.DataSource;

import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

@Component
public class TransformParm {
	
	@Autowired
	@Qualifier("wqpDataSource")
	private DataSource wqpDataSource;

	@Autowired
	@Qualifier("natdbDataSource")
	private DataSource natdbDataSource;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Value("classpath:sql/parm.sql")
	private Resource resource;
	
	
	@Bean
	public JdbcCursorItemReader<Parm> parmReader() throws Exception{
		return new JdbcCursorItemReaderBuilder<Parm>()
				.dataSource(natdbDataSource)
				.name("natdbParm")
				.sql(new String(FileCopyUtils.copyToByteArray(resource.getInputStream())))
				.rowMapper(new ParmRowManager())
				.build();
	}

	@Bean
	public ParmProcessor parmProcessor() {
		return new ParmProcessor();
	}

	@Bean
	public JdbcBatchItemWriter<Parm> parmWriter() {
		return new JdbcBatchItemWriterBuilder<Parm>()
				.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
				.sql("INSERT INTO parm (parm_cd, parm_nm, parm_rmk_tx, parm_unt_tx, "
						+ "parm_seq_nu, parm_seq_grp_cd, parm_ds, parm_medium_tx, "
						+ "parm_frac_tx, parm_temp_tx, parm_stat_tx, parm_tm_tx, parm_wt_tx, "
						+ "parm_size_tx, parm_entry_fg, parm_public_fg, parm_neg_fg, "
						+ "parm_zero_fg, parm_null_fg, parm_ts_fg, parm_init_dt, parm_init_nm, "
						+ "parm_rev_dt, parm_rev_nm, parm_seq_grp_nm, wqpcrosswalk, srsname) "
						+ " VALUES (:parmCd, :parmNm, :parmRmkTx, :parmUntTx, "
						+ ":parmSeqNu, :parmSeqGrpCd, :parmDs, :parmMediumTx, :parmFracTx, "
						+ ":parmTempTx, :parmStatTx, :parmTmTx, :parmWtTx, :parmSizeTx, "
						+ ":parmEntryFg, :parmPublicFg, :parmNegFg, :parmZeroFg, :parmNullFg, "
						+ ":parmTsFg, :parmInitDt, :parmInitNm, :parmRevDt, :parmRevNm, "
						+ ":parmSeqGrpNm, :wqpcrosswalk, :srsname)")
				.dataSource(wqpDataSource)
				.build();
	}
}
