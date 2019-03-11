package gov.acwi.wqp.etl.parmAlias;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import gov.acwi.wqp.etl.BaseDeleteTable;

@Component
@StepScope
public class DeleteParmAlias extends BaseDeleteTable {
	
	@Autowired
	public DeleteParmAlias(JdbcTemplate jdbcTemplate) {
		super(jdbcTemplate, "parm_alias");
	}
}
