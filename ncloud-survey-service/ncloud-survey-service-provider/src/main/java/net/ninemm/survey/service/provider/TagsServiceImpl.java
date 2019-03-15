package net.ninemm.survey.service.provider;

import com.jfinal.plugin.activerecord.Db;
import io.jboot.Jboot;
import io.jboot.aop.annotation.Bean;
import net.ninemm.survey.service.api.TagsService;
import net.ninemm.survey.service.api.TaskService;
import net.ninemm.survey.service.model.Tags;
import io.jboot.service.JbootServiceBase;
import net.ninemm.survey.service.model.Task;
import net.ninemm.survey.service.model.TaskProcess;

import java.util.List;


@Bean
public class TagsServiceImpl extends JbootServiceBase<Tags> implements TagsService {

    @Override
    public void deleteBySurveyId(String surveyId) {
        String sql ="delete  from survey_tags where survey_id=?";
        Db.delete(sql,surveyId);
    }

    @Override
    public void clearAllCache() {
        Jboot.getCache().removeAll(Tags.CACHE_NAME);
    }

    @Override
    public List<Tags> findBySurveyId(String surveyId) {
        String sql ="select * from survey_tags where survey_id=?";
        return DAO.find(sql,surveyId);
    }
}