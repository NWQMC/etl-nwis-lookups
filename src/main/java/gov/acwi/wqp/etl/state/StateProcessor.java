package gov.acwi.wqp.etl.state;

import org.springframework.batch.item.ItemProcessor;

import gov.acwi.wqp.etl.BaseProcessor;

public class StateProcessor extends BaseProcessor implements ItemProcessor<State, State> {

	@Override
	public State process(State source) throws Exception {
		State result = new State();
		result.setCountryCd(trimString(source.getCountryCd()));
		result.setStateCd(trimString(source.getStateCd()));
		result.setStateNm(trimString(source.getStateNm()));
		result.setStatePostCd(trimString(source.getStatePostCd()));
		result.setStateMaxLatVa(trimString(source.getStateMaxLatVa()));
		result.setStateMinLatVa(trimString(source.getStateMinLatVa()));
		result.setStateMaxLongVa(trimString(source.getStateMaxLongVa()));
		result.setStateMinLongVa(trimString(source.getStateMinLongVa()));
		result.setStateMaxAltVa(trimString(source.getStateMaxAltVa()));
		result.setStateMinAltVa(trimString(source.getStateMinAltVa()));
		result.setStateMd(trimString(source.getStateMd()));
		
		return result;
	}
}
