package gov.acwi.wqp.etl.tu;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TuRowManager implements RowMapper<Tu> {
	
	public static final String TU_ID = "tu_id";
	public static final String TU_1_CD = "tu_1_cd";
	public static final String TU_1_NM = "tu_1_nm";
	public static final String TU_2_CD = "tu_2_cd";
	public static final String TU_2_NM = "tu_2_nm";
	public static final String TU_3_CD = "tu_3_cd";
	public static final String TU_3_NM = "tu_3_nm";
	public static final String TU_4_CD = "tu_4_cd";
	public static final String TU_4_NM = "tu_4_nm";
	public static final String TU_UNNM_CD = "tu_unnm_cd";
	public static final String TU_USE_CD = "tu_use_cd";
	public static final String TU_UNACCP_RSN_TX = "tu_unaccp_rsn_tx";
	public static final String TU_CRED_RAT_TX = "tu_cred_rat_tx";
	public static final String TU_CMPLT_RAT_CD = "tu_cmplt_rat_cd";
	public static final String TU_CURR_RAT_CD = "tu_curr_rat_cd";
	public static final String TU_PHYL_SRT_NU = "tu_phyl_srt_nu";
	public static final String TU_CR = "tu_cr";
	public static final String TU_PAR_ID = "tu_par_id";
	public static final String TU_TAX_AUTH_ID = "tu_tax_auth_id";
	public static final String TU_HYBR_AUTH_ID = "tu_hybr_auth_id";
	public static final String TU_KING_ID = "tu_king_id";
	public static final String TU_RNK_ID = "tu_rnk_id";
	public static final String TU_MD = "tu_md";
	
	
	public Tu mapRow(ResultSet rs, int rowNum) throws SQLException {
		Tu tu = new Tu();
		
		tu.setTuId(rs.getInt(TU_ID));
		tu.setTu1Cd(rs.getString(TU_1_CD));
		tu.setTu1Nm(rs.getString(TU_1_NM));
		tu.setTu2Cd(rs.getString(TU_2_CD));
		tu.setTu2Nm(rs.getString(TU_2_NM));
		tu.setTu3Cd(rs.getString(TU_3_CD));
		tu.setTu3Nm(rs.getString(TU_3_NM));
		tu.setTu4Cd(rs.getString(TU_4_CD));
		tu.setTu4Nm(rs.getString(TU_4_NM));
		tu.setTuUnnmCd(rs.getString(TU_UNNM_CD));
		tu.setTuUseCd(rs.getString(TU_USE_CD));
		tu.setTuUnaccpRsnTx(rs.getString(TU_UNACCP_RSN_TX));
		tu.setTuCredRatTx(rs.getString(TU_CRED_RAT_TX));
		tu.setTuCmpltRatCd(rs.getString(TU_CMPLT_RAT_CD));
		tu.setTuCurrRatCd(rs.getString(TU_CURR_RAT_CD));
		tu.setTuPhylSrtNu(rs.getInt(TU_PHYL_SRT_NU));
		tu.setTuCr(rs.getDate(TU_CR));
		tu.setTuParId(rs.getInt(TU_PAR_ID));
		tu.setTuTaxAuthId(rs.getInt(TU_TAX_AUTH_ID));
		tu.setTuHybrAuthId(rs.getInt(TU_HYBR_AUTH_ID));
		tu.setTuKingId(rs.getInt(TU_KING_ID));
		tu.setTuRnkId(rs.getInt(TU_RNK_ID));
		tu.setTuMd(rs.getDate(TU_MD));
		
		return tu;
	}

}
