package net.ninemm.survey.service.provider;

import io.jboot.aop.annotation.Bean;
import net.ninemm.survey.service.api.ProjectService;
import net.ninemm.survey.service.model.Project;
import io.jboot.service.JbootServiceBase;


@Bean
public class ProjectServiceImpl extends JbootServiceBase<Project> implements ProjectService {

}