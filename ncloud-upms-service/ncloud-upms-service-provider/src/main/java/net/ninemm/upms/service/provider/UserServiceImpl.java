package net.ninemm.upms.service.provider;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.IAtom;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import io.jboot.Jboot;
import io.jboot.aop.annotation.Bean;
import io.jboot.core.cache.annotation.Cacheable;
import io.jboot.db.model.Columns;
import io.jboot.utils.StrUtils;
import net.ninemm.base.utils.EncryptUtils;
import net.ninemm.base.web.base.BaseService;
import net.ninemm.upms.service.api.GroupService;
import net.ninemm.upms.service.api.UserGroupRelService;
import net.ninemm.upms.service.api.UserService;
import net.ninemm.upms.service.model.User;
import net.ninemm.upms.service.model.UserGroupRel;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Bean
@Singleton
public class UserServiceImpl extends BaseService<User> implements UserService {

    @Inject
    GroupService groupService;

    @Inject
    UserGroupRelService userGroupRelService;

    @Override
    public Page<User> paginate(int page, int pageSize, Map<String, Object> params) {
        Columns columns = Columns.create();
        Object realname = params.get("realname");
        if (realname != null) {
            columns.likeAppendPercent("realname", realname);
        }

        Object isAsc = params.get("isAsc");
        Object orderByField = params.get("orderByField");
        String orderBy = orderBy(orderByField, isAsc);

        return DAO.paginateByColumns(page, pageSize, columns, orderBy);
    }

    @Override
    @Cacheable(name = "upms_user", key = "#(mobile)", nullCacheEnable = false)
    public List<User> findByMobile(String mobile) {
        Columns columns = new Columns();
        columns.eq("mobile", mobile);
        columns.eq("status", 1);
        return DAO.findListByColumns(columns);
    }

    @Cacheable(name = "upms_user", key = "#(mobile):#(password)", nullCacheEnable = false)
    public User findByMobileAndPassword(String mobile, String password) {
        Columns columns = Columns.create("mobile", mobile);
        columns.eq("password", password);
        return DAO.findFirstByColumns(columns);
    }

    /**
     * find user by username
     *
     * @param username
     * @return net.ninemm.upms.service.model.User
     * @desc
     */
    @Override
    public User findByUsername(String username) {
        return DAO.findFirstByColumn("username", username);
    }

    /**
     * find user by mobile and deptId
     *
     * @param mobile
     * @param deptId
     * @return
     */
    @Override
    public User findByMobileAndDeptId(String mobile, String deptId) {
        Columns columns = Columns.create();
        columns.eq("mobile", mobile);
        columns.eq("department_id", deptId);
        return DAO.findFirstByColumns(columns);
    }

    @Override
    public List<Record> findAllAccount(String mobile) {
        String sql = "select department_id as deptId, department_name as deptName from upms_user where mobile = ?";
        return Db.find(sql, mobile);
    }

    /**
     * find user by dept id
     *
     * @param deptId
     * @return List
     */
    @Override
    @Cacheable(name = "upms_user", key = "user:dept:#(deptId)", nullCacheEnable = false)
    public List<User> findListByDeptId(String deptId) {
        return DAO.findListByColumn("department_id", deptId);
    }

    @Override
    public boolean saveOrUpdate(User user) {

        boolean result = Db.tx(new IAtom() {
            @Override
            public boolean run() throws SQLException {

                clearAllCache();
                clearCacheByKey(User.CACHE_NAME, buildCacheKey(user.getId()));

                // 删除已有的用户组
                if (StrUtils.notBlank(user.getId())) {
                    userGroupRelService.deleteByUserId(user.getId());
                } else {
                    String salt = EncryptUtils.salt();
                    user.setSalt(salt);
                    user.setPassword(EncryptUtils.encryptPassword(user.getPassword(), salt));
                }

                List<String> stationList = JSON.parseArray(user.getStationId(), String.class);
                String[] idArray = new String[stationList.size()];
                String stationIds = StrUtils.join(stationList.toArray(idArray), ",");

                List<String> groupList = JSON.parseArray(user.getGroupId(), String.class);
                String[] groupIdArray = new String[groupList.size()];
                String groupIds = StrUtils.join(groupList.toArray(groupIdArray), ",");

                if (!user.saveOrUpdate()) {
                    return false;
                }

                List<UserGroupRel> userGroupRelList = Lists.newArrayList();
                groupList.stream().forEach(groupId -> {
                    UserGroupRel userGroupRel = new UserGroupRel();
                    userGroupRel.setId(StrUtils.uuid());
                    userGroupRel.setUserId(user.getId());
                    userGroupRel.setGroupId(groupId);
                    userGroupRelList.add(userGroupRel);
                });

                Db.batchSave(userGroupRelList, userGroupRelList.size());
                return true;
            }
        });
        return result;
    }

    /**
     * batch save user
     *
     * @param list
     * @return boolean
     */
    @Override
    public boolean batchSave(List<User> list) {

        boolean result = Db.tx(new IAtom() {
            @Override
            public boolean run() throws SQLException {

                List<UserGroupRel> userGroupRelList = Lists.newArrayList();

                list.stream().forEach(user -> {
                    String salt = EncryptUtils.salt();
                    user.setSalt(salt);
                    user.setPassword(EncryptUtils.encryptPassword(user.getPassword(), salt));

                    String groupId = groupService.findGroupIdByGroupName(user.getGroupName());
                    if (StrUtils.notBlank(groupId)) {
                        user.setGroupId(groupId);
                    }
                    user.saveOrUpdate();

                    UserGroupRel userGroupRel = new UserGroupRel();
                    userGroupRel.setId(StrUtils.uuid());
                    userGroupRel.setUserId(user.getId());
                    userGroupRel.setGroupId(groupId);
                    userGroupRelList.add(userGroupRel);
                });

                Db.batchSave(userGroupRelList, userGroupRelList.size());
                clearAllCache();
                return true;
            }
        });
        return result;
    }

    @Override
    public boolean deleteById(Object id) {
        if (id == null) {
            return false;
        }
        userGroupRelService.deleteByUserId(id.toString());
        Jboot.me().getCache().remove(User.CACHE_NAME, buildCacheKey(id.toString()));
        return super.deleteById(id);
    }

    @Override
    protected void clearAllCache() {
        Jboot.me().getCache().removeAll(User.CACHE_NAME);
    }

    private void clearCacheByKey(String cacheName, String key) {
        Jboot.me().getCache().remove(cacheName, key);
    }

    private String buildCacheKey(String id) {
        return "user:" + id;
    }
}