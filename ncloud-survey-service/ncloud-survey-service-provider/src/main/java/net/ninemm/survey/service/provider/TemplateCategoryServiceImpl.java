package net.ninemm.survey.service.provider;

import io.jboot.aop.annotation.Bean;
import net.ninemm.survey.service.api.TemplateCategoryService;
import net.ninemm.survey.service.model.TemplateCategory;
import io.jboot.service.JbootServiceBase;

import java.util.List;


@Bean
public class TemplateCategoryServiceImpl extends JbootServiceBase<TemplateCategory> implements TemplateCategoryService {

    @Override
    public List<TemplateCategory> findByDataArea(String dataArea) {
        String sql ="select * from survey_template_category where data_area LIKE ?";
        return DAO.find(sql,dataArea+"%");
    }
}