package net.ninemm.survey.service.provider;

import io.jboot.Jboot;
import io.jboot.aop.annotation.Bean;
import net.ninemm.survey.service.api.AnswerRestrictService;
import net.ninemm.survey.service.model.AnswerRestrict;
import io.jboot.service.JbootServiceBase;
import net.ninemm.survey.service.model.TaskProcess;


@Bean
public class AnswerRestrictServiceImpl extends JbootServiceBase<AnswerRestrict> implements AnswerRestrictService {

    @Override
    public void clearAllCache() {
        Jboot.getCache().removeAll(AnswerRestrict.CACHE_NAME);
    }
}