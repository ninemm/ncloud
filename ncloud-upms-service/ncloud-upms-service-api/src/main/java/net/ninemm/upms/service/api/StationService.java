package net.ninemm.upms.service.api;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import net.ninemm.upms.service.model.Role;
import net.ninemm.upms.service.model.Station;

import java.util.List;
import java.util.Map;

public interface StationService  {

    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public Station findById(Object id);


    /**
     * find all model
     *
     * @return all <Station
     */
    public List<Station> findAll();


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
    public boolean delete(Station model);


    /**
     * save model to database
     *
     * @param model
     * @return
     */
    public Object save(Station model);


    /**
     * save or update model
     *
     * @param model
     * @return if save or update success
     */
    public Object saveOrUpdate(Station model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(Station model);


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

    public Page<Station> paginate(int page, int pageSize, Map<String, Object> params);

    public List<Record> findOperationPermsByStationId(String stationId, String dataArea);

    public List<Record> findListAsOptions(String dataArea);

    /**
     * 更新岗位权限
     * @author Eric
     * @date  2018-12-27 14:36
     * @param stationId
     * @param moduleId
     * @param operationIds
     * @return java.util.List<net.ninemm.upms.service.model.Role>
     */
    public void updatePermission(String stationId, String moduleId, String operationIds);
}