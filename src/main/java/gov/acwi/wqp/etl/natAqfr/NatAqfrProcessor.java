package gov.acwi.wqp.etl.natAqfr;

import org.springframework.batch.item.ItemProcessor;

import gov.acwi.wqp.etl.BaseProcessor;

public class NatAqfrProcessor extends BaseProcessor implements ItemProcessor<NatAqfr, NatAqfr> {

	@Override
	public NatAqfr process(NatAqfr source) throws Exception {
		final String countryCd = trimString(source.getCountryCd());
		final String stateCd = trimString(source.getStateCd());
		final String natAqfrCd = trimString(source.getNatAqfrCd());
		final String natAqfrNm = trimString(source.getNatAqfrNm());
		
		return new NatAqfr(countryCd, stateCd, natAqfrCd, natAqfrNm);
	}
}
