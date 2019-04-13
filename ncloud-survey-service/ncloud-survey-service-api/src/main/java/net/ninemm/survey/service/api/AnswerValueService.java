package net.ninemm.survey.service.api;

import com.jfinal.plugin.activerecord.Page;
import net.ninemm.survey.service.model.AnswerValue;
import io.jboot.db.model.Columns;

import java.util.List;

public interface AnswerValueService  {

    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public AnswerValue findById(Object id);


    /**
     * find all model
     *
     * @return all <AnswerValue
     */
    public List<AnswerValue> findAll();


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
    public boolean delete(AnswerValue model);


    /**
     * save model to database
     *
     * @param model
     * @return id value if save success
     */
    public Object save(AnswerValue model);


    /**
     * save or update model
     *
     * @param model
     * @return id value if save or update success
     */
    public Object saveOrUpdate(AnswerValue model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(AnswerValue model);


    /**
     * page query
     *
     * @param page
     * @param pageSize
     * @return page data
     */
    public Page<AnswerValue> paginate(int page, int pageSize);


    /**
     * page query by columns
     *
     * @param page
     * @param pageSize
     * @param columns
     * @return page data
     */
    public Page<AnswerValue> paginateByColumns(int page, int pageSize, Columns columns);


    /**
     * page query by columns
     *
     * @param page
     * @param pageSize
     * @param columns
     * @param orderBy
     * @return page data
     */
    public Page<AnswerValue> paginateByColumns(int page, int pageSize, Columns columns, String orderBy);


}