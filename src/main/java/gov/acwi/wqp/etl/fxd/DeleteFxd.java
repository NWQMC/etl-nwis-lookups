package gov.acwi.wqp.etl.fxd;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import gov.acwi.wqp.etl.BaseDeleteTable;

@Component
@StepScope
public class DeleteFxd extends BaseDeleteTable {
	
	@Autowired
	public DeleteFxd(JdbcTemplate jdbcTemplate) {
		super(jdbcTemplate, "fxd");
	}
}
