package net.ninemm.survey.service.provider;

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
}