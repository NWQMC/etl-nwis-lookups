package main.java.gov.acwi.wqp.etl.altitudeMethod;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@StepScope
public class DeleteAltitudeMethod implements Tasklet {
	
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public DeleteAltitudeMethod(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		String sql = new String("delete from altitude_method");
		jdbcTemplate.execute(sql);
		
		return RepeatStatus.FINISHED;
	}

}
