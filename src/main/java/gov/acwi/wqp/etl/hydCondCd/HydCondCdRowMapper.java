package gov.acwi.wqp.etl.hydCondCd;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class HydCondCdRowMapper implements RowMapper<HydCondCd> {
	
	public static final String HYD_COND_CD = "hyd_cond_cd";
	public static final String HYD_COND_SRT_NU = "hyd_cond_srt_nu";
	public static final String HYD_COND_VLD_FG = "hyd_cond_vld_fg";
	public static final String HYD_COND_NM = "hyd_cond_nm";
	public static final String HYD_COND_DS = "hyd_cond_ds";
	
	public HydCondCd mapRow(ResultSet rs, int rowNum) throws SQLException {
		HydCondCd hydCondCd = new HydCondCd();
		
		hydCondCd.setHydCondCd(rs.getString(HYD_COND_CD).charAt(0));
		hydCondCd.setHydCondSrtNu(rs.getInt(HYD_COND_SRT_NU));
		hydCondCd.setHydCondVldFg(rs.getString(HYD_COND_VLD_FG).charAt(0) == 'Y');
		hydCondCd.setHydCondNm(rs.getString(HYD_COND_NM));
		hydCondCd.setHydCondDs(rs.getString(HYD_COND_DS));
		
		return hydCondCd;
	}
}
