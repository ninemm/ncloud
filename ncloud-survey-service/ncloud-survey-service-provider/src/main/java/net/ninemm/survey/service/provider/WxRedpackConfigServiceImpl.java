package net.ninemm.survey.service.provider;

import io.jboot.aop.annotation.Bean;
import io.jboot.db.model.Column;
import net.ninemm.survey.service.api.WxRedpackConfigService;
import net.ninemm.survey.service.model.WxRedpackConfig;
import io.jboot.service.JbootServiceBase;


@Bean
public class WxRedpackConfigServiceImpl extends JbootServiceBase<WxRedpackConfig> implements WxRedpackConfigService {

    @Override
    public WxRedpackConfig findBySurveyId(String surveyId) {
        Column colum = Column.create("survey_id", surveyId);
        return DAO.findFirstByColumn(colum,"create_date desc ");
    }
}