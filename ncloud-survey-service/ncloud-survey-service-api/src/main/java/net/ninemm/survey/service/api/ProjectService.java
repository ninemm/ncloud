package net.ninemm.survey.service.api;

import com.jfinal.plugin.activerecord.Page;
import net.ninemm.survey.service.model.Project;
import io.jboot.db.model.Columns;

import java.util.List;

public interface ProjectService  {

    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public Project findById(Object id);


    /**
     * find all model
     *
     * @return all <Project
     */
    public List<Project> findAll();


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
    public boolean delete(Project model);


    /**
     * save model to database
     *
     * @param model
     * @return id value if save success
     */
    public Object save(Project model);


    /**
     * save or update model
     *
     * @param model
     * @return id value if save or update success
     */
    public Object saveOrUpdate(Project model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(Project model);


    /**
     * page query
     *
     * @param page
     * @param pageSize
     * @return page data
     */
    public Page<Project> paginate(int page, int pageSize);


    /**
     * page query by columns
     *
     * @param page
     * @param pageSize
     * @param columns
     * @return page data
     */
    public Page<Project> paginateByColumns(int page, int pageSize, Columns columns);


    /**
     * page query by columns
     *
     * @param page
     * @param pageSize
     * @param columns
     * @param orderBy
     * @return page data
     */
    public Page<Project> paginateByColumns(int page, int pageSize, Columns columns, String orderBy);


}