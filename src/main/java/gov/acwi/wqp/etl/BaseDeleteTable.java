package main.java.gov.acwi.wqp.etl;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class BaseDeleteTable implements Tasklet {

	private final JdbcTemplate jdbcTemplate;
	private String tableName;
	
	@Autowired
	public BaseDeleteTable(JdbcTemplate jdbcTemplate, String tableName) {
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
