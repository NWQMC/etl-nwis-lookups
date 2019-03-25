package gov.acwi.wqp.etl.siteTp;


public class SiteTp {

	private String siteTpCd;
	private int siteTpSrtNu;
	private boolean siteTpVldFg;
	private boolean siteTpPrimFg;
	private String siteTpNm;
	private String siteTpLn;
	private String siteTpDs;
	
	public SiteTp() {
	}

	public SiteTp(String siteTpCd, int siteTpSrtNu, boolean siteTpVldFg, boolean siteTpPrimFg, String siteTpNm,
			String siteTpLn, String siteTpDs) {
		super();
		this.siteTpCd = siteTpCd;
		this.siteTpSrtNu = siteTpSrtNu;
		this.siteTpVldFg = siteTpVldFg;
		this.siteTpPrimFg = siteTpPrimFg;
		this.siteTpNm = siteTpNm;
		this.siteTpLn = siteTpLn;
		this.siteTpDs = siteTpDs;
	}

	public String getSiteTpCd() {
		return siteTpCd;
	}

	public void setSiteTpCd(String siteTpCd) {
		this.siteTpCd = siteTpCd;
	}

	public int getSiteTpSrtNu() {
		return siteTpSrtNu;
	}

	public void setSiteTpSrtNu(int siteTpSrtNu) {
		this.siteTpSrtNu = siteTpSrtNu;
	}

	public boolean isSiteTpVldFg() {
		return siteTpVldFg;
	}

	public void setSiteTpVldFg(boolean siteTpVldFg) {
		this.siteTpVldFg = siteTpVldFg;
	}

	public boolean isSiteTpPrimFg() {
		return siteTpPrimFg;
	}

	public void setSiteTpPrimFg(boolean siteTpPrimFg) {
		this.siteTpPrimFg = siteTpPrimFg;
	}

	public String getSiteTpNm() {
		return siteTpNm;
	}

	public void setSiteTpNm(String siteTpNm) {
		this.siteTpNm = siteTpNm;
	}

	public String getSiteTpLn() {
		return siteTpLn;
	}

	public void setSiteTpLn(String siteTpLn) {
		this.siteTpLn = siteTpLn;
	}

	public String getSiteTpDs() {
		return siteTpDs;
	}

	public void setSiteTpDs(String siteTpDs) {
		this.siteTpDs = siteTpDs;
	}
}