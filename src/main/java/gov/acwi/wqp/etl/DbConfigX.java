package main.java.gov.acwi.wqp.etl;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DbConfigX {

	@Bean
	@Primary
	@ConfigurationProperties("app.datasource.wqp")
	public DataSourceProperties wqpDataSourceProperties() {
		return new DataSourceProperties();
	}
	
	@Bean
	@Primary
	@ConfigurationProperties("app.datasource.wqp")
	public DataSource wqpDataSource() {
		return wqpDataSourceProperties().initializeDataSourceBuilder().build();
	}

	@Bean
	@ConfigurationProperties("app.datasource.natdb")
	public DataSourceProperties natdbDataSourceProperties() {
		return new DataSourceProperties();
	}
	
	@Bean
	@ConfigurationProperties("app.datasource.natdb")
	public DataSource natdbDataSource() {
		return natdbDataSourceProperties().initializeDataSourceBuilder().build();
	}
}
