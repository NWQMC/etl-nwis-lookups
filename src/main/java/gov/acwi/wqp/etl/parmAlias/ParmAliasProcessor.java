package gov.acwi.wqp.etl.parmAlias;

import org.springframework.batch.item.ItemProcessor;

import gov.acwi.wqp.etl.BaseProcessor;

public class ParmAliasProcessor extends BaseProcessor implements ItemProcessor<ParmAlias, ParmAlias> {

	@Override
	public ParmAlias process(ParmAlias source) throws Exception {
		ParmAlias result = new ParmAlias();
		result.setParmCd(trimString(source.getParmCd()));
		result.setParmAliasCd(trimString(source.getParmAliasCd()));
		result.setParmAliasNm(trimString(source.getParmAliasNm()));
		result.setParmAliasInitDt(source.getParmAliasInitDt());
		result.setParmAliasInitNm(trimString(source.getParmAliasInitNm()));
		result.setParmAliasRevDt(source.getParmAliasRevDt());
		result.setParmAliasRevNm(trimString(source.getParmAliasRevNm()));
		
		return result;
	}
}
