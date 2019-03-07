package net.ninemm.survey.service.provider;

import com.jfinal.plugin.activerecord.Db;
import io.jboot.aop.annotation.Bean;
import net.ninemm.survey.service.api.TimeConditionService;
import net.ninemm.survey.service.model.TimeCondition;
import io.jboot.service.JbootServiceBase;

import java.util.List;


@Bean
public class TimeConditionServiceImpl extends JbootServiceBase<TimeCondition> implements TimeConditionService {

    @Override
    public List<TimeCondition> findByRestrictId(String answerRestrictId) {
        String sql ="select * from survey_time_condition where answer_restrict_id=?";
        return DAO.find(sql,answerRestrictId);
    }
}