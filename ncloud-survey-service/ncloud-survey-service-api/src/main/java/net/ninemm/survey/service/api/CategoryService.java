package net.ninemm.survey.service.api;

import com.jfinal.plugin.activerecord.Page;
import net.ninemm.survey.service.model.Category;
import io.jboot.db.model.Columns;

import java.util.List;

public interface CategoryService  {

    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public Category findById(Object id);


    /**
     * find all model
     *
     * @return all <Category
     */
    public List<Category> findAll();


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
    public boolean delete(Category model);


    /**
     * save model to database
     *
     * @param model
     * @return id value if save success
     */
    public Object save(Category model);


    /**
     * save or update model
     *
     * @param model
     * @return id value if save or update success
     */
    public Object saveOrUpdate(Category model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(Category model);


    /**
     * page query
     *
     * @param page
     * @param pageSize
     * @return page data
     */
    public Page<Category> paginate(int page, int pageSize);


    /**
     * page query by columns
     *
     * @param page
     * @param pageSize
     * @param columns
     * @return page data
     */
    public Page<Category> paginateByColumns(int page, int pageSize, Columns columns);


    /**
     * page query by columns
     *
     * @param page
     * @param pageSize
     * @param columns
     * @param orderBy
     * @return page data
     */
    public Page<Category> paginateByColumns(int page, int pageSize, Columns columns, String orderBy);

    void clearAllCache();

    /**
    * @Description:  通过数据域查询
    * @Param: [dataArea]
    * @return: java.util.List<net.ninemm.survey.service.model.Category>
    * @Author: lsy
    * @Date: 2019/4/16
    */
    List<Category> findByDataArea(String dataArea);
}
