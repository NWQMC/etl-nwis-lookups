package gov.acwi.wqp.etl.valQualCd;

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
public class ValQualCdTransformation {
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	@Qualifier("deleteValQualCd")
	private Tasklet deleteValQualCd;
	
	@Bean
	public Step deleteValQualCdStep() {
		return stepBuilderFactory.get("deleteValQualCd")
				.tasklet(deleteValQualCd)
				.build();
	}
	
	@Autowired
	@Qualifier("valQualCdReader")
	private JdbcCursorItemReader<ValQualCd> valQualCdReader;
	
	@Autowired
	@Qualifier("valQualCdProcessor")
	private ValQualCdProcessor valQualCdProcessor;
	
	@Autowired
	@Qualifier("valQualCdWriter")
	private JdbcBatchItemWriter<ValQualCd> valQualCdWriter;
	
	@Bean
	public Step transformValQualCdStep() {
		return stepBuilderFactory
				.get("transformValQualCdStep")
				.<ValQualCd, ValQualCd> chunk(1000)
				.reader(valQualCdReader)
				.processor(valQualCdProcessor)
				.writer(valQualCdWriter)
				.build();
	}
	
	@Bean
	public Flow valQualCdFlow() {
		return new FlowBuilder<SimpleFlow>("valQualCdFlow")
				.start(deleteValQualCdStep())
				.next(transformValQualCdStep())
				.build();
	}

}
