package net.ninemm.survey.service.api;

import com.jfinal.plugin.activerecord.Page;
import net.ninemm.survey.service.model.Tags;
import io.jboot.db.model.Columns;

import java.util.List;

public interface TagsService  {

    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public Tags findById(Object id);


    /**
     * find all model
     *
     * @return all <Tags
     */
    public List<Tags> findAll();


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
    public boolean delete(Tags model);


    /**
     * save model to database
     *
     * @param model
     * @return id value if save success
     */
    public Object save(Tags model);


    /**
     * save or update model
     *
     * @param model
     * @return id value if save or update success
     */
    public Object saveOrUpdate(Tags model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(Tags model);


    /**
     * page query
     *
     * @param page
     * @param pageSize
     * @return page data
     */
    public Page<Tags> paginate(int page, int pageSize);


    /**
     * page query by columns
     *
     * @param page
     * @param pageSize
     * @param columns
     * @return page data
     */
    public Page<Tags> paginateByColumns(int page, int pageSize, Columns columns);


    /**
     * page query by columns
     *
     * @param page
     * @param pageSize
     * @param columns
     * @param orderBy
     * @return page data
     */
    public Page<Tags> paginateByColumns(int page, int pageSize, Columns columns, String orderBy);

    /**
     *
     * @param surveyId
     */
    void deleteBySurveyId(String surveyId);

    void clearAllCache();
    /**
    * @Description:
    * @Param: [surveyId]
    * @return: java.util.List<net.ninemm.survey.service.model.Tags>
    * @Author: lsy
    * @Date: 2019/3/14
    */
    List<Tags> findBySurveyId(String surveyId);
}