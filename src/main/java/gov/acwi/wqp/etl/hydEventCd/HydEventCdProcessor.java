package gov.acwi.wqp.etl.hydEventCd;

import org.springframework.batch.item.ItemProcessor;

import gov.acwi.wqp.etl.BaseProcessor;

public class HydEventCdProcessor extends BaseProcessor implements ItemProcessor<HydEventCd, HydEventCd> {

	@Override
	public HydEventCd process(HydEventCd source) throws Exception {
		HydEventCd result = new HydEventCd();
		result.setHydEventCd(source.getHydEventCd());
		result.setHydEventSrtNu(source.getHydEventSrtNu());
		result.setHydEventVldFg(source.isHydEventVldFg());
		result.setHydEventNm(trimString(source.getHydEventNm()));
		result.setHydEventDs(trimString(source.getHydEventDs()));
		
		return result;
	}
}
