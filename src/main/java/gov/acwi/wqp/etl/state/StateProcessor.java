package gov.acwi.wqp.etl.state;

import org.springframework.batch.item.ItemProcessor;

import gov.acwi.wqp.etl.BaseProcessor;

public class StateProcessor extends BaseProcessor implements ItemProcessor<State, State> {

	@Override
	public State process(State source) throws Exception {
		final String countryCd = trimString(source.getCountryCd());
		final String stateCd = trimString(source.getStateCd());
		final String stateNm = trimString(source.getStateNm());
		final String statePostCd = trimString(source.getStatePostCd());
		final String stateMaxLatVa = trimString(source.getStateMaxLatVa());
		final String stateMinLatVa = trimString(source.getStateMinLatVa());
		final String stateMaxLongVa = trimString(source.getStateMaxLongVa());
		final String stateMinLongVa = trimString(source.getStateMinLongVa());
		final String stateMaxAltVa = trimString(source.getStateMaxAltVa());
		final String stateMinAltVa = trimString(source.getStateMinAltVa());
		final String stateMd = trimString(source.getStateMd());
		
		return new State(countryCd, stateCd, stateNm, statePostCd, stateMaxLatVa, stateMinLatVa, stateMaxLongVa,
				stateMinLongVa, stateMaxAltVa, stateMinAltVa, stateMd);
	}
}
