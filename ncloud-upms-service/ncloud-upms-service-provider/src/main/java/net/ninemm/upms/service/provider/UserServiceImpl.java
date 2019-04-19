package net.ninemm.upms.service.provider;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.jfinal.aop.Inject;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.IAtom;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import io.jboot.Jboot;
import io.jboot.aop.annotation.Bean;
import io.jboot.components.cache.annotation.Cacheable;
import io.jboot.db.model.Columns;
import io.jboot.utils.StrUtil;
import net.ninemm.base.common.Consts;
import net.ninemm.base.utils.EncryptUtils;
import net.ninemm.base.web.base.BaseService;
import net.ninemm.upms.service.api.GroupService;
import net.ninemm.upms.service.api.UserGroupRelService;
import net.ninemm.upms.service.api.UserService;
import net.ninemm.upms.service.model.User;
import net.ninemm.upms.service.model.UserGroupRel;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Bean
public class UserServiceImpl extends BaseService<User> implements UserService {

    @Inject
    GroupService groupService;

    @Inject
    UserGroupRelService userGroupRelService;

    @Override
    public Page<User> paginate(int page, int pageSize, Map<String, Object> params) {
        Columns columns = Columns.create();
        Object realName = params.get("realName");
        Object departmentId = params.get("departmentId");
        Object status = params.get("status");
        if (departmentId!=null){
            columns.eq("department_id",departmentId);
        }
        if (realName != null) {
            columns.likeAppendPercent("realname", realName);
        }
        if (status != null) {
            columns.eq("status",status);
        }
        Object dataArea = params.get("dataArea");
        if (dataArea != null) {
            columns.like("data_area", dataArea);
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
    public int batchReset(String[] ids) {
        if (ids != null && ids.length > 0) {
            int deleteCount = 0;
            for (int i = 0; i < ids.length; i++) {
                if (ids[i].equals("0")) {
                    continue;
                }
                if (resetPasswordById(ids[i])) {
                    ++deleteCount;
                }
            }
            return deleteCount;
        }
        return 0;
    }

    @Override
    public List<Record> findByDepTid(String ids) {
        String sql = "SELECT u.* FROM upms_user u LEFT JOIN upms_department up on u.department_id =up.id WHERE up.id in ("+ids+")";
        return Db.find(sql);
    }

    @Override
    public void updateStatusById(String id, String status) {
        String sql ="UPDATE upms_user SET status = "+status+" where id = '"+id+"'";
        Db.update(sql);
    }

    @Override
    public List<Record> findByDetaArea(String area) {
        String sql = "SELECT * FROM upms_user WHERE  data_area like '"+area+"'";
        return Db.find(sql);
    }

    public boolean resetPasswordById(String id) {
        User user = findById(id);
        user.setPassword(EncryptUtils.encryptPassword(Consts.USER_DEFAULT_PASSWORD, user.getSalt()));
        return user.update();
    }

    @Override
    public Object saveOrUpdate(User user) {

        boolean result = Db.tx(new IAtom() {
            @Override
            public boolean run() throws SQLException {

                clearAllCache();
                clearCacheByKey(User.CACHE_NAME, buildCacheKey(user.getId()));

                // 删除已有的用户组
                if (StrUtil.notBlank(user.getId())) {
                    userGroupRelService.deleteByUserId(user.getId());
                } else {
                    String salt = EncryptUtils.salt();
                    user.setSalt(salt);
                    user.setPassword(EncryptUtils.encryptPassword(user.getPassword(), salt));
                }

                List<String> stationList = JSON.parseArray(user.getStationId(), String.class);
                String[] idArray = new String[stationList.size()];
                String stationIds = StrUtil.join(stationList.toArray(idArray), ",");

                List<String> groupList = JSON.parseArray(user.getGroupId(), String.class);
                String[] groupIdArray = new String[groupList.size()];
                String groupIds = StrUtil.join(groupList.toArray(groupIdArray), ",");

                if (!user.saveOrUpdate()) {
                    return false;
                }

                List<UserGroupRel> userGroupRelList = Lists.newArrayList();
                groupList.stream().forEach(groupId -> {
                    UserGroupRel userGroupRel = new UserGroupRel();
                    userGroupRel.setId(StrUtil.uuid());
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
                    if (StrUtil.notBlank(groupId)) {
                        user.setGroupId(groupId);
                    }
                    user.saveOrUpdate();

                    UserGroupRel userGroupRel = new UserGroupRel();
                    userGroupRel.setId(StrUtil.uuid());
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
        Jboot.getCache().remove(User.CACHE_NAME, buildCacheKey(id.toString()));
        return super.deleteById(id);
    }

    @Override
    protected void clearAllCache() {
        Jboot.getCache().removeAll(User.CACHE_NAME);
    }

    private void clearCacheByKey(String cacheName, String key) {
        Jboot.getCache().remove(cacheName, key);
    }

    private String buildCacheKey(String id) {
        return "user:" + id;
    }
}