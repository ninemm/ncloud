package net.ninemm.upms.service.provider;

import com.jfinal.plugin.activerecord.Db;
import io.jboot.aop.annotation.Bean;
import io.jboot.service.JbootServiceBase;
import net.ninemm.upms.service.api.UserGroupRelService;
import net.ninemm.upms.service.model.UserGroupRel;

@Bean
public class UserGroupRelServiceImpl extends JbootServiceBase<UserGroupRel> implements UserGroupRelService {

    @Override
    public int deleteByUserId(String userId) {
        return Db.delete("delete from upms_user_group_rel where user_id = ?", userId);
    }

}