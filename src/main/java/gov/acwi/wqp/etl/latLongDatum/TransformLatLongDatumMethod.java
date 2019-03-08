package gov.acwi.wqp.etl.latLongDatum;

import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import gov.acwi.wqp.etl.BasicLookup;
import gov.acwi.wqp.etl.BasicLookupProcessor;
import gov.acwi.wqp.etl.GwReflist;
import gov.acwi.wqp.etl.TransformBasicLookup;

@Component
public class TransformLatLongDatumMethod extends TransformBasicLookup {
	
	public TransformLatLongDatumMethod() {
		super("scordm", "lat_long_datum");
	}
	
	@Bean
	public JdbcCursorItemReader<GwReflist> gwReflistLatLongDatumReader() {
		return gwReflistReader();
	}
	
	@Bean
	public BasicLookupProcessor latLongDatumProcessor() {
		return basicLookupProcessor();
	}
	
	@Bean
	public JdbcBatchItemWriter<BasicLookup> latLongDatumWriter() {
		return basicLookupWriter();
	}

}
