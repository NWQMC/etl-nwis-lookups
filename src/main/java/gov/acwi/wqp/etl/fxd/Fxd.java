package gov.acwi.wqp.etl.fxd;

import java.math.BigDecimal;
import java.util.Date;

public class Fxd {
	
	private String parmCd;
	private BigDecimal fxdVa;
	private String fxdNm;
	private String fxdTx;
	private Date fxdInitDt;
	private String fxdInitNm;
	private Date fxdRevDt;
	private String fxdRevNm;

	public Fxd() {
	}

	public Fxd(String parmCd, BigDecimal fxdVa, String fxdNm, String fxdTx, Date fxdInitDt, String fxdInitNm, Date fxdRevDt,
			String fxdRevNm) {
		super();
		this.parmCd = parmCd;
		this.fxdVa = fxdVa;
		this.fxdNm = fxdNm;
		this.fxdTx = fxdTx;
		this.fxdInitDt = fxdInitDt;
		this.fxdInitNm = fxdInitNm;
		this.fxdRevDt = fxdRevDt;
		this.fxdRevNm = fxdRevNm;
	}

	public String getParmCd() {
		return parmCd;
	}

	public void setParmCd(String parmCd) {
		this.parmCd = parmCd;
	}

	public BigDecimal getFxdVa() {
		return fxdVa;
	}

	public void setFxdVa(BigDecimal fxdVa) {
		this.fxdVa = fxdVa;
	}

	public String getFxdNm() {
		return fxdNm;
	}

	public void setFxdNm(String fxdNm) {
		this.fxdNm = fxdNm;
	}

	public String getFxdTx() {
		return fxdTx;
	}

	public void setFxdTx(String fxdTx) {
		this.fxdTx = fxdTx;
	}

	public Date getFxdInitDt() {
		return fxdInitDt;
	}

	public void setFxdInitDt(Date fxdInitDt) {
		this.fxdInitDt = fxdInitDt;
	}

	public String getFxdInitNm() {
		return fxdInitNm;
	}

	public void setFxdInitNm(String fxdInitNm) {
		this.fxdInitNm = fxdInitNm;
	}

	public Date getFxdRevDt() {
		return fxdRevDt;
	}

	public void setFxdRevDt(Date fxdRevDt) {
		this.fxdRevDt = fxdRevDt;
	}

	public String getFxdRevNm() {
		return fxdRevNm;
	}

	public void setFxdRevNm(String fxdRevNm) {
		this.fxdRevNm = fxdRevNm;
	}
}
