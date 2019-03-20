package net.ninemm.survey.service.provider;

import io.jboot.aop.annotation.Bean;
import net.ninemm.survey.service.api.TagService;
import net.ninemm.survey.service.model.Tag;
import io.jboot.service.JbootServiceBase;


@Bean
public class TagServiceImpl extends JbootServiceBase<Tag> implements TagService {

}