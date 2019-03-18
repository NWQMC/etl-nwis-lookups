package gov.acwi.wqp.etl.parm;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import gov.acwi.wqp.etl.JobCompletionNotificationListener;

@Component
public class AddMultiplierColumn implements Tasklet {
	
	private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

	@Autowired
	@Qualifier("wqpDataSource")
	DataSource wqpDataSource;
	
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		
		JdbcTemplate wqpJdbcTemplate = new JdbcTemplate(wqpDataSource);
		
		wqpJdbcTemplate.batchUpdate("update parm set multiplier = m.multiplier from (select parm_meth.multiplier, parm_cd from parm_meth) m where m.parm_cd = regexp_replace(parm.parm_cd, '(^[[:space:]]*|[[:space:]]*$)', '')");
		return RepeatStatus.FINISHED;
	}

}
