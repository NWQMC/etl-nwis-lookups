package gov.acwi.wqp.etl.bodyPart;

import org.springframework.batch.item.ItemProcessor;

import gov.acwi.wqp.etl.BaseProcessor;

public class BodyPartProcessor extends BaseProcessor implements ItemProcessor<BodyPart, BodyPart> {

	final static String TRIM = "^\\s]*|\\s]*$";

	@Override
	public BodyPart process(BodyPart source) throws Exception {
		final String bodyPartNm = trimString(source.getBodyPartNm());
		
		return new BodyPart(source.getBodyPartId(), bodyPartNm);
	}
}
