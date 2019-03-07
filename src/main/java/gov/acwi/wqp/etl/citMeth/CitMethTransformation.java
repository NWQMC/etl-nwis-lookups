package gov.acwi.wqp.etl.citMeth;

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
public class CitMethTransformation {
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	@Qualifier("deleteCitMeth")
	private Tasklet deleteCitMeth;
	
	@Bean
	public Step deleteCitMethStep() {
		return stepBuilderFactory.get("deleteCitMeth")
				.tasklet(deleteCitMeth)
				.build();
	}
	
	@Autowired
	@Qualifier("citMethReader")
	private JdbcCursorItemReader<CitMeth> citMethReader;
	
	@Autowired
	@Qualifier("citMethProcessor")
	private CitMethProcessor citMethProcessor;
	
	@Autowired
	@Qualifier("citMethWriter")
	private JdbcBatchItemWriter<CitMeth> citMethWriter;
	
	@Bean
	public Step transformCitMethStep() {
		return stepBuilderFactory
				.get("transformCitMethStep")
				.<CitMeth, CitMeth> chunk(1000)
				.reader(citMethReader)
				.processor(citMethProcessor)
				.writer(citMethWriter)
				.build();
	}
	
	@Bean
	public Flow citMethFlow() {
		return new FlowBuilder<SimpleFlow>("citMethFlow")
				.start(deleteCitMethStep())
				.next(transformCitMethStep())
				.build();
	}

}
