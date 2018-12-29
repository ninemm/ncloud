package net.ninemm.upms.service.provider;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.IAtom;
import com.jfinal.plugin.activerecord.SqlPara;
import io.jboot.Jboot;
import io.jboot.aop.annotation.Bean;
import io.jboot.core.cache.annotation.Cacheable;
import io.jboot.db.model.Columns;
import io.jboot.utils.StrUtils;
import net.ninemm.base.web.base.BaseService;
import net.ninemm.upms.service.api.DepartmentService;
import net.ninemm.upms.service.model.Department;

import javax.inject.Singleton;
import java.sql.SQLException;
import java.util.List;

@Bean
@Singleton
public class DepartmentServiceImpl extends BaseService<Department> implements DepartmentService<Department> {

    @Override
    public boolean saveOrUpdate(Department dept) {

        boolean saved = Db.tx(new IAtom() {
            @Override
            public boolean run() throws SQLException {
                clearAllCache();

                if (dept.getIsParent() == null) {
                    dept.setIsParent(0);
                }

                if (StrUtils.isBlank(dept.getId())) {
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
        return DAO.findListByColumn("parent_id", parentId, "order_list asc");
    }

    @Override
    @Cacheable(name = "upms_department", key = "list:#(deptId)", liveSeconds = 86400)
    public List<Department> findAllParentDeptByDeptId(String deptId) {
        SqlPara sqlPara = Db.getSqlPara("upms-dept.findAllParentDeptByDeptId", deptId);
        return DAO.find(sqlPara);
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

    private boolean updateParentChildIds(String childIds, String id) {
        String sql = "UPDATE upms_department SET is_parent = 1, child_ids = ? WHERE id = ?";
        int count = Db.update(sql, childIds, id);
        if (count >= 0) {
            return true;
        }
        return false;
    }

    private String findNextDataArea(String parentId) {
        String sql = "select max(data_area) from upms_department where parent_id = ? order by data_area desc";
        String dataArea = Db.queryStr(sql, parentId);
        if (StrUtils.isBlank(dataArea)) {
            Department department = findById(parentId);
            dataArea = department.getDataArea();
            return dataArea + "001";
        }
        return "00" + String.valueOf(Integer.valueOf(dataArea).intValue() + 1);
    }

    @Override
    public void clearAllCache() {
        Jboot.me().getCache().removeAll(Department.CACHE_NAME);
    }

}