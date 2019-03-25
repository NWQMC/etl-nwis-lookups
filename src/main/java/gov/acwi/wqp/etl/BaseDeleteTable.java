package gov.acwi.wqp.etl;

import java.util.HashMap;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

public abstract class BaseDeleteTable implements Tasklet {

	private final JdbcTemplate jdbcTemplate;
	private String tableName;
	
	public static final String FUNCTION_NAME = "truncate_table";
	public static final String SCHEMA_NAME = "nwis_ws_star";
	
	@Autowired
	public BaseDeleteTable(JdbcTemplate jdbcTemplate, String tableName) {
		this.jdbcTemplate = jdbcTemplate;
		this.tableName = tableName;
	}

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate).withSchemaName(SCHEMA_NAME).withFunctionName(FUNCTION_NAME);
		
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("table_name", tableName);

		call.execute(params);
		
		return RepeatStatus.FINISHED;
	}

}
