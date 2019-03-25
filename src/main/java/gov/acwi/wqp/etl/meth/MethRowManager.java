package gov.acwi.wqp.etl.meth;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MethRowManager implements RowMapper<Meth> {
	
	public static final String METH_CD = "meth_cd";
	public static final String METH_TP = "meth_tp";
	public static final String METH_NM = "meth_nm";
	public static final String METH_DS = "meth_ds";
	public static final String METH_RND_OWNER_CD = "meth_rnd_owner_cd";
	public static final String DISCIPLINE_CD = "discipline_cd";
	public static final String METH_INIT_NM = "meth_init_nm";
	public static final String METH_INIT_DT = "meth_init_dt";
	public static final String METH_REV_NM = "meth_rev_nm";
	public static final String METH_REV_DT = "meth_rev_dt";
	
	public Meth mapRow(ResultSet rs, int rowNum) throws SQLException {
		Meth meth = new Meth();
		
		meth.setMethCd(rs.getString(METH_CD));
		meth.setMethTp(rs.getString(METH_TP));
		meth.setMethNm(rs.getString(METH_NM));
		meth.setMethDs(rs.getString(METH_DS));
		meth.setMethRndOwnerCd(rs.getString(METH_RND_OWNER_CD));
		meth.setDisciplineCd(rs.getString(DISCIPLINE_CD));
		meth.setMethInitNm(rs.getString(METH_INIT_NM));
		meth.setMethInitDt(rs.getDate(METH_INIT_DT));
		meth.setMethRevNm(rs.getString(METH_REV_NM));
		meth.setMethRevDt(rs.getDate(METH_REV_DT));
		
		return meth;
	}

}
