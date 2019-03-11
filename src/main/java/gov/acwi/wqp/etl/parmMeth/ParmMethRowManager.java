package gov.acwi.wqp.etl.parmMeth;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ParmMethRowManager implements RowMapper<ParmMeth> {
	
	public static final String PARM_CD = "parm_cd";
	public static final String METH_CD = "meth_cd";
	public static final String PARM_METH_LGCY_CD = "parm_meth_lgcy_cd";
	public static final String PARM_METH_RND_TX = "parm_meth_rnd_tx"; 
	public static final String PARM_METH_INIT_NM = "parm_meth_init_nm";
	public static final String PARM_METH_INIT_DT = "parm_meth_init_dt";
	public static final String PARM_METH_REV_NM = "parm_meth_rev_nm";
	public static final String PARM_METH_REV_DT = "parm_meth_rev_dt";
	public static final String PARM_METH_VLD_FG = "parm_meth_vld_fg";
	public static final String MULTIPLIER = "multiplier";
	
	public ParmMeth mapRow(ResultSet rs, int rowNum) throws SQLException {
		ParmMeth parmMeth = new ParmMeth();
		
		parmMeth.setParmCd(rs.getString(PARM_CD));
		parmMeth.setMethCd(rs.getString(METH_CD));
		parmMeth.setParmMethLgcyCd(rs.getString(PARM_METH_LGCY_CD));
		parmMeth.setParmMethRndTx(rs.getString(PARM_METH_RND_TX));
		parmMeth.setParmMethInitNm(rs.getString(PARM_METH_INIT_NM));
		parmMeth.setParmMethInitDt(rs.getDate(PARM_METH_INIT_DT));
		parmMeth.setParmMethRevNm(rs.getString(PARM_METH_REV_NM));
		parmMeth.setParmMethRevDt(rs.getDate(PARM_METH_REV_DT));
		parmMeth.setParmMethVldFg(rs.getString(PARM_METH_VLD_FG).charAt(0) == 'Y');
		parmMeth.setMultiplier(rs.getString(MULTIPLIER));
		
		return parmMeth;
	}

}
