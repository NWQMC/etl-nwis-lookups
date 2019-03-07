package gov.acwi.wqp.etl.county;

public class County {
	private String countryCd;
	private String stateCd;
	private String countyCd;
	private String countyNm;
	private String countyMaxLatVa;
	private String countyMinLatVa;
	private String countyMaxLongVa;
	private String countyMinLongVa;
	private String countyMaxAltVa;
	private String countyMinAltVa;
	private String countyMd;
	
	public County() {
	}

	public County(String countryCd, String stateCd, String countyCd, String countyNm, String countyMaxLatVa,
			String countyMinLatVa, String countyMaxLongVa, String countyMinLongVa, String countyMaxAltVa,
			String countyMinAltVa, String countyMd) {
		super();
		this.countryCd = countryCd;
		this.stateCd = stateCd;
		this.countyCd = countyCd;
		this.countyNm = countyNm;
		this.countyMaxLatVa = countyMaxLatVa;
		this.countyMinLatVa = countyMinLatVa;
		this.countyMaxLongVa = countyMaxLongVa;
		this.countyMinLongVa = countyMinLongVa;
		this.countyMaxAltVa = countyMaxAltVa;
		this.countyMinAltVa = countyMinAltVa;
		this.countyMd = countyMd;
	}

	public String getCountryCd() {
		return countryCd;
	}

	public void setCountryCd(String countryCd) {
		this.countryCd = countryCd;
	}

	public String getStateCd() {
		return stateCd;
	}

	public void setStateCd(String stateCd) {
		this.stateCd = stateCd;
	}

	public String getCountyCd() {
		return countyCd;
	}

	public void setCountyCd(String countyCd) {
		this.countyCd = countyCd;
	}

	public String getCountyNm() {
		return countyNm;
	}

	public void setCountyNm(String countyNm) {
		this.countyNm = countyNm;
	}

	public String getCountyMaxLatVa() {
		return countyMaxLatVa;
	}

	public void setCountyMaxLatVa(String countyMaxLatVa) {
		this.countyMaxLatVa = countyMaxLatVa;
	}

	public String getCountyMinLatVa() {
		return countyMinLatVa;
	}

	public void setCountyMinLatVa(String countyMinLatVa) {
		this.countyMinLatVa = countyMinLatVa;
	}

	public String getCountyMaxLongVa() {
		return countyMaxLongVa;
	}

	public void setCountyMaxLongVa(String countyMaxLongVa) {
		this.countyMaxLongVa = countyMaxLongVa;
	}

	public String getCountyMinLongVa() {
		return countyMinLongVa;
	}

	public void setCountyMinLongVa(String countyMinLongVa) {
		this.countyMinLongVa = countyMinLongVa;
	}

	public String getCountyMaxAltVa() {
		return countyMaxAltVa;
	}

	public void setCountyMaxAltVa(String countyMaxAltVa) {
		this.countyMaxAltVa = countyMaxAltVa;
	}

	public String getCountyMinAltVa() {
		return countyMinAltVa;
	}

	public void setCountyMinAltVa(String countyMinAltVa) {
		this.countyMinAltVa = countyMinAltVa;
	}

	public String getCountyMd() {
		return countyMd;
	}

	public void setCountyMd(String countyMd) {
		this.countyMd = countyMd;
	}
}
