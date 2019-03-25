package gov.acwi.wqp.etl.methWithCit;

import org.springframework.batch.item.ItemProcessor;

import gov.acwi.wqp.etl.BaseProcessor;

public class MethWithCitProcessor extends BaseProcessor implements ItemProcessor<MethWithCit, MethWithCit> {

	@Override
	public MethWithCit process(MethWithCit source) throws Exception {
				
		return new MethWithCit(source.getMethCd(), source.getMethNm(), source.getCitNm());
	}
}
