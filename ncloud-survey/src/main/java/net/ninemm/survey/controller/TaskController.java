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
import com.jfinal.kit.Ret;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Page;

import io.jboot.Jboot;
import io.jboot.db.model.Columns;
import io.jboot.utils.StrUtil;
import io.jboot.web.controller.annotation.RequestMapping;
import io.jboot.web.cors.EnableCORS;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.ninemm.base.interceptor.NotNullPara;
import net.ninemm.base.message.MessageAction;
import net.ninemm.survey.service.api.TaskService;
import net.ninemm.survey.service.model.Project;
import net.ninemm.survey.service.model.Task;
import net.ninemm.upms.service.api.UserService;
import net.ninemm.upms.service.model.User;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RequestMapping(value = "/task")
@Api(description = "任务管理", basePath = "/task", tags = "task", position = 3)
@EnableCORS(allowOrigin = "http://localhost:8080", allowHeaders = "Content-Type,Jwt", allowCredentials = "true")
public class TaskController extends BaseAppController {
	@Inject
	TaskService taskService;
	@Inject
	UserService userService;

	public void index() {
		String userId = getUserId();
		Columns colum = Columns.create("publisher_id", userId);
		Page<Task> page = taskService.paginateByColumns(getPageNumber(), getPageSize(), colum, " create_date desc ");
		Map<String, Object> map = ImmutableBiMap.of("total", page.getTotalRow(), "records", page.getList());
		renderJson(map); 
	}
	
	public void findByProject() {
		JSONObject rawObject = getRawObject();
		Columns colum = Columns.create("project_id", rawObject.get("projectId"));
		Page<Task> page = taskService.paginateByColumns(getPageNumber(), getPageSize(), colum, " create_date desc ");
		Map<String, Object> map = ImmutableBiMap.of("total", page.getTotalRow(), "records", page.getList());
		renderJson(map);
	}

	public void findById(String id) {
		JSONObject rawObject = getRawObject();
		Task task = taskService.findById(rawObject.get("id"));
		renderJson(task);
	}

	/**
	 * title 任务名 type 任务类型 1：模板方式 2：新问卷方式 3：修改模板 status 任务状态 1：待处理 2：设计中 3：设计完成
	 * 4：测试中 5：测试完成 6：审核中 7：发布中 8：发布结束 9：分析中 10：分析结束 projectId 项目Id publisherId
	 * 项目创建人 dataArea 数据域 startDate 开始时间 endDate 结束时间 
	 */
	public void findByColum() {
		JSONObject rawObject = getRawObject();

		Columns colum = Columns.create();
		colum.eq("status", rawObject.get("status"));
		colum.eq("type", rawObject.get("type"));
		colum.eq("project_id", rawObject.get("projectId"));
		colum.eq("publisher_id", rawObject.get("publisherId"));
		colum.like("title", rawObject.get("title"));
		colum.like("data_area", rawObject.get("dataArea"));
		colum.ge("create_date", rawObject.get("startDate"));
		colum.le("create_date", rawObject.get("endDate"));

		String orderBy = rawObject.get("orderBy") == null ? null : rawObject.get("orderBy").toString();
		if (StrUtil.isBlank(orderBy)) {
			orderBy = " create_date desc ";
		}

		Page<Task> page = taskService.paginateByColumns(getPageNumber(), getPageSize(), colum, orderBy);
		Map<String, Object> map = ImmutableBiMap.of("total", page.getTotalRow(), "records", page.getList());
		renderJson(map);
	}

	public void saveOrUpdate() {
		Task task = getRawObject(Task.class);

		if (!StrUtil.isNotEmpty(task.getId())) {
			String userId = getUserId();
			User user = userService.findById(userId);
			String name = user.getRealname();
			task.setDataArea(user.getDataArea());
			task.setDeptId(user.getDepartmentId());
			task.setPublisherId(userId);
			task.setPublisherName(name);
			task.setViewerId(userId);
			task.setViewerName(name);
			task.setReviewerId(userId);
			task.setReviewerName(name);
			task.setAccepterId(userId);
			task.setAccepterName(name);
			task.setModifyDate(new Date());
			task.setAcceptTime(new Date());
		} else {
			task.setModifyDate(new Date());
		}
		Object result = taskService.saveOrUpdate(task);
		if (result != null) {
			renderJson(Ret.ok());
		} else {
			renderJson(Ret.fail());
		}
	}

	public void delete() {
		JSONObject rawObject = getRawObject();
		if (taskService.deleteById(rawObject.get("id"))) {
			renderJson(Ret.ok());
		} else {
			renderJson(Ret.fail());
		}
	}

}
