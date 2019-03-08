package gov.acwi.wqp.etl.hydEventCd;

public class HydEventCd {
	
	private Character hydEventCd;
	private int hydEventSrtNu;
	private boolean hydEventVldFg;
	private String hydEventNm;
	private String hydEventDs;
	
	public HydEventCd() {
	}

	public HydEventCd(Character hydEventCd, int hydEventSrtNu, boolean hydEventVldFg, String hydEventNm,
			String hydEventDs) {
		super();
		this.hydEventCd = hydEventCd;
		this.hydEventSrtNu = hydEventSrtNu;
		this.hydEventVldFg = hydEventVldFg;
		this.hydEventNm = hydEventNm;
		this.hydEventDs = hydEventDs;
	}

	public Character getHydEventCd() {
		return hydEventCd;
	}

	public void setHydEventCd(Character hydEventCd) {
		this.hydEventCd = hydEventCd;
	}

	public int getHydEventSrtNu() {
		return hydEventSrtNu;
	}

	public void setHydEventSrtNu(int hydEventSrtNu) {
		this.hydEventSrtNu = hydEventSrtNu;
	}

	public boolean isHydEventVldFg() {
		return hydEventVldFg;
	}

	public void setHydEventVldFg(boolean hydEventVldFg) {
		this.hydEventVldFg = hydEventVldFg;
	}

	public String getHydEventNm() {
		return hydEventNm;
	}

	public void setHydEventNm(String hydEventNm) {
		this.hydEventNm = hydEventNm;
	}

	public String getHydEventDs() {
		return hydEventDs;
	}

	public void setHydEventDs(String hydEventDs) {
		this.hydEventDs = hydEventDs;
	}
}
