package gov.acwi.wqp.etl.latLongDatum;

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
public class LatLongDatumTransformation {

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	@Qualifier("deleteLatLongDatum")
	private Tasklet deleteLatLongDatum;

	@Autowired
	@Qualifier("gwReflistLatLongDatumReader")
	private JdbcCursorItemReader<GwReflist> gwReflistLatLongDatumReader;
	
	
	@Autowired
	@Qualifier("latLongDatumProcessor")
	private BasicLookupProcessor latLongDatumProcessor;

	@Autowired
	@Qualifier("latLongDatumWriter")
	private JdbcBatchItemWriter<BasicLookup> latLongDatumWriter;

	@Bean
	public Step deleteLatLongDatumStep() {
		return stepBuilderFactory.get("deleteLatLongDatumStep")
				.tasklet(deleteLatLongDatum)
				.build();
	}

	@Bean
	public Step transformLatLongDatumStep() {
		return stepBuilderFactory
				.get("transformLatLongDatumStep")
				.<GwReflist, BasicLookup>chunk(10)
				.reader(gwReflistLatLongDatumReader)
				.processor(latLongDatumProcessor)
				.writer(latLongDatumWriter)
				.build();
	}

	@Bean
	public Flow latLongDatumFlow() {
		return new FlowBuilder<SimpleFlow>("latLongDatumFlow")
				.start(deleteLatLongDatumStep())
				.next(transformLatLongDatumStep())
				.build();
	}
}
