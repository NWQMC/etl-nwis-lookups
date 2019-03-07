package gov.acwi.wqp.etl;

import org.springframework.batch.item.ItemProcessor;

public class BasicLookupProcessor implements ItemProcessor<GwReflist, BasicLookup> {
	
	final static String TRIM = "^\\s]*|\\s]*$";

	@Override
	public BasicLookup process(GwReflist gwReflist) throws Exception {
		final String code = gwReflist.getGwRefCd().replaceAll(TRIM, "");
		final String name = gwReflist.getGwRefNm().replaceAll(TRIM,  "");
		final String description = gwReflist.getGwRefDs().replaceAll(TRIM,  "");
		final Boolean validFlag = gwReflist.getGwValidFg() == 'Y';
		
		return new BasicLookup(code, name, gwReflist.getGwSortNu(), description, validFlag);
	}

}
