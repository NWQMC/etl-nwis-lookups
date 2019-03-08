package gov.acwi.wqp.etl.hydCondCd;

import org.springframework.batch.item.ItemProcessor;

import gov.acwi.wqp.etl.BaseProcessor;

public class HydCondCdProcessor extends BaseProcessor implements ItemProcessor<HydCondCd, HydCondCd> {

	@Override
	public HydCondCd process(HydCondCd source) throws Exception {
		final String hydCondNm = trimString(source.getHydCondNm());
		final String hydCondDs = trimString(source.getHydCondDs());
		
		return new HydCondCd(source.getHydCondCd(), source.getHydCondSrtNu(), 
				source.isHydCondVldFg(), hydCondNm, hydCondDs);
	}
}
