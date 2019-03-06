package main.java.gov.acwi.wqp.etl.bodyPart;

import org.springframework.batch.item.ItemProcessor;

public class BodyPartProcessor implements ItemProcessor<BodyPart, BodyPart> {

	final static String TRIM = "^\\s]*|\\s]*$";

	@Override
	public BodyPart process(BodyPart source) throws Exception {
		final String bodyPartNm = source.getBodyPartNm().replaceAll(TRIM,  "");
		
		return new BodyPart(source.getBodyPartId(), bodyPartNm);
	}
}
