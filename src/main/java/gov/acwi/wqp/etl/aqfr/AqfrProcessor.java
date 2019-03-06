package main.java.gov.acwi.wqp.etl.aqfr;

import org.springframework.batch.item.ItemProcessor;

public class AqfrProcessor implements ItemProcessor<Aqfr, Aqfr> {

	final static String TRIM = "^\\s]*|\\s]*$";

	@Override
	public Aqfr process(Aqfr source) throws Exception {
		final String countryCd = source.getCountryCd().replaceAll(TRIM, "");
		final String stateCd = source.getStateCd().replaceAll(TRIM,  "");
		final String aqfrCd = source.getAqfrCd().replaceAll(TRIM, "");
		final String aqfrNm = source.getAqfrNm().replaceAll(TRIM,  "");
		final String aqfrMd = source.getAqfrMd().replaceAll(TRIM,  "");
		
		return new Aqfr(countryCd, stateCd, aqfrCd, aqfrNm, aqfrMd);
	}
}
