package net.ninemm.survey.service.provider;

import io.jboot.aop.annotation.Bean;
import net.ninemm.survey.service.api.SendRecordService;
import net.ninemm.survey.service.model.SendRecord;
import io.jboot.service.JbootServiceBase;


@Bean
public class SendRecordServiceImpl extends JbootServiceBase<SendRecord> implements SendRecordService {

}