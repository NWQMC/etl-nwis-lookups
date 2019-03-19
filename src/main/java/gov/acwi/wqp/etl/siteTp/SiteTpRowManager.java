package gov.acwi.wqp.etl.siteTp;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class SiteTpRowManager implements RowMapper<SiteTp> {
	
	public static final String SITE_TP_CD = "site_tp_cd";
	public static final String SITE_TP_SRT_NU = "site_tp_srt_nu";
	public static final String SITE_TP_VLD_FG = "site_tp_vld_fg";
	public static final String SITE_TP_PRIM_FG = "site_tp_prim_fg";
	public static final String SITE_TP_NM = "site_tp_nm";
	public static final String SITE_TP_LN = "site_tp_ln";
	public static final String SITE_TP_DS = "site_tp_ds";
	
	public SiteTp mapRow(ResultSet rs, int rowNum) throws SQLException {
		SiteTp siteTp = new SiteTp();
		
		siteTp.setSiteTpCd(rs.getString(SITE_TP_CD));
		siteTp.setSiteTpSrtNu(rs.getInt(SITE_TP_SRT_NU));		
		siteTp.setSiteTpVldFg(rs.getString(SITE_TP_VLD_FG).charAt(0) == 'Y');		
		siteTp.setSiteTpPrimFg(rs.getString(SITE_TP_PRIM_FG).charAt(0) == 'Y');		
		siteTp.setSiteTpNm(rs.getString(SITE_TP_NM));		
		siteTp.setSiteTpLn(rs.getString(SITE_TP_LN));		
		siteTp.setSiteTpDs(rs.getString(SITE_TP_DS));		
		
		return siteTp;
	}

}
