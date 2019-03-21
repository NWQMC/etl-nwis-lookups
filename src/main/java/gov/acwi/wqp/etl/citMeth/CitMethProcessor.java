package gov.acwi.wqp.etl.citMeth;

import org.springframework.batch.item.ItemProcessor;

import gov.acwi.wqp.etl.BaseProcessor;

public class CitMethProcessor extends BaseProcessor implements ItemProcessor<CitMeth, CitMeth> {

	@Override
	public CitMeth process(CitMeth source) throws Exception {
		CitMeth result = new CitMeth();
		result.setCitMethId(source.getCitMethId());
		result.setMethCd(trimString(source.getMethCd()));
		result.setCitNm(trimString(source.getCitNm()));
		result.setCitMethNo(trimString(source.getCitMethNo()));
		result.setMethSrcCd(trimString(source.getMethSrcCd()));
		result.setCitMethInitNm(trimString(source.getCitMethInitNm()));
		result.setCitMethInitDt(source.getCitMethInitDt());
		result.setCitMethRevNm(trimString(source.getCitMethRevNm()));
		result.setCitMethRevDt(source.getCitMethRevDt());
		
		return result;
	}
}
