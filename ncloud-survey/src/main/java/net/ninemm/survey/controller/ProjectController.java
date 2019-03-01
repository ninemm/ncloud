/*
 * Copyright (c) 2015-2018, Eric Huang 黄鑫 (ninemm@126.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

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

    }

    @ApiOperation(value = "数据字典列表", httpMethod = "GET", notes = "getall")
    public void findAll() {
        List<Project> allProject = projectService.findAll();
        renderJson(allProject);
    }


    @NotNullPara("id")
    public void findById(String id) {
        Project project = projectService.findById(id);
        renderJson(project);
    }

    public void findByName() {
        String name = getPara("name");
        Columns colum = Columns.create("project_name", name);
        Page<Project> page = projectService.paginateByColumns(getPageNumber(), getPageSize(), colum);
        Map<String, Object> map = ImmutableBiMap.of("total", page.getTotalRow(), "records", page.getList());
        renderJson(map);
    }

    /**
     * 多字段查询
     */
    public void findByColum() {
        JSONObject rawObject = getRawObject();

        Columns colum = Columns.create("status",rawObject.get("status"))
                .create("project_category",rawObject.get("projectCategory"))
                .create("creater_id",rawObject.get("createrId"));
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
            Ret ret = Ret.create();
            ret.set("result",result);
            ret.set("userId",userId);
            ret.set("dataArea",user.getDataArea());
            ret.set("deptId",user.getDepartmentId());
            Jboot.sendEvent(MessageAction.PROJECT_MANAGE_ADD,ret);
            renderJson(Ret.ok());
        } else {
            renderJson(Ret.fail());
        }
    }

    public void delete() {
        String id = getPara("id");
        if (StrKit.isBlank(id)) {
            renderJson(Ret.fail());
            return;
        }
        projectService.deleteById(id);
        renderJson(Ret.ok());
    }
}
