package net.ninemm.survey.service.provider;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import io.jboot.aop.annotation.Bean;
import net.ninemm.survey.service.api.PublishService;
import net.ninemm.survey.service.model.Publish;
import io.jboot.service.JbootServiceBase;


@Bean
public class PublishServiceImpl extends JbootServiceBase<Publish> implements PublishService {

    @Override
    public void deleteBySurveyId(String surveyId) {

    }

    @Override
    public Publish findBySurveyId(String surveyId) {
        String sql ="select * from survey_publish where survey_id= ? ";
        return DAO.findFirst(sql,surveyId);
    }
}