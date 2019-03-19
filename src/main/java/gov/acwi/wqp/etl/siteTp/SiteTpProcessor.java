package gov.acwi.wqp.etl.siteTp;

import org.springframework.batch.item.ItemProcessor;

import gov.acwi.wqp.etl.BaseProcessor;

public class SiteTpProcessor extends BaseProcessor implements ItemProcessor<SiteTp, SiteTp> {

	@Override
	public SiteTp process(SiteTp source) throws Exception {

		final String siteTpCd = trimString(source.getSiteTpCd());
		final String siteTpNm = trimString(source.getSiteTpNm());
		final String siteTpLn = trimString(source.getSiteTpLn());
		final String siteTpDs = trimString(source.getSiteTpDs());
		
		
		return new SiteTp(siteTpCd, source.getSiteTpSrtNu(), source.isSiteTpVldFg(),
				source.isSiteTpPrimFg(), siteTpNm, siteTpLn, siteTpDs);
	}
}
