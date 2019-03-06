package main.java.gov.acwi.wqp.etl.bodyPart;

public class BodyPart {

	private int	bodyPartId;
	private String bodyPartNm;
	
	public BodyPart() {
	}
	
	public BodyPart(int bodyPartId, String bodyPartNm) {
		this.bodyPartId = bodyPartId;
		this.bodyPartNm = bodyPartNm;
	
	}

	public int getBodyPartId() {
		return bodyPartId;
	}

	public void setBodyPartId(int bodyPartId) {
		this.bodyPartId = bodyPartId;
	}

	public String getBodyPartNm() {
		return bodyPartNm;
	}

	public void setBodyPartNm(String bodyPartNm) {
		this.bodyPartNm = bodyPartNm;
	}
}
