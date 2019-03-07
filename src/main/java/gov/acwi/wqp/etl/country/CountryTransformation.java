package gov.acwi.wqp.etl.country;

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
public class CountryTransformation {
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	@Qualifier("deleteCountry")
	private Tasklet deleteCountry;
	
	@Bean
	public Step deleteCountryStep() {
		return stepBuilderFactory.get("deleteCountryStep")
				.tasklet(deleteCountry)
				.build();
	}
	
	@Autowired
	@Qualifier("countryReader")
	private JdbcCursorItemReader<Country> countryReader;
	
	@Autowired
	@Qualifier("countryProcessor")
	private CountryProcessor countryProcessor;
	
	@Autowired
	@Qualifier("countryWriter")
	private JdbcBatchItemWriter<Country> countryWriter;
	
	@Bean
	public Step transformCountryStep() {
		return stepBuilderFactory
				.get("transformCountryStep")
				.<Country, Country> chunk(1000)
				.reader(countryReader)
				.processor(countryProcessor)
				.writer(countryWriter)
				.build();
	}
	
	@Bean
	public Flow countryFlow() {
		return new FlowBuilder<SimpleFlow>("countryFlow")
				.start(deleteCountryStep())
				.next(transformCountryStep())
				.build();
	}

}
