package gov.acwi.wqp.etl.parmMeth;

import java.util.Date;

public class ParmMeth {

	private String parmCd;
	private String methCd;
	private String parmMethLgcyCd;
	private String  parmMethRndTx;
	private String  parmMethInitNm;
	private Date parmMethInitDt;
	private String  parmMethRevNm;
	private Date parmMethRevDt;
	private boolean parmMethVldFg;
	private String multiplier;
	

	public String getParmCd() {
		return parmCd;
	}

	public void setParmCd(String parmCd) {
		this.parmCd = parmCd;
	}

	public String getMethCd() {
		return methCd;
	}

	public void setMethCd(String methCd) {
		this.methCd = methCd;
	}

	public String getParmMethLgcyCd() {
		return parmMethLgcyCd;
	}

	public void setParmMethLgcyCd(String parmMethLgcyCd) {
		this.parmMethLgcyCd = parmMethLgcyCd;
	}

	public String getParmMethRndTx() {
		return parmMethRndTx;
	}

	public void setParmMethRndTx(String parmMethRndTx) {
		this.parmMethRndTx = parmMethRndTx;
	}

	public String getParmMethInitNm() {
		return parmMethInitNm;
	}

	public void setParmMethInitNm(String parmMethInitNm) {
		this.parmMethInitNm = parmMethInitNm;
	}

	public Date getParmMethInitDt() {
		return parmMethInitDt;
	}

	public void setParmMethInitDt(Date parmMethInitDt) {
		this.parmMethInitDt = parmMethInitDt;
	}

	public String getParmMethRevNm() {
		return parmMethRevNm;
	}

	public void setParmMethRevNm(String parmMethRevNm) {
		this.parmMethRevNm = parmMethRevNm;
	}

	public Date getParmMethRevDt() {
		return parmMethRevDt;
	}

	public void setParmMethRevDt(Date parmMethRevDt) {
		this.parmMethRevDt = parmMethRevDt;
	}

	public boolean isParmMethVldFg() {
		return parmMethVldFg;
	}

	public void setParmMethVldFg(boolean parmMethVldFg) {
		this.parmMethVldFg = parmMethVldFg;
	}
	
	public String getMultiplier() {
		return multiplier;
	}

	public void setMultiplier(String multiplier) {
		this.multiplier = multiplier;
	}
}
