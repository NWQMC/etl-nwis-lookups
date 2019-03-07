package gov.acwi.wqp.etl.aqfr;

import org.springframework.batch.item.ItemProcessor;

import gov.acwi.wqp.etl.BaseProcessor;

public class AqfrProcessor extends BaseProcessor implements ItemProcessor<Aqfr, Aqfr> {

	@Override
	public Aqfr process(Aqfr source) throws Exception {
		final String countryCd = trimString(source.getCountryCd());
		final String stateCd = trimString(source.getStateCd());
		final String aqfrCd = trimString(source.getAqfrCd());
		final String aqfrNm = trimString(source.getAqfrNm());
		final String aqfrMd = trimString(source.getAqfrMd());
		
		return new Aqfr(countryCd, stateCd, aqfrCd, aqfrNm, aqfrMd);
	}
}
