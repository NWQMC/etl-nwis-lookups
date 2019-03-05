package main.java.gov.acwi.wqp.etl;

public class GwReflist {

	private String gwEdTblNm;
	private String gwRefCd;
	private String gwRefNm;
	private int gwSortNu;
	private String gwRefDs;
	private Character gwValidFg;
	
	public GwReflist() {
	}
	
	public GwReflist(String gwEdTblNm, String gwRefCd, String gwRefNm, int gwSortNu, String gwRefDs, Character gwValidFg) {
		this.gwEdTblNm = gwEdTblNm;
		this.gwRefCd = gwRefCd;
		this.gwRefNm = gwRefNm;
		this.gwSortNu = gwSortNu;
		this.gwRefDs = gwRefDs;
		this.gwValidFg = gwValidFg;
	}
	public String getGwEdTblNm() {
		return gwEdTblNm;
	}
	public void setGwEdTblNm(String gwEdTblNm) {
		this.gwEdTblNm = gwEdTblNm;
	}
	public String getGwRefCd() {
		return gwRefCd;
	}
	public void setGwRefCd(String gwRefCd) {
		this.gwRefCd = gwRefCd;
	}
	public String getGwRefNm() {
		return gwRefNm;
	}
	public void setGwRefNm(String gwRefNm) {
		this.gwRefNm = gwRefNm;
	}
	public int getGwSortNu() {
		return gwSortNu;
	}
	public void setGwSortNu(int gwSortNu) {
		this.gwSortNu = gwSortNu;
	}
	public String getGwRefDs() {
		return gwRefDs;
	}
	public void setGwRefDs(String gwRefDs) {
		this.gwRefDs = gwRefDs;
	}
	public Character getGwValidFg() {
		return gwValidFg;
	}
	public void setGwValidFg(Character gwValidFg) {
		this.gwValidFg = gwValidFg;
	}
	
}
