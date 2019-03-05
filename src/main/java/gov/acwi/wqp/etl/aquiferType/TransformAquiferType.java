package main.java.gov.acwi.wqp.etl.aquiferType;

import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import main.java.gov.acwi.wqp.etl.BasicLookup;
import main.java.gov.acwi.wqp.etl.BasicLookupProcessor;
import main.java.gov.acwi.wqp.etl.GwReflist;
import main.java.gov.acwi.wqp.etl.TransformBasicLookup;

@Component
public class TransformAquiferType extends TransformBasicLookup {
	
	public TransformAquiferType() {
		super("saqtyp", "aquifer_type");
	}
	
	@Bean
	public JdbcCursorItemReader<GwReflist> gwReflistAquiferTypeReader() {
		return gwReflistReader();
	}
	
	@Bean
	public BasicLookupProcessor aquiferTypeProcessor() {
		return basicLookupProcessor();
	}
	
	@Bean
	public JdbcBatchItemWriter<BasicLookup> aquiferTypeWriter() {
		return basicLookupWriter();
	}

}
