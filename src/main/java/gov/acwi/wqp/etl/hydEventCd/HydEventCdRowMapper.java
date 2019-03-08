package gov.acwi.wqp.etl.hydEventCd;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class HydEventCdRowMapper implements RowMapper<HydEventCd> {
	
	public static final String HYD_EVENT_CD = "hyd_event_cd";
	public static final String HYD_EVENT_SRT_NU = "hyd_event_srt_nu";
	public static final String HYD_EVENT_VLD_FG = "hyd_event_vld_fg";
	public static final String HYD_EVENT_NM = "hyd_event_nm";
	public static final String HYD_EVENT_DS = "hyd_event_ds";
	
	public HydEventCd mapRow(ResultSet rs, int rowNum) throws SQLException {
		HydEventCd hydEventCd = new HydEventCd();
		
		hydEventCd.setHydEventCd(rs.getString(HYD_EVENT_CD).charAt(0));
		hydEventCd.setHydEventSrtNu(rs.getInt(HYD_EVENT_SRT_NU));
		hydEventCd.setHydEventVldFg(rs.getString(HYD_EVENT_VLD_FG).charAt(0) == 'Y');
		hydEventCd.setHydEventNm(rs.getString(HYD_EVENT_NM));
		hydEventCd.setHydEventDs(rs.getString(HYD_EVENT_DS));
		
		return hydEventCd;
	}
}
