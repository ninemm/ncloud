package net.ninemm.upms.service.provider;

import io.jboot.aop.annotation.Bean;
import net.ninemm.upms.service.api.RoleOperationRelService;
import net.ninemm.upms.service.model.RoleOperationRel;
import io.jboot.service.JbootServiceBase;

import javax.inject.Singleton;
import java.util.List;

@Bean
@Singleton
public class RoleOperationRelServiceImpl extends JbootServiceBase<RoleOperationRel> implements RoleOperationRelService {

    public List<RoleOperationRel> findListByRoleId(String roleId) {
        return DAO.findListByColumn("role_id", roleId);
    }

}