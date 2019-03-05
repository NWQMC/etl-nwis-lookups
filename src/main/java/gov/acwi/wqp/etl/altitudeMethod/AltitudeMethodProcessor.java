package main.java.gov.acwi.wqp.etl.altitudeMethod;

import org.springframework.batch.item.ItemProcessor;

import main.java.gov.acwi.wqp.etl.GwReflist;

public class AltitudeMethodProcessor implements ItemProcessor<GwReflist, AltitudeMethod> {

	@Override
	public AltitudeMethod process(GwReflist gwReflist) throws Exception {
		final String trim = "^\\s]*|\\s]*$";
		final String code = gwReflist.getGwRefCd().replaceFirst(trim, "");
		final String name = gwReflist.getGwRefNm().replaceFirst(trim,  "");
		final String description = gwReflist.getGwRefDs().replaceFirst(trim,  "");
		final Boolean validFlag = gwReflist.getGwValidFg() == 'Y';
		
		return new AltitudeMethod(code, name, gwReflist.getGwSortNu(), description, validFlag);
	}

}
