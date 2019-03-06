package main.java.gov.acwi.wqp.etl.citMeth;

import java.util.Date;

public class CitMeth {

	private int citMethId;
	private String methCd;
	private String citNm;
	private String citMethNo;
	private String methSrcCd;
	private String citMethInitNm;
	private Date citMethInitDt;
	private String citMethRevNm;
	private Date citMethRevDt;
	
	
	public CitMeth() {
	}


	public CitMeth(int citMethId, String methCd, String citNm, String citMethNo, String methSrcCd, String citMethInitNm,
			Date citMethInitDt, String citMethRevNm, Date citMethRevDt) {
		super();
		this.citMethId = citMethId;
		this.methCd = methCd;
		this.citNm = citNm;
		this.citMethNo = citMethNo;
		this.methSrcCd = methSrcCd;
		this.citMethInitNm = citMethInitNm;
		this.citMethInitDt = citMethInitDt;
		this.citMethRevNm = citMethRevNm;
		this.citMethRevDt = citMethRevDt;
	}


	public int getCitMethId() {
		return citMethId;
	}


	public void setCitMethId(int citMethId) {
		this.citMethId = citMethId;
	}


	public String getMethCd() {
		return methCd;
	}


	public void setMethCd(String methCd) {
		this.methCd = methCd;
	}


	public String getCitNm() {
		return citNm;
	}


	public void setCitNm(String citNm) {
		this.citNm = citNm;
	}


	public String getCitMethNo() {
		return citMethNo;
	}


	public void setCitMethNo(String citMethNo) {
		this.citMethNo = citMethNo;
	}


	public String getMethSrcCd() {
		return methSrcCd;
	}


	public void setMethSrcCd(String methSrcCd) {
		this.methSrcCd = methSrcCd;
	}


	public String getCitMethInitNm() {
		return citMethInitNm;
	}


	public void setCitMethInitNm(String citMethInitNm) {
		this.citMethInitNm = citMethInitNm;
	}


	public Date getCitMethInitDt() {
		return citMethInitDt;
	}


	public void setCitMethInitDt(Date citMethInitDt) {
		this.citMethInitDt = citMethInitDt;
	}


	public String getCitMethRevNm() {
		return citMethRevNm;
	}


	public void setCitMethRevNm(String citMethRevNm) {
		this.citMethRevNm = citMethRevNm;
	}


	public Date getCitMethRevDt() {
		return citMethRevDt;
	}


	public void setCitMethRevDt(Date citMethRevDt) {
		this.citMethRevDt = citMethRevDt;
	}
}
