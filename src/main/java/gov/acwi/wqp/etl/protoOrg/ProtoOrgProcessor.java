package gov.acwi.wqp.etl.protoOrg;

import org.springframework.batch.item.ItemProcessor;

import gov.acwi.wqp.etl.BaseProcessor;

public class ProtoOrgProcessor extends BaseProcessor implements ItemProcessor<ProtoOrg, ProtoOrg> {

	@Override
	public ProtoOrg process(ProtoOrg source) throws Exception {

		final String protoOrgCd = trimString(source.getProtoOrgCd());
		final String protoOrgNm = trimString(source.getProtoOrgNm());
		final String protoOrgFvCd = trimString(source.getProtoOrgFvCd());
		final String protoOrgInitNm = trimString(source.getProtoOrgInitNm());
		final String protoOrgRevNm = trimString(source.getProtoOrgRevNm());
		
		return new ProtoOrg(protoOrgCd, protoOrgNm, protoOrgFvCd, source.isProtoOrgVldFg(), 
				protoOrgInitNm, source.getProtoOrgInitDt(), protoOrgRevNm, source.getProtoOrgRevDt());
	}
}
