package net.ninemm.survey.service.api;

import com.jfinal.plugin.activerecord.Page;
import io.jboot.service.JbootServiceJoiner;
import net.ninemm.survey.service.model.TimeCondition;
import io.jboot.db.model.Columns;

import java.util.List;

public interface TimeConditionService extends JbootServiceJoiner {

    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public TimeCondition findById(Object id);


    /**
     * find all model
     *
     * @return all <TimeCondition
     */
    public List<TimeCondition> findAll();


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
    public boolean delete(TimeCondition model);


    /**
     * save model to database
     *
     * @param model
     * @return id value if save success
     */
    public Object save(TimeCondition model);


    /**
     * save or update model
     *
     * @param model
     * @return id value if save or update success
     */
    public Object saveOrUpdate(TimeCondition model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(TimeCondition model);


    /**
     * page query
     *
     * @param page
     * @param pageSize
     * @return page data
     */
    public Page<TimeCondition> paginate(int page, int pageSize);


    /**
     * page query by columns
     *
     * @param page
     * @param pageSize
     * @param columns
     * @return page data
     */
    public Page<TimeCondition> paginateByColumns(int page, int pageSize, Columns columns);


    /**
     * page query by columns
     *
     * @param page
     * @param pageSize
     * @param columns
     * @param orderBy
     * @return page data
     */
    public Page<TimeCondition> paginateByColumns(int page, int pageSize, Columns columns, String orderBy);

    /**
     *
     * @param answerRestrictId
     */
    List<TimeCondition> findByRestrictId(String answerRestrictId);
}