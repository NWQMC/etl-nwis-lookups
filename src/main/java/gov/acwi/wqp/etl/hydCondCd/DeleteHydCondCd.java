package gov.acwi.wqp.etl.hydCondCd;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import gov.acwi.wqp.etl.BaseDeleteTable;

@Component
@StepScope
public class DeleteHydCondCd extends BaseDeleteTable {
	
	@Autowired
	public DeleteHydCondCd(JdbcTemplate jdbcTemplate) {
		super(jdbcTemplate, "hyd_cond_cd");
	}
}
