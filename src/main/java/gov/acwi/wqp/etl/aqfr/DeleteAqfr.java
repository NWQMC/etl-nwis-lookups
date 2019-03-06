package main.java.gov.acwi.wqp.etl.aqfr;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import main.java.gov.acwi.wqp.etl.BaseDeleteTable;

@Component
@StepScope
public class DeleteAqfr extends BaseDeleteTable {
	
	@Autowired
	public DeleteAqfr(JdbcTemplate jdbcTemplate) {
		super(jdbcTemplate, "aqfr");
	}
}
