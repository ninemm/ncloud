package net.ninemm.survey.service.provider;

import io.jboot.Jboot;
import io.jboot.aop.annotation.Bean;
import net.ninemm.survey.service.api.TaskRelService;
import net.ninemm.survey.service.model.Project;
import net.ninemm.survey.service.model.TaskRel;
import io.jboot.service.JbootServiceBase;


@Bean
public class TaskRelServiceImpl extends JbootServiceBase<TaskRel> implements TaskRelService {
    @Override
    public void clearAllCache() {
        Jboot.getCache().removeAll(TaskRel.CACHE_NAME);
    }
}