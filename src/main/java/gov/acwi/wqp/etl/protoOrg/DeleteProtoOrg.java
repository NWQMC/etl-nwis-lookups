package gov.acwi.wqp.etl.protoOrg;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import gov.acwi.wqp.etl.BaseDeleteTable;

@Component
@StepScope
public class DeleteProtoOrg extends BaseDeleteTable {
	
	@Autowired
	public DeleteProtoOrg(JdbcTemplate jdbcTemplate) {
		super(jdbcTemplate, "proto_org");
	}
}
