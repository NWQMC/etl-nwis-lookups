package gov.acwi.wqp.etl.parm;

import org.springframework.batch.item.ItemProcessor;

import gov.acwi.wqp.etl.BaseProcessor;

public class ParmProcessor extends BaseProcessor implements ItemProcessor<Parm, Parm> {

	@Override
	public Parm process(Parm source) throws Exception {
		Parm result = new Parm();
		
		result.setParmCd(trimString(source.getParmCd()));
		result.setParmNm(trimString(source.getParmNm()));
		result.setParmRmkTx(trimString(source.getParmRmkTx()));
		result.setParmUntTx(trimString(source.getParmUntTx()));
		result.setParmSeqNu(source.getParmSeqNu());
		result.setParmSeqGrpCd(trimString(source.getParmSeqGrpCd()));
		result.setParmDs(trimString(source.getParmDs()));
		result.setParmMediumTx(trimString(source.getParmMediumTx()));
		result.setParmFracTx(trimString(source.getParmFracTx()));
		result.setParmTempTx(trimString(source.getParmTempTx()));
		result.setParmStatTx(trimString(source.getParmStatTx()));
		result.setParmTmTx(trimString(source.getParmTmTx()));
		result.setParmWtTx(trimString(source.getParmWtTx()));
		result.setParmSizeTx(trimString(source.getParmSizeTx()));
		result.setParmEntryFg(source.isParmEntryFg());
		result.setParmPublicFg(source.isParmPublicFg());
		result.setParmNegFg(source.isParmNegFg());
		result.setParmZeroFg(source.isParmZeroFg());
		result.setParmNullFg(source.isParmNullFg());
		result.setParmTsFg(source.isParmTsFg());
		result.setParmInitDt(source.getParmInitDt());
		result.setParmInitNm(trimString(source.getParmInitNm()));
		result.setParmRevDt(source.getParmRevDt());
		result.setParmRevNm(trimString(source.getParmRevNm()));
		result.setParmSeqGrpNm(trimString(source.getParmSeqGrpNm()));
		result.setWqpcrosswalk(trimString(source.getWqpcrosswalk()));
		result.setSrsname(trimString(source.getSrsname()));
		
		return result;
	}
}
