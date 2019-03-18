package gov.acwi.wqp.etl.protoOrg;

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
public class ProtoOrgTransformation {
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	@Qualifier("deleteProtoOrg")
	private Tasklet deleteProtoOrg;
	
	@Bean
	public Step deleteProtoOrgStep() {
		return stepBuilderFactory.get("deleteProtoOrgStep")
				.tasklet(deleteProtoOrg)
				.build();
	}
	
	@Autowired
	@Qualifier("protoOrgReader")
	private JdbcCursorItemReader<ProtoOrg> protoOrgReader;
	
	@Autowired
	@Qualifier("protoOrgProcessor")
	private ProtoOrgProcessor protoOrgProcessor;
	
	@Autowired
	@Qualifier("protoOrgWriter")
	private JdbcBatchItemWriter<ProtoOrg> protoOrgWriter;
	
	@Bean
	public Step transformProtoOrgStep() {
		return stepBuilderFactory
				.get("transformProtoOrgStep")
				.<ProtoOrg, ProtoOrg> chunk(1000)
				.reader(protoOrgReader)
				.processor(protoOrgProcessor)
				.writer(protoOrgWriter)
				.build();
	}
	
	@Bean
	public Flow protoOrgFlow() {
		return new FlowBuilder<SimpleFlow>("protoOrgFlow")
				.start(deleteProtoOrgStep())
				.next(transformProtoOrgStep())
				.build();
	}

}
