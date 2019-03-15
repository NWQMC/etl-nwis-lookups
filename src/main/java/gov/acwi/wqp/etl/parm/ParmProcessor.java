package gov.acwi.wqp.etl.parm;

import org.springframework.batch.item.ItemProcessor;

import gov.acwi.wqp.etl.BaseProcessor;

public class ParmProcessor extends BaseProcessor implements ItemProcessor<Parm, Parm> {

	@Override
	public Parm process(Parm source) throws Exception {
		final String parmCd = trimString(source.getParmCd());
		final String parmNm = trimString(source.getParmNm());
		final String parmRmkTx = trimString(source.getParmRmkTx());
		final String parmUntTx = trimString(source.getParmUntTx());
		final String parmSeqGrpCd = trimString(source.getParmSeqGrpCd());
		final String parmDs = trimString(source.getParmDs());
		final String parmMediumTx = trimString(source.getParmMediumTx());
		final String parmFracTx= trimString(source.getParmFracTx());
		final String parmTempTx = trimString(source.getParmTempTx());
		final String parmStatTx = trimString(source.getParmStatTx());
		final String parmTmTx = trimString(source.getParmTmTx());
		final String parmWtTx = trimString(source.getParmWtTx());
		final String parmSizeTx = trimString(source.getParmSizeTx());
		final String parmInitNm = trimString(source.getParmInitNm());
		final String parmRevNm = trimString(source.getParmRevNm());
		final String parmSeqGrpNm = trimString(source.getParmSeqGrpNm());
		final String wqpcrosswalk = trimString(source.getWqpcrosswalk());
		final String srsname = trimString(source.getSrsname());
		
		return new Parm(parmCd, parmNm, parmRmkTx, parmUntTx, source.getParmSeqNu(), parmSeqGrpCd,
				parmDs, parmMediumTx, parmFracTx, parmTempTx, parmStatTx, parmTmTx, 
				parmWtTx, parmSizeTx, source.isParmEntryFg(), source.isParmPublicFg(),
				source.isParmNegFg(), source.isParmZeroFg(), source.isParmNullFg(),
				source.isParmTsFg(), source.getParmInitDt(), parmInitNm, source.getParmRevDt(),
				parmRevNm, parmSeqGrpNm, wqpcrosswalk, srsname, null);
	}
}
