package net.ninemm.survey.service.provider;

import io.jboot.Jboot;
import io.jboot.aop.annotation.Bean;
import net.ninemm.survey.service.api.TagsService;
import net.ninemm.survey.service.api.TaskService;
import net.ninemm.survey.service.model.Tags;
import io.jboot.service.JbootServiceBase;
import net.ninemm.survey.service.model.Task;
import net.ninemm.survey.service.model.TaskProcess;


@Bean
public class TagsServiceImpl extends JbootServiceBase<Tags> implements TagsService {

    @Override
    public void deleteBySurveyId(String surveyId) {

    }

    @Override
    public void clearAllCache() {
        Jboot.getCache().removeAll(Tags.CACHE_NAME);
    }
}