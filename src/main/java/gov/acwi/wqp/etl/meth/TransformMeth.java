package gov.acwi.wqp.etl.meth;

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
public class TransformMeth {
	
	@Autowired
	@Qualifier("wqpDataSource")
	DataSource wqpDataSource;

	@Autowired
	@Qualifier("natdbDataSource")
	DataSource natdbDataSource;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	public TransformMeth() {
	}
	
	@Bean
	public JdbcCursorItemReader<Meth> methReader() {
		return new JdbcCursorItemReaderBuilder<Meth>()
				.dataSource(natdbDataSource)
				.name("natdbMeth")
				.sql("select meth_cd, meth_tp, meth_nm, meth_ds, meth_rnd_owner_cd, discipline_cd, meth_init_nm, meth_init_dt, meth_rev_nm, meth_rev_dt from meth")
				.rowMapper(new MethRowManager())
				.build();
	}

	@Bean
	public MethProcessor methProcessor() {
		return new MethProcessor();
	}

	@Bean
	public JdbcBatchItemWriter<Meth> methWriter() {
		return new JdbcBatchItemWriterBuilder<Meth>()
				.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
				.sql("INSERT INTO meth (meth_cd, meth_tp, meth_nm, meth_ds, meth_rnd_owner_cd, discipline_cd, meth_init_nm, meth_init_dt, meth_rev_nm, meth_rev_dt)" + 
						" VALUES (:methCd, :methTp, :methNm, :methDs, :methRndOwnerCd, :disciplineCd, :methInitNm, :methInitDt, :methRevNm, :methRevDt)")
				.dataSource(wqpDataSource)
				.build();
	}
}
