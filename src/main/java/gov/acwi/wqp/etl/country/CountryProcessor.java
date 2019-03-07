package gov.acwi.wqp.etl.country;

import org.springframework.batch.item.ItemProcessor;

import gov.acwi.wqp.etl.BaseProcessor;

public class CountryProcessor extends BaseProcessor implements ItemProcessor<Country, Country> {

	@Override
	public Country process(Country source) throws Exception {
		final String countryCd = trimString(source.getCountryCd());
		final String countryNm = trimString(source.getCountryNm());
		
		return new Country(countryCd, countryNm);
	}
}
