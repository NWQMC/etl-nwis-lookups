package main.java.gov.acwi.wqp.etl.bodyPart;

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
public class BodyPartTransformation {
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	@Qualifier("deleteBodyPart")
	private Tasklet deleteBodyPart;
	
	@Bean
	public Step deleteBodyPartStep() {
		return stepBuilderFactory.get("deleteBodyPart")
				.tasklet(deleteBodyPart)
				.build();
	}
	
	@Autowired
	@Qualifier("bodyPartReader")
	private JdbcCursorItemReader<BodyPart> bodyPartReader;
	
	@Autowired
	@Qualifier("bodyPartProcessor")
	private BodyPartProcessor bodyPartProcessor;
	
	@Autowired
	@Qualifier("bodyPartWriter")
	private JdbcBatchItemWriter<BodyPart> bodyPartWriter;
	
	@Bean
	public Step transformBodyPartStep() {
		return stepBuilderFactory
				.get("transformBodyPartStep")
				.<BodyPart, BodyPart> chunk(1000)
				.reader(bodyPartReader)
				.processor(bodyPartProcessor)
				.writer(bodyPartWriter)
				.build();
	}
	
	@Bean
	public Flow bodyPartFlow() {
		return new FlowBuilder<SimpleFlow>("bodyPartFlow")
				.start(deleteBodyPartStep())
				.next(transformBodyPartStep())
				.build();
	}

}
