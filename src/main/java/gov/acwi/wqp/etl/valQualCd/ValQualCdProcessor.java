package gov.acwi.wqp.etl.valQualCd;

import org.springframework.batch.item.ItemProcessor;

import gov.acwi.wqp.etl.BaseProcessor;

public class ValQualCdProcessor extends BaseProcessor implements ItemProcessor<ValQualCd, ValQualCd> {

	@Override
	public ValQualCd process(ValQualCd source) throws Exception {
		final String valQualCd = trimString(source.getValQualCd());
		final String valQualTp = trimString(source.getValQualTp());
		final String valQualNm = trimString(source.getValQualNm());
		final String valQualDs = trimString(source.getValQualDs());
		
		return new ValQualCd(valQualCd, valQualTp, source.getValQualSrtNu(),
				source.isValQualVldFg(), valQualNm, valQualDs);
	}
}
