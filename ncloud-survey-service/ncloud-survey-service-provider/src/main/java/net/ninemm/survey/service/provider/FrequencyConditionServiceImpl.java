package net.ninemm.survey.service.provider;

import io.jboot.aop.annotation.Bean;
import net.ninemm.survey.service.api.FrequencyConditionService;
import net.ninemm.survey.service.model.FrequencyCondition;
import io.jboot.service.JbootServiceBase;

import java.util.List;


@Bean
public class FrequencyConditionServiceImpl extends JbootServiceBase<FrequencyCondition> implements FrequencyConditionService {

    @Override
    public List<FrequencyCondition> findByRestrictId(String answerRestrictId) {
        String sql ="select * from survey_frequency_condition where answer_restrict_id=?";
        return DAO.find(sql,answerRestrictId);
    }
}