package net.ninemm.survey.service.provider;

import io.jboot.Jboot;
import io.jboot.aop.annotation.Bean;
import net.ninemm.survey.service.api.CategoryService;
import net.ninemm.survey.service.model.Category;
import io.jboot.service.JbootServiceBase;
import net.ninemm.survey.service.model.TaskProcess;


@Bean
public class CategoryServiceImpl extends JbootServiceBase<Category> implements CategoryService {

    @Override
    public void clearAllCache() {
        Jboot.getCache().removeAll(Category.CACHE_NAME);
    }
}