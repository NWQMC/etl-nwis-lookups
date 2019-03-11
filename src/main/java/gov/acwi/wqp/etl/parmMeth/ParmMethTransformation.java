package gov.acwi.wqp.etl.parmMeth;

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
public class ParmMethTransformation {
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	@Qualifier("deleteParmMeth")
	private Tasklet deleteParmMeth;
	
	@Bean
	public Step deleteParmMethStep() {
		return stepBuilderFactory.get("deleteParmMethStep")
				.tasklet(deleteParmMeth)
				.build();
	}
	
	@Autowired
	@Qualifier("parmMethReader")
	private JdbcCursorItemReader<ParmMeth> parmMethReader;
	
	@Autowired
	@Qualifier("parmMethProcessor")
	private ParmMethProcessor parmMethProcessor;
	
	@Autowired
	@Qualifier("parmMethWriter")
	private JdbcBatchItemWriter<ParmMeth> parmMethWriter;
	
	@Bean
	public Step transformParmMethStep() {
		return stepBuilderFactory
				.get("transformParmMethStep")
				.<ParmMeth, ParmMeth> chunk(1000)
				.reader(parmMethReader)
				.processor(parmMethProcessor)
				.writer(parmMethWriter)
				.build();
	}
	
	@Bean
	public Flow parmMethFlow() {
		return new FlowBuilder<SimpleFlow>("parmMethFlow")
				.start(deleteParmMethStep())
				.next(transformParmMethStep())
				.build();
	}

}
