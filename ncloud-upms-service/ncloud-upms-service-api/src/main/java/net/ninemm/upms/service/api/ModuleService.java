package net.ninemm.upms.service.api;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import net.ninemm.upms.service.model.Module;
import net.ninemm.upms.service.model.Systems;

import java.util.List;
import java.util.Map;

public interface ModuleService  {

    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public Module findById(Object id);


    /**
     * find all model
     *
     * @return all <Module
     */
    public List<Module> findAll();


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
    public boolean delete(Module model);


    /**
     * save model to database
     *
     * @param model
     * @return
     */
    public Object save(Module model);


    /**
     * save or update model
     *
     * @param model
     * @return if save or update success
     */
    public Object saveOrUpdate(Module model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(Module model);


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

    public Page<Module> paginate(int page, int pageSize, Map<String, Object> params);

    public List<Module> findAllAsSort();

    public List<Module> findListByParentId(String parentId);

}