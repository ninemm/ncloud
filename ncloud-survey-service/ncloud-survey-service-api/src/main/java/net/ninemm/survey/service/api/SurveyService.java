package net.ninemm.survey.service.api;

import com.jfinal.plugin.activerecord.Page;
import net.ninemm.survey.service.model.Survey;
import io.jboot.db.model.Columns;

import java.util.List;

public interface SurveyService  {

    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public Survey findById(Object id);


    /**
     * find all model
     *
     * @return all <Survey
     */
    public List<Survey> findAll();


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
    public boolean delete(Survey model);


    /**
     * save model to database
     *
     * @param model
     * @return id value if save success
     */
    public Object save(Survey model);


    /**
     * save or update model
     *
     * @param model
     * @return id value if save or update success
     */
    public Object saveOrUpdate(Survey model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(Survey model);


    /**
     * page query
     *
     * @param page
     * @param pageSize
     * @return page data
     */
    public Page<Survey> paginate(int page, int pageSize);


    /**
     * page query by columns
     *
     * @param page
     * @param pageSize
     * @param columns
     * @return page data
     */
    public Page<Survey> paginateByColumns(int page, int pageSize, Columns columns);


    /**
     * page query by columns
     *
     * @param page
     * @param pageSize
     * @param columns
     * @param orderBy
     * @return page data
     */
    public Page<Survey> paginateByColumns(int page, int pageSize, Columns columns, String orderBy);

    void clearAllCache();
    /**
    * @Description:
    * @Param: [ids]
    * @return:
    * @Author: lsy
    * @Date: 2019/3/18
    */
    void deleteByIds(String ids);

    /**
    * @Description:  根据ids查找
    * @Param: [ids]
    * @return: java.util.List<net.ninemm.survey.service.model.Survey>
    * @Author: lsy
    * @Date: 2019/4/13
    */
    List<Survey> findByIds(String ids);
}
