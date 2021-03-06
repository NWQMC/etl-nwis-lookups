package gov.acwi.wqp.etl.latLongDatum;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import gov.acwi.wqp.etl.BaseDeleteTable;

@Component
@StepScope
public class DeleteLatLongDatum extends BaseDeleteTable {
	
	
	@Autowired
	public DeleteLatLongDatum(JdbcTemplate jdbcTemplate) {
		super(jdbcTemplate, "lat_long_datum");
	}

}
