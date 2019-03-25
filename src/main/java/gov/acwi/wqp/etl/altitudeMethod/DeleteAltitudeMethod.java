package gov.acwi.wqp.etl.altitudeMethod;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import gov.acwi.wqp.etl.BaseDeleteTable;

@Component
@StepScope
public class DeleteAltitudeMethod extends BaseDeleteTable {
	
	
	@Autowired
	public DeleteAltitudeMethod(JdbcTemplate jdbcTemplate) {
		super(jdbcTemplate, "altitude_method");
	}

}
