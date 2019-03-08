package gov.acwi.wqp.etl.latLongMethod;

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

import gov.acwi.wqp.etl.BasicLookup;
import gov.acwi.wqp.etl.BasicLookupProcessor;
import gov.acwi.wqp.etl.GwReflist;

@Configuration
public class LatLongMethodTransformation {

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	@Qualifier("deleteLatLongMethod")
	private Tasklet deleteLatLongMethod;

	@Bean
	public Step deleteLatLongMethodStep() {
		return stepBuilderFactory.get("deleteLatLongMethodStep")
				.tasklet(deleteLatLongMethod)
				.build();
	}

	@Autowired
	@Qualifier("gwReflistLatLongMethodReader")
	private JdbcCursorItemReader<GwReflist> gwReflistLatLongMethodReader;

	@Autowired
	@Qualifier("latLongMethodProcessor")
	private BasicLookupProcessor latLongMethodProcessor;

	@Autowired
	@Qualifier("latLongMethodWriter")
	private JdbcBatchItemWriter<BasicLookup> latLongMethodWriter;

	@Bean
	public Step transformLatLongMethodStep() {
		return stepBuilderFactory
				.get("transformLatLongDatumStep")
				.<GwReflist, BasicLookup>chunk(10)
				.reader(gwReflistLatLongMethodReader)
				.processor(latLongMethodProcessor)
				.writer(latLongMethodWriter)
				.build();
	}

	@Bean
	public Flow latLongMethodFlow() {
		return new FlowBuilder<SimpleFlow>("latLongMethodFlow")
				.start(deleteLatLongMethodStep())
				.next(transformLatLongMethodStep())
				.build();
	}
}
