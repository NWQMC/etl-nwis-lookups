package gov.acwi.wqp.etl.fxd;

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
public class FxdTransformation {
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	@Qualifier("deleteFxd")
	private Tasklet deleteFxd;
	
	@Autowired
	@Qualifier("fxdReader")
	private JdbcCursorItemReader<Fxd> fxdReader;
	
	@Autowired
	@Qualifier("fxdProcessor")
	private FxdProcessor fxdProcessor;
	
	@Autowired
	@Qualifier("fxdWriter")
	private JdbcBatchItemWriter<Fxd> fxdWriter;
	
	@Bean
	public Step deleteFxdStep() {
		return stepBuilderFactory.get("deleteFxdStep")
				.tasklet(deleteFxd)
				.build();
	}
	
	@Bean
	public Step transformFxdStep() {
		return stepBuilderFactory
				.get("transformFxdStep")
				.<Fxd, Fxd> chunk(1000)
				.reader(fxdReader)
				.processor(fxdProcessor)
				.writer(fxdWriter)
				.build();
	}
	
	@Bean
	public Flow fxdFlow() {
		return new FlowBuilder<SimpleFlow>("fxdFlow")
				.start(deleteFxdStep())
				.next(transformFxdStep())
				.build();
	}

}
