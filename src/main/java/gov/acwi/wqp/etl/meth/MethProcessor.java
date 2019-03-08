package gov.acwi.wqp.etl.meth;

import org.springframework.batch.item.ItemProcessor;

import gov.acwi.wqp.etl.BaseProcessor;

public class MethProcessor extends BaseProcessor implements ItemProcessor<Meth, Meth> {

	@Override
	public Meth process(Meth source) throws Exception {
		final String methCd = trimString(source.getMethCd());
		final String methTp = trimString(source.getMethTp());
		final String methNm = trimString(source.getMethNm());
		final String methDs = trimString(source.getMethDs());
		final String methRndOwnerCd = trimString(source.getMethRndOwnerCd());
		final String discipleCd = trimString(source.getDisciplineCd());
		final String methInitNm = trimString(source.getMethInitNm());
		final String methRevNm = trimString(source.getMethRevNm());
		
		
		
		return new Meth(methCd, methTp, methNm, methDs, methRndOwnerCd, discipleCd,
				methInitNm, source.getMethInitDt(), methRevNm, source.getMethRevDt());
	}
}
