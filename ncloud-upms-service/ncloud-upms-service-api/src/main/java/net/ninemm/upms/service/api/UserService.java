package net.ninemm.upms.service.api;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import io.jboot.db.model.JbootModel;
import io.jboot.service.JbootServiceJoiner;
import net.ninemm.upms.service.model.User;

import java.util.List;
import java.util.Map;

public interface UserService extends JbootServiceJoiner {

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
     * find all account
     *
     * @param mobile
     * @return all Record
     */
    public List<Record> findAllAccount(String mobile);

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
    public Object save(User model);


    /**
     * save or update model
     *
     * @param model
     * @return if save or update success
     */
    public Object saveOrUpdate(User model);


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

    /**
     * 带参数的分页
     *
     * @param page
     * @param pageSize
     * @param params
     * @return
     */
    public Page<User> paginate(int page, int pageSize, Map<String, Object> params);

    /*public void keep(Model model, String... attrs);

    public void keep(List<? extends Model> models, String... attrs);*/

    /**
     * find user by mobile
     * @param mobile
     * @return
     */
    public List<User> findByMobile(String mobile);

    /**
     * find user by mobile and deptId
     * @param mobile
     * @param deptId
     * @return
     */
    public User findByMobileAndDeptId(String mobile, String deptId);
    
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



    /**
     * find user by dept id
     *
     * @param deptId
     * @return List
     */
    public List<User> findListByDeptId(String deptId);

    int batchReset(String[] ids);

    List<Record> findByDepTid(String ids);

    void updateStatusById(String id, String status);

    List<Record> findByDateArea(String userId);
}