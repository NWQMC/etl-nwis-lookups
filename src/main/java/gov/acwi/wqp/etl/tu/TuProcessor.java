package gov.acwi.wqp.etl.tu;

import org.springframework.batch.item.ItemProcessor;

import gov.acwi.wqp.etl.BaseProcessor;

public class TuProcessor extends BaseProcessor implements ItemProcessor<Tu, Tu> {

	@Override
	public Tu process(Tu source) throws Exception {
		Tu result = new Tu();
		result.setTuId(source.getTuId());
		result.setTu1Cd(trimString(source.getTu1Cd()));
		result.setTu1Nm(trimString(source.getTu1Nm()));
		result.setTu2Cd(trimString(source.getTu2Cd()));
		result.setTu2Nm(trimString(source.getTu2Nm()));
		result.setTu3Cd(trimString(source.getTu3Cd()));
		result.setTu3Nm(trimString(source.getTu3Nm()));
		result.setTu4Cd(trimString(source.getTu4Cd()));
		result.setTu4Nm(trimString(source.getTu4Nm()));
		result.setTuUnnmCd(trimString(source.getTuUnnmCd()));
		result.setTuUseCd(trimString(source.getTuUseCd()));
		result.setTuUnaccpRsnTx(trimString(source.getTuUnaccpRsnTx()));
		result.setTuCredRatTx(trimString(source.getTuCredRatTx()));
		result.setTuCmpltRatCd(trimString(source.getTuCmpltRatCd()));
		result.setTuCurrRatCd(trimString(source.getTuCurrRatCd()));
		result.setTuPhylSrtNu(source.getTuPhylSrtNu());
		result.setTuCr(source.getTuCr());
		result.setTuParId(source.getTuParId());
		result.setTuTaxAuthId(source.getTuTaxAuthId());
		result.setTuHybrAuthId(source.getTuHybrAuthId());
		result.setTuKingId(source.getTuKingId());
		result.setTuRnkId(source.getTuRnkId());
		result.setTuMd(source.getTuMd());
		
		return result;
	}
}
