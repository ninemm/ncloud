package net.ninemm.upms.service.api;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import net.ninemm.upms.service.model.StationOperationRel;

import java.util.List;

public interface StationOperationRelService  {

    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public StationOperationRel findById(Object id);


    /**
     * find all model
     *
     * @return all <StationOperationRel
     */
    public List<StationOperationRel> findAll();


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
    public boolean delete(StationOperationRel model);


    /**
     * save model to database
     *
     * @param model
     * @return
     */
    public Object save(StationOperationRel model);


    /**
     * save or update model
     *
     * @param model
     * @return if save or update success
     */
    public Object saveOrUpdate(StationOperationRel model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(StationOperationRel model);


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

    public List<String> findListByStationId(String stationId);

    public void deleteByModuleId(String stationId, String moduleId);

    Record findByOperIdAndStationId(String stationId, String id);

    void deleteByOperationId(String id);

    Record findStationByOpId(String id);

    Record findByOperId(String id);
}