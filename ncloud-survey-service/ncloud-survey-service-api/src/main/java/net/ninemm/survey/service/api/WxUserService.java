package net.ninemm.survey.service.api;

import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import net.ninemm.survey.service.model.WxUser;
import io.jboot.db.model.Columns;

import java.util.List;

public interface WxUserService  {

    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public WxUser findById(Object id);


    /**
     * find all model
     *
     * @return all <WxUser
     */
    public List<WxUser> findAll();


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
    public boolean delete(WxUser model);


    /**
     * save model to database
     *
     * @param model
     * @return id value if save success
     */
    public Object save(WxUser model);


    /**
     * save or update model
     *
     * @param model
     * @return id value if save or update success
     */
    public Object saveOrUpdate(WxUser model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(WxUser model);


    /**
     * page query
     *
     * @param page
     * @param pageSize
     * @return page data
     */
    public Page<WxUser> paginate(int page, int pageSize);


    /**
     * page query by columns
     *
     * @param page
     * @param pageSize
     * @param columns
     * @return page data
     */
    public Page<WxUser> paginateByColumns(int page, int pageSize, Columns columns);


    /**
     * page query by columns
     *
     * @param page
     * @param pageSize
     * @param columns
     * @param orderBy
     * @return page data
     */
    public Page<WxUser> paginateByColumns(int page, int pageSize, Columns columns, String orderBy);

    /**
    * @Description:
    * @Param: [openid]
    * @return:
    * @Author: lsy
    * @Date: 2019/4/1
    */
    WxUser findByOpenid(String openid);
    /**
    * @Description: 用户取消关注
     * @Param: [openid, subscribe]
    * @return: void
    * @Author: lsy
    * @Date: 2019/4/3
    */
    void updateUserStatus(String openid, int subscribe);

    /**
    * @Description:
    * @Param: [pageNumber, pageSize, departmentId]
    * @return: com.jfinal.plugin.activerecord.Page<Record>
    * @Author: lsy
    * @Date: 2019/4/4
    */
    Page<Record> paginate(Integer pageNumber, Integer pageSize, String departmentId);
}