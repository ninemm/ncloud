package net.ninemm.upms.service.provider;

import io.jboot.aop.annotation.Bean;
import net.ninemm.upms.service.api.StationOperationRelService;
import net.ninemm.upms.service.model.StationOperationRel;
import io.jboot.service.JbootServiceBase;

import javax.inject.Singleton;

@Bean
@Singleton
public class StationOperationRelServiceImpl extends JbootServiceBase<StationOperationRel> implements StationOperationRelService {

}