package net.ninemm.survey.service.provider;

import io.jboot.aop.annotation.Bean;
import net.ninemm.survey.service.api.ConsumerService;
import net.ninemm.survey.service.model.Consumer;
import io.jboot.service.JbootServiceBase;


@Bean
public class ConsumerServiceImpl extends JbootServiceBase<Consumer> implements ConsumerService {

}