package gov.acwi.wqp.etl.country;

public class Country {
	
	private String countryCd;
	private String countryNm;
	
	public Country() {
	}
	
	public Country(String countryCd, String countryNm) {
		super();
		this.countryCd = countryCd;
		this.countryNm = countryNm;
	}

	public String getCountryCd() {
		return countryCd;
	}

	public void setCountryCd(String countryCd) {
		this.countryCd = countryCd;
	}

	public String getCountryNm() {
		return countryNm;
	}

	public void setCountryNm(String countryNm) {
		this.countryNm = countryNm;
	}
}
