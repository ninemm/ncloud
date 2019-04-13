package net.ninemm.survey.service.api;

import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import net.ninemm.survey.service.model.WxRedpackResult;
import io.jboot.db.model.Columns;

import java.util.List;

public interface WxRedpackResultService  {

    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public WxRedpackResult findById(Object id);


    /**
     * find all model
     *
     * @return all <WxRedpackResult
     */
    public List<WxRedpackResult> findAll();


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
    public boolean delete(WxRedpackResult model);


    /**
     * save model to database
     *
     * @param model
     * @return id value if save success
     */
    public Object save(WxRedpackResult model);


    /**
     * save or update model
     *
     * @param model
     * @return id value if save or update success
     */
    public Object saveOrUpdate(WxRedpackResult model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(WxRedpackResult model);


    /**
     * page query
     *
     * @param page
     * @param pageSize
     * @return page data
     */
    public Page<WxRedpackResult> paginate(int page, int pageSize);


    /**
     * page query by columns
     *
     * @param page
     * @param pageSize
     * @param columns
     * @return page data
     */
    public Page<WxRedpackResult> paginateByColumns(int page, int pageSize, Columns columns);


    /**
     * page query by columns
     *
     * @param page
     * @param pageSize
     * @param columns
     * @param orderBy
     * @return page data
     */
    public Page<WxRedpackResult> paginateByColumns(int page, int pageSize, Columns columns, String orderBy);

    /**
    * @Description:
    * @Param: [pageNumber, pageSize, departmentId]
    * @return: com.jfinal.plugin.activerecord.Page<com.jfinal.plugin.activerecord.Record>
    * @Author: lsy
    * @Date: 2019/4/4
    */
    Page<Record> paginate(Integer pageNumber, Integer pageSize, String departmentId);

    /**
    * @Description:
    * @Param: [pageNumber, pageSize, kv]
    * @return: com.jfinal.plugin.activerecord.Page<com.jfinal.plugin.activerecord.Record>
    * @Author: lsy
    * @Date: 2019/4/4
    */
    Page<Record> paginateBySurveyId(Integer pageNumber, Integer pageSize, Kv kv);
}