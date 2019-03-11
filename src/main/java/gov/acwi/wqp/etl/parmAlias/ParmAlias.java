package gov.acwi.wqp.etl.parmAlias;

import java.util.Date;

public class ParmAlias {

	private String parmCd;
	private String parmAliasCd;
	private String parmAliasNm;
	private Date parmAliasInitDt;
	private String parmAliasInitNm;
	private Date parmAliasRevDt;
	private String parmAliasRevNm;
	
	public ParmAlias() {
	}

	public ParmAlias(String parmCd, String parmAliasCd, String parmAliasNm, Date parmAliasInitDt, String parmAliasInitNm,
			Date parmAliasRevDt, String parmAliasRevNm) {
		super();
		this.parmCd = parmCd;
		this.parmAliasCd = parmAliasCd;
		this.parmAliasNm = parmAliasNm;
		this.parmAliasInitDt = parmAliasInitDt;
		this.parmAliasInitNm = parmAliasInitNm;
		this.parmAliasRevDt = parmAliasRevDt;
		this.parmAliasRevNm = parmAliasRevNm;
	}

	public String getParmCd() {
		return parmCd;
	}

	public void setParmCd(String parmCd) {
		this.parmCd = parmCd;
	}

	public String getParmAliasCd() {
		return parmAliasCd;
	}

	public void setParmAliasCd(String parmAliasCd) {
		this.parmAliasCd = parmAliasCd;
	}

	public String getParmAliasNm() {
		return parmAliasNm;
	}

	public void setParmAliasNm(String parmAliasNm) {
		this.parmAliasNm = parmAliasNm;
	}

	public Date getParmAliasInitDt() {
		return parmAliasInitDt;
	}

	public void setParmAliasInitDt(Date parmMethInitDt) {
		this.parmAliasInitDt = parmMethInitDt;
	}

	public String getParmAliasInitNm() {
		return parmAliasInitNm;
	}

	public void setParmAliasInitNm(String parmAliasInitNm) {
		this.parmAliasInitNm = parmAliasInitNm;
	}

	public Date getParmAliasRevDt() {
		return parmAliasRevDt;
	}

	public void setParmAliasRevDt(Date parmAliasRevDt) {
		this.parmAliasRevDt = parmAliasRevDt;
	}

	public String getParmAliasRevNm() {
		return parmAliasRevNm;
	}

	public void setParmAliasRevNm(String parmAliasRevNm) {
		this.parmAliasRevNm = parmAliasRevNm;
	}
}