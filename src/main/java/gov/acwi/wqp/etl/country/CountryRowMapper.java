package gov.acwi.wqp.etl.country;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CountryRowMapper implements RowMapper<Country> {
	
	public static final String COUNTRY_CD = "country_cd";
	public static final String COUNTRY_NM = "country_nm";
	
	public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
		Country country = new Country();
		
		country.setCountryCd(rs.getString(COUNTRY_CD));
		country.setCountryNm(rs.getString(COUNTRY_NM));
		
		return country;
	}
}
