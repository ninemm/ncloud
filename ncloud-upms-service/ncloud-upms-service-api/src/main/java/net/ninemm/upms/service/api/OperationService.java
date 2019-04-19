package net.ninemm.upms.service.api;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import net.ninemm.upms.service.model.Operation;
import net.ninemm.upms.service.model.Role;

import java.util.List;
import java.util.Map;

public interface OperationService  {

    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public Operation findById(Object id);


    /**
     * find all model
     *
     * @return all <Operation
     */
    public List<Operation> findAll();


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
    public boolean delete(Operation model);


    /**
     * save model to database
     *
     * @param model
     * @return
     */
    public Object save(Operation model);


    /**
     * save or update model
     *
     * @param model
     * @return if save or update success
     */
    public Object saveOrUpdate(Operation model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(Operation model);


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

    public Page<Operation> paginate(int page, int pageSize, Map<String, Object> params);

    /**
     * 获取用户的所有角色
     * @author Eric
     * @date  2018-12-27 14:36
     * @param userId
     * @return java.util.List<net.ninemm.upms.service.model.Role>
     */
    public List<String> findAllPermissionByUserId(String userId, String roleIds);

    public List<Operation> findListByModuleId(String moduleId);

    void updateIsPrivilegeById(String id);
}