package gov.acwi.wqp.etl.aquiferType;

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
public class TransformAquiferType {
	
	@Autowired
	@Qualifier("wqpDataSource")
	private DataSource wqpDataSource;

	@Autowired
	@Qualifier("natdbDataSource")
	DataSource natdbDataSource;

	
	@Bean
	public JdbcCursorItemReader<GwReflist> gwReflistAquiferTypeReader() {
		return new JdbcCursorItemReaderBuilder<GwReflist>()
				.dataSource(natdbDataSource)
				.name("natdbGwReflistAquiferType")
				.preparedStatementSetter(new PreparedStatementSetter() {
					 public void setValues(PreparedStatement preparedStatement) throws SQLException {
					      preparedStatement.setString(1, "saqtyp");
					   }
				})
				.sql("select * from gw_reflist where gw_ed_tbl_nm = ?")
				.rowMapper(new GwReflistRowMapper())
				.build();
	}
	
	@Bean 
	public BasicLookupProcessor aquiferTypeProcessor() {
		return new BasicLookupProcessor();
	}
	
	@Bean
	public JdbcBatchItemWriter<BasicLookup> aquiferTypeWriter() {
		return new JdbcBatchItemWriterBuilder<BasicLookup>()
				.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
				.sql("INSERT INTO aquifer_type"
						+ " (code, name, sort_order, description, valid_flag) VALUES (:code, :name, :sortOrder, :description, :validFlag)")
				.dataSource(wqpDataSource)
				.build();
	}	
}
