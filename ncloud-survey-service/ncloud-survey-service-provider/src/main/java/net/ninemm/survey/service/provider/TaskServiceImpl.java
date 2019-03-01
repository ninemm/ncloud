package net.ninemm.survey.service.provider;

import io.jboot.aop.annotation.Bean;
import net.ninemm.survey.service.api.TaskService;
import net.ninemm.survey.service.model.Task;
import io.jboot.service.JbootServiceBase;


@Bean
public class TaskServiceImpl extends JbootServiceBase<Task> implements TaskService {

}