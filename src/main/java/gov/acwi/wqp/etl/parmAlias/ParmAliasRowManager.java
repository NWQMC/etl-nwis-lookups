package gov.acwi.wqp.etl.parmAlias;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ParmAliasRowManager implements RowMapper<ParmAlias> {
	
	public static final String PARM_CD = "parm_cd";
	public static final String PARM_ALIAS_CD = "parm_alias_cd";
	public static final String PARM_ALIAS_NM = "parm_alias_nm";
	public static final String PARM_ALIAS_INIT_DT = "parm_alias_init_dt";
	public static final String PARM_ALIAS_INIT_NM = "parm_alias_init_nm";
	public static final String PARM_ALIAS_REV_DT = "parm_alias_rev_dt";
	public static final String PARM_ALIAS_REV_NM = "parm_alias_rev_nm";
	
	
	public ParmAlias mapRow(ResultSet rs, int rowNum) throws SQLException {
		ParmAlias parmAlias = new ParmAlias();
		
		parmAlias.setParmCd(rs.getString(PARM_CD));
		parmAlias.setParmAliasCd(rs.getString(PARM_ALIAS_CD));
		parmAlias.setParmAliasNm(rs.getString(PARM_ALIAS_NM));
		parmAlias.setParmAliasInitDt(rs.getDate(PARM_ALIAS_INIT_DT));
		parmAlias.setParmAliasInitNm(rs.getString(PARM_ALIAS_INIT_NM));
		parmAlias.setParmAliasRevDt(rs.getDate(PARM_ALIAS_REV_DT));
		parmAlias.setParmAliasRevNm(rs.getString(PARM_ALIAS_REV_NM));

		
		return parmAlias;
	}

}
