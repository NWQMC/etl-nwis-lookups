package gov.acwi.wqp.etl.tu;

import org.springframework.batch.item.ItemProcessor;

import gov.acwi.wqp.etl.BaseProcessor;

public class TuProcessor extends BaseProcessor implements ItemProcessor<Tu, Tu> {

	@Override
	public Tu process(Tu source) throws Exception {
		final String tu1Cd = trimString(source.getTu1Cd());
		final String tu1Nm = trimString(source.getTu1Nm());
		final String tu2Cd = trimString(source.getTu2Cd());
		final String tu2Nm = trimString(source.getTu2Nm());
		final String tu3Cd = trimString(source.getTu3Cd());
		final String tu3Nm = trimString(source.getTu3Nm());
		final String tu4Cd = trimString(source.getTu4Cd());
		final String tu4Nm = trimString(source.getTu4Nm());
		final String tuUnnmCd = trimString(source.getTuUnnmCd());
		final String tuUseCd = trimString(source.getTuUseCd());
		final String tuUnaccpRsnTx = trimString(source.getTuUnaccpRsnTx());
		final String tuCredRatTx = trimString(source.getTuCredRatTx());
		final String tuCmpltRatCd = trimString(source.getTuCmpltRatCd());
		final String tuCurrRatCd = trimString(source.getTuCurrRatCd());
		
		
		return new Tu(source.getTuId(), tu1Cd, tu1Nm, tu2Cd, tu2Nm, tu3Cd, tu3Nm, tu4Cd, tu4Nm, tuUnnmCd,
				tuUseCd, tuUnaccpRsnTx, tuCredRatTx, tuCmpltRatCd, tuCurrRatCd, 
				source.getTuPhylSrtNu(), source.getTuCr(), source.getTuParId(),
				source.getTuTaxAuthId(), source.getTuHybrAuthId(), source.getTuKingId(),
				source.getTuRnkId(), source.getTuMd());
	}
}
