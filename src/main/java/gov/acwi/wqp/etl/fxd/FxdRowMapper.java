package gov.acwi.wqp.etl.fxd;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class FxdRowMapper implements RowMapper<Fxd> {
	
	public static final String PARM_CD = "parm_cd";
	public static final String FXD_VA = "fxd_va";
	public static final String FXD_NM = "fxd_nm";
	public static final String FXD_TX = "fxd_tx";
	public static final String FXD_INIT_DT = "fxd_init_dt";
	public static final String FXD_INIT_NM = "fxd_init_nm";
	public static final String FXD_REV_DT = "fxd_rev_dt";
	public static final String FXD_REV_NM = "fxd_rev_nm";
	
	public Fxd mapRow(ResultSet rs, int rowNum) throws SQLException {
		Fxd fxd = new Fxd();
		
		fxd.setParmCd(rs.getString(PARM_CD));
		fxd.setFxdVa(rs.getBigDecimal(FXD_VA));
		fxd.setFxdNm(rs.getString(FXD_NM));
		fxd.setFxdTx(rs.getString(FXD_TX));
		fxd.setFxdInitDt(rs.getDate(FXD_INIT_DT));
		fxd.setFxdInitNm(rs.getString(FXD_INIT_NM));
		fxd.setFxdRevDt(rs.getDate(FXD_REV_DT));
		fxd.setFxdRevNm(rs.getString(FXD_REV_NM));
		
		return fxd;
	}
}
