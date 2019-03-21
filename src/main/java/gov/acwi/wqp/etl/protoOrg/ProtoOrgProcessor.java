package gov.acwi.wqp.etl.protoOrg;

import org.springframework.batch.item.ItemProcessor;

import gov.acwi.wqp.etl.BaseProcessor;

public class ProtoOrgProcessor extends BaseProcessor implements ItemProcessor<ProtoOrg, ProtoOrg> {

	@Override
	public ProtoOrg process(ProtoOrg source) throws Exception {
		ProtoOrg result = new ProtoOrg();
		result.setProtoOrgCd(trimString(source.getProtoOrgCd()));
		result.setProtoOrgNm(trimString(source.getProtoOrgNm()));
		result.setProtoOrgFvCd(trimString(source.getProtoOrgFvCd()));
		result.setProtoOrgVldFg(source.isProtoOrgVldFg());
		result.setProtoOrgInitNm(trimString(source.getProtoOrgInitNm()));
		result.setProtoOrgInitDt(source.getProtoOrgInitDt());
		result.setProtoOrgRevNm(trimString(source.getProtoOrgRevNm()));
		result.setProtoOrgRevDt(source.getProtoOrgRevDt());
		
		return result;
	}
}
