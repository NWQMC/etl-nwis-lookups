package gov.acwi.wqp.etl.county;

import org.springframework.batch.item.ItemProcessor;

import gov.acwi.wqp.etl.BaseProcessor;

public class CountyProcessor extends BaseProcessor implements ItemProcessor<County, County> {

	@Override
	public County process(County source) throws Exception {
		County result = new County();
		result.setCountryCd(trimString(source.getCountryCd()));
		result.setStateCd(trimString(source.getStateCd()));
		result.setCountyCd(trimString(source.getCountyCd()));
		result.setCountyNm(trimString(source.getCountyNm()));
		result.setCountyMaxLatVa(trimString(source.getCountyMaxLatVa()));
		result.setCountyMinLatVa(trimString(source.getCountyMinLatVa()));
		result.setCountyMaxLongVa(trimString(source.getCountyMaxLongVa()));
		result.setCountyMinLongVa(trimString(source.getCountyMinLongVa()));
		result.setCountyMaxAltVa(trimString(source.getCountyMaxAltVa()));
		result.setCountyMinAltVa(trimString(source.getCountyMinAltVa()));
		result.setCountyMd(trimString(source.getCountyMd()));
		
		return result;
	}
}
