package net.ninemm.survey.service.provider;

import io.jboot.aop.annotation.Bean;
import net.ninemm.survey.service.api.TaskAttachmentService;
import net.ninemm.survey.service.model.TaskAttachment;
import io.jboot.service.JbootServiceBase;


@Bean
public class TaskAttachmentServiceImpl extends JbootServiceBase<TaskAttachment> implements TaskAttachmentService {

}