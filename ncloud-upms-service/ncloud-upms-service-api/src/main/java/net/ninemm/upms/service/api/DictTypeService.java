package net.ninemm.upms.service.api;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import io.jboot.service.JbootServiceJoiner;
import net.ninemm.upms.service.model.DictType;

import java.util.List;
import java.util.Map;

public interface DictTypeService extends JbootServiceJoiner {

    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public DictType findById(Object id);


    /**
     * find all model
     *
     * @return all <DictType
     */
    public List<DictType> findAll();


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
    public boolean delete(DictType model);


    /**
     * save model to database
     *
     * @param model
     * @return
     */
    public Object save(DictType model);


    /**
     * save or update model
     *
     * @param model
     * @return if save or update success
     */
    public Object saveOrUpdate(DictType model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(DictType model);


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

    /**
     * 分页
     * @date  2019-01-31 13:30
     * @param page
     * @param pageSize
     * @param params
     * @return com.jfinal.plugin.activerecord.Page
     */
    public Page<DictType> paginate(int page, int pageSize, Map<String, Object> params);
}