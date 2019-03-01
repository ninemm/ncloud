package net.ninemm.survey.service.provider;

import io.jboot.aop.annotation.Bean;
import net.ninemm.survey.service.api.TaskProcessService;
import net.ninemm.survey.service.model.TaskProcess;
import io.jboot.service.JbootServiceBase;


@Bean
public class TaskProcessServiceImpl extends JbootServiceBase<TaskProcess> implements TaskProcessService {

}