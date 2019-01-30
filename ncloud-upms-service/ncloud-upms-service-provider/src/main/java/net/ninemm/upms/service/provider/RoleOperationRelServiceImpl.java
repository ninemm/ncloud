package net.ninemm.upms.service.provider;

import com.jfinal.plugin.activerecord.Db;
import io.jboot.aop.annotation.Bean;
import io.jboot.service.JbootServiceBase;
import net.ninemm.upms.service.api.RoleOperationRelService;
import net.ninemm.upms.service.model.RoleOperationRel;

import javax.inject.Singleton;
import java.util.List;

@Bean
@Singleton
public class RoleOperationRelServiceImpl extends JbootServiceBase<RoleOperationRel> implements RoleOperationRelService {

    @Override
    public List<String> findListByRoleId(String roleId) {
        String sql = "select operation_id from upms_role_operation_rel where role_id = ?";
        return Db.query(sql, roleId);
    }

    @Override
    public void deleteByModuleId(String roleId, String moduleId) {
        String sql = "delete from upms_role_operation_rel where role_id = ? and module_id = ?";
        Db.delete(sql, roleId, moduleId);
    }
}