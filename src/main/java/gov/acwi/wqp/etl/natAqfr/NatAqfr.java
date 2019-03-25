package gov.acwi.wqp.etl.natAqfr;

public class NatAqfr {

	private String countryCd;
	private String stateCd;
	private String natAqfrCd;
	private String natAqfrNm;

	
	public NatAqfr() {
	}
	
	public NatAqfr(String countryCd, String stateCd, String natAqfrCd, String natAqfrNm) {
		this.countryCd = countryCd;
		this.stateCd = stateCd;
		this.natAqfrCd = natAqfrCd;
		this.natAqfrNm = natAqfrNm;
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

	public String getNatAqfrCd() {
		return natAqfrCd;
	}

	public void setNatAqfrCd(String aqfrCd) {
		this.natAqfrCd = aqfrCd;
	}

	public String getNatAqfrNm() {
		return natAqfrNm;
	}

	public void setNatAqfrNm(String natAqfrNm) {
		this.natAqfrNm = natAqfrNm;
	}
}
