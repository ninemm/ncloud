package net.ninemm.upms.service.api;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import net.ninemm.upms.service.model.UserGroupRel;

import java.util.List;

public interface UserGroupRelService  {

    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public UserGroupRel findById(Object id);


    /**
     * find all model
     *
     * @return all <UserGroupRel
     */
    public List<UserGroupRel> findAll();


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
    public boolean delete(UserGroupRel model);


    /**
     * save model to database
     *
     * @param model
     * @return
     */
    public Object save(UserGroupRel model);


    /**
     * save or update model
     *
     * @param model
     * @return if save or update success
     */
    public Object saveOrUpdate(UserGroupRel model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(UserGroupRel model);


    /**
     * 分页
     *
     * @param page
     * @param pageSize
     * @return
     */
    public Page<? extends Model> paginate(int page, int pageSize);

    /*public void keep(Model model, String... attrs);

    public void keep(List<? extends Model> models, String... attrs);*/

    public int deleteByUserId(String userId);
}