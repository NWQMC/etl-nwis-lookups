package gov.acwi.wqp.etl.siteTp;

import org.springframework.batch.item.ItemProcessor;

import gov.acwi.wqp.etl.BaseProcessor;

public class SiteTpProcessor extends BaseProcessor implements ItemProcessor<SiteTp, SiteTp> {

	@Override
	public SiteTp process(SiteTp source) throws Exception {
		SiteTp result = new SiteTp();
		result.setSiteTpCd(trimString(source.getSiteTpCd()));
		result.setSiteTpSrtNu(source.getSiteTpSrtNu());
		result.setSiteTpVldFg(source.isSiteTpVldFg());
		result.setSiteTpPrimFg(source.isSiteTpPrimFg());
		result.setSiteTpNm(trimString(source.getSiteTpNm()));
		result.setSiteTpLn(trimString(source.getSiteTpLn()));
		result.setSiteTpDs(trimString(source.getSiteTpDs()));
		
		return result;
	}
}
