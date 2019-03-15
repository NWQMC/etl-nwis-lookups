package gov.acwi.wqp.etl.parm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ParmRowManager implements RowMapper<Parm> {
	
	public static final String PARM_CD = "parm_cd";
	public static final String PARM_NM = "parm_nm";
	public static final String PARM_RMK_TX = "parm_rmk_tx";
	public static final String PARM_UNT_TX = "parm_unt_tx";
	public static final String PARM_SEQ_NU = "parm_seq_nu";
	public static final String PARM_SEQ_GRP_CD = "parm_seq_grp_cd";
	public static final String PARM_DS = "parm_ds";
	public static final String PARM_MEDIUM_TX = "parm_medium_tx";
	public static final String PARM_FRAC_TX = "parm_frac_tx";
	public static final String PARM_TEMP_TX = "parm_temp_tx";
	public static final String PARM_STAT_TX = "parm_stat_tx";
	public static final String PARM_TM_TX = "parm_tm_tx";
	public static final String PARM_WT_TX = "parm_wt_tx";
	public static final String PARM_SIZE_TX = "parm_size_tx";
	public static final String PARM_ENTRY_FG = "parm_entry_fg";
	public static final String PARM_PUBLIC_FG = "parm_public_fg";
	public static final String PARM_NEG_FG = "parm_neg_fg";
	public static final String PARM_ZERO_FG = "parm_zero_fg";
	public static final String PARM_NULL_FG = "parm_null_fg";
	public static final String PARM_TS_FG = "parm_ts_fg";
	public static final String PARM_INIT_DT = "parm_init_dt";
	public static final String PARM_INIT_NM = "parm_init_nm";
	public static final String PARM_REV_DT = "parm_rev_dt";
	public static final String PARM_REV_NM = "parm_rev_nm";
	public static final String PARM_SEQ_GRP_NM = "parm_seq_grp_nm";
	public static final String WQPCROSSWALK = "wqpcrosswalk";
	public static final String SRSNAME = "srsname";
	
	
	public Parm mapRow(ResultSet rs, int rowNum) throws SQLException {
		Parm parm = new Parm();
		
		parm.setParmCd(rs.getString(PARM_CD));
		parm.setParmNm(rs.getString(PARM_NM));
		parm.setParmRmkTx(rs.getString(PARM_RMK_TX));
		parm.setParmUntTx(rs.getString(PARM_UNT_TX));
		parm.setParmSeqNu(rs.getInt(PARM_SEQ_NU));
		parm.setParmSeqGrpCd(rs.getString(PARM_SEQ_GRP_CD));
		parm.setParmDs(rs.getString(PARM_DS));
		parm.setParmMediumTx(rs.getString(PARM_MEDIUM_TX));
		parm.setParmFracTx(rs.getString(PARM_FRAC_TX));
		parm.setParmTempTx(rs.getString(PARM_TEMP_TX));
		parm.setParmStatTx(rs.getString(PARM_STAT_TX));
		parm.setParmTmTx(rs.getString(PARM_TM_TX));
		parm.setParmWtTx(rs.getString(PARM_WT_TX));
		parm.setParmSizeTx(rs.getString(PARM_SIZE_TX));
		parm.setParmEntryFg(rs.getString(PARM_ENTRY_FG).charAt(0) == 'Y');
		parm.setParmPublicFg(rs.getString(PARM_PUBLIC_FG).charAt(0) == 'Y');
		parm.setParmNegFg(rs.getString(PARM_NEG_FG).charAt(0) == 'Y');
		parm.setParmZeroFg(rs.getString(PARM_ZERO_FG).charAt(0) == 'Y');
		parm.setParmNullFg(rs.getString(PARM_NULL_FG).charAt(0) == 'Y');
		parm.setParmTsFg(rs.getString(PARM_TS_FG).charAt(0) == 'Y');
		parm.setParmInitDt(rs.getDate(PARM_INIT_DT));
		parm.setParmInitNm(rs.getString(PARM_INIT_NM));
		parm.setParmRevDt(rs.getDate(PARM_REV_DT));
		parm.setParmRevNm(rs.getString(PARM_REV_NM));;
		parm.setParmSeqGrpNm(rs.getString(PARM_SEQ_GRP_NM));
		parm.setWqpcrosswalk(rs.getString(WQPCROSSWALK));
		parm.setSrsname(rs.getString(SRSNAME));
		return parm;
	}

}
