package gov.acwi.wqp.etl.parm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import gov.acwi.wqp.etl.parmMeth.ParmMeth;

public class ParmMethMultiplerRowMapper implements RowMapper<ParmMeth> {
	
	public static final String PARM_CD = "parm_cd";
	public static final String MULTIPLIER = "multiplier";
	
	public ParmMeth mapRow(ResultSet rs, int rowNum) throws SQLException {
		ParmMeth parmMeth= new ParmMeth();
		
		parmMeth.setParmCd(rs.getString(PARM_CD));
		parmMeth.setMultiplier(rs.getString(MULTIPLIER));
		
		return parmMeth;
		
	}

}
