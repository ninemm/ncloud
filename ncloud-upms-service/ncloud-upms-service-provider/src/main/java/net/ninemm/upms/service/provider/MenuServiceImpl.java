package net.ninemm.upms.service.provider;

import io.jboot.aop.annotation.Bean;
import io.jboot.db.model.Column;
import io.jboot.db.model.Columns;
import io.jboot.service.JbootServiceBase;
import net.ninemm.upms.service.api.MenuService;
import net.ninemm.upms.service.model.Menu;

import javax.inject.Singleton;
import java.util.List;

@Bean
@Singleton
public class MenuServiceImpl extends JbootServiceBase<Menu> implements MenuService {

    @Override
    public List<Menu> findListByParentId(String parentId) {
        return DAO.findListByColumn("parent_id", parentId, "order_list", 5);
    }

    @Override
    public List<Menu> findListWithoutRoot() {
        Columns columns = Columns.create();
        columns.is_not_null("parent_id");
        List<Menu> list = DAO.findListByColumns(columns, "order_list");
        return list;
    }

    @Override
    public List<Menu> findAllAsSort() {
        return DAO.find("select * from upms_menu order by order_list asc");
    }

    @Override
    public List<Menu> findHeaderMenuSet() {
        Columns columns = Columns.create();
        columns.eq("parent_id", "0");
        columns.eq("is_parent", 1);
        return DAO.findListByColumns(columns, "order_list");
    }
}