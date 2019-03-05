package main.java.gov.acwi.wqp.etl;

import org.springframework.batch.item.ItemProcessor;

public class BasicLookupProcessor implements ItemProcessor<GwReflist, BasicLookup> {

	@Override
	public BasicLookup process(GwReflist gwReflist) throws Exception {
		final String trim = "^\\s]*|\\s]*$";
		final String code = gwReflist.getGwRefCd().replaceFirst(trim, "");
		final String name = gwReflist.getGwRefNm().replaceFirst(trim,  "");
		final String description = gwReflist.getGwRefDs().replaceFirst(trim,  "");
		final Boolean validFlag = gwReflist.getGwValidFg() == 'Y';
		
		return new BasicLookup(code, name, gwReflist.getGwSortNu(), description, validFlag);
	}

}
