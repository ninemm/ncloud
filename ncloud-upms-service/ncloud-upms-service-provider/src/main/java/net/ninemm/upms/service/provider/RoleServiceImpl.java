package net.ninemm.upms.service.provider;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.activerecord.SqlPara;
import io.jboot.Jboot;
import io.jboot.aop.annotation.Bean;
import io.jboot.db.model.Columns;
import io.jboot.utils.StrUtils;
import net.ninemm.base.web.base.BaseService;
import net.ninemm.upms.service.api.RoleService;
import net.ninemm.upms.service.model.Role;

import javax.inject.Singleton;
import java.util.List;
import java.util.Map;

@Bean
@Singleton
public class RoleServiceImpl extends BaseService<Role> implements RoleService {

    @Override
    public Page<Role> paginate(int page, int pageSize, Map<String, Object> params) {
        Columns columns = Columns.create();
        Object roleName = params.get("roleName");
        if (roleName != null) {
            columns.likeAppendPercent("role_name", roleName);
        }

        Object isAsc = params.get("isAsc");
        Object orderByField = params.get("orderByField");
        String orderBy = orderBy(orderByField, isAsc);
        return DAO.paginateByColumns(page, pageSize, columns, orderBy);
    }

    @Override
    public List<Record> findListAsOptions(String dataArea) {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("select id, role_name as name from upms_role where 1=1");
        if (StrUtils.isNotBlank(dataArea)) {
            sqlBuilder.append(" AND data_area = ?");
        }

        return Db.find(sqlBuilder.toString());
    }

    @Override
    public List<Role> findRoleListByUserId(String userId) {
        SqlPara sqlPara = Db.getSqlPara("upms-role.findAllRoleCodeByUserId", userId);
        return DAO.find(sqlPara);
    }

    /**
     * 清除 model 缓存
     */
    @Override
    protected void clearAllCache() {
        Jboot.me().getCache().removeAll(Role.CACHE_NAME);
    }
}