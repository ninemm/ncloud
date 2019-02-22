package net.ninemm.upms.service.api;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import io.jboot.db.model.JbootModel;
import io.jboot.service.JbootServiceJoiner;
import net.ninemm.upms.service.model.Department;

import java.util.List;

public interface DepartmentService<M extends JbootModel<M>> extends JbootServiceJoiner {

    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public Department findById(Object id);


    /**
     * find all model
     *
     * @return all <Department
     */
    public List<? extends Model> findAll();


    /**
     * delete model by primary key
     *
     * @param id
     * @return success
     */
    public boolean deleteById(Object id);


    /**
     * delete model
     *
     * @param model
     * @return
     */
    public boolean delete(M model);


    /**
     * save model to database
     *
     * @param model
     * @return
     */
    public Object save(M model);


    /**
     * save or update model
     *
     * @param model
     * @return if save or update success
     */
    public Object saveOrUpdate(M model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(M model);


    /**
     * 分页
     *
     * @param page
     * @param pageSize
     * @return
     */
    public Page<? extends Model> paginate(int page, int pageSize);


    /*public void join(Page<? extends Model> page, String joinOnField);

    public void join(Page<? extends Model> page, String joinOnField, String[] attrs);

    public void join(Page<? extends Model> page, String joinOnField, String joinName);

    public void join(Page<? extends Model> page, String joinOnField, String joinName, String[] attrs);

    public void join(List<? extends Model> models, String joinOnField);

    public void join(List<? extends Model> models, String joinOnField, String[] attrs);

    public void join(List<? extends Model> models, String joinOnField, String joinName);

    public void join(List<? extends Model> models, String joinOnField, String joinName, String[] attrs);*/

    /*public void join(Model model, String joinOnField);

    public void join(Model model, String joinOnField, String[] attrs);

    public void join(Model model, String joinOnField, String joinName);

    public void join(Model model, String joinOnField, String joinName, String[] attrs);*/

    /*public void keep(Model model, String... attrs);

    public void keep(List<? extends Model> models, String... attrs);*/

    public List<? extends Model> findAllAsSort();

    public List<? extends Model> findListExcludeRoot();

    /**
     * find child list include parent node by dataArea
     * @author Eric
     * @date  2018-12-27 11:41
     * @param deptDataArea
     * @return list
     */
    public List<? extends Model> findChildListIncludeRoot(String deptDataArea);

    public List<? extends Model> findListByParentId(String parentId);

    /**
     * find all parent dept as desc order
     * @author Eric
     * @date  2018-12-27 11:41
     * @param deptId
     * @return list
     */
    public List<? extends Model> findAllParentDeptByDeptId(String deptId);

    /**
     * find parent dept node
     * @author Eric
     * @date  2018-12-27 11:41
     * @param deptId
     * @return net.ninemm.upms.service.model.Department
     */
    public Department findDeptDataAreaByDeptId(String deptId);

}