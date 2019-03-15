package net.ninemm.survey.service.provider;

import com.jfinal.plugin.activerecord.Db;
import io.jboot.Jboot;
import io.jboot.aop.annotation.Bean;
import net.ninemm.survey.service.api.StyleService;
import net.ninemm.survey.service.model.Style;
import io.jboot.service.JbootServiceBase;
import net.ninemm.survey.service.model.TaskProcess;

import java.util.List;


@Bean
public class StyleServiceImpl extends JbootServiceBase<Style> implements StyleService {

    @Override
    public void deleteBySurveyId(String surveyId) {
        String sql ="delete from survey_style where survey_id= ? ";
        Db.delete(sql,surveyId);
    }

    @Override
    public void clearAllCache() {
        Jboot.getCache().removeAll(Style.CACHE_NAME);
    }

    @Override
    public List<Style> findBySurveyId(String surveyId) {
        String sql ="select * from survey_style where survey_id= ? ";
        return DAO.find(sql,surveyId);
    }
}