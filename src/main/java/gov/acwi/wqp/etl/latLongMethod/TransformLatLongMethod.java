package gov.acwi.wqp.etl.latLongMethod;

import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import gov.acwi.wqp.etl.BasicLookup;
import gov.acwi.wqp.etl.BasicLookupProcessor;
import gov.acwi.wqp.etl.GwReflist;
import gov.acwi.wqp.etl.TransformBasicLookup;

@Component
public class TransformLatLongMethod extends TransformBasicLookup {
	
	public TransformLatLongMethod() {
		super("scormt", "lat_long_method");
	}
	
	@Bean
	public JdbcCursorItemReader<GwReflist> gwReflistLatLongMethodReader() {
		return gwReflistReader();
	}
	
	@Bean
	public BasicLookupProcessor latLongMethodProcessor() {
		return basicLookupProcessor();
	}
	
	@Bean
	public JdbcBatchItemWriter<BasicLookup> latLongMethodWriter() {
		return basicLookupWriter();
	}

}
