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
import java.util.Date;
import java.util.Map;
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
import net.ninemm.survey.service.api.TaskProcessService;
import net.ninemm.survey.service.model.TaskProcess;
import net.ninemm.upms.service.api.UserService;
import net.ninemm.upms.service.model.User;

@RequestMapping(value = "/taskProcess")
@Api(description = "任务管理", basePath = "/taskProcess", tags = "", position = 3)
@EnableCORS(allowOrigin = "http://localhost:8080", allowHeaders = "Content-Type,Jwt", allowCredentials = "true")
public class TaskProcessController extends BaseAppController {
	@Inject
	TaskProcessService taskProcessService;
	@Inject
	UserService userService;

	public void index() {
		String userId = getUserId();
		Columns colum = Columns.create("task_id", userId);
		Page<TaskProcess> page = taskProcessService.paginateByColumns(getPageNumber(), getPageSize(), colum,
				" create_date desc ");
		Map<String, Object> map = ImmutableBiMap.of("total", page.getTotalRow(), "records", page.getList());
		renderJson(map);
	}

	public void findById(String id) {
		JSONObject rawObject = getRawObject();
		TaskProcess task = taskProcessService.findById(rawObject.get("id"));
		renderJson(task);
	}


	/**
	 * 
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

		Page<TaskProcess> page = taskProcessService.paginateByColumns(getPageNumber(), getPageSize(), colum, orderBy);
		Map<String, Object> map = ImmutableBiMap.of("total", page.getTotalRow(), "records", page.getList());
		renderJson(map);
	}

	public void saveOrUpdate() {
		TaskProcess task = getRawObject(TaskProcess.class);

		if (!StrUtil.isNotEmpty(task.getId())) {
			String userId = getUserId();
			User user = userService.findById(userId);
			String name = user.getRealname();

		} else {
			task.setModifyDate(new Date());
		}
		Object result = taskProcessService.saveOrUpdate(task);
		if (result != null) {
			renderJson(Ret.ok());
		} else {
			renderJson(Ret.fail());
		}
	}

	public void delete() {
		JSONObject rawObject = getRawObject();
		if (taskProcessService.deleteById(rawObject.get("id"))) {
			renderJson(Ret.ok());
		} else {
			renderJson(Ret.fail());
		}
	}

}
