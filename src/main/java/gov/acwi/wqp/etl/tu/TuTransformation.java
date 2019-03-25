package gov.acwi.wqp.etl.tu;

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
public class TuTransformation {
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	@Qualifier("deleteTu")
	private Tasklet deleteTu;
	
	@Autowired
	@Qualifier("tuReader")
	private JdbcCursorItemReader<Tu> tuReader;
	
	@Autowired
	@Qualifier("tuProcessor")
	private TuProcessor tuProcessor;
	
	@Autowired
	@Qualifier("tuWriter")
	private JdbcBatchItemWriter<Tu> tuWriter;
	
	@Bean
	public Step deleteTuStep() {
		return stepBuilderFactory.get("deleteTuStep")
				.tasklet(deleteTu)
				.build();
	}
	
	@Bean
	public Step transformTuStep() {
		return stepBuilderFactory
				.get("transformTuStep")
				.<Tu, Tu> chunk(1000)
				.reader(tuReader)
				.processor(tuProcessor)
				.writer(tuWriter)
				.build();
	}
	
	@Bean
	public Flow tuFlow() {
		return new FlowBuilder<SimpleFlow>("tuFlow")
				.start(deleteTuStep())
				.next(transformTuStep())
				.build();
	}

}
