package net.ninemm.survey.service.api;

import com.jfinal.plugin.activerecord.Page;
import net.ninemm.survey.service.model.TemplateCategory;
import io.jboot.db.model.Columns;

import java.util.List;

public interface TemplateCategoryService  {

    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public TemplateCategory findById(Object id);


    /**
     * find all model
     *
     * @return all <TemplateCategory
     */
    public List<TemplateCategory> findAll();


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
    public boolean delete(TemplateCategory model);


    /**
     * save model to database
     *
     * @param model
     * @return id value if save success
     */
    public Object save(TemplateCategory model);


    /**
     * save or update model
     *
     * @param model
     * @return id value if save or update success
     */
    public Object saveOrUpdate(TemplateCategory model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(TemplateCategory model);


    /**
     * page query
     *
     * @param page
     * @param pageSize
     * @return page data
     */
    public Page<TemplateCategory> paginate(int page, int pageSize);


    /**
     * page query by columns
     *
     * @param page
     * @param pageSize
     * @param columns
     * @return page data
     */
    public Page<TemplateCategory> paginateByColumns(int page, int pageSize, Columns columns);


    /**
     * page query by columns
     *
     * @param page
     * @param pageSize
     * @param columns
     * @param orderBy
     * @return page data
     */
    public Page<TemplateCategory> paginateByColumns(int page, int pageSize, Columns columns, String orderBy);

    /**
    * @Description:
    * @Param: [dataArea]
    * @return: java.util.List<net.ninemm.survey.service.model.TemplateCategory>
    * @Author: lsy
    * @Date: 2019/3/14
    */
    List<TemplateCategory> findByDataArea(String dataArea);
}