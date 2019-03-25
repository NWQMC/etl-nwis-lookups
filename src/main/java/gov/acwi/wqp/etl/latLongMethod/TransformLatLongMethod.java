package gov.acwi.wqp.etl.latLongMethod;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;

import gov.acwi.wqp.etl.BasicLookup;
import gov.acwi.wqp.etl.BasicLookupProcessor;
import gov.acwi.wqp.etl.GwReflist;
import gov.acwi.wqp.etl.GwReflistRowMapper;

@Component
public class TransformLatLongMethod {
	
	@Autowired
	@Qualifier("wqpDataSource")
	private DataSource wqpDataSource;

	@Autowired
	@Qualifier("natdbDataSource")
	private DataSource natdbDataSource;
	
	
	@Bean
	public JdbcCursorItemReader<GwReflist> gwReflistLatLongMethodReader() {
		return new JdbcCursorItemReaderBuilder<GwReflist>()
				.dataSource(natdbDataSource)
				.name("natdbGwReflistLatLongMethod")
				.preparedStatementSetter(new PreparedStatementSetter() {
					 public void setValues(PreparedStatement preparedStatement) throws SQLException {
					      preparedStatement.setString(1, "scormt");
					   }
				})
				.sql("select * from gw_reflist where gw_ed_tbl_nm = ?")
				.rowMapper(new GwReflistRowMapper())
				.build();
	}
	
	@Bean
	public BasicLookupProcessor latLongMethodProcessor() {
		return new BasicLookupProcessor();
	}

	@Bean
	public JdbcBatchItemWriter<BasicLookup> latLongMethodWriter() {
		return new JdbcBatchItemWriterBuilder<BasicLookup>()
				.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
				.sql("INSERT INTO lat_long_method"
						+ " (code, name, sort_order, description, valid_flag) VALUES (:code, :name, :sortOrder, :description, :validFlag)")
				.dataSource(wqpDataSource)
				.build();
	}	
}
