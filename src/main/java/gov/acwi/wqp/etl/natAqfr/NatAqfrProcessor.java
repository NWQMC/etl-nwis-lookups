package gov.acwi.wqp.etl.natAqfr;

import org.springframework.batch.item.ItemProcessor;

import gov.acwi.wqp.etl.BaseProcessor;

public class NatAqfrProcessor extends BaseProcessor implements ItemProcessor<NatAqfr, NatAqfr> {

	@Override
	public NatAqfr process(NatAqfr source) throws Exception {
		NatAqfr result = new NatAqfr();
		result.setCountryCd(trimString(source.getCountryCd()));
		result.setStateCd(trimString(source.getStateCd()));
		result.setNatAqfrCd(trimString(source.getNatAqfrCd()));
		result.setNatAqfrNm(trimString(source.getNatAqfrNm()));
		
		return result;
	}
}
