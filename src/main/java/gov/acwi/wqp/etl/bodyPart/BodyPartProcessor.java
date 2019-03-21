package gov.acwi.wqp.etl.bodyPart;

import org.springframework.batch.item.ItemProcessor;

import gov.acwi.wqp.etl.BaseProcessor;

public class BodyPartProcessor extends BaseProcessor implements ItemProcessor<BodyPart, BodyPart> {

	@Override
	public BodyPart process(BodyPart source) throws Exception {
		BodyPart result = new BodyPart();
		result.setBodyPartId(source.getBodyPartId());
		result.setBodyPartNm(trimString(source.getBodyPartNm()));
		
		return result;
	}
}
