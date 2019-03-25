package gov.acwi.wqp.etl.protoOrg;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProtoOrgRowManager implements RowMapper<ProtoOrg> {
	
	public static final String PROTO_ORG_CD = "proto_org_cd";
	public static final String PROTO_ORG_NM = "proto_org_nm";
	public static final String PROTO_ORG_FV_CD = "proto_org_fv_cd";
	public static final String PROTO_ORG_VLD_FG = "proto_org_vld_fg";
	public static final String PROTO_ORG_INIT_NM = "proto_org_init_nm";
	public static final String PROTO_ORG_INIT_DT = "proto_org_init_dt";
	public static final String PROTO_ORG_REV_NM = "proto_org_rev_nm";
	public static final String PROTO_ORG_REV_DT = "proto_org_rev_dt";
	
	
	public ProtoOrg mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProtoOrg protoOrg = new ProtoOrg();
		
		protoOrg.setProtoOrgCd(rs.getString(PROTO_ORG_CD));
		protoOrg.setProtoOrgNm(rs.getString(PROTO_ORG_NM));
		protoOrg.setProtoOrgFvCd(rs.getString(PROTO_ORG_FV_CD));
		protoOrg.setProtoOrgVldFg(rs.getString(PROTO_ORG_VLD_FG).charAt(0) == 'Y');
		protoOrg.setProtoOrgInitNm(rs.getString(PROTO_ORG_INIT_NM));
		protoOrg.setProtoOrgInitDt(rs.getDate(PROTO_ORG_INIT_DT));
		protoOrg.setProtoOrgRevNm(rs.getString(PROTO_ORG_REV_NM));
		protoOrg.setProtoOrgRevDt(rs.getDate(PROTO_ORG_REV_DT));
		
		return protoOrg;
	}

}
