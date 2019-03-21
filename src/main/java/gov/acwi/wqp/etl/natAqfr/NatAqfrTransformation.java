package gov.acwi.wqp.etl.natAqfr;

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
public class NatAqfrTransformation {
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	@Qualifier("deleteNatAqfr")
	private Tasklet deleteNatAqfr;
	
	@Autowired
	@Qualifier("natAqfrReader")
	private JdbcCursorItemReader<NatAqfr> natAqfrReader;
	
	@Autowired
	@Qualifier("natAqfrProcessor")
	private NatAqfrProcessor natAqfrProcessor;
	
	@Autowired
	@Qualifier("natAqfrWriter")
	private JdbcBatchItemWriter<NatAqfr> natAqfrWriter;
	
	@Bean
	public Step deleteNatAqfrStep() {
		return stepBuilderFactory.get("deleteNatAqfrStep")
				.tasklet(deleteNatAqfr)
				.build();
	}
	
	@Bean
	public Step transformNatAqfrStep() {
		return stepBuilderFactory
				.get("transformNatAqfrStep")
				.<NatAqfr, NatAqfr> chunk(1000)
				.reader(natAqfrReader)
				.processor(natAqfrProcessor)
				.writer(natAqfrWriter)
				.build();
	}
	
	@Bean
	public Flow natAqfrFlow() {
		return new FlowBuilder<SimpleFlow>("natAqfrFlow")
				.start(deleteNatAqfrStep())
				.next(transformNatAqfrStep())
				.build();
	}

}
