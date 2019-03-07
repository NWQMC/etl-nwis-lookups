package gov.acwi.wqp.etl.county;

import org.springframework.batch.item.ItemProcessor;

import gov.acwi.wqp.etl.BaseProcessor;

public class CountyProcessor extends BaseProcessor implements ItemProcessor<County, County> {

	@Override
	public County process(County source) throws Exception {
		final String countryCd = trimString(source.getCountryCd());
		final String stateCd = trimString(source.getStateCd());
		final String countyCd = trimString(source.getCountyCd());
		final String countyNm = trimString(source.getCountyNm());
		final String countyMaxLatVa = trimString(source.getCountyMaxLatVa());
		final String countyMinLatVa = trimString(source.getCountyMinLatVa());
		final String countyMaxLongVa = trimString(source.getCountyMaxLongVa());
		final String countyMinLongVa = trimString(source.getCountyMinLongVa());
		final String countyMaxAltVa = trimString(source.getCountyMaxAltVa());
		final String countyMinAltVa = trimString(source.getCountyMinAltVa());
		final String countyMd = trimString(source.getCountyMd());
		
		return new County(countryCd, stateCd, countyCd, countyNm, countyMaxLatVa, countyMinLatVa, countyMaxLongVa,
				countyMinLongVa, countyMaxAltVa, countyMinAltVa, countyMd);
	}
}
