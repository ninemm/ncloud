package net.ninemm.survey.service.api;

import com.jfinal.plugin.activerecord.Page;
import net.ninemm.survey.service.model.Attr;
import io.jboot.db.model.Columns;

import java.util.List;

public interface AttrService  {

    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public Attr findById(Object id);


    /**
     * find all model
     *
     * @return all <Attr
     */
    public List<Attr> findAll();


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
    public boolean delete(Attr model);


    /**
     * save model to database
     *
     * @param model
     * @return id value if save success
     */
    public Object save(Attr model);


    /**
     * save or update model
     *
     * @param model
     * @return id value if save or update success
     */
    public Object saveOrUpdate(Attr model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(Attr model);


    /**
     * page query
     *
     * @param page
     * @param pageSize
     * @return page data
     */
    public Page<Attr> paginate(int page, int pageSize);


    /**
     * page query by columns
     *
     * @param page
     * @param pageSize
     * @param columns
     * @return page data
     */
    public Page<Attr> paginateByColumns(int page, int pageSize, Columns columns);


    /**
     * page query by columns
     *
     * @param page
     * @param pageSize
     * @param columns
     * @param orderBy
     * @return page data
     */
    public Page<Attr> paginateByColumns(int page, int pageSize, Columns columns, String orderBy);

    /**
     *
     * @param surveyId
     */
    void deleteBySurveyId(String surveyId);

    void clearAllCache();
}