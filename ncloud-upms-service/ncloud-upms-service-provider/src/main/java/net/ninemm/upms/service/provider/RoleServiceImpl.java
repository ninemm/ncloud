package net.ninemm.upms.service.provider;

import com.google.common.base.Splitter;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import io.jboot.aop.annotation.Bean;
import io.jboot.db.model.Columns;
import io.jboot.utils.StrUtils;
import net.ninemm.upms.service.api.RoleService;
import net.ninemm.upms.service.model.Role;
import io.jboot.service.JbootServiceBase;

import javax.inject.Singleton;
import java.util.List;
import java.util.Map;

@Bean
@Singleton
public class RoleServiceImpl extends JbootServiceBase<Role> implements RoleService {

    @Override
    public Page<Role> paginate(int page, int pageSize, Map<String, Object> params) {
        Columns columns = Columns.create();
        Object roleName = params.get("roleName");
        if (roleName != null) {
            columns.likeAppendPercent("role_name", roleName);
        }

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

    private String orderBy(String orderByFields, Boolean isSort) {

        String sort = isSort ? "asc" : "desc";
        List<String> list = Splitter.on(",").splitToList(orderByFields);
        int size = list.size();
        StringBuilder sb = new StringBuilder();
        if (size == 1) {
            sb.append(list.get(0)).append(" ").append(sort);
            return sb.toString();
        }

        for (String field : list) {
            sb.append(field).append(" ").append(sort).append(",");
        }
        return sb.substring(0, sb.length() - 1);

    }
}