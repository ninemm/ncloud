package net.ninemm.survey.service.provider;

import com.jfinal.plugin.activerecord.Db;
import io.jboot.Jboot;
import io.jboot.aop.annotation.Bean;
import net.ninemm.survey.service.api.ConfigService;
import net.ninemm.survey.service.model.Config;
import io.jboot.service.JbootServiceBase;
import net.ninemm.survey.service.model.TaskProcess;

import java.util.List;


@Bean
public class ConfigServiceImpl extends JbootServiceBase<Config> implements ConfigService {

    @Override
    public void deleteBySurveyId(String surveyId) {
        String sql ="delete from survey_config where survey_id= ? ";
        Db.delete(sql,surveyId);
    }

    @Override
    public void clearAllCache() {
        Jboot.getCache().removeAll(Config.CACHE_NAME);
    }

    @Override
    public List<Config> findBySurveyId(String surveyId) {
        String sql ="select * from survey_config where survey_id= ? ";
        return DAO.find(sql,surveyId);
    }
}