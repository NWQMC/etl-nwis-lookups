package gov.acwi.wqp.etl.hydEventCd;

import org.springframework.batch.item.ItemProcessor;

import gov.acwi.wqp.etl.BaseProcessor;

public class HydEventCdProcessor extends BaseProcessor implements ItemProcessor<HydEventCd, HydEventCd> {

	@Override
	public HydEventCd process(HydEventCd source) throws Exception {
		final String hydEventNm = trimString(source.getHydEventNm());
		final String hydEventDs = trimString(source.getHydEventDs());
		
		return new HydEventCd(source.getHydEventCd(), source.getHydEventSrtNu(), 
				source.isHydEventVldFg(), hydEventNm, hydEventDs);
	}
}
