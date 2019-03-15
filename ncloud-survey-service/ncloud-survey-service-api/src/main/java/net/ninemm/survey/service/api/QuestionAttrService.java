package net.ninemm.survey.service.api;

import com.jfinal.plugin.activerecord.Page;
import net.ninemm.survey.service.model.QuestionAttr;
import io.jboot.db.model.Columns;

import java.util.List;

public interface QuestionAttrService  {

    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public QuestionAttr findById(Object id);


    /**
     * find all model
     *
     * @return all <QuestionAttr
     */
    public List<QuestionAttr> findAll();


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
    public boolean delete(QuestionAttr model);


    /**
     * save model to database
     *
     * @param model
     * @return id value if save success
     */
    public Object save(QuestionAttr model);


    /**
     * save or update model
     *
     * @param model
     * @return id value if save or update success
     */
    public Object saveOrUpdate(QuestionAttr model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(QuestionAttr model);


    /**
     * page query
     *
     * @param page
     * @param pageSize
     * @return page data
     */
    public Page<QuestionAttr> paginate(int page, int pageSize);


    /**
     * page query by columns
     *
     * @param page
     * @param pageSize
     * @param columns
     * @return page data
     */
    public Page<QuestionAttr> paginateByColumns(int page, int pageSize, Columns columns);


    /**
     * page query by columns
     *
     * @param page
     * @param pageSize
     * @param columns
     * @param orderBy
     * @return page data
     */
    public Page<QuestionAttr> paginateByColumns(int page, int pageSize, Columns columns, String orderBy);

    /**
    * @Description:  通过问卷题目id查找题目属性
    * @Param: [questionId]
    * @return:
    * @Author: lsy
    * @Date: 2019/3/11
    */
    List<QuestionAttr> findByQurstionId(String questionId);
    /**
    * @Description:
    * @Param:  questionId
    * @return:  
    * @Author: lsy 
    * @Date: 2019/3/11 
    */ 
    void deleteByQuestionId(String questionId);
    /**
    * @Description:  根据问卷id查找
    * @Param: [surveyId]
    * @return:
    * @Author: lsy
    * @Date: 2019/3/11
    */
    List<QuestionAttr> findBySurveyId(String surveyId);
    /**
    * @Description:
    * @Param:  surveyId
    * @return:
    * @Author: lsy
    * @Date: 2019/3/11
    */
    void deleteBySurveyId(String surveyId);
}