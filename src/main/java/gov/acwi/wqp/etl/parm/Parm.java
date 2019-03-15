package gov.acwi.wqp.etl.parm;

import java.util.Date;

public class Parm {

	private String parmCd;
	private String parmNm;
	private String parmRmkTx;
	private String parmUntTx;
	private int parmSeqNu;
	private String parmSeqGrpCd;
	private String parmDs;
	private String parmMediumTx;
	private String parmFracTx;
	private String parmTempTx;
	private String parmStatTx;
	private String parmTmTx;
	private String parmWtTx;
	private String parmSizeTx;
	private boolean parmEntryFg;
	private boolean parmPublicFg;
	private boolean parmNegFg;
	private boolean parmZeroFg;
	private boolean parmNullFg;
	private boolean parmTsFg;
	private Date parmInitDt;
	private String parmInitNm;
	private Date parmRevDt;
	private String parmRevNm;
	private String parmSeqGrpNm;
	private String wqpcrosswalk;
	private String srsname;
	private String multiplier;
	
	
	public Parm() {
	}


	public Parm(String parmCd, String parmNm, String parmRmkTx, String parmUntTx, int parmSeqNu, String parmSeqGrpCd, String parmDs,
			String parmMediumTx, String parmFracTx, String parmTempTx, String parmStatTx, String parmTmTx,
			String parmWtTx, String parmSizeTx, boolean parmEntryFg, boolean parmPublicFg, boolean parmNegFg,
			boolean parmZeroFg, boolean parmNullFg, boolean parmTsFg, Date parmInitDt, String parmInitNm,
			Date parmRevDt, String parmRevNm, String parmSeqGrpNm, String wqpcrosswalk, String srsname,
			String multiplier) {
		super();
		this.parmCd = parmCd;
		this.parmNm = parmNm;
		this.parmRmkTx = parmRmkTx;
		this.parmUntTx = parmUntTx;
		this.parmSeqNu = parmSeqNu;
		this.parmSeqGrpCd = parmSeqGrpCd;
		this.parmDs = parmDs;
		this.parmMediumTx = parmMediumTx;
		this.parmFracTx = parmFracTx;
		this.parmTempTx = parmTempTx;
		this.parmStatTx = parmStatTx;
		this.parmTmTx = parmTmTx;
		this.parmWtTx = parmWtTx;
		this.parmSizeTx = parmSizeTx;
		this.parmEntryFg = parmEntryFg;
		this.parmPublicFg = parmPublicFg;
		this.parmNegFg = parmNegFg;
		this.parmZeroFg = parmZeroFg;
		this.parmNullFg = parmNullFg;
		this.parmTsFg = parmTsFg;
		this.parmInitDt = parmInitDt;
		this.parmInitNm = parmInitNm;
		this.parmRevDt = parmRevDt;
		this.parmRevNm = parmRevNm;
		this.parmSeqGrpNm = parmSeqGrpNm;
		this.wqpcrosswalk = wqpcrosswalk;
		this.srsname = srsname;
		this.multiplier = multiplier;
	}


	public String getParmCd() {
		return parmCd;
	}


	public void setParmCd(String parmCd) {
		this.parmCd = parmCd;
	}


	public String getParmNm() {
		return parmNm;
	}


	public void setParmNm(String parmNm) {
		this.parmNm = parmNm;
	}


	public String getParmRmkTx() {
		return parmRmkTx;
	}


	public void setParmRmkTx(String parmRmkTx) {
		this.parmRmkTx = parmRmkTx;
	}


	public String getParmUntTx() {
		return parmUntTx;
	}


	public void setParmUntTx(String parmUntTx) {
		this.parmUntTx = parmUntTx;
	}


	public int getParmSeqNu() {
		return parmSeqNu;
	}
	
	public void setParmSeqNu(int parmSeqNu) {
		this.parmSeqNu = parmSeqNu;
	}


	public String getParmSeqGrpCd() {
		return parmSeqGrpCd;
	}


	public void setParmSeqGrpCd(String parmSeqGrpCd) {
		this.parmSeqGrpCd = parmSeqGrpCd;
	}
	
	
	public String getParmDs() {
		return parmDs;
	}


	public void setParmDs(String parmDs) {
		this.parmDs = parmDs;
	}


	public String getParmMediumTx() {
		return parmMediumTx;
	}


	public void setParmMediumTx(String parmMediumTx) {
		this.parmMediumTx = parmMediumTx;
	}


	public String getParmFracTx() {
		return parmFracTx;
	}


	public void setParmFracTx(String parmFracTx) {
		this.parmFracTx = parmFracTx;
	}


	public String getParmTempTx() {
		return parmTempTx;
	}


	public void setParmTempTx(String parmTempTx) {
		this.parmTempTx = parmTempTx;
	}


	public String getParmStatTx() {
		return parmStatTx;
	}


	public void setParmStatTx(String parmStatTx) {
		this.parmStatTx = parmStatTx;
	}


	public String getParmTmTx() {
		return parmTmTx;
	}


	public void setParmTmTx(String parmTmTx) {
		this.parmTmTx = parmTmTx;
	}


	public String getParmWtTx() {
		return parmWtTx;
	}


	public void setParmWtTx(String parmWtTx) {
		this.parmWtTx = parmWtTx;
	}


	public String getParmSizeTx() {
		return parmSizeTx;
	}


	public void setParmSizeTx(String parmSizeTx) {
		this.parmSizeTx = parmSizeTx;
	}


	public boolean isParmEntryFg() {
		return parmEntryFg;
	}


	public void setParmEntryFg(boolean parmEntryFg) {
		this.parmEntryFg = parmEntryFg;
	}


	public boolean isParmPublicFg() {
		return parmPublicFg;
	}


	public void setParmPublicFg(boolean parmPublicFg) {
		this.parmPublicFg = parmPublicFg;
	}


	public boolean isParmNegFg() {
		return parmNegFg;
	}


	public void setParmNegFg(boolean parmNegFg) {
		this.parmNegFg = parmNegFg;
	}


	public boolean isParmZeroFg() {
		return parmZeroFg;
	}


	public void setParmZeroFg(boolean parmZeroFg) {
		this.parmZeroFg = parmZeroFg;
	}


	public boolean isParmNullFg() {
		return parmNullFg;
	}


	public void setParmNullFg(boolean parmNullFg) {
		this.parmNullFg = parmNullFg;
	}


	public boolean isParmTsFg() {
		return parmTsFg;
	}


	public void setParmTsFg(boolean parmTsFg) {
		this.parmTsFg = parmTsFg;
	}


	public Date getParmInitDt() {
		return parmInitDt;
	}


	public void setParmInitDt(Date parmInitDt) {
		this.parmInitDt = parmInitDt;
	}


	public String getParmInitNm() {
		return parmInitNm;
	}


	public void setParmInitNm(String parmInitNm) {
		this.parmInitNm = parmInitNm;
	}


	public Date getParmRevDt() {
		return parmRevDt;
	}


	public void setParmRevDt(Date parmRevDt) {
		this.parmRevDt = parmRevDt;
	}


	public String getParmRevNm() {
		return parmRevNm;
	}


	public void setParmRevNm(String parmRevNm) {
		this.parmRevNm = parmRevNm;
	}


	public String getParmSeqGrpNm() {
		return parmSeqGrpNm;
	}


	public void setParmSeqGrpNm(String parmSeqGrpNm) {
		this.parmSeqGrpNm = parmSeqGrpNm;
	}


	public String getWqpcrosswalk() {
		return wqpcrosswalk;
	}


	public void setWqpcrosswalk(String wqpcrosswalk) {
		this.wqpcrosswalk = wqpcrosswalk;
	}


	public String getSrsname() {
		return srsname;
	}


	public void setSrsname(String srsname) {
		this.srsname = srsname;
	}


	public String getMultiplier() {
		return multiplier;
	}


	public void setMultiplier(String multiplier) {
		this.multiplier = multiplier;
	}
}

	