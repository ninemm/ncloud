package net.ninemm.upms.service.provider;

import io.jboot.aop.annotation.Bean;
import io.jboot.core.cache.annotation.Cacheable;
import io.jboot.db.model.Columns;
import net.ninemm.upms.service.api.DepartmentService;
import net.ninemm.upms.service.model.Department;
import io.jboot.service.JbootServiceBase;
import net.ninemm.upms.service.model.Menu;

import javax.inject.Singleton;
import java.util.List;

@Bean
@Singleton
public class DepartmentServiceImpl extends JbootServiceBase<Department> implements DepartmentService {

    @Override
    public List<Department> findListExcludeRoot() {
        Columns columns = Columns.create();
        columns.is_not_null("parent_id");
        return DAO.findListByColumns(columns, "order_list asc");
    }

    @Override
    @Cacheable(name = "upms_department", key = "all", liveSeconds = 86400)
    public List<Department> findAllAsSort() {
        return DAO.find("select * from upms_department order by order_list asc");
    }

    @Override
    @Cacheable(name = "upms_department", key = "parent:#(parentId)", liveSeconds = 86400)
    public List<Department> findListByParentId(String parentId) {
        return DAO.findListByColumn("parent_id", parentId, "order_list asc");
    }

}