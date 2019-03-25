package gov.acwi.wqp.etl.meth;

import org.springframework.batch.item.ItemProcessor;

import gov.acwi.wqp.etl.BaseProcessor;

public class MethProcessor extends BaseProcessor implements ItemProcessor<Meth, Meth> {

	@Override
	public Meth process(Meth source) throws Exception {
		Meth result = new Meth();
		result.setMethCd(trimString(source.getMethCd()));
		result.setMethTp(trimString(source.getMethTp()));
		result.setMethNm(trimString(source.getMethNm()));
		result.setMethDs(trimString(source.getMethDs()));
		result.setMethRndOwnerCd(trimString(source.getMethRndOwnerCd()));
		result.setDisciplineCd(trimString(source.getDisciplineCd()));
		result.setMethInitNm(trimString(source.getMethInitNm()));
		result.setMethInitDt(source.getMethInitDt());
		result.setMethRevNm(trimString(source.getMethRevNm()));
		result.setMethRevDt(source.getMethRevDt());

		return result;
	}
}
