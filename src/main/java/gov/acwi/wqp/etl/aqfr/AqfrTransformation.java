package main.java.gov.acwi.wqp.etl.aqfr;

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
public class AqfrTransformation {
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	@Qualifier("deleteAqfr")
	private Tasklet deleteAqfr;
	
	@Bean
	public Step deleteAqfrStep() {
		return stepBuilderFactory.get("deleteAqfr")
				.tasklet(deleteAqfr)
				.build();
	}
	
	@Autowired
	@Qualifier("aqfrReader")
	private JdbcCursorItemReader<Aqfr> aqfrReader;
	
	@Autowired
	@Qualifier("aqfrProcessor")
	private AqfrProcessor aqfrProcessor;
	
	@Autowired
	@Qualifier("aqfrWriter")
	private JdbcBatchItemWriter<Aqfr> aqfrWriter;
	
	@Bean
	public Step transformAqfrStep() {
		return stepBuilderFactory
				.get("transformAqfrStep")
				.<Aqfr, Aqfr> chunk(1000)
				.reader(aqfrReader)
				.processor(aqfrProcessor)
				.writer(aqfrWriter)
				.build();
	}
	
	@Bean
	public Flow aqfrFlow() {
		return new FlowBuilder<SimpleFlow>("aqfrFlow")
				.start(deleteAqfrStep())
				.next(transformAqfrStep())
				.build();
	}

}
