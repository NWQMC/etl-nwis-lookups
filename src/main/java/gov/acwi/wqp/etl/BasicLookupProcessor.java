package gov.acwi.wqp.etl;

import org.springframework.batch.item.ItemProcessor;

public class BasicLookupProcessor extends BaseProcessor implements ItemProcessor<GwReflist, BasicLookup> {
	
	final static String TRIM = "^\\s]*|\\s]*$";

	@Override
	public BasicLookup process(GwReflist gwReflist) throws Exception {
		final String code = trimString(gwReflist.getGwRefCd());
		final String name = trimString(gwReflist.getGwRefNm());
		final String description = trimString(gwReflist.getGwRefDs());
		final Boolean validFlag = gwReflist.getGwValidFg() == 'Y';
		
		return new BasicLookup(code, name, gwReflist.getGwSortNu(), description, validFlag);
	}

}
