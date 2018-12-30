package net.ninemm.upms.service.api;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import io.jboot.db.model.JbootModel;
import net.ninemm.upms.service.model.User;

import java.util.List;
import java.util.Map;

public interface UserService  {

    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public User findById(Object id);


    /**
     * find all model
     *
     * @return all <User
     */
    public List<User> findAll();


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
    public boolean delete(User model);


    /**
     * save model to database
     *
     * @param model
     * @return
     */
    public boolean save(User model);


    /**
     * save or update model
     *
     * @param model
     * @return if save or update success
     */
    public boolean saveOrUpdate(User model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(User model);


    /**
     * 分页
     *
     * @param page
     * @param pageSize
     * @return
     */
    public Page<User> paginate(int page, int pageSize);


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

    /**
     * find user by mobile
     * @param mobile
     * @return
     */
    public List<User> findByMobile(String mobile);
    
    /**
     * find user by username
     *
     * @param username
     * @return net.ninemm.upms.service.model.User
     */
    public User findByUsername(String username);

    /**
     * batch save user
     *
     * @param list
     * @return boolean
     */
    public boolean batchSave(List<User> list);

    public Page<User> paginate(int page, int pageSize, Map<String, Object> params);

    /**
     * find user by dept id
     *
     * @param deptId
     * @return List
     */
    public List<User> findListByDeptId(String deptId);
}