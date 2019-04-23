package net.ninemm.upms.service.api;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import net.ninemm.upms.service.model.RoleOperationRel;

import java.util.List;

public interface RoleOperationRelService  {

    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public RoleOperationRel findById(Object id);


    /**
     * find all model
     *
     * @return all <RoleOperationRel
     */
    public List<RoleOperationRel> findAll();


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
    public boolean delete(RoleOperationRel model);


    /**
     * save model to database
     *
     * @param model
     * @return
     */
    public Object save(RoleOperationRel model);


    /**
     * save or update model
     *
     * @param model
     * @return if save or update success
     */
    public Object saveOrUpdate(RoleOperationRel model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(RoleOperationRel model);


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

    public List<String> findListByRoleId(String roleId);

    public void deleteByModuleId(String roleId, String moduleId);

    void deleteByRoleIdAndOpId(String roleId, String operationId);

}