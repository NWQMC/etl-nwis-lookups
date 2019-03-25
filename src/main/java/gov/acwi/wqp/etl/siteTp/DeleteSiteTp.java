package gov.acwi.wqp.etl.siteTp;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import gov.acwi.wqp.etl.BaseDeleteTable;

@Component
@StepScope
public class DeleteSiteTp extends BaseDeleteTable {
	
	@Autowired
	public DeleteSiteTp(JdbcTemplate jdbcTemplate) {
		super(jdbcTemplate, "site_tp");
	}
}
