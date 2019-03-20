package net.ninemm.survey.service.api;

import com.jfinal.plugin.activerecord.Page;
import net.ninemm.survey.service.model.StoreQuestion;
import io.jboot.db.model.Columns;

import java.util.List;

public interface StoreQuestionService  {

    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public StoreQuestion findById(Object id);


    /**
     * find all model
     *
     * @return all <StoreQuestion
     */
    public List<StoreQuestion> findAll();


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
    public boolean delete(StoreQuestion model);


    /**
     * save model to database
     *
     * @param model
     * @return id value if save success
     */
    public Object save(StoreQuestion model);


    /**
     * save or update model
     *
     * @param model
     * @return id value if save or update success
     */
    public Object saveOrUpdate(StoreQuestion model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(StoreQuestion model);


    /**
     * page query
     *
     * @param page
     * @param pageSize
     * @return page data
     */
    public Page<StoreQuestion> paginate(int page, int pageSize);


    /**
     * page query by columns
     *
     * @param page
     * @param pageSize
     * @param columns
     * @return page data
     */
    public Page<StoreQuestion> paginateByColumns(int page, int pageSize, Columns columns);


    /**
     * page query by columns
     *
     * @param page
     * @param pageSize
     * @param columns
     * @param orderBy
     * @return page data
     */
    public Page<StoreQuestion> paginateByColumns(int page, int pageSize, Columns columns, String orderBy);


}