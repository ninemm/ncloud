package net.ninemm.survey.service.api;

import com.jfinal.plugin.activerecord.Page;
import io.jboot.service.JbootServiceJoiner;
import net.ninemm.survey.service.model.WxConfig;
import io.jboot.db.model.Columns;

import java.util.List;

public interface WxConfigService extends JbootServiceJoiner {

    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public WxConfig findById(Object id);


    /**
     * find all model
     *
     * @return all <WxConfig
     */
    public List<WxConfig> findAll();


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
    public boolean delete(WxConfig model);


    /**
     * save model to database
     *
     * @param model
     * @return id value if save success
     */
    public Object save(WxConfig model);


    /**
     * save or update model
     *
     * @param model
     * @return id value if save or update success
     */
    public Object saveOrUpdate(WxConfig model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(WxConfig model);


    /**
     * page query
     *
     * @param page
     * @param pageSize
     * @return page data
     */
    public Page<WxConfig> paginate(int page, int pageSize);


    /**
     * page query by columns
     *
     * @param page
     * @param pageSize
     * @param columns
     * @return page data
     */
    public Page<WxConfig> paginateByColumns(int page, int pageSize, Columns columns);


    /**
     * page query by columns
     *
     * @param page
     * @param pageSize
     * @param columns
     * @param orderBy
     * @return page data
     */
    public Page<WxConfig> paginateByColumns(int page, int pageSize, Columns columns, String orderBy);


    /**
    * @Description:  查找开启的微信配置
    * @Param: []
    * @return: java.util.List<net.ninemm.survey.service.model.WxConfig>
    * @Author: lsy
    * @Date: 2019/4/1
    */
    List<WxConfig> findOpenConfig();
    /**
    * @Description:  根据微信appid查找配置
    * @Param: [appIdKey]
    * @return: net.ninemm.survey.service.model.WxConfig
    * @Author: lsy
    * @Date: 2019/4/1
    */
    WxConfig findByAppId(String appIdKey);

    /**
    * @Description:  根据部门id查找
    * @Param: [deptId]
    * @return: net.ninemm.survey.service.model.WxConfig
    * @Author: lsy
    * @Date: 2019/4/4
    */
    List<WxConfig> findByDeptId(String deptId);

    /**
    * @Description:
    * @Param: [departmentId]
    * @return: java.lang.String
    * @Author: lsy
    * @Date: 2019/4/4
    */
    String findStringAppid(String departmentId);
}