package gov.acwi.wqp.etl.valQualCd;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ValQualCdRowManager implements RowMapper<ValQualCd> {
	
	public static final String VAL_QUAL_CD = "val_qual_cd";
	public static final String VAL_QUAL_TP = "val_qual_tp";
	public static final String VAL_QUAL_SRT_NU = "val_qual_srt_nu";
	public static final String VAL_QUAL_VLD_FG = "val_qual_vld_fg";
	public static final String VAL_QUAL_NM = "val_qual_nm";
	public static final String VAL_QUAL_DS = "val_qual_ds";
	
	
	public ValQualCd mapRow(ResultSet rs, int rowNum) throws SQLException {
		ValQualCd valQualCd = new ValQualCd();
		
		valQualCd.setValQualCd(rs.getString(VAL_QUAL_CD));
		valQualCd.setValQualTp(rs.getString(VAL_QUAL_TP));
		valQualCd.setValQualSrtNu(rs.getInt(VAL_QUAL_SRT_NU));
		valQualCd.setValQualVldFg(rs.getString(VAL_QUAL_VLD_FG).charAt(0) == 'Y');
		valQualCd.setValQualNm(rs.getString(VAL_QUAL_NM));
		valQualCd.setValQualDs(rs.getString(VAL_QUAL_DS));
		
		return valQualCd;
	}

}
