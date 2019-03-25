package gov.acwi.wqp.etl.aqfr;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AqfrRowMapper implements RowMapper<Aqfr> {
	
	public static final String COUNTRY_CD = "country_cd";
	public static final String STATE_CD = "state_cd";
	public static final String AQFR_CD = "aqfr_cd";
	public static final String AQFR_NM = "aqfr_nm";
	public static final String AQFR_MD = "aqfr_md";
	
	public Aqfr mapRow(ResultSet rs, int rowNum) throws SQLException {
		Aqfr aqfr = new Aqfr();
		
		aqfr.setCountryCd(rs.getString(COUNTRY_CD));
		aqfr.setStateCd(rs.getString(STATE_CD));
		aqfr.setAqfrCd(rs.getString(AQFR_CD));
		aqfr.setAqfrNm(rs.getString(AQFR_NM));
		aqfr.setAqfrMd(rs.getString(AQFR_MD));
		
		return aqfr;
	}

}
