package net.ninemm.survey.service.provider;

import io.jboot.aop.annotation.Bean;
import net.ninemm.survey.service.api.TagMappingService;
import net.ninemm.survey.service.model.TagMapping;
import io.jboot.service.JbootServiceBase;


@Bean
public class TagMappingServiceImpl extends JbootServiceBase<TagMapping> implements TagMappingService {

}