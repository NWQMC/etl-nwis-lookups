package gov.acwi.wqp.etl.natAqfr;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import gov.acwi.wqp.etl.BaseDeleteTable;

@Component
@StepScope
public class DeleteNatAqfr extends BaseDeleteTable {
	
	@Autowired
	public DeleteNatAqfr(JdbcTemplate jdbcTemplate) {
		super(jdbcTemplate, "nat_aqfr");
	}
}
