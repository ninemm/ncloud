package net.ninemm.upms.service.provider;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.jfinal.aop.Inject;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.IAtom;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import io.jboot.Jboot;
import io.jboot.aop.annotation.Bean;
import io.jboot.db.model.Columns;
import io.jboot.utils.StrUtil;
import net.ninemm.base.web.base.BaseService;
import net.ninemm.upms.service.api.RoleService;
import net.ninemm.upms.service.model.Role;
import net.ninemm.upms.service.model.RoleOperationRel;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Bean
public class RoleServiceImpl extends BaseService<Role> implements RoleService {

    @Inject
    RoleOperationRelServiceImpl roleOperationRelService;

    @Override
    public Page<Role> paginate(int page, int pageSize, Map<String, Object> params) {
        Columns columns = Columns.create();
        Object roleName = params.get("roleName");
        Object deptId = params.get("deptId");
        if (roleName != null) {
            columns.likeAppendPercent("role_name", roleName);
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
    public List<Record> findListAsOptions(String dataArea) {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("select id, role_name as name from upms_role where 1=1");
        if (StrUtil.isNotBlank(dataArea)) {
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
                if (StrUtil.isBlank(operationIds)) {
                    return true;
                }

                Splitter.on(",").splitToList(operationIds).stream().forEach(operatorId -> {
                    RoleOperationRel ror = new RoleOperationRel();
                    ror.setId(StrUtil.uuid());
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

    @Override
    public void deleteByIds(String ids) {
        String sql = "DELETE FROM upms_role WHERE id in ("+ids+")";
        Db.delete(sql);
    }

    @Override
    public List<Role> findByDeptId(String id) {
        String sql = "SELECT * FROM upms_role WHERE dept_id = '"+id+"'";
        return Db.query(sql);
    }

    /**
     * 清除 model 缓存
     */
    @Override
    protected void clearAllCache() {
        Jboot.getCache().removeAll(Role.CACHE_NAME);
    }
}