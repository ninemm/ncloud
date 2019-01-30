package net.ninemm.upms.service.api;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import net.ninemm.upms.service.model.Option;

import java.util.List;

public interface OptionService  {

    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public Option findById(Object id);


    /**
     * find all model
     *
     * @return all <Option
     */
    public List<Option> findAll();


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
    public boolean delete(Option model);


    /**
     * save model to database
     *
     * @param model
     * @return
     */
    public boolean save(Option model);


    /**
     * save or update model
     *
     * @param model
     * @return if save or update success
     */
    public boolean saveOrUpdate(Option model);

    /**
     * save or update model
     *
     * @param key
     * @param value
     * @return if save or update success
     */
    public boolean saveOrUpdate(String key, String value);

    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(Option model);


    /**
     * 分页
     *
     * @param page
     * @param pageSize
     * @return
     */
    public Page<? extends Model> paginate(int page, int pageSize);


    public void join(Page<? extends Model> page, String joinOnField);

    public void join(Page<? extends Model> page, String joinOnField, String[] attrs);

    public void join(Page<? extends Model> page, String joinOnField, String joinName);

    public void join(Page<? extends Model> page, String joinOnField, String joinName, String[] attrs);

    public void join(List<? extends Model> models, String joinOnField);

    public void join(List<? extends Model> models, String joinOnField, String[] attrs);

    public void join(List<? extends Model> models, String joinOnField, String joinName);

    public void join(List<? extends Model> models, String joinOnField, String joinName, String[] attrs);

    public void join(Model model, String joinOnField);

    public void join(Model model, String joinOnField, String[] attrs);

    public void join(Model model, String joinOnField, String joinName);

    public void join(Model model, String joinOnField, String joinName, String[] attrs);

    public void keep(Model model, String... attrs);

    public void keep(List<? extends Model> models, String... attrs);

    /**
     * 获取系统配置信息
     *
     * @date  2019-01-27 22:47
     * @return list
     */
    public List<Option> findAllSystemSettingList();

}