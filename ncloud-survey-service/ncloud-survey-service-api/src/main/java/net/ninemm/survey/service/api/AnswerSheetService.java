package net.ninemm.survey.service.api;

import com.jfinal.plugin.activerecord.Page;
import net.ninemm.survey.service.model.AnswerSheet;
import io.jboot.db.model.Columns;

import java.util.List;

public interface AnswerSheetService  {

    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public AnswerSheet findById(Object id);


    /**
     * find all model
     *
     * @return all <AnswerSheet
     */
    public List<AnswerSheet> findAll();


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
    public boolean delete(AnswerSheet model);


    /**
     * save model to database
     *
     * @param model
     * @return id value if save success
     */
    public Object save(AnswerSheet model);


    /**
     * save or update model
     *
     * @param model
     * @return id value if save or update success
     */
    public Object saveOrUpdate(AnswerSheet model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(AnswerSheet model);


    /**
     * page query
     *
     * @param page
     * @param pageSize
     * @return page data
     */
    public Page<AnswerSheet> paginate(int page, int pageSize);


    /**
     * page query by columns
     *
     * @param page
     * @param pageSize
     * @param columns
     * @return page data
     */
    public Page<AnswerSheet> paginateByColumns(int page, int pageSize, Columns columns);


    /**
     * page query by columns
     *
     * @param page
     * @param pageSize
     * @param columns
     * @param orderBy
     * @return page data
     */
    public Page<AnswerSheet> paginateByColumns(int page, int pageSize, Columns columns, String orderBy);


}