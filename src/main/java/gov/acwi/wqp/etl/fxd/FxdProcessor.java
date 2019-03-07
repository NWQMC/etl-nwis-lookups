package gov.acwi.wqp.etl.fxd;

import org.springframework.batch.item.ItemProcessor;

import gov.acwi.wqp.etl.BaseProcessor;

public class FxdProcessor extends BaseProcessor implements ItemProcessor<Fxd, Fxd> {

	@Override
	public Fxd process(Fxd source) throws Exception {
		final String parmCd = trimString(source.getParmCd());
		final String fxdNm = trimString(source.getFxdNm());
		final String fxdTx = trimString(source.getFxdTx());
		final String fxdInitNm = trimString(source.getFxdInitNm());
		final String fxdRevNm = trimString(source.getFxdRevNm());
		
		
		return new Fxd(parmCd, source.getFxdVa(), fxdNm, fxdTx, 
				source.getFxdInitDt(), fxdInitNm, source.getFxdRevDt(), fxdRevNm);
	}
}
