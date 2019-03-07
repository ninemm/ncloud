package net.ninemm.survey.service.api;

import com.jfinal.plugin.activerecord.Page;
import net.ninemm.survey.service.model.FrequencyCondition;
import io.jboot.db.model.Columns;

import java.util.List;

public interface FrequencyConditionService  {

    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public FrequencyCondition findById(Object id);


    /**
     * find all model
     *
     * @return all <FrequencyCondition
     */
    public List<FrequencyCondition> findAll();


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
    public boolean delete(FrequencyCondition model);


    /**
     * save model to database
     *
     * @param model
     * @return id value if save success
     */
    public Object save(FrequencyCondition model);


    /**
     * save or update model
     *
     * @param model
     * @return id value if save or update success
     */
    public Object saveOrUpdate(FrequencyCondition model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(FrequencyCondition model);


    /**
     * page query
     *
     * @param page
     * @param pageSize
     * @return page data
     */
    public Page<FrequencyCondition> paginate(int page, int pageSize);


    /**
     * page query by columns
     *
     * @param page
     * @param pageSize
     * @param columns
     * @return page data
     */
    public Page<FrequencyCondition> paginateByColumns(int page, int pageSize, Columns columns);


    /**
     * page query by columns
     *
     * @param page
     * @param pageSize
     * @param columns
     * @param orderBy
     * @return page data
     */
    public Page<FrequencyCondition> paginateByColumns(int page, int pageSize, Columns columns, String orderBy);

    /**
     *
     * @param answerRestrictId
     * @return
     */
    List<FrequencyCondition> findByRestrictId(String answerRestrictId);
}