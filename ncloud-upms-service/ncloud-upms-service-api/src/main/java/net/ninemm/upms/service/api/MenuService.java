package net.ninemm.upms.service.api;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import net.ninemm.upms.service.model.Menu;
import net.ninemm.upms.service.model.Operation;

import java.util.List;

public interface MenuService  {

    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public Menu findById(Object id);


    /**
     * find all model
     *
     * @return all <Menu
     */
    public List<Menu> findAll();


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
    public boolean delete(Menu model);


    /**
     * save model to database
     *
     * @param model
     * @return
     */
    public boolean save(Menu model);

    /**
     * save model to database
     *
     * @param operation
     * @return
     */
    public boolean save(Operation operation);

   /**
     * save or update model
     *
     * @param model
     * @return if save or update success
     */
    public boolean saveOrUpdate(Menu model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(Menu model);


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

    public List<Menu> findListByParentId(String parentId);

    public List<Menu> findListWithoutRoot();

    public List<Menu> findAllAsSort();

    /**
     * 获取 Header 菜单
     * @return java.util.List<net.ninemm.upms.service.model.Menu>
     */
    public List<Menu> findHeaderMenuSet();

}