package gov.acwi.wqp.etl.altitudeMethod;

import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import gov.acwi.wqp.etl.BasicLookup;
import gov.acwi.wqp.etl.BasicLookupProcessor;
import gov.acwi.wqp.etl.GwReflist;
import gov.acwi.wqp.etl.TransformBasicLookup;

@Component
public class TransformAltitudeMethod extends TransformBasicLookup {
	
	public TransformAltitudeMethod() {
		super("saltmt", "altitude_method");
	}
	
	@Bean
	public JdbcCursorItemReader<GwReflist> gwReflistAltitudeMethodReader() {
		return gwReflistReader();
	}
	
	@Bean
	public BasicLookupProcessor altitudeMethodProcessor() {
		return basicLookupProcessor();
	}
	
	@Bean
	public JdbcBatchItemWriter<BasicLookup> altitudeMethodWriter() {
		return basicLookupWriter();
	}

}
