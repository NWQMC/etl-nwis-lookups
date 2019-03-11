package gov.acwi.wqp.etl.natAqfr;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class NatAqfrRowMapper implements RowMapper<NatAqfr> {
	
	public static final String COUNTRY_CD = "country_cd";
	public static final String STATE_CD = "state_cd";
	public static final String NAT_AQFR_CD = "nat_aqfr_cd";
	public static final String NAT_AQFR_NM = "nat_aqfr_nm";
	
	public NatAqfr mapRow(ResultSet rs, int rowNum) throws SQLException {
		NatAqfr aqfr = new NatAqfr();
		
		aqfr.setCountryCd(rs.getString(COUNTRY_CD));
		aqfr.setStateCd(rs.getString(STATE_CD));
		aqfr.setNatAqfrCd(rs.getString(NAT_AQFR_CD));
		aqfr.setNatAqfrNm(rs.getString(NAT_AQFR_NM));
		
		return aqfr;
	}

}
