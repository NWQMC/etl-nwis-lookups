package gov.acwi.wqp.etl.meth;

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
public class MethTransformation {
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	@Qualifier("deleteMeth")
	private Tasklet deleteMeth;
	
	@Autowired
	@Qualifier("methReader")
	private JdbcCursorItemReader<Meth> methReader;
	
	@Autowired
	@Qualifier("methProcessor")
	private MethProcessor methProcessor;
	
	@Autowired
	@Qualifier("methWriter")
	private JdbcBatchItemWriter<Meth> methWriter;
	
	@Bean
	public Step deleteMethStep() {
		return stepBuilderFactory.get("deleteMethStep")
				.tasklet(deleteMeth)
				.build();
	}
	
	@Bean
	public Step transformMethStep() {
		return stepBuilderFactory
				.get("transformMethStep")
				.<Meth, Meth> chunk(1000)
				.reader(methReader)
				.processor(methProcessor)
				.writer(methWriter)
				.build();
	}
	
	@Bean
	public Flow methFlow() {
		return new FlowBuilder<SimpleFlow>("methFlow")
				.start(deleteMethStep())
				.next(transformMethStep())
				.build();
	}

}
