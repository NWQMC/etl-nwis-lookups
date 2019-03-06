package main.java.gov.acwi.wqp.etl.bodyPart;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BodyPartRowManager implements RowMapper<BodyPart> {
	
	public static final String BODY_PART_ID = "body_part_id";
	public static final String BODY_PART_NM = "body_part_nm";
	
	
	public BodyPart mapRow(ResultSet rs, int rowNum) throws SQLException {
		BodyPart bodyPart = new BodyPart();
		
		bodyPart.setBodyPartId(rs.getInt(BODY_PART_ID));
		bodyPart.setBodyPartNm(rs.getString(BODY_PART_NM));
		
		return bodyPart;
	}

}
