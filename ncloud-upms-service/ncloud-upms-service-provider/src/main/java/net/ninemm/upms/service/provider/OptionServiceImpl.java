package net.ninemm.upms.service.provider;

import io.jboot.aop.annotation.Bean;
import io.jboot.service.JbootServiceBase;
import net.ninemm.upms.service.api.OptionService;
import net.ninemm.upms.service.model.Option;

import javax.inject.Singleton;

@Bean
@Singleton
public class OptionServiceImpl extends JbootServiceBase<Option> implements OptionService {

}