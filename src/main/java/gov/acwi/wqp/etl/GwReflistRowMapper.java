package main.java.gov.acwi.wqp.etl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class GwReflistRowMapper implements RowMapper<GwReflist> {
	
	public static final String GW_ED_TBL_NM = "gw_ed_tbl_nm";
	public static final String GW_REF_CD = "gw_ref_cd";
	public static final String GW_REF_NM = "gw_ref_nm";
	public static final String GW_SORT_NU = "gw_sort_nu";
	public static final String GW_REF_DS = "gw_ref_ds";
	public static final String GW_VALID_FG = "gw_valid_fg";
	
	public GwReflist mapRow(ResultSet rs, int rowNum) throws SQLException {
		GwReflist gwReflist = new GwReflist();
		
		gwReflist.setGwEdTblNm(rs.getString(GW_ED_TBL_NM));
		gwReflist.setGwRefCd(rs.getString(GW_REF_CD));
		gwReflist.setGwRefNm(rs.getString(GW_REF_NM));
		gwReflist.setGwSortNu(rs.getInt(GW_SORT_NU));
		gwReflist.setGwRefDs(rs.getString(GW_REF_DS));
		gwReflist.setGwValidFg(rs.getString(GW_VALID_FG).charAt(0));
		return gwReflist;
	}

}
