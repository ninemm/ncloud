package net.ninemm.upms.service.api;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import net.ninemm.upms.service.model.Group;
import net.ninemm.upms.service.model.Station;

import java.util.List;
import java.util.Map;

public interface GroupService  {

    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public Group findById(Object id);


    /**
     * find all model
     *
     * @return all <Group
     */
    public List<Group> findAll();

    /**
     * find groupId by groupName
     *
     * @return String
     */
    public String findGroupIdByGroupName(String groupName);
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
    public boolean delete(Group model);


    /**
     * save model to database
     *
     * @param model
     * @return
     */
    public Object save(Group model);


    /**
     * save or update model
     *
     * @param model
     * @return if save or update success
     */
    public Object saveOrUpdate(Group model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(Group model);


    /**
     * 分页
     *
     * @param page
     * @param pageSize
     * @return
     */
    public Page<? extends Model> paginate(int page, int pageSize);

/*    public void keep(Model model, String... attrs);

    public void keep(List<? extends Model> models, String... attrs);*/

    public List<Record> findListAsOptions(String dataArea);

    public Page<Group> paginate(int page, int pageSize, Map<String, Object> params);

    void deleteByIds(String ids);
}