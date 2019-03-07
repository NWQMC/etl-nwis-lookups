package gov.acwi.wqp.etl.citMeth;

import org.springframework.batch.item.ItemProcessor;

public class CitMethProcessor implements ItemProcessor<CitMeth, CitMeth> {

	final static String TRIM = "^\\s]*|\\s]*$";
	
	private String trimString(String value) {
		if (null != value) {
			return value.replaceAll(TRIM,  "");
		} 
		return value;
	}

	@Override
	public CitMeth process(CitMeth source) throws Exception {
		final String methCd = trimString(source.getMethCd());
		final String citNm = trimString(source.getCitNm());
		final String citMethNo = trimString(source.getCitMethNo());
		final String methSrcCd = trimString(source.getMethSrcCd());
		final String citMethInitNm = trimString(source.getCitMethInitNm());
		final String citMethRevNm = trimString(source.getCitMethRevNm());
		
		return new CitMeth(source.getCitMethId(), methCd, citNm, citMethNo, methSrcCd, citMethInitNm, source.getCitMethInitDt(),
				citMethRevNm, source.getCitMethRevDt());
	}
}
