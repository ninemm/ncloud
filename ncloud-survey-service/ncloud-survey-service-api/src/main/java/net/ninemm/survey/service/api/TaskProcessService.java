package net.ninemm.survey.service.api;

import com.jfinal.plugin.activerecord.Page;
import net.ninemm.survey.service.model.TaskProcess;
import io.jboot.db.model.Columns;

import java.util.List;

public interface TaskProcessService  {

    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public TaskProcess findById(Object id);


    /**
     * find all model
     *
     * @return all <TaskProcess
     */
    public List<TaskProcess> findAll();


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
    public boolean delete(TaskProcess model);


    /**
     * save model to database
     *
     * @param model
     * @return id value if save success
     */
    public Object save(TaskProcess model);


    /**
     * save or update model
     *
     * @param model
     * @return id value if save or update success
     */
    public Object saveOrUpdate(TaskProcess model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(TaskProcess model);


    /**
     * page query
     *
     * @param page
     * @param pageSize
     * @return page data
     */
    public Page<TaskProcess> paginate(int page, int pageSize);


    /**
     * page query by columns
     *
     * @param page
     * @param pageSize
     * @param columns
     * @return page data
     */
    public Page<TaskProcess> paginateByColumns(int page, int pageSize, Columns columns);


    /**
     * page query by columns
     *
     * @param page
     * @param pageSize
     * @param columns
     * @param orderBy
     * @return page data
     */
    public Page<TaskProcess> paginateByColumns(int page, int pageSize, Columns columns, String orderBy);

    /**
     *
     * @param taskId
     */
    void deleteByTaskId(String taskId);

    void clearAllCache();
}