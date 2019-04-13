package net.ninemm.survey.service.provider;

import io.jboot.aop.annotation.Bean;
import net.ninemm.survey.service.api.AnswerService;
import net.ninemm.survey.service.model.Answer;
import io.jboot.service.JbootServiceBase;


@Bean
public class AnswerServiceImpl extends JbootServiceBase<Answer> implements AnswerService {

}