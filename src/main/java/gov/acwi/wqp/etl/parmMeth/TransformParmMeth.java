package gov.acwi.wqp.etl.parmMeth;

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
public class TransformParmMeth {
	
	@Autowired
	@Qualifier("wqpDataSource")
	DataSource wqpDataSource;

	@Autowired
	@Qualifier("natdbDataSource")
	DataSource natdbDataSource;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	public TransformParmMeth() {
	}
	
	@Bean
	public JdbcCursorItemReader<ParmMeth> parmMethReader() {
		return new JdbcCursorItemReaderBuilder<ParmMeth>()
				.dataSource(natdbDataSource)
				.name("natdbParmMeth")
				.sql("select parm_cd, meth_cd, parm_meth_lgcy_cd, parm_meth_rnd_tx, parm_meth_init_nm, parm_meth_init_dt, parm_meth_rev_nm, parm_meth_rev_dt, parm_meth_vld_fg," + 
						"decode(regexp_instr(parm_meth_rnd_tx, '[1-9]', 1, 1)," + 
						"1, '0.001'," + 
						"2, '0.01', " +
						"3, '0.1'," + 
						"4, '1.'," +
						"5, '10'," +
						"6, '100'," +
						"7, '1000'," +
						"8, '10000'," +
						"9, '100000') multiplier from parm_meth")
				.rowMapper(new ParmMethRowManager())
				.build();
	}

	@Bean
	public ParmMethProcessor parmMethProcessor() {
		return new ParmMethProcessor();
	}

	@Bean
	public JdbcBatchItemWriter<ParmMeth> parmMethWriter() {
		return new JdbcBatchItemWriterBuilder<ParmMeth>()
				.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
				.sql("INSERT INTO parm_meth (parm_cd, meth_cd, parm_meth_lgcy_cd, parm_meth_rnd_tx, parm_meth_init_nm, parm_meth_init_dt, parm_meth_rev_nm, parm_meth_rev_dt, parm_meth_vld_fg, multiplier)" +
						" VALUES (:parmCd, :methCd, :parmMethLgcyCd, :parmMethRndTx, :parmMethInitNm, :parmMethInitDt, :parmMethRevNm, :parmMethRevDt, :parmMethVldFg, :multiplier)")
				.dataSource(wqpDataSource)
				.build();
	}
}
