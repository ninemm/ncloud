package net.ninemm.survey.service.provider;

import io.jboot.aop.annotation.Bean;
import net.ninemm.survey.service.api.PublishService;
import net.ninemm.survey.service.model.Publish;
import io.jboot.service.JbootServiceBase;


@Bean
public class PublishServiceImpl extends JbootServiceBase<Publish> implements PublishService {

    @Override
    public void deleteBySurveyId(String surveyId) {

    }
}