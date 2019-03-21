package gov.acwi.wqp.etl.hydCondCd;

import org.springframework.batch.item.ItemProcessor;

import gov.acwi.wqp.etl.BaseProcessor;

public class HydCondCdProcessor extends BaseProcessor implements ItemProcessor<HydCondCd, HydCondCd> {

	@Override
	public HydCondCd process(HydCondCd source) throws Exception {
		HydCondCd result = new HydCondCd();
		result.setHydCondCd(source.getHydCondCd());
		result.setHydCondSrtNu(source.getHydCondSrtNu());
		result.setHydCondVldFg(source.isHydCondVldFg());
		result.setHydCondNm(trimString(source.getHydCondNm()));
		result.setHydCondDs(trimString(source.getHydCondDs()));
		
		return result;
	}
}
