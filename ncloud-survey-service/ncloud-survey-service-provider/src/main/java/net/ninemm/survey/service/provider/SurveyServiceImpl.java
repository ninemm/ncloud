package net.ninemm.survey.service.provider;

import com.jfinal.plugin.activerecord.Db;
import io.jboot.Jboot;
import io.jboot.aop.annotation.Bean;
import net.ninemm.survey.service.api.SurveyService;
import net.ninemm.survey.service.model.Survey;
import io.jboot.service.JbootServiceBase;
import net.ninemm.survey.service.model.TaskProcess;


@Bean
public class SurveyServiceImpl extends JbootServiceBase<Survey> implements SurveyService {

    @Override
    public void clearAllCache() {
        Jboot.getCache().removeAll(Survey.CACHE_NAME);
    }

    @Override
    public void deleteByIds(String ids) {
        String sql ="update survey set status="+Survey.SurveyStatus.DELETE.getStatu()+" where id in ("+ids+")";
        Db.update(sql);
    }
}