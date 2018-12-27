package net.ninemm.upms.service.provider;

import com.jfinal.kit.Kv;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.IAtom;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.SqlPara;
import io.jboot.Jboot;
import io.jboot.aop.annotation.Bean;
import io.jboot.core.cache.annotation.Cacheable;
import io.jboot.db.model.Columns;
import net.ninemm.upms.service.api.ModuleService;
import net.ninemm.upms.service.model.Department;
import net.ninemm.upms.service.model.Menu;
import net.ninemm.upms.service.model.Module;
import io.jboot.service.JbootServiceBase;
import net.ninemm.upms.service.model.Systems;

import javax.inject.Singleton;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Bean
@Singleton
public class ModuleServiceImpl extends JbootServiceBase<Module> implements ModuleService {

    @Override
    public Page<Module> paginate(int page, int pageSize, Map<String, Object> params) {

        Columns columns = Columns.create();
        Object moduleName = params.get("moduleName");
        if (moduleName != null) {
            columns.likeAppendPercent("module_name", moduleName);
        }

        Object systemId = params.get("systemId");
        if (systemId != null) {
            columns.eq("system_id", systemId);
        }

        columns.is_not_null("parent_id");
        Object orderByField = params.get("orderByField");
        String orderBy = orderByField != null ? orderByField.toString() : "create_date";

        Object _isAsc = params.get("isAsc");
        if (_isAsc != null) {
            Boolean isAsc = Boolean.valueOf(_isAsc.toString());
            if (isAsc) {
                orderBy += " asc";
            } else {
                orderBy += " desc";
            }
        }

        SqlPara sqlPara = Db.getSqlPara("upms-module.pagination", params);
        return DAO.paginate(page, pageSize, sqlPara);
    }

    @Override
    public boolean save(Module model) {
        String parentId = model.getParentId();
        if (StrKit.isBlank(parentId)) {
            return false;
        }

        boolean isSaved = Db.tx(new IAtom() {
            @Override
            public boolean run() throws SQLException {

                Module parent = DAO.findById(parentId);
                if (parent.getIsParent() == 0) {
                    parent.setIsParent(1);
                    parent.setModifyDate(new Date());
                    if (!parent.update()) {
                        return false;
                    }
                }

                if (!model.save()) {
                    return false;
                }

                // clear all cache
                Jboot.me().getCache().removeAll("upms_module");
                return true;
            }
        });

        return isSaved;
    }

    @Override
    public List<Module> findAllAsSort() {
        return DAO.find("select * from upms_module order by parent_id asc, order_list asc");
    }

    @Override
    @Cacheable(name = "upms_module", key = "parent:#(parentId)", liveSeconds = 86400)
    public List<Module> findListByParentId(String parentId) {
        return DAO.findListByColumn("parent_id", parentId, "order_list asc");
    }

}