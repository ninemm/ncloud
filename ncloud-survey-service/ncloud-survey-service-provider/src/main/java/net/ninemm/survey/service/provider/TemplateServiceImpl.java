package net.ninemm.survey.service.provider;

import io.jboot.aop.annotation.Bean;
import net.ninemm.survey.service.api.TemplateService;
import net.ninemm.survey.service.model.Template;
import io.jboot.service.JbootServiceBase;
import net.ninemm.survey.service.model.TemplateCategory;

import java.util.List;


@Bean
public class TemplateServiceImpl extends JbootServiceBase<Template> implements TemplateService {

    @Override
    public List<Template> findByDataArea(String dataArea) {
        String sql ="select * from survey_template where data_area LIKE ?";
        return DAO.find(sql,dataArea+"%");
    }
}