package gov.acwi.wqp.etl.methWithCit;

public class MethWithCit {

	private String methCd;
	private String methNm;
	private String citNm;
	
	public MethWithCit() {
	}

	public MethWithCit(String methCd, String methNm, String citNm) {
		super();
		this.methCd = methCd;
		this.methNm = methNm;
		this.citNm = citNm;
	}

	public String getMethCd() {
		return methCd;
	}

	public void setMethCd(String methCd) {
		this.methCd = methCd;
	}

	public String getMethNm() {
		return methNm;
	}

	public void setMethNm(String methNm) {
		this.methNm = methNm;
	}

	public String getCitNm() {
		return citNm;
	}

	public void setCitNm(String citNm) {
		this.citNm = citNm;
	}
}
