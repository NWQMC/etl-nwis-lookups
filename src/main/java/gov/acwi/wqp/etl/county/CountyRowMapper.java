package gov.acwi.wqp.etl.county;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CountyRowMapper implements RowMapper<County> {
	
	public static final String COUNTRY_CD = "country_cd";
	public static final String STATE_CD = "state_cd";
	public static final String COUNTY_CD = "county_cd";
	public static final String COUNTY_NM = "county_nm";
	public static final String COUNTY_MAX_LAT_VA = "county_max_lat_va";
	public static final String COUNTY_MIN_LAT_VA = "county_min_lat_va";
	public static final String COUNTY_MAX_LONG_VA = "county_max_long_va";
	public static final String COUNTY_MIN_LONG_VA = "county_min_long_va";
	public static final String COUNTY_MAX_ALT_VA = "county_max_alt_va";
	public static final String COUNTY_MIN_ALT_VA = "county_min_alt_va";
	public static final String COUNTY_MD = "county_md";
	
	public County mapRow(ResultSet rs, int rowNum) throws SQLException {
		County county = new County();
		
		county.setCountryCd(rs.getString(COUNTRY_CD));
		county.setStateCd(rs.getString(STATE_CD));
		county.setCountyCd(rs.getString(COUNTY_CD));
		county.setCountyNm(rs.getString(COUNTY_NM));
		county.setCountyMaxLatVa(rs.getString(COUNTY_MAX_LAT_VA));
		county.setCountyMinLatVa(rs.getString(COUNTY_MIN_LAT_VA));
		county.setCountyMaxLongVa(rs.getString(COUNTY_MAX_LONG_VA));
		county.setCountyMinLongVa(rs.getString(COUNTY_MIN_LONG_VA));
		county.setCountyMaxAltVa(rs.getString(COUNTY_MAX_ALT_VA));
		county.setCountyMinAltVa(rs.getString(COUNTY_MIN_ALT_VA));
		county.setCountyMd(rs.getString(COUNTY_MD));
		
		return county;
	}
}
