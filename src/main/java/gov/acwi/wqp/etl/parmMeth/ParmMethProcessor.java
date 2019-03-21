package gov.acwi.wqp.etl.parmMeth;

import org.springframework.batch.item.ItemProcessor;

import gov.acwi.wqp.etl.BaseProcessor;

public class ParmMethProcessor extends BaseProcessor implements ItemProcessor<ParmMeth, ParmMeth> {

	@Override
	public ParmMeth process(ParmMeth source) throws Exception {
		ParmMeth result = new ParmMeth();
		result.setParmCd(trimString(source.getParmCd()));
		result.setMethCd(trimString(source.getMethCd()));
		result.setParmMethLgcyCd(trimString(source.getParmMethLgcyCd()));
		result.setParmMethRndTx(trimString(source.getParmMethRndTx()));
		result.setParmMethInitNm(trimString(source.getParmMethInitNm()));
		result.setParmMethInitDt(source.getParmMethInitDt());
		result.setParmMethRevNm(trimString(source.getParmMethRevNm()));
		result.setParmMethRevDt(source.getParmMethRevDt());
		result.setParmMethVldFg(source.isParmMethVldFg());
		result.setMultiplier(trimString(source.getMultiplier()));
		
		return result;
	}
}
