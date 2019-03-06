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

package net.ninemm.survey.controller.task;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.ImmutableBiMap;
import com.jfinal.aop.Inject;
import com.jfinal.kit.Ret;
import com.jfinal.plugin.activerecord.Page;
import io.jboot.db.model.Columns;
import io.jboot.utils.StrUtil;
import io.jboot.web.controller.annotation.RequestMapping;
import io.jboot.web.cors.EnableCORS;
import io.swagger.annotations.Api;
import net.ninemm.survey.controller.BaseAppController;
import net.ninemm.survey.service.api.TaskService;
import net.ninemm.survey.service.model.Task;
import net.ninemm.upms.service.api.UserService;
import net.ninemm.upms.service.model.User;

import java.util.Date;
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
		Columns columns = Columns.create("publisher_id", userId);
		Page<Task> page = taskService.paginateByColumns(getPageNumber(), getPageSize(), columns, " create_date desc ");
		Map<String, Object> map = ImmutableBiMap.of("total", page.getTotalRow(), "records", page.getList());
		renderJson(map);
	}
	
	public void findByProject() {
		String projectId = getPara("projectId");
		Columns columns = Columns.create("project_id", projectId);
		Page<Task> page = taskService.paginateByColumns(getPageNumber(), getPageSize(), columns, " create_date desc ");
		Map<String, Object> map = ImmutableBiMap.of("total", page.getTotalRow(), "records", page.getList());
		renderJson(map);
	}

	public void findById(String id) {
		Task task = taskService.findById(getPara("id"));
		renderJson(task);
	}

	/**
	 * title 任务名 type 任务类型 1：模板方式 2：新问卷方式 3：修改模板 status 任务状态 1：待处理 2：设计中 3：设计完成
	 * 4：测试中 5：测试完成 6：审核中 7：发布中 8：发布结束 9：分析中 10：分析结束 projectId 项目Id publisherId
	 * 项目创建人 dataArea 数据域 startDate 开始时间 endDate 结束时间 
	 */
	public void findByColum() {
		JSONObject rawObject = getRawObject();

		Columns columns = Columns.create();
		columns.eq("status", rawObject.get("status"));
		columns.eq("type", rawObject.get("type"));
		columns.eq("project_id", rawObject.get("projectId"));
		columns.eq("publisher_id", rawObject.get("publisherId"));
		columns.like("title", rawObject.get("title"));
		columns.like("data_area", rawObject.get("dataArea"));
		columns.ge("create_date", rawObject.get("startDate"));
		columns.le("create_date", rawObject.get("endDate"));

		String orderBy = rawObject.get("orderBy") == null ? null : rawObject.get("orderBy").toString();
		if (StrUtil.isBlank(orderBy)) {
			orderBy = " create_date desc ";
		}

		Page<Task> page = taskService.paginateByColumns(getPageNumber(), getPageSize(), columns, orderBy);
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
		if (taskService.deleteById(getPara("id"))) {
			renderJson(Ret.ok());
		} else {
			renderJson(Ret.fail());
		}
	}

	public void deleteByProjectId() {
		String projectId = getPara("projectId");
		taskService.deleteByProjectId(projectId);
		renderJson(Ret.ok());
	}

}
