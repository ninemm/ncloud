package net.ninemm.upms.service.provider;

import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.IAtom;
import com.jfinal.plugin.activerecord.Record;
import io.jboot.aop.annotation.Bean;
import io.jboot.db.model.Column;
import io.jboot.utils.StrUtils;
import net.ninemm.upms.service.api.GroupRoleRelService;
import net.ninemm.upms.service.model.GroupRoleRel;
import io.jboot.service.JbootServiceBase;

import javax.inject.Singleton;
import java.sql.SQLException;
import java.util.List;

@Bean
@Singleton
public class GroupRoleRelServiceImpl extends JbootServiceBase<GroupRoleRel> implements GroupRoleRelService {

    @Override
    public List<String> findRoleList(String groupId) {
        Column column = Column.create("group_id", groupId);
        List<GroupRoleRel> list = DAO.findListByColumn(column);
        List<String> roleIdList = Lists.newArrayList();
        list.forEach(obj -> {
            roleIdList.add(obj.getRoleId());
        });
        return roleIdList;
    }

    @Override
    public boolean update(String groupId, String roleIds) {

        if (!StrUtils.areNotEmpty(groupId, roleIds)) {
            return true;
        }

        boolean updated = Db.tx(new IAtom() {
            @Override
            public boolean run() throws SQLException {

                int count = Db.delete("delete from upms_group_role_rel where group_id = ?", groupId);
                if (count == 0) {
                    return false;
                }

                List<GroupRoleRel> list = Lists.newArrayList();
                List<String> roleIdsList = Splitter.on(",").splitToList(roleIds);
                ImmutableList<String> roleIdList = ImmutableList.<String>copyOf(roleIdsList);

                roleIdList.stream().forEach(roleId -> {
                    if (!list.contains(roleId)) {
                        GroupRoleRel groupRoleRel = new GroupRoleRel();
                        groupRoleRel.setId(StrUtils.uuid());
                        groupRoleRel.setGroupId(groupId);
                        groupRoleRel.setRoleId(roleId);
                        list.add(groupRoleRel);
                    }
                });

                Db.batchSave(list, list.size());
                return true;
            }
        });
        return updated;
    }

}