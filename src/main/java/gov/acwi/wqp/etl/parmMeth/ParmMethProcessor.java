package gov.acwi.wqp.etl.parmMeth;

import org.springframework.batch.item.ItemProcessor;

import gov.acwi.wqp.etl.BaseProcessor;

public class ParmMethProcessor extends BaseProcessor implements ItemProcessor<ParmMeth, ParmMeth> {

	@Override
	public ParmMeth process(ParmMeth source) throws Exception {
		final String parmCd = trimString(source.getParmCd());
		final String methCd = trimString(source.getMethCd());
		final String parmMethLgcyCd = trimString(source.getParmMethLgcyCd());
		final String parmMethRndTx = trimString(source.getParmMethRndTx());
		final String parmMethInitNm = trimString(source.getParmMethInitNm());
		final String parmMethRevNm = trimString(source.getParmMethRevNm());
		final String multiplier = trimString(source.getMultiplier());
		
		
		
		return new ParmMeth(parmCd, methCd, parmMethLgcyCd, parmMethRndTx, parmMethInitNm, 
				source.getParmMethInitDt(), parmMethRevNm, source.getParmMethRevDt(),
				source.isParmMethVldFg(), multiplier);
	}
}
