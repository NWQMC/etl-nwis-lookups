package gov.acwi.wqp.etl.parmAlias;

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
public class ParmAliasTransformation {
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	@Qualifier("deleteParmAlias")
	private Tasklet deleteParmAlias;
	
	@Bean
	public Step deleteParmAliasStep() {
		return stepBuilderFactory.get("deleteParmAliasStep")
				.tasklet(deleteParmAlias)
				.build();
	}
	
	@Autowired
	@Qualifier("parmAliasReader")
	private JdbcCursorItemReader<ParmAlias> parmAliasReader;
	
	@Autowired
	@Qualifier("parmAliasProcessor")
	private ParmAliasProcessor parmAliasProcessor;
	
	@Autowired
	@Qualifier("parmAliasWriter")
	private JdbcBatchItemWriter<ParmAlias> parmAliasWriter;
	
	@Bean
	public Step transformParmAliasStep() {
		return stepBuilderFactory
				.get("transformParmAliasStep")
				.<ParmAlias, ParmAlias> chunk(1000)
				.reader(parmAliasReader)
				.processor(parmAliasProcessor)
				.writer(parmAliasWriter)
				.build();
	}
	
	@Bean
	public Flow parmAliasFlow() {
		return new FlowBuilder<SimpleFlow>("parmAliasFlow")
				.start(deleteParmAliasStep())
				.next(transformParmAliasStep())
				.build();
	}

}
