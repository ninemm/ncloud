package net.ninemm.survey.service.api;

import com.alibaba.fastjson.JSONObject;
import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.upload.UploadFile;
import io.jboot.db.model.Columns;
import net.ninemm.survey.service.model.Task;

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

    /**
    * @Description:
    * @Param: [rawObject, task, file]
    * @return: java.lang.String
    * @Author: lsy
    * @Date: 2019/4/18
    */
    String saveTasks(JSONObject rawObject, Task task, UploadFile file, Kv kv);

    /**
    * @Description:  根据用户查询
    * @Param: [userId]
    * @return: com.jfinal.plugin.activerecord.Page<net.ninemm.survey.service.model.Task>
    * @Author: lsy
    * @Date: 2019/4/19
    */
    Page<Record> findByUser(Integer pageNumber, Integer pageSize, String userId, String orderBy);
}
