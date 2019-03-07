package gov.acwi.wqp.etl.county;

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
public class CountyTransformation {
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	@Qualifier("deleteCounty")
	private Tasklet deleteCounty;
	
	@Bean
	public Step deleteCountyStep() {
		return stepBuilderFactory.get("deleteCountyStep")
				.tasklet(deleteCounty)
				.build();
	}
	
	@Autowired
	@Qualifier("countyReader")
	private JdbcCursorItemReader<County> countyReader;
	
	@Autowired
	@Qualifier("countyProcessor")
	private CountyProcessor countyProcessor;
	
	@Autowired
	@Qualifier("countyWriter")
	private JdbcBatchItemWriter<County> countyWriter;
	
	@Bean
	public Step transformCountyStep() {
		return stepBuilderFactory
				.get("transformCountyStep")
				.<County, County> chunk(1000)
				.reader(countyReader)
				.processor(countyProcessor)
				.writer(countyWriter)
				.build();
	}
	
	@Bean
	public Flow countyFlow() {
		return new FlowBuilder<SimpleFlow>("countyFlow")
				.start(deleteCountyStep())
				.next(transformCountyStep())
				.build();
	}

}
