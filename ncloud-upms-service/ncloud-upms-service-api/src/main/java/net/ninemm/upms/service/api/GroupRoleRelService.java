package net.ninemm.upms.service.api;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import net.ninemm.upms.service.model.GroupRoleRel;

import java.util.List;

public interface GroupRoleRelService  {

    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public GroupRoleRel findById(Object id);


    /**
     * find all model
     *
     * @return all <GroupRoleRel
     */
    public List<GroupRoleRel> findAll();


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
    public boolean delete(GroupRoleRel model);


    /**
     * save model to database
     *
     * @param model
     * @return
     */
    public Object save(GroupRoleRel model);


    /**
     * save or update model
     *
     * @param model
     * @return if save or update success
     */
    public Object saveOrUpdate(GroupRoleRel model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(GroupRoleRel model);


    /**
     * 分页
     *
     * @param page
     * @param pageSize
     * @return
     */
    public Page<? extends Model> paginate(int page, int pageSize);

/*    public void keep(Model model, String... attrs);

    public void keep(List<? extends Model> models, String... attrs);*/

    public List<String> findRoleList(String groupId);

    public boolean update(String groupId, String roleIds);

}