package gov.acwi.wqp.etl.state;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.core.job.flow.support.SimpleFlow;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StateTransformation {

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	@Qualifier("deleteState")
	private Tasklet deleteState;

	@Bean
	public Step deleteStateStep() {
		return stepBuilderFactory.get("deleteStateStep").tasklet(deleteState).build();
	}

	@Autowired
	@Qualifier("stateReader")
	private JdbcCursorItemReader<State> stateReader;

	@Autowired
	@Qualifier("stateProcessor")
	private StateProcessor stateProcessor;

	@Autowired
	@Qualifier("stateWriter")
	private JdbcBatchItemWriter<State> stateWriter;

	@Bean
	public Step transformStateStep() {
		return stepBuilderFactory.get("transformStateStep").<State, State>chunk(1000).reader(stateReader)
				.processor(stateProcessor).writer(stateWriter).build();
	}

	@Bean
	public Flow stateFlow() {
		return new FlowBuilder<SimpleFlow>("stateFlow").start(deleteStateStep()).next(transformStateStep()).build();
	}

}
