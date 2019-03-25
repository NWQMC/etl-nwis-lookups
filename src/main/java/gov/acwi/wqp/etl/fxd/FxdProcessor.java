package gov.acwi.wqp.etl.fxd;

import org.springframework.batch.item.ItemProcessor;

import gov.acwi.wqp.etl.BaseProcessor;

public class FxdProcessor extends BaseProcessor implements ItemProcessor<Fxd, Fxd> {

	@Override
	public Fxd process(Fxd source) throws Exception {
		Fxd result = new Fxd();
		result.setParmCd(trimString(source.getParmCd()));
		result.setFxdVa(source.getFxdVa());
		result.setFxdNm(trimString(source.getFxdNm()));
		result.setFxdTx(trimString(source.getFxdTx()));
		result.setFxdInitDt(source.getFxdInitDt());
		result.setFxdInitNm(trimString(source.getFxdInitNm()));
		result.setFxdRevDt(source.getFxdRevDt());
		result.setFxdRevNm(trimString(source.getFxdRevNm()));
		
		return result;
	}
}
