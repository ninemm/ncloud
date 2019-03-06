package net.ninemm.survey.service.provider;

import com.jfinal.plugin.activerecord.Db;
import io.jboot.Jboot;
import io.jboot.aop.annotation.Bean;
import net.ninemm.survey.service.api.AttrService;
import net.ninemm.survey.service.model.Attr;
import io.jboot.service.JbootServiceBase;
import net.ninemm.survey.service.model.TaskProcess;


@Bean
public class AttrServiceImpl extends JbootServiceBase<Attr> implements AttrService {

    @Override
    public void deleteBySurveyId(String surveyId) {
        String sql ="delete from survey_attr where survey_id= ? ";
        Db.delete(sql,surveyId);
    }

    @Override
    public void clearAllCache() {
        Jboot.getCache().removeAll(Attr.CACHE_NAME);
    }
}