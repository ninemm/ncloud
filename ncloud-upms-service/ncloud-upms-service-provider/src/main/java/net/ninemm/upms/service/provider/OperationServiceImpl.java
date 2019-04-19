package net.ninemm.upms.service.provider;

import com.jfinal.aop.Inject;
import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.activerecord.SqlPara;
import io.jboot.Jboot;
import io.jboot.aop.annotation.Bean;
import io.jboot.db.model.Columns;
import io.jboot.utils.StrUtil;
import net.ninemm.base.web.base.BaseService;
import net.ninemm.upms.service.api.OperationService;
import net.ninemm.upms.service.api.UserService;
import net.ninemm.upms.service.model.Operation;
import net.ninemm.upms.service.model.User;
import org.apache.curator.shaded.com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;

@Bean
public class OperationServiceImpl extends BaseService<Operation> implements OperationService {

    @Inject
    UserService userService;

    @Override
    public Page<Operation> paginate(int page, int pageSize, Map<String, Object> params) {
        Columns columns = Columns.create();
        Object operationName = params.get("operationName");
        Object deptId = params.get("deptId");
        if (operationName != null) {
            columns.likeAppendPercent("operation_name", operationName);
        }
        if (deptId!=null){
            columns.eq("dept_id",deptId);
        }
        Object isAsc = params.get("isAsc");
        Object orderByField = params.get("orderByField");
        String orderBy = orderBy(orderByField, isAsc);
        return DAO.paginateByColumns(page, pageSize, columns, orderBy);
    }

    @Override
    public List<String> findAllPermissionByUserId(String userId, String roleIds) {

        Kv kv = Kv.create();
        kv.set("roleIds", roleIds);
        List<String> urlList = Lists.newLinkedList();
        User user = userService.findById(userId);

        String stationIds = user.getStationId();
        if (StrUtil.notBlank(stationIds)) {
            stationIds = stationIds.replace("\"", "")
                    .replaceAll("[\\[, \\]]", "");
            kv.set("stationIds", stationIds);
        }

        SqlPara sqlPara = Db.getSqlPara("upms-operation.findOperationPermissionByUserId", kv);
        List<Record> list = Db.find(sqlPara);
        list.stream().forEach(record -> {
            urlList.add(record.getStr("url"));
        });
        return urlList;
    }

    @Override
    public List<Operation> findListByModuleId(String moduleId) {
        return DAO.findListByColumn("module_id", moduleId);
    }

    @Override
    public void updateIsPrivilegeById(String id) {
        String sql = "UPDATE upms_operation SET is_privilege = 0 where id = '"+id+"'";
        Db.update(sql);
    }

    /**
     * 清除 model 缓存
     */
    @Override
    protected void clearAllCache() {
        Jboot.getCache().removeAll(Operation.CACHE_NAME);
    }
}