package main.java.gov.acwi.wqp.etl.citMeth;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CitMethRowMapper implements RowMapper<CitMeth> {
	
	public static final String CIT_METH_ID = "cit_meth_id";
	public static final String METH_CD = "meth_cd";
	public static final String CIT_NM = "cit_nm";
	public static final String CIT_METH_NO = "cit_meth_no";
	public static final String METH_SRC_CD = "meth_src_cd";
	public static final String CIT_METH_INIT_NM = "cit_meth_init_nm";
	public static final String CIT_METH_INIT_DT = "cit_meth_init_dt";
	public static final String CIT_METH_REV_NM = "cit_meth_rev_nm";
	public static final String CIT_METH_REV_DT = "cit_meth_rev_dt";

	public CitMeth mapRow(ResultSet rs, int rowNum) throws SQLException {
		CitMeth citMeth = new CitMeth();
		
		citMeth.setCitMethId(rs.getInt(CIT_METH_ID));
		citMeth.setMethCd(rs.getString(METH_CD));
		citMeth.setCitNm(rs.getString(CIT_NM));
		citMeth.setCitMethNo(rs.getString(CIT_METH_NO));
		citMeth.setMethSrcCd(rs.getString(METH_SRC_CD));
		citMeth.setCitMethInitNm(rs.getString(CIT_METH_INIT_NM));
		citMeth.setCitMethInitDt(rs.getDate(CIT_METH_INIT_DT));
		citMeth.setCitMethRevNm(rs.getString(CIT_METH_REV_NM));
		citMeth.setCitMethRevDt(rs.getDate(CIT_METH_REV_DT));
		
		return citMeth;
	}

}
