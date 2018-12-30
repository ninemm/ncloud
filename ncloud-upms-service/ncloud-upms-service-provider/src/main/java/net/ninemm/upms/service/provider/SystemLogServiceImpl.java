package net.ninemm.upms.service.provider;

import io.jboot.aop.annotation.Bean;
import io.jboot.service.JbootServiceBase;
import net.ninemm.upms.service.api.SystemLogService;
import net.ninemm.upms.service.model.SystemLog;

import javax.inject.Singleton;

@Bean
@Singleton
public class SystemLogServiceImpl extends JbootServiceBase<SystemLog> implements SystemLogService {

}