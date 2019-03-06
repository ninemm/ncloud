package net.ninemm.survey.service.api;

import com.jfinal.plugin.activerecord.Page;
import net.ninemm.survey.service.model.AnswerRestrict;
import io.jboot.db.model.Columns;

import java.util.List;

public interface AnswerRestrictService  {

    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public AnswerRestrict findById(Object id);


    /**
     * find all model
     *
     * @return all <AnswerRestrict
     */
    public List<AnswerRestrict> findAll();


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
    public boolean delete(AnswerRestrict model);


    /**
     * save model to database
     *
     * @param model
     * @return id value if save success
     */
    public Object save(AnswerRestrict model);


    /**
     * save or update model
     *
     * @param model
     * @return id value if save or update success
     */
    public Object saveOrUpdate(AnswerRestrict model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(AnswerRestrict model);


    /**
     * page query
     *
     * @param page
     * @param pageSize
     * @return page data
     */
    public Page<AnswerRestrict> paginate(int page, int pageSize);


    /**
     * page query by columns
     *
     * @param page
     * @param pageSize
     * @param columns
     * @return page data
     */
    public Page<AnswerRestrict> paginateByColumns(int page, int pageSize, Columns columns);


    /**
     * page query by columns
     *
     * @param page
     * @param pageSize
     * @param columns
     * @param orderBy
     * @return page data
     */
    public Page<AnswerRestrict> paginateByColumns(int page, int pageSize, Columns columns, String orderBy);

    void clearAllCache();
}