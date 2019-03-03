package net.ninemm.survey.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.ImmutableBiMap;
import com.jfinal.aop.Inject;
import com.jfinal.kit.Kv;
import com.jfinal.kit.Ret;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Page;
import io.jboot.Jboot;
import io.jboot.db.model.Columns;
import io.jboot.support.swagger.ParamType;
import io.jboot.utils.StrUtil;
import io.jboot.web.controller.annotation.RequestMapping;
import io.jboot.web.cors.EnableCORS;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.ninemm.base.interceptor.NotNullPara;
import net.ninemm.base.message.MessageAction;
import net.ninemm.survey.service.api.ProjectService;
import net.ninemm.survey.service.model.Project;
import net.ninemm.upms.service.api.UserService;
import net.ninemm.upms.service.model.User;


import java.util.List;
import java.util.Map;

@RequestMapping(value = "/project")
@Api(description = "项目管理", basePath = "/project", tags = "project", position = 2)
@EnableCORS(allowOrigin = "http://localhost:8080", allowHeaders = "Content-Type,Jwt", allowCredentials = "true")
public class ProjectController extends BaseAppController {
    @Inject
    ProjectService projectService;
    @Inject
    UserService userService;
    
    public void index() {
    	String userId = getUserId();
        Columns colum = Columns.create("creater_id", userId);
        Page<Project> page = projectService.paginateByColumns(getPageNumber(), getPageSize(), colum," create_date desc ");
        Map<String, Object> map = ImmutableBiMap.of("total", page.getTotalRow(), "records", page.getList());
        renderJson(map);
    }

    @ApiOperation(value = "数据字典列表", httpMethod = "GET", notes = "getall")
    public void findAll() {
        List<Project> allProject = projectService.findAll();
        renderJson(allProject);
    }

    public void findById() {
    	JSONObject rawObject = getRawObject();
        Project project = projectService.findById(rawObject.get("id"));
        renderJson(project);
    }


    /**
     * 多字段查询
     */
    public void findByColum() {
        JSONObject rawObject = getRawObject();

        Columns colum = Columns.create();
        colum.eq("status", rawObject.get("status"));
        colum.eq("project_category", rawObject.get("projectCategory"));
        colum.eq("creater_id", rawObject.get("createrId"));
        colum.like("project_name", "projectName");
        colum.like("data_area",rawObject.get("dataArea"));
        colum.ge("create_date",rawObject.get("startDate"));
        colum.le("create_date",rawObject.get("endDate"));

        String orderBy = rawObject.get("orderBy")==null?null:rawObject.get("orderBy").toString();
        if(StrUtil.isBlank(orderBy)){
            orderBy=" create_date desc ";
        }

        Page<Project> page = projectService.paginateByColumns(getPageNumber(), getPageSize(), colum,orderBy);
        Map<String, Object> map = ImmutableBiMap.of("total", page.getTotalRow(), "records", page.getList());
        renderJson(map);
    }

    public void saveOrUpdate() {
        Project project = getRawObject(Project.class);
        String userId = getUserId();

        User user = userService.findById(userId);
        if(!StrUtil.isNotEmpty(project.getId())){
            project.setDataArea(user.getDataArea());
            project.setCreaterId(userId);
            project.setRealname(user.getRealname());
            project.setDeptId(user.getDepartmentId());
        }
        Object result = projectService.saveOrUpdate(project);
        if (result != null) {
            Jboot.sendEvent(MessageAction.PROJECT_MANAGE_ADD,project);
            renderJson(Ret.ok());
        } else {
            renderJson(Ret.fail());
        }
    }

    public void delete() {
    	JSONObject rawObject = getRawObject();
    	Project project = projectService.findById(rawObject.get("id"));
    	if(project==null){
    		renderJson(Ret.fail());
    		return ;
    	}
        if(projectService.deleteById(rawObject.get("id"))){
        	Jboot.sendEvent(MessageAction.PROJECT_MANAGE_DEL,project);
        }
        renderJson(Ret.ok());
    }
}
