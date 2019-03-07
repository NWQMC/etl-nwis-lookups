package gov.acwi.wqp.etl.county;

public class County {
	private String country_cd;
	private String state_cd;
	private String county_cd;
	private String county_nm;
	private String county_max_lat_va;
	private String county_min_lat_va;
	private String county_max_long_va;
	private String county_min_long_va;
	private String county_max_alt_va_;
	private String county_min_alt_va;
	private String county_md;
	
	public County() {
	}

	public County(String country_cd, String state_cd, String county_cd, String county_nm, String county_max_lat_va,
			String county_min_lat_va, String county_max_long_va, String county_min_long_va, String county_max_alt_va_,
			String county_min_alt_va, String county_md) {
		super();
		this.country_cd = country_cd;
		this.state_cd = state_cd;
		this.county_cd = county_cd;
		this.county_nm = county_nm;
		this.county_max_lat_va = county_max_lat_va;
		this.county_min_lat_va = county_min_lat_va;
		this.county_max_long_va = county_max_long_va;
		this.county_min_long_va = county_min_long_va;
		this.county_max_alt_va_ = county_max_alt_va_;
		this.county_min_alt_va = county_min_alt_va;
		this.county_md = county_md;
	}

	public String getCountry_cd() {
		return country_cd;
	}

	public void setCountry_cd(String country_cd) {
		this.country_cd = country_cd;
	}

	public String getState_cd() {
		return state_cd;
	}

	public void setState_cd(String state_cd) {
		this.state_cd = state_cd;
	}

	public String getCounty_cd() {
		return county_cd;
	}

	public void setCounty_cd(String county_cd) {
		this.county_cd = county_cd;
	}

	public String getCounty_nm() {
		return county_nm;
	}

	public void setCounty_nm(String county_nm) {
		this.county_nm = county_nm;
	}

	public String getCounty_max_lat_va() {
		return county_max_lat_va;
	}

	public void setCounty_max_lat_va(String county_max_lat_va) {
		this.county_max_lat_va = county_max_lat_va;
	}

	public String getCounty_min_lat_va() {
		return county_min_lat_va;
	}

	public void setCounty_min_lat_va(String county_min_lat_va) {
		this.county_min_lat_va = county_min_lat_va;
	}

	public String getCounty_max_long_va() {
		return county_max_long_va;
	}

	public void setCounty_max_long_va(String county_max_long_va) {
		this.county_max_long_va = county_max_long_va;
	}

	public String getCounty_min_long_va() {
		return county_min_long_va;
	}

	public void setCounty_min_long_va(String county_min_long_va) {
		this.county_min_long_va = county_min_long_va;
	}

	public String getCounty_max_alt_va_() {
		return county_max_alt_va_;
	}

	public void setCounty_max_alt_va_(String county_max_alt_va_) {
		this.county_max_alt_va_ = county_max_alt_va_;
	}

	public String getCounty_min_alt_va() {
		return county_min_alt_va;
	}

	public void setCounty_min_alt_va(String county_min_alt_va) {
		this.county_min_alt_va = county_min_alt_va;
	}

	public String getCounty_md() {
		return county_md;
	}

	public void setCounty_md(String county_md) {
		this.county_md = county_md;
	}
}
