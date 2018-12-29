package net.ninemm.upms.service.api;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import net.ninemm.upms.service.model.Module;
import net.ninemm.upms.service.model.Role;

import java.util.List;
import java.util.Map;

public interface RoleService  {

    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public Role findById(Object id);


    /**
     * find all model
     *
     * @return all <Role
     */
    public List<Role> findAll();


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
    public boolean delete(Role model);


    /**
     * save model to database
     *
     * @param model
     * @return
     */
    public boolean save(Role model);


    /**
     * save or update model
     *
     * @param model
     * @return if save or update success
     */
    public boolean saveOrUpdate(Role model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(Role model);


    /**
     * 分页
     *
     * @param page
     * @param pageSize
     * @return
     */
    public Page<? extends Model> paginate(int page, int pageSize);


    public void join(Page<? extends Model> page, String joinOnField);

    public void join(Page<? extends Model> page, String joinOnField, String[] attrs);

    public void join(Page<? extends Model> page, String joinOnField, String joinName);

    public void join(Page<? extends Model> page, String joinOnField, String joinName, String[] attrs);

    public void join(List<? extends Model> models, String joinOnField);

    public void join(List<? extends Model> models, String joinOnField, String[] attrs);

    public void join(List<? extends Model> models, String joinOnField, String joinName);

    public void join(List<? extends Model> models, String joinOnField, String joinName, String[] attrs);

    public void join(Model model, String joinOnField);

    public void join(Model model, String joinOnField, String[] attrs);

    public void join(Model model, String joinOnField, String joinName);

    public void join(Model model, String joinOnField, String joinName, String[] attrs);

    public void keep(Model model, String... attrs);

    public void keep(List<? extends Model> models, String... attrs);

    public Page<Role> paginate(int page, int pageSize, Map<String, Object> params);

    public List<Record> findListAsOptions(String dataArea);

    /**
     * 获取用户的所有角色
     * @author Eric
     * @date  2018-12-27 14:36
     * @param userId
     * @return java.util.List<net.ninemm.upms.service.model.Role>
     */
    public List<Role> findRoleListByUserId(String userId);

}