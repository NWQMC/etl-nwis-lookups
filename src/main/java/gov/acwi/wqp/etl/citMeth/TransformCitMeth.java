package gov.acwi.wqp.etl.citMeth;

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
public class TransformCitMeth {
	
	@Autowired
	@Qualifier("wqpDataSource")
	DataSource wqpDataSource;

	@Autowired
	@Qualifier("natdbDataSource")
	DataSource natdbDataSource;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	public TransformCitMeth() {
	}
	
	@Bean
	public JdbcCursorItemReader<CitMeth> citMethReader() {
		return new JdbcCursorItemReaderBuilder<CitMeth>()
				.dataSource(natdbDataSource)
				.name("natdbcitMeth")
				.sql("select cit_meth_id, meth_cd, cit_nm, cit_meth_no, meth_src_cd, cit_meth_init_nm, cit_meth_init_dt, cit_meth_rev_nm, cit_meth_rev_dt from cit_meth")
				.rowMapper(new CitMethRowMapper())
				.build();
	}

	@Bean
	public CitMethProcessor citMethProcessor() {
		return new CitMethProcessor();
	}

	@Bean
	public JdbcBatchItemWriter<CitMeth> citMethWriter() {
		return new JdbcBatchItemWriterBuilder<CitMeth>()
				.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
				.sql("INSERT INTO cit_meth" + 
						" (cit_meth_id, meth_cd, cit_nm, cit_meth_no, meth_src_cd, cit_meth_init_nm, cit_meth_init_dt, cit_meth_rev_nm, cit_meth_rev_dt) VALUES (:citMethId, :methCd, :citNm, :citMethNo, :methSrcCd,  :citMethInitNm, :citMethInitDt, :citMethRevNm, :citMethRevDt)")
				.dataSource(wqpDataSource)
				.build();
	}
}
