package gov.acwi.wqp.etl.state;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StateRowMapper implements RowMapper<State> {

	public static final String COUNTRY_CD = "country_cd";
	public static final String STATE_CD = "state_cd";
	public static final String STATE_NM = "state_nm";
	public static final String STATE_POST_CD = "state_post_cd";
	public static final String STATE_MAX_LAT_VA = "state_max_lat_va";
	public static final String STATE_MIN_LAT_VA = "state_min_lat_va";
	public static final String STATE_MAX_LONG_VA = "state_max_long_va";
	public static final String STATE_MIN_LONG_VA = "state_min_long_va";
	public static final String STATE_MAX_ALT_VA = "state_max_alt_va";
	public static final String STATE_MIN_ALT_VA = "state_min_alt_va";
	public static final String STATE_MD = "state_md";

	public State mapRow(ResultSet rs, int rowNum) throws SQLException {
		State state = new State();

		state.setCountryCd(rs.getString(COUNTRY_CD));
		state.setStateCd(rs.getString(STATE_CD));
		state.setStateNm(rs.getString(STATE_NM));
		state.setStatePostCd(rs.getString(STATE_POST_CD));
		state.setStateMaxLatVa(rs.getString(STATE_MAX_LAT_VA));
		state.setStateMinLatVa(rs.getString(STATE_MIN_LAT_VA));
		state.setStateMaxLongVa(rs.getString(STATE_MAX_LONG_VA));
		state.setStateMinLongVa(rs.getString(STATE_MIN_LONG_VA));
		state.setStateMaxAltVa(rs.getString(STATE_MAX_ALT_VA));
		state.setStateMinAltVa(rs.getString(STATE_MIN_ALT_VA));
		state.setStateMd(rs.getString(STATE_MD));

		return state;
	}
}
