package gov.acwi.wqp.etl.parmMeth;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import gov.acwi.wqp.etl.BaseDeleteTable;

@Component
@StepScope
public class DeleteParmMeth extends BaseDeleteTable {
	
	@Autowired
	public DeleteParmMeth(JdbcTemplate jdbcTemplate) {
		super(jdbcTemplate, "parm_meth");
	}
}
