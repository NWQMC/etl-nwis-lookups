package gov.acwi.wqp.etl.methWithCit;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MethWithCitRowManager implements RowMapper<MethWithCit> {
	
	public static final String METH_CD = "meth_cd";
	public static final String METH_NM = "meth_nm";
	public static final String CIT_NM = "cit_nm";
	
	
	public MethWithCit mapRow(ResultSet rs, int rowNum) throws SQLException {
		MethWithCit methWithCit = new MethWithCit();
		
		methWithCit.setMethCd(rs.getString(METH_CD));
		methWithCit.setMethNm(rs.getString(METH_NM));
		methWithCit.setCitNm(rs.getString(CIT_NM));
		
		return methWithCit;
	}

}
