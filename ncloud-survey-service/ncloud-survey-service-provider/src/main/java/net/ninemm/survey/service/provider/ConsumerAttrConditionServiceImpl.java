package net.ninemm.survey.service.provider;

import io.jboot.aop.annotation.Bean;
import net.ninemm.survey.service.api.ConsumerAttrConditionService;
import net.ninemm.survey.service.model.ConsumerAttrCondition;
import io.jboot.service.JbootServiceBase;

import java.util.List;


@Bean
public class ConsumerAttrConditionServiceImpl extends JbootServiceBase<ConsumerAttrCondition> implements ConsumerAttrConditionService {

    @Override
    public List<ConsumerAttrCondition> findByRestrictId(String answerRestrictId) {
        String sql ="select * from consumer_attr_condition where answer_restrict_id=?";
        return DAO.find(sql,answerRestrictId);
    }
}