package gov.acwi.wqp.etl.parm;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.core.job.flow.support.SimpleFlow;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import gov.acwi.wqp.etl.parmMeth.ParmMeth;

@Configuration
public class ParmTransformation {
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	@Qualifier("deleteParm")
	private Tasklet deleteParm;
	
	@Bean
	public Step deleteParmStep() {
		return stepBuilderFactory.get("deleteParmStep")
				.tasklet(deleteParm)
				.build();
	}
	
	@Autowired
	@Qualifier("parmReader")
	private JdbcCursorItemReader<Parm> parmReader;
	
	@Autowired
	@Qualifier("parmProcessor")
	private ParmProcessor parmProcessor;
	
	@Autowired
	@Qualifier("parmWriter")
	private JdbcBatchItemWriter<Parm> parmWriter;
	
	@Autowired
	@Qualifier("addMultiplierColumn")
	private Tasklet addMultiplierColumn;
	
	@Bean 
	public Step addMultiplierColumnStep() {
		return stepBuilderFactory.get("addMultiplierColumnStep")
				.tasklet(addMultiplierColumn)
				.build();
	}
	
	
	@Bean
	public Step transformParmStep() {
		return stepBuilderFactory
				.get("transformParmStep")
				.<Parm, Parm> chunk(1000)
				.reader(parmReader)
				.processor(parmProcessor)
				.writer(parmWriter)
				.build();
	}
	
	@Bean
	public Flow parmFlow() {
		return new FlowBuilder<SimpleFlow>("parmFlow")
				.start(deleteParmStep())
				.next(transformParmStep())
				.next(addMultiplierColumnStep())
				.build();
	}

}
