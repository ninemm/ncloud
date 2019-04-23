package net.ninemm.upms.service.provider;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import io.jboot.aop.annotation.Bean;
import io.jboot.service.JbootServiceBase;
import net.ninemm.upms.service.api.UserGroupRelService;
import net.ninemm.upms.service.model.UserGroupRel;

import java.util.List;

@Bean
public class UserGroupRelServiceImpl extends JbootServiceBase<UserGroupRel> implements UserGroupRelService {

    @Override
    public int deleteByUserId(String userId) {
        return Db.delete("delete from upms_user_group_rel where user_id = ?", userId);
    }

    @Override
    public void deleteByGroupId(String id) {
        Db.delete("delete from upms_user_group_rel where group_id = "+ id);
    }

    @Override
    public List<Record> findUserListByGroupId(String id) {
        return Db.find("SELECT u.* FROM upms_user_group_rel ug LEFT JOIN upms_user u on ug.user_id = u.id WHERE  ug.group_id = '"+id+"'");
    }

    @Override
    public List<Record> findNotUser(String id, String s) {
        String sql = "SELECT u.* FROM upms_user u WHERE u.id not in(SELECT ug.user_id FROM upms_user_group_rel ug WHERE ug.group_id = '"+id+"') and u.data_area like '"+s+"'";
        return Db.find(sql);
    }

    @Override
    public List<Record> findNotGroup(String id, String s) {
        String sql = "SELECT g.* FROM upms_group g WHERE g.id not in(SELECT ug.group_id FROM upms_user_group_rel ug WHERE ug.user_id = '"+id+"') and g.data_area like '"+s+"'";
        return Db.find(sql);
    }

    @Override
    public List<Record> findGroupListByUserId(String id) {
        return Db.find("SELECT g.* FROM upms_user_group_rel ug LEFT JOIN upms_group g on ug.group_id = g.id WHERE  ug.user_id = '"+id+"'");
    }

}