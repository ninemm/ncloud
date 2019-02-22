package net.ninemm.upms.service.api;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import io.jboot.service.JbootServiceJoiner;
import net.ninemm.upms.service.model.Systems;

import java.util.List;
import java.util.Map;

public interface SystemsService extends JbootServiceJoiner {

    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public Systems findById(Object id);


    /**
     * find all model
     *
     * @return all <Systems
     */
    public List<Systems> findAll();


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
    public boolean delete(Systems model);


    /**
     * save model to database
     *
     * @param model
     * @return
     */
    public Object save(Systems model);


    /**
     * save or update model
     *
     * @param model
     * @return if save or update success
     */
    public Object saveOrUpdate(Systems model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(Systems model);


    /**
     * 分页
     *
     * @param page
     * @param pageSize
     * @return
     */
    public Page<Systems> paginate(int page, int pageSize);

    /*public void keep(Model model, String... attrs);

    public void keep(List<? extends Model> models, String... attrs);*/

    public List<Systems> findListAsSelect();

    public Page<Systems> paginate(int page, int pageSize, Map<String, Object> params);

}