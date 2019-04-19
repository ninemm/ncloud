package net.ninemm.survey.service.provider;

import io.jboot.Jboot;
import io.jboot.aop.annotation.Bean;
import io.jboot.db.model.Column;
import io.jboot.db.model.Columns;
import net.ninemm.survey.service.api.CategoryService;
import net.ninemm.survey.service.model.Category;
import io.jboot.service.JbootServiceBase;
import net.ninemm.survey.service.model.TaskProcess;

import java.util.List;


@Bean
public class CategoryServiceImpl extends JbootServiceBase<Category> implements CategoryService {

    @Override
    public void clearAllCache() {
        Jboot.getCache().removeAll(Category.CACHE_NAME);
    }

    @Override
    public List<Category> findByDataArea(String dataArea) {
        Columns columns = Columns.create();
        columns.like("data_area",dataArea+"%");
        String sql = "select * from survey_category where data_area like ? and `status`=1";
        return DAO.find(sql,dataArea+"%");
    }
}
