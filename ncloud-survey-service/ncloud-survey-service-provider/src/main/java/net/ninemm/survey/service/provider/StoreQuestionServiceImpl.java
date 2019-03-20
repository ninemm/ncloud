package net.ninemm.survey.service.provider;

import io.jboot.aop.annotation.Bean;
import net.ninemm.survey.service.api.StoreQuestionService;
import net.ninemm.survey.service.model.StoreQuestion;
import io.jboot.service.JbootServiceBase;


@Bean
public class StoreQuestionServiceImpl extends JbootServiceBase<StoreQuestion> implements StoreQuestionService {

}