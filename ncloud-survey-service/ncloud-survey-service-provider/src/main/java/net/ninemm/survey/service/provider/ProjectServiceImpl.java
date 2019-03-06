package net.ninemm.survey.service.provider;

import com.jfinal.plugin.activerecord.Page;

import io.jboot.Jboot;
import io.jboot.aop.annotation.Bean;
import io.jboot.db.model.Columns;
import io.jboot.utils.StrUtil;
import net.ninemm.survey.service.api.ProjectService;
import net.ninemm.survey.service.model.Project;
import io.jboot.service.JbootServiceBase;

import java.util.List;


@Bean
public class ProjectServiceImpl extends JbootServiceBase<Project> implements ProjectService {

    @Override
    public List<Project> findByProjectName(String name, Page pagePara) {

        return null;
    }

    @Override
    public Page<Project> paginateByColumns(Integer pageNumber, Integer pageSize, Columns columns, String startDate, String endDate, String orderBy) {
        return null;
    }
    
    @Override
    public void clearAllCache() {
        Jboot.getCache().removeAll(Project.CACHE_NAME);
    }
}