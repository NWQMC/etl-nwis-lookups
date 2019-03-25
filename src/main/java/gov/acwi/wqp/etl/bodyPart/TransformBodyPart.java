package gov.acwi.wqp.etl.bodyPart;

import javax.sql.DataSource;

import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class TransformBodyPart {
	
	@Autowired
	@Qualifier("wqpDataSource")
	private DataSource wqpDataSource;

	@Autowired
	@Qualifier("natdbDataSource")
	private DataSource natdbDataSource;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public JdbcCursorItemReader<BodyPart> bodyPartReader() {
		return new JdbcCursorItemReaderBuilder<BodyPart>()
				.dataSource(natdbDataSource)
				.name("natdbBodyPart")
				.sql("select body_part_id, body_part_nm from body_part")
				.rowMapper(new BodyPartRowManager())
				.build();
	}

	@Bean
	public BodyPartProcessor bodyPartProcessor() {
		return new BodyPartProcessor();
	}

	@Bean
	public JdbcBatchItemWriter<BodyPart> bodyPartWriter() {
		return new JdbcBatchItemWriterBuilder<BodyPart>()
				.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
				.sql("INSERT INTO body_part (body_part_id, body_part_nm) VALUES (:bodyPartId, :bodyPartNm)")
				.dataSource(wqpDataSource)
				.build();
	}
}
