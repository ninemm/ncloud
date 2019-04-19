package net.ninemm.upms.service.provider;

import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.IAtom;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.SqlPara;
import io.jboot.Jboot;
import io.jboot.aop.annotation.Bean;
import io.jboot.components.cache.annotation.Cacheable;
import io.jboot.components.rpc.annotation.RPCBean;
import io.jboot.db.model.Columns;
import io.jboot.utils.StrUtil;
import net.ninemm.base.web.base.BaseService;
import net.ninemm.upms.service.api.DepartmentService;
import net.ninemm.upms.service.model.Department;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@Bean
public class DepartmentServiceImpl extends BaseService<Department> implements DepartmentService<Department> {

    @Override
    public Object saveOrUpdate(Department dept) {

        boolean saved = Db.tx(new IAtom() {
            @Override
            public boolean run() throws SQLException {
                clearAllCache();

                if (dept.getIsParent() == null) {
                    dept.setIsParent(0);
                }

                if (StrUtil.isBlank(dept.getId())) {
                    String dataArea = findNextDataArea(dept.getParentId());
                    dept.setDataArea(dataArea);
                }

                if (!dept.saveOrUpdate()) {
                    return false;
                }

                List<Department> childList = findListByParentId(dept.getParentId());
                StringBuilder childIds = new StringBuilder();
                childList.stream().forEach(dept -> {
                    childIds.append(dept.getId()).append(",");
                });

                childIds.append(dept.getId());
                boolean result = updateParentChildIds(childIds.toString(), dept.getParentId());
                return result;
            }
        });
        return saved;
    }

    @Override
    public boolean deleteById(Object id) {
        String sql = "delete from upms_department where parent_id = ?";
        Db.delete(sql, id);
        return super.deleteById(id);
    }

    @Override
    public List<Department> findListExcludeRoot() {
        Columns columns = Columns.create();
        columns.is_not_null("parent_id");
        return DAO.findListByColumns(columns, "order_list asc");
    }

    @Override
    public List<Department> findChildListIncludeRoot(String deptDataArea) {
        String sql = "SELECT * FROM `upms_department` where data_area like ? order by dept_level asc, order_list asc";
        return DAO.find(sql, deptDataArea + "%");
    }

    @Override
    @Cacheable(name = "upms_department", key = "all", liveSeconds = 86400)
    public List<Department> findAllAsSort() {
        return DAO.find("select * from upms_department order by order_list asc");
    }

    @Override
    @Cacheable(name = "upms_department", key = "parent:#(parentId)", liveSeconds = 86400)
    public List<Department> findListByParentId(String parentId) {
        return DAO.findListByColumn("parent_id", parentId, "data_area desc");
    }

    @Override
    @Cacheable(name = "upms_department", key = "list:#(deptId)", liveSeconds = 86400)
    public List<Department> findAllParentDeptByDeptId(String deptId) {
        SqlPara sql = Db.getSqlPara("upms-dept.findAllParentDeptByDeptId", deptId);
        return DAO.find(sql);
    }

    @Override
    @Cacheable(name = "upms_department", key = "id:#(deptId)", liveSeconds = 86400)
    public Department findDeptDataAreaByDeptId(String deptId) {
        List<Department> list = findAllParentDeptByDeptId(deptId);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<? extends Model> findByDeptName(String deptName) {
        String sql = "SELECT * FROM `upms_department` where dept_name like ? order by order_list asc ";
        return DAO.find(sql, "%"+deptName + "%");
    }

    @Override
    public List<Department> findByDeptDataArea(String dataArea ,String deptName) {
        LinkedList<String> parmas = new LinkedList<>();
        StringBuilder sql = new StringBuilder("SELECT up.*  FROM upms_department up LEFT JOIN (select id,dept_name from upms_department) a on up.parent_id = a.id left join upms_user b on b.id = up.principal_user_id WHERE up.data_area like ? ") ;
        parmas.add(dataArea);
        if (StrKit.notBlank(deptName)){
            sql.append("and up.dept_name like ?  ");
            parmas.add("%"+deptName+"%");
        }
        return DAO.find(sql.toString(), parmas.toArray());
    }

    @Override
    public Department findByUserId(String userId) {
        String sql = "SELECT up.* FROM upms_department up LEFT JOIN upms_user u on u.department_id =up.id WHERE u.id = ? ";
        return DAO.findFirst(sql,userId);
    }

    @Override
    public void deleteByIds(String ids) {
        String sql = "DELETE FROM upms_department WHERE id in ("+ids+")";
        Db.delete(sql);
    }


    private boolean updateParentChildIds(String childIds, String id) {
        String sql = "UPDATE upms_department SET is_parent = 1, child_ids = ? WHERE id = ?";
        int count = Db.update(sql, childIds, id);
        if (count >= 0) {
            return true;
        }
        return false;
    }

    private String findNextDataArea(String parentId) {
        String sql = "SELECT MAX(data_area) FROM upms_department WHERE parent_id = ? ORDER BY data_area DESC";
        String dataArea = Db.queryStr(sql, parentId);
        if (StrUtil.isBlank(dataArea)) {
            Department department = findById(parentId);
            dataArea = department.getDataArea();
            return dataArea + "001";
        }
        return "00" + String.valueOf(Integer.valueOf(dataArea).intValue() + 1);
    }

    @Override
    public void clearAllCache() {
        Jboot.getCache().removeAll(Department.CACHE_NAME);
    }

}