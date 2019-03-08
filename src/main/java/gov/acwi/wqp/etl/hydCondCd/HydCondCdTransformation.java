package gov.acwi.wqp.etl.hydCondCd;

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
public class HydCondCdTransformation {
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	@Qualifier("deleteHydCondCd")
	private Tasklet deleteHydCondCd;
	
	@Bean
	public Step deleteHydCondCdStep() {
		return stepBuilderFactory.get("deleteHydCondCdStep")
				.tasklet(deleteHydCondCd)
				.build();
	}
	
	@Autowired
	@Qualifier("hydCondCdReader")
	private JdbcCursorItemReader<HydCondCd> hydCondCdReader;
	
	@Autowired
	@Qualifier("hydCondCdProcessor")
	private HydCondCdProcessor hydCondCdProcessor;
	
	@Autowired
	@Qualifier("hydCondCdWriter")
	private JdbcBatchItemWriter<HydCondCd> hydCondCdWriter;
	
	@Bean
	public Step transformHydCondCdStep() {
		return stepBuilderFactory
				.get("transformHydCondCdStep")
				.<HydCondCd, HydCondCd> chunk(1000)
				.reader(hydCondCdReader)
				.processor(hydCondCdProcessor)
				.writer(hydCondCdWriter)
				.build();
	}
	
	@Bean
	public Flow hydCondCdFlow() {
		return new FlowBuilder<SimpleFlow>("hydCondCdFlow")
				.start(deleteHydCondCdStep())
				.next(transformHydCondCdStep())
				.build();
	}

}
