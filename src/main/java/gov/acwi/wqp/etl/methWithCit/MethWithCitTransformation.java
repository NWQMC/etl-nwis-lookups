package gov.acwi.wqp.etl.methWithCit;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.core.job.flow.support.SimpleFlow;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MethWithCitTransformation {
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	@Qualifier("deleteMethWithCit")
	private Tasklet deleteMethWithCit;
	
	// We are using a tasklet for this ETL. The JdbcCursorItemReader failed when
	// the aggregation part of the query was included
	@Autowired
	@Qualifier("taskMethWithCitMeth")
	private Tasklet taskMethWithCitMeth;
	
	@Bean
	public Step deleteMethWithCitStep() {
		return stepBuilderFactory
				.get("deleteMethWithCitStep")
				.tasklet(deleteMethWithCit)
				.build();
	}
	
	@Bean
	public Step transformMethWithCitStep() {
		return stepBuilderFactory
				.get("transformMethWithCitStep")
				.tasklet(taskMethWithCitMeth)

				.build();
	}
	
	@Bean
	public Flow methWithCitFlow() {
		return new FlowBuilder<SimpleFlow>("methWithCitFlow")
				.start(deleteMethWithCitStep())
				.next(transformMethWithCitStep())
				.build();
	}

}
