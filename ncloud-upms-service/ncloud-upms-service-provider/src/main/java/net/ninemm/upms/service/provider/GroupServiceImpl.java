package net.ninemm.upms.service.provider;

import com.google.common.base.Splitter;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import io.jboot.aop.annotation.Bean;
import io.jboot.core.cache.annotation.Cacheable;
import io.jboot.db.model.Columns;
import io.jboot.utils.StrUtils;
import net.ninemm.upms.service.api.GroupService;
import net.ninemm.upms.service.model.Group;
import io.jboot.service.JbootServiceBase;

import javax.inject.Singleton;
import java.util.List;
import java.util.Map;

@Bean
@Singleton
public class GroupServiceImpl extends JbootServiceBase<Group> implements GroupService {

    @Override
    public Page<Group> paginate(int page, int pageSize, Map<String, Object> params) {
        Columns columns = Columns.create();
        Object groupName = params.get("groupName");
        if (groupName != null) {
            columns.likeAppendPercent("group_name", groupName);
        }

        Object orderByField = params.get("orderByField");
        String orderByFields = orderByField != null ? orderByField.toString() : "create_date";
        Object isAsc = params.get("isAsc");
        String orderBy = orderBy(orderByFields, isAsc);

        return DAO.paginateByColumns(page, pageSize, columns, orderBy);
    }

    @Override
    @Cacheable(name = "upms_group", key = "group:#(groupName)")
    public String findGroupIdByGroupName(String groupName) {
        return Db.queryStr("select id from upms_group where group_name = ?", groupName);
    }

    @Override
    public boolean deleteById(Object id) {

        return super.deleteById(id);
    }

    @Override
    public List<Record> findListAsOptions(String dataArea) {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("select id, group_name as name from upms_group where 1=1");
        if (StrUtils.isNotBlank(dataArea)) {
            sqlBuilder.append(" AND data_area = ?");
        }

        return Db.find(sqlBuilder.toString());
    }

    private String orderBy(String orderByFields, Object isAsc) {

        boolean isSort = false;
        if (isAsc != null) {
            isSort = Boolean.valueOf(isAsc.toString());
        }
        String sort = isSort ? "asc" : "desc";

        List<String> list = Splitter.on(",").splitToList(orderByFields);
        StringBuilder sb = new StringBuilder();
        if (list.size() == 1) {
            sb.append(list.get(0)).append(" ").append(sort);
            return sb.toString();
        }

        for (String field : list) {
            sb.append(field).append(" ").append(sort).append(",");
        }
        return sb.substring(0, sb.length() - 1);
    }
}