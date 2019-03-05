package main.java.gov.acwi.wqp.etl.altitudeMethod;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class BaseDeleteMethod implements Tasklet {

	private final JdbcTemplate jdbcTemplate;
	private String tableName;
	
	@Autowired
	public BaseDeleteMethod(JdbcTemplate jdbcTemplate, String tableName) {
		this.jdbcTemplate = jdbcTemplate;
		this.tableName = tableName;
	}

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		String sql = new String("delete from " + tableName);
		jdbcTemplate.execute(sql);
		
		return RepeatStatus.FINISHED;
	}

}
