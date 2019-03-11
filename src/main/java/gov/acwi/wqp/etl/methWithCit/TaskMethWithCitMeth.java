package gov.acwi.wqp.etl.methWithCit;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import gov.acwi.wqp.etl.JobCompletionNotificationListener;

@Component
public class TaskMethWithCitMeth implements Tasklet {
		
	private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

	@Autowired
	@Qualifier("wqpDataSource")
	DataSource wqpDataSource;

	
	@Autowired
	@Qualifier("natdbDataSource")
	DataSource natdbDataSource;

	
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		String sql = new String("select meth.meth_cd, meth.meth_nm, min(cit_meth.cit_nm) cit_nm from meth left join cit_meth on meth.meth_cd = cit_meth.meth_cd group by meth.meth_cd, meth.meth_nm");

		JdbcTemplate natdbJdbcTemplate = new JdbcTemplate(natdbDataSource);
		JdbcTemplate wqpJdbcTemplate = new JdbcTemplate(wqpDataSource);
		
		List <MethWithCit> rows = natdbJdbcTemplate.query(sql, new MethWithCitRowManager());
		
		log.info("Selected row count: " + rows.size());
		
		wqpJdbcTemplate.batchUpdate("INSERT INTO meth_with_cit (meth_cd, meth_nm, cit_nm) VALUES (?, ?, ?)",
				new BatchPreparedStatementSetter() {
					public void setValues(PreparedStatement ps, int i) throws SQLException {
						ps.setString(1,  rows.get(i).getMethCd());
						ps.setString(2,  rows.get(i).getMethNm());
						ps.setString(3,  rows.get(i).getCitNm());
					}
					
					public int getBatchSize() {
						return rows.size();
					}
		} );
		
		return RepeatStatus.FINISHED;
	}
}
