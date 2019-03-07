package net.ninemm.survey.service.api;

import com.jfinal.plugin.activerecord.Page;
import net.ninemm.survey.service.model.ConsumerAttrCondition;
import io.jboot.db.model.Columns;

import java.util.List;

public interface ConsumerAttrConditionService  {

    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public ConsumerAttrCondition findById(Object id);


    /**
     * find all model
     *
     * @return all <ConsumerAttrCondition
     */
    public List<ConsumerAttrCondition> findAll();


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
    public boolean delete(ConsumerAttrCondition model);


    /**
     * save model to database
     *
     * @param model
     * @return id value if save success
     */
    public Object save(ConsumerAttrCondition model);


    /**
     * save or update model
     *
     * @param model
     * @return id value if save or update success
     */
    public Object saveOrUpdate(ConsumerAttrCondition model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(ConsumerAttrCondition model);


    /**
     * page query
     *
     * @param page
     * @param pageSize
     * @return page data
     */
    public Page<ConsumerAttrCondition> paginate(int page, int pageSize);


    /**
     * page query by columns
     *
     * @param page
     * @param pageSize
     * @param columns
     * @return page data
     */
    public Page<ConsumerAttrCondition> paginateByColumns(int page, int pageSize, Columns columns);


    /**
     * page query by columns
     *
     * @param page
     * @param pageSize
     * @param columns
     * @param orderBy
     * @return page data
     */
    public Page<ConsumerAttrCondition> paginateByColumns(int page, int pageSize, Columns columns, String orderBy);

    /**
     *
     * @param answerRestrictId
     * @return
     */
    List<ConsumerAttrCondition> findByRestrictId(String answerRestrictId);
}