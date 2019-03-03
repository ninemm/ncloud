package net.ninemm.survey.service.api;

import com.jfinal.plugin.activerecord.Page;
import net.ninemm.survey.service.model.Task;
import io.jboot.db.model.Columns;

import java.util.List;

public interface TaskService  {

    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public Task findById(Object id);


    /**
     * find all model
     *
     * @return all <Task
     */
    public List<Task> findAll();


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
    public boolean delete(Task model);


    /**
     * save model to database
     *
     * @param model
     * @return id value if save success
     */
    public Object save(Task model);


    /**
     * save or update model
     *
     * @param model
     * @return id value if save or update success
     */
    public Object saveOrUpdate(Task model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(Task model);


    /**
     * page query
     *
     * @param page
     * @param pageSize
     * @return page data
     */
    public Page<Task> paginate(int page, int pageSize);


    /**
     * page query by columns
     *
     * @param page
     * @param pageSize
     * @param columns
     * @return page data
     */
    public Page<Task> paginateByColumns(int page, int pageSize, Columns columns);


    /**
     * page query by columns
     *
     * @param page
     * @param pageSize
     * @param columns
     * @param orderBy
     * @return page data
     */
    public Page<Task> paginateByColumns(int page, int pageSize, Columns columns, String orderBy);


	public void deleteByProjectId(String projectId);


	void clearAllCache();


}