package net.ninemm.upms.service.provider;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.IAtom;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import io.jboot.Jboot;
import io.jboot.aop.annotation.Bean;
import io.jboot.core.rpc.annotation.JbootrpcService;
import io.jboot.db.model.Columns;
import io.jboot.service.JbootServiceBase;
import io.jboot.utils.StrUtils;
import net.ninemm.base.web.base.BaseService;
import net.ninemm.upms.service.api.RoleService;
import net.ninemm.upms.service.model.Role;
import net.ninemm.upms.service.model.RoleOperationRel;

import javax.inject.Singleton;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Bean
@Singleton
@JbootrpcService
public class RoleServiceImpl extends BaseService<Role> implements RoleService {

    @Inject
    RoleOperationRelServiceImpl roleOperationRelService;

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
        String sqlPara = Db.getSql("upms-role.findAllRoleCodeByUserId");
        return DAO.find(sqlPara, userId);
    }

    /**
     * 更新角色权限
     *
     * @param roleId
     * @param moduleId
     * @param operationIds
     * @return java.util.List<net.ninemm.upms.service.model.Role>
     * @author Eric
     * @date 2018-12-27 14:36
     */
    @Override
    public void updatePermission(String roleId, String moduleId, String operationIds) {

        boolean updated = Db.tx(new IAtom() {
            @Override
            public boolean run() throws SQLException {

                roleOperationRelService.deleteByModuleId(roleId, moduleId);
                List<RoleOperationRel> list = Lists.newArrayList();
                if (StrUtils.isBlank(operationIds)) {
                    return true;
                }

                Splitter.on(",").splitToList(operationIds).stream().forEach(operatorId -> {
                    RoleOperationRel ror = new RoleOperationRel();
                    ror.setId(StrUtils.uuid());
                    ror.setRoleId(roleId);
                    ror.setModuleId(moduleId);
                    ror.setOperationId(operatorId);

                    list.add(ror);
                });

                Db.batchSave(list, list.size());
                return true;
            }
        });
    }

    /**
     * 清除 model 缓存
     */
    protected void clearAllCache() {
        Jboot.me().getCache().removeAll(Role.CACHE_NAME);
    }
}