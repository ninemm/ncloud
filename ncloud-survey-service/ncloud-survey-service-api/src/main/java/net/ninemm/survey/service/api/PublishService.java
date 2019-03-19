package net.ninemm.survey.service.api;

import com.jfinal.plugin.activerecord.Page;
import net.ninemm.survey.service.model.Publish;
import io.jboot.db.model.Columns;

import java.util.List;

public interface PublishService  {

    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public Publish findById(Object id);


    /**
     * find all model
     *
     * @return all <Publish
     */
    public List<Publish> findAll();


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
    public boolean delete(Publish model);


    /**
     * save model to database
     *
     * @param model
     * @return id value if save success
     */
    public Object save(Publish model);


    /**
     * save or update model
     *
     * @param model
     * @return id value if save or update success
     */
    public Object saveOrUpdate(Publish model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(Publish model);


    /**
     * page query
     *
     * @param page
     * @param pageSize
     * @return page data
     */
    public Page<Publish> paginate(int page, int pageSize);


    /**
     * page query by columns
     *
     * @param page
     * @param pageSize
     * @param columns
     * @return page data
     */
    public Page<Publish> paginateByColumns(int page, int pageSize, Columns columns);


    /**
     * page query by columns
     *
     * @param page
     * @param pageSize
     * @param columns
     * @param orderBy
     * @return page data
     */
    public Page<Publish> paginateByColumns(int page, int pageSize, Columns columns, String orderBy);

    /**
     *
     * @param surveyId
     */
    void deleteBySurveyId(String surveyId);
    /**
    * @Description:
    * @Param: [surveyId]
    * @return: net.ninemm.survey.service.model.Publish
    * @Author: lsy
    * @Date: 2019/3/19
    */
    Publish findBySurveyId(String surveyId);
}