package gov.acwi.wqp.etl.valQualCd;

public class ValQualCd {

	private String valQualCd;
	private String valQualTp;
	private int valQualSrtNu;
	private boolean valQualVldFg;
	private String valQualNm;
	private String valQualDs;
	
	public ValQualCd() {
	}

	public ValQualCd(String valQualCd, String valQualTp, int valQualSrtNu, boolean valQualVldFg, String valQualNm,
			String valQualDs) {
		super();
		this.valQualCd = valQualCd;
		this.valQualTp = valQualTp;
		this.valQualSrtNu = valQualSrtNu;
		this.valQualVldFg = valQualVldFg;
		this.valQualNm = valQualNm;
		this.valQualDs = valQualDs;
	}

	public String getValQualCd() {
		return valQualCd;
	}

	public void setValQualCd(String valQualCd) {
		this.valQualCd = valQualCd;
	}

	public String getValQualTp() {
		return valQualTp;
	}

	public void setValQualTp(String valQualTp) {
		this.valQualTp = valQualTp;
	}

	public int getValQualSrtNu() {
		return valQualSrtNu;
	}

	public void setValQualSrtNu(int valQualSrtNu) {
		this.valQualSrtNu = valQualSrtNu;
	}

	public boolean isValQualVldFg() {
		return valQualVldFg;
	}

	public void setValQualVldFg(boolean valQualVldFg) {
		this.valQualVldFg = valQualVldFg;
	}

	public String getValQualNm() {
		return valQualNm;
	}

	public void setValQualNm(String valQualNm) {
		this.valQualNm = valQualNm;
	}

	public String getValQualDs() {
		return valQualDs;
	}

	public void setValQualDs(String valQualDs) {
		this.valQualDs = valQualDs;
	}
}
