package gov.acwi.wqp.etl.siteTp;

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
public class SiteTpTransformation {
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	@Qualifier("deleteSiteTp")
	private Tasklet deleteSiteTp;
	
	@Autowired
	@Qualifier("siteTpReader")
	private JdbcCursorItemReader<SiteTp> siteTpReader;
	
	@Autowired
	@Qualifier("siteTpProcessor")
	private SiteTpProcessor siteTpProcessor;
	
	@Autowired
	@Qualifier("siteTpWriter")
	private JdbcBatchItemWriter<SiteTp> siteTpWriter;
	
	@Bean
	public Step deleteSiteTpStep() {
		return stepBuilderFactory.get("deleteSiteTpStep")
				.tasklet(deleteSiteTp)
				.build();
	}
	
	@Bean
	public Step transformSiteTpStep() {
		return stepBuilderFactory
				.get("transformSiteTpStep")
				.<SiteTp, SiteTp> chunk(1000)
				.reader(siteTpReader)
				.processor(siteTpProcessor)
				.writer(siteTpWriter)
				.build();
	}
	
	@Bean
	public Flow siteTpFlow() {
		return new FlowBuilder<SimpleFlow>("siteTpFlow")
				.start(deleteSiteTpStep())
				.next(transformSiteTpStep())
				.build();
	}

}
