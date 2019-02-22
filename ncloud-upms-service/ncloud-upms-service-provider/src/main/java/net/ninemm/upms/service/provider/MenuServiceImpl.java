package net.ninemm.upms.service.provider;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.IAtom;
import io.jboot.Jboot;
import io.jboot.aop.annotation.Bean;
import io.jboot.db.model.Columns;
import io.jboot.utils.StrUtil;
import net.ninemm.base.common.Consts;
import net.ninemm.base.web.base.BaseService;
import net.ninemm.upms.service.api.MenuService;
import net.ninemm.upms.service.model.Menu;
import net.ninemm.upms.service.model.Operation;

import java.sql.SQLException;
import java.util.List;

@Bean
public class MenuServiceImpl extends BaseService<Menu> implements MenuService {

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

    /**
     * save model to database
     *
     * @param operation
     * @return
     */
    @Override
    public Object save(Operation operation) {
        Menu menu = new Menu();
        menu.setId(StrUtil.uuid());
        menu.setLevel(1);
        menu.setOperatorId(operation.getId());
        menu.setCode(operation.getOperationCode());

        menu.setPath(operation.getOperationCode());
        menu.setComponent(operation.getUrl());
        menu.setName(operation.getOperationName());
        menu.setIsParent(Consts.TREE_DEFAULT_ROOT_ID);
        menu.setParentId(Consts.TREE_DEFAULT_ROOT_ID.toString());
        return menu.save();
    }

    @Override
    public Object saveOrUpdate(Menu model) {

        boolean result = Db.tx(new IAtom() {
            @Override
            public boolean run() throws SQLException {
                clearAllCache();
                if (model.getIsParent() == null) {
                    model.setIsParent(0);
                }

                if (!model.saveOrUpdate()) {
                    return false;
                }

                Menu parent = findById(model.getParentId());
                parent.setIsParent(1);
                if (!parent.saveOrUpdate()) {
                    return false;
                }

                return true;
            }
        });

        return result;
    }

    /**
     * 清除 model 缓存
     */
    @Override
    protected void clearAllCache() {
        Jboot.getCache().removeAll(Menu.CACHE_NAME);
    }
}