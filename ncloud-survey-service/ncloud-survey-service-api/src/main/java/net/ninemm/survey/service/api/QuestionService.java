package net.ninemm.survey.service.api;

import com.jfinal.plugin.activerecord.Page;
import net.ninemm.survey.service.model.Question;
import io.jboot.db.model.Columns;

import java.util.List;

public interface QuestionService  {

    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public Question findById(Object id);


    /**
     * find all model
     *
     * @return all <Question
     */
    public List<Question> findAll();


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
    public boolean delete(Question model);


    /**
     * save model to database
     *
     * @param model
     * @return id value if save success
     */
    public Object save(Question model);


    /**
     * save or update model
     *
     * @param model
     * @return id value if save or update success
     */
    public Object saveOrUpdate(Question model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(Question model);


    /**
     * page query
     *
     * @param page
     * @param pageSize
     * @return page data
     */
    public Page<Question> paginate(int page, int pageSize);


    /**
     * page query by columns
     *
     * @param page
     * @param pageSize
     * @param columns
     * @return page data
     */
    public Page<Question> paginateByColumns(int page, int pageSize, Columns columns);


    /**
     * page query by columns
     *
     * @param page
     * @param pageSize
     * @param columns
     * @param orderBy
     * @return page data
     */
    public Page<Question> paginateByColumns(int page, int pageSize, Columns columns, String orderBy);

    void deleteBySurveyId(String surveyId);
    /** 
    * @Description: 根据问卷id查询问卷的所有题目信息
    * @Param:  surveyId
    * @return:  
    * @Author: lsy 
    * @Date: 2019/3/11 
    */ 
    List<Question> findBySurveyId(String surveyId);
    /**
    * @Description:
    * @Param: [questionsList,surveyId]
    * @return:
    * @Author: lsy
    * @Date: 2019/3/11
    */
    Boolean saveQuestions(List<Question> questionsList, String surveyId);
}