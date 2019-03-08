package gov.acwi.wqp.etl.hydCondCd;

public class HydCondCd {
	
	private Character hydCondCd;
	private int hydCondSrtNu;
	private boolean hydCondVldFg;
	private String hydCondNm;
	private String hydCondDs;
	
	public HydCondCd() {
	}

	public HydCondCd(Character hydCondCd, int hydCondSrtNu, boolean hydCondVldFg, String hydCondNm, String hydCondDs) {
		super();
		this.hydCondCd = hydCondCd;
		this.hydCondSrtNu = hydCondSrtNu;
		this.hydCondVldFg = hydCondVldFg;
		this.hydCondNm = hydCondNm;
		this.hydCondDs = hydCondDs;
	}

	public Character getHydCondCd() {
		return hydCondCd;
	}

	public void setHydCondCd(Character hydCondCd) {
		this.hydCondCd = hydCondCd;
	}

	public int getHydCondSrtNu() {
		return hydCondSrtNu;
	}

	public void setHydCondSrtNu(int hydCondSrtNu) {
		this.hydCondSrtNu = hydCondSrtNu;
	}

	public boolean isHydCondVldFg() {
		return hydCondVldFg;
	}

	public void setHydCondVldFg(boolean hydCondVldFg) {
		this.hydCondVldFg = hydCondVldFg;
	}

	public String getHydCondNm() {
		return hydCondNm;
	}

	public void setHydCondNm(String hydCondNm) {
		this.hydCondNm = hydCondNm;
	}

	public String getHydCondDs() {
		return hydCondDs;
	}

	public void setHydCondDs(String hydCondDs) {
		this.hydCondDs = hydCondDs;
	}
}
