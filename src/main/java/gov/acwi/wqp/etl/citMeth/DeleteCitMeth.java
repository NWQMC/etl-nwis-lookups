package main.java.gov.acwi.wqp.etl.citMeth;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import main.java.gov.acwi.wqp.etl.BaseDeleteTable;

@Component
@StepScope
public class DeleteCitMeth extends BaseDeleteTable {
	
	@Autowired
	public DeleteCitMeth(JdbcTemplate jdbcTemplate) {
		super(jdbcTemplate, "cit_meth");
	}
}
