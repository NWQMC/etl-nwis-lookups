package gov.acwi.wqp.etl.protoOrg;

import java.util.Date;

public class ProtoOrg {

	private String protoOrgCd;
	private String protoOrgNm;
	private String protoOrgFvCd;
	private boolean protoOrgVldFg;
	private String protoOrgInitNm;
	private Date protoOrgInitDt;
	private String protoOrgRevNm;
	private Date protoOrgRevDt;
	
	public ProtoOrg() {
	}

	public ProtoOrg(String protoOrgCd, String protoOrgNm, String protoOrgFvCd, boolean protoOrgVldFg,
			String protoOrgInitNm, Date protoOrgInitDt, String protoOrgRevNm, Date protoOrgRevDt) {
		super();
		this.protoOrgCd = protoOrgCd;
		this.protoOrgNm = protoOrgNm;
		this.protoOrgFvCd = protoOrgFvCd;
		this.protoOrgVldFg = protoOrgVldFg;
		this.protoOrgInitNm = protoOrgInitNm;
		this.protoOrgInitDt = protoOrgInitDt;
		this.protoOrgRevNm = protoOrgRevNm;
		this.protoOrgRevDt = protoOrgRevDt;
	}

	public String getProtoOrgCd() {
		return protoOrgCd;
	}

	public void setProtoOrgCd(String protoOrgCd) {
		this.protoOrgCd = protoOrgCd;
	}

	public String getProtoOrgNm() {
		return protoOrgNm;
	}

	public void setProtoOrgNm(String protoOrgNm) {
		this.protoOrgNm = protoOrgNm;
	}

	public String getProtoOrgFvCd() {
		return protoOrgFvCd;
	}

	public void setProtoOrgFvCd(String protoOrgFvCd) {
		this.protoOrgFvCd = protoOrgFvCd;
	}

	public boolean isProtoOrgVldFg() {
		return protoOrgVldFg;
	}

	public void setProtoOrgVldFg(boolean protoOrgVldFg) {
		this.protoOrgVldFg = protoOrgVldFg;
	}

	public String getProtoOrgInitNm() {
		return protoOrgInitNm;
	}

	public void setProtoOrgInitNm(String protoOrgInitNm) {
		this.protoOrgInitNm = protoOrgInitNm;
	}

	public Date getProtoOrgInitDt() {
		return protoOrgInitDt;
	}

	public void setProtoOrgInitDt(Date protoOrgInitDt) {
		this.protoOrgInitDt = protoOrgInitDt;
	}

	public String getProtoOrgRevNm() {
		return protoOrgRevNm;
	}

	public void setProtoOrgRevNm(String protoOrgRevNm) {
		this.protoOrgRevNm = protoOrgRevNm;
	}

	public Date getProtoOrgRevDt() {
		return protoOrgRevDt;
	}

	public void setProtoOrgRevDt(Date protoOrgRevDt) {
		this.protoOrgRevDt = protoOrgRevDt;
	}
}