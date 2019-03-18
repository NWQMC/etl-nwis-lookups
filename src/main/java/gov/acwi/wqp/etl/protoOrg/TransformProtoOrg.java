package gov.acwi.wqp.etl.protoOrg;

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
public class TransformProtoOrg {
	
	@Autowired
	@Qualifier("wqpDataSource")
	DataSource wqpDataSource;

	@Autowired
	@Qualifier("natdbDataSource")
	DataSource natdbDataSource;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	public TransformProtoOrg() {
	}
	
	@Bean
	public JdbcCursorItemReader<ProtoOrg> protoOrgReader() {
		return new JdbcCursorItemReaderBuilder<ProtoOrg>()
				.dataSource(natdbDataSource)
				.name("natdbProtoOrg")
				.sql("select proto_org_cd, proto_org_nm, proto_org_fv_cd, proto_org_vld_fg, proto_org_init_nm, proto_org_init_dt, proto_org_rev_nm, proto_org_rev_dt " + 
						"from proto_org")
				.rowMapper(new ProtoOrgRowManager())
				.build();
	}

	@Bean
	public ProtoOrgProcessor protoOrgProcessor() {
		return new ProtoOrgProcessor();
	}

	@Bean
	public JdbcBatchItemWriter<ProtoOrg> protoOrgWriter() {
		return new JdbcBatchItemWriterBuilder<ProtoOrg>()
				.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
				.sql("INSERT INTO proto_org(proto_org_cd, proto_org_nm, proto_org_fv_cd, proto_org_vld_fg, proto_org_init_nm, proto_org_init_dt, proto_org_rev_nm, proto_org_rev_dt)" + 
						" VALUES (:protoOrgCd, :protoOrgNm, :protoOrgFvCd, :protoOrgVldFg, :protoOrgInitNm, :protoOrgInitDt, :protoOrgRevNm, :protoOrgRevDt)")
				.dataSource(wqpDataSource)
				.build();
	}
}
