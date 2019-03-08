package gov.acwi.wqp.etl.latLongMethod;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import gov.acwi.wqp.etl.BaseDeleteTable;

@Component
@StepScope
public class DeleteLatLongMethod extends BaseDeleteTable {
	
	
	@Autowired
	public DeleteLatLongMethod(JdbcTemplate jdbcTemplate) {
		super(jdbcTemplate, "lat_long_method");
	}

}
