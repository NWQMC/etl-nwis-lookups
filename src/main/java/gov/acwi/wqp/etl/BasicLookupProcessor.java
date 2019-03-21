package gov.acwi.wqp.etl;

import org.springframework.batch.item.ItemProcessor;

public class BasicLookupProcessor extends BaseProcessor implements ItemProcessor<GwReflist, BasicLookup> {
	
	@Override
	public BasicLookup process(GwReflist gwReflist) throws Exception {
		BasicLookup result = new BasicLookup();
		result.setCode(trimString(gwReflist.getGwRefCd()));
		result.setName(trimString(gwReflist.getGwRefNm()));
		result.setSortOrder(gwReflist.getGwSortNu());
		result.setDescription(trimString(gwReflist.getGwRefDs()));
		result.setValidFlag(gwReflist.getGwValidFg() == 'Y');
		
		return result;
	}

}
