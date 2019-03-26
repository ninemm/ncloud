package net.ninemm.survey.service.provider;

import io.jboot.aop.annotation.Bean;
import net.ninemm.survey.service.api.ShareService;
import net.ninemm.survey.service.model.Share;
import io.jboot.service.JbootServiceBase;


@Bean
public class ShareServiceImpl extends JbootServiceBase<Share> implements ShareService {

}