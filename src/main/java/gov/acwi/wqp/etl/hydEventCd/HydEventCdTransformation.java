package gov.acwi.wqp.etl.hydEventCd;

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
public class HydEventCdTransformation {
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	@Qualifier("deleteHydEventCd")
	private Tasklet deleteHydEventCd;
	
	@Autowired
	@Qualifier("hydEventCdReader")
	private JdbcCursorItemReader<HydEventCd> hydEventCdReader;
	
	@Autowired
	@Qualifier("hydEventCdProcessor")
	private HydEventCdProcessor hydEventCdProcessor;
	
	@Autowired
	@Qualifier("hydEventCdWriter")
	private JdbcBatchItemWriter<HydEventCd> hydEventCdWriter;
	
	@Bean
	public Step deleteHydEventCdStep() {
		return stepBuilderFactory.get("deleteHydEventCdStep")
				.tasklet(deleteHydEventCd)
				.build();
	}
	
	@Bean
	public Step transformHydEventCdStep() {
		return stepBuilderFactory
				.get("transformHydEventCdStep")
				.<HydEventCd, HydEventCd> chunk(1000)
				.reader(hydEventCdReader)
				.processor(hydEventCdProcessor)
				.writer(hydEventCdWriter)
				.build();
	}
	
	@Bean
	public Flow hydEventCdFlow() {
		return new FlowBuilder<SimpleFlow>("hydEventCdFlow")
				.start(deleteHydEventCdStep())
				.next(transformHydEventCdStep())
				.build();
	}

}
