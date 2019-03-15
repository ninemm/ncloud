package net.ninemm.survey.service.api;

import com.jfinal.plugin.activerecord.Page;
import net.ninemm.survey.service.model.Template;
import io.jboot.db.model.Columns;
import net.ninemm.survey.service.model.TemplateCategory;

import java.util.List;

public interface TemplateService  {

    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public Template findById(Object id);


    /**
     * find all model
     *
     * @return all <Template
     */
    public List<Template> findAll();


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
    public boolean delete(Template model);


    /**
     * save model to database
     *
     * @param model
     * @return id value if save success
     */
    public Object save(Template model);


    /**
     * save or update model
     *
     * @param model
     * @return id value if save or update success
     */
    public Object saveOrUpdate(Template model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(Template model);


    /**
     * page query
     *
     * @param page
     * @param pageSize
     * @return page data
     */
    public Page<Template> paginate(int page, int pageSize);


    /**
     * page query by columns
     *
     * @param page
     * @param pageSize
     * @param columns
     * @return page data
     */
    public Page<Template> paginateByColumns(int page, int pageSize, Columns columns);


    /**
     * page query by columns
     *
     * @param page
     * @param pageSize
     * @param columns
     * @param orderBy
     * @return page data
     */
    public Page<Template> paginateByColumns(int page, int pageSize, Columns columns, String orderBy);

    /**
    * @Description:
    * @Param: [dataArea]
    * @return: java.util.List<net.ninemm.survey.service.model.TemplateCategory>
    * @Author: lsy
    * @Date: 2019/3/14
    */
    List<Template> findByDataArea(String dataArea);
}