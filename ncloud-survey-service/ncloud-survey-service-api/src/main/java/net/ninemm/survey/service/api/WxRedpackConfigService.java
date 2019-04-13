package net.ninemm.survey.service.api;

import com.jfinal.plugin.activerecord.Page;
import net.ninemm.survey.service.model.WxRedpackConfig;
import io.jboot.db.model.Columns;

import java.util.List;

public interface WxRedpackConfigService  {

    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public WxRedpackConfig findById(Object id);


    /**
     * find all model
     *
     * @return all <WxRedpackConfig
     */
    public List<WxRedpackConfig> findAll();


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
    public boolean delete(WxRedpackConfig model);


    /**
     * save model to database
     *
     * @param model
     * @return id value if save success
     */
    public Object save(WxRedpackConfig model);


    /**
     * save or update model
     *
     * @param model
     * @return id value if save or update success
     */
    public Object saveOrUpdate(WxRedpackConfig model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(WxRedpackConfig model);


    /**
     * page query
     *
     * @param page
     * @param pageSize
     * @return page data
     */
    public Page<WxRedpackConfig> paginate(int page, int pageSize);


    /**
     * page query by columns
     *
     * @param page
     * @param pageSize
     * @param columns
     * @return page data
     */
    public Page<WxRedpackConfig> paginateByColumns(int page, int pageSize, Columns columns);


    /**
     * page query by columns
     *
     * @param page
     * @param pageSize
     * @param columns
     * @param orderBy
     * @return page data
     */
    public Page<WxRedpackConfig> paginateByColumns(int page, int pageSize, Columns columns, String orderBy);

    /**
    * @Description: 根据问卷id查找红包配置
    * @Param: [surveyId]
    * @return: net.ninemm.survey.service.model.WxRedpackConfig
    * @Author: lsy
    * @Date: 2019/4/4
    */
    WxRedpackConfig findBySurveyId(String surveyId);
}