package gov.acwi.wqp.etl.parmAlias;

import org.springframework.batch.item.ItemProcessor;

import gov.acwi.wqp.etl.BaseProcessor;

public class ParmAliasProcessor extends BaseProcessor implements ItemProcessor<ParmAlias, ParmAlias> {

	@Override
	public ParmAlias process(ParmAlias source) throws Exception {
		final String parmCd = trimString(source.getParmCd());
		final String parmAliasCd = trimString(source.getParmAliasCd());
		final String parmAliasNm = trimString(source.getParmAliasNm());
		final String parmAliasInitNm = trimString(source.getParmAliasInitNm());
		final String parmAliasRevNm = trimString(source.getParmAliasRevNm());
		
		return new ParmAlias(parmCd, parmAliasCd, parmAliasNm,
				source.getParmAliasInitDt(), parmAliasInitNm, source.getParmAliasRevDt(), 
				parmAliasRevNm);
	}
}
