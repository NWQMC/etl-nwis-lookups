package main.java.gov.acwi.wqp.etl.bodyPart;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import main.java.gov.acwi.wqp.etl.BaseDeleteTable;

@Component
@StepScope
public class DeleteBodyPart extends BaseDeleteTable {
	
	@Autowired
	public DeleteBodyPart(JdbcTemplate jdbcTemplate) {
		super(jdbcTemplate, "body_part");
	}
}
