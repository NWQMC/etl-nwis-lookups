package gov.acwi.wqp.etl.aqfr;

public class Aqfr {

	private String countryCd;
	private String stateCd;
	private String aqfrCd;
	private String aqfrNm;
	private String aqfrMd;
	
	public Aqfr() {
	}
	
	public Aqfr(String countryCd, String stateCd, String aqfrCd, String aqfrNm, String aqfrMd) {
		this.countryCd = countryCd;
		this.stateCd = stateCd;
		this.aqfrCd = aqfrCd;
		this.aqfrNm = aqfrNm;
		this.aqfrMd = aqfrMd;
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

	public String getAqfrCd() {
		return aqfrCd;
	}

	public void setAqfrCd(String aqfrCd) {
		this.aqfrCd = aqfrCd;
	}

	public String getAqfrNm() {
		return aqfrNm;
	}

	public void setAqfrNm(String aqfrNm) {
		this.aqfrNm = aqfrNm;
	}

	public String getAqfrMd() {
		return aqfrMd;
	}

	public void setAqfrMd(String aqfrMd) {
		this.aqfrMd = aqfrMd;
	}
	
	
}
