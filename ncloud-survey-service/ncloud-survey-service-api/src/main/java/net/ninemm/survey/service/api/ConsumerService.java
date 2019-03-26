package net.ninemm.survey.service.api;

import com.jfinal.plugin.activerecord.Page;
import net.ninemm.survey.service.model.Consumer;
import io.jboot.db.model.Columns;

import java.util.List;

public interface ConsumerService  {

    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public Consumer findById(Object id);


    /**
     * find all model
     *
     * @return all <Consumer
     */
    public List<Consumer> findAll();


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
    public boolean delete(Consumer model);


    /**
     * save model to database
     *
     * @param model
     * @return id value if save success
     */
    public Object save(Consumer model);


    /**
     * save or update model
     *
     * @param model
     * @return id value if save or update success
     */
    public Object saveOrUpdate(Consumer model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(Consumer model);


    /**
     * page query
     *
     * @param page
     * @param pageSize
     * @return page data
     */
    public Page<Consumer> paginate(int page, int pageSize);


    /**
     * page query by columns
     *
     * @param page
     * @param pageSize
     * @param columns
     * @return page data
     */
    public Page<Consumer> paginateByColumns(int page, int pageSize, Columns columns);


    /**
     * page query by columns
     *
     * @param page
     * @param pageSize
     * @param columns
     * @param orderBy
     * @return page data
     */
    public Page<Consumer> paginateByColumns(int page, int pageSize, Columns columns, String orderBy);


}