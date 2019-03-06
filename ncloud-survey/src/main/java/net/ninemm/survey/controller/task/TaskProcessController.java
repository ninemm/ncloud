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
import net.ninemm.survey.service.api.TaskProcessService;
import net.ninemm.survey.service.model.TaskProcess;
import net.ninemm.upms.service.api.UserService;
import net.ninemm.upms.service.model.User;

import java.util.Date;
import java.util.Map;

@RequestMapping(value = "/taskProcess")
@Api(description = "任务管理", basePath = "/taskProcess", tags = "", position = 3)
@EnableCORS(allowOrigin = "http://localhost:8080", allowHeaders = "Content-Type,Jwt", allowCredentials = "true")
public class TaskProcessController extends BaseAppController {
	@Inject
	TaskProcessService taskProcessService;
	@Inject
	UserService userService;

	public void findByUserId() {
		String userId = getUserId();
		Columns columns = Columns.create("task_id", userId);
		Page<TaskProcess> page = taskProcessService.paginateByColumns(getPageNumber(), getPageSize(), columns,
				" create_date desc ");
		Map<String, Object> map = ImmutableBiMap.of("total", page.getTotalRow(), "records", page.getList());
		renderJson(map);
	}

	public void findById(String id) {
		TaskProcess taskProcess = taskProcessService.findById(getPara("id"));
		renderJson(taskProcess);
	}


	/**
	 * 
	 */
	public void findByColum() {
		JSONObject rawObject = getRawObject();

		Columns columns = Columns.create();
		columns.eq("task_id", rawObject.get("taskId"));
		columns.eq("accepter_id", rawObject.get("accepterId"));
		columns.eq("stage", rawObject.get("stage"));
		columns.like("accepter_name", rawObject.get("accepterName"));
		columns.like("data_area", rawObject.get("dataArea"));
		columns.ge("create_date", rawObject.get("startDate"));
		columns.le("create_date", rawObject.get("endDate"));

		String orderBy = rawObject.get("orderBy") == null ? null : rawObject.get("orderBy").toString();
		if (StrUtil.isBlank(orderBy)) {
			orderBy = " create_date desc ";
		}

		Page<TaskProcess> page = taskProcessService.paginateByColumns(getPageNumber(), getPageSize(), columns, orderBy);
		Map<String, Object> map = ImmutableBiMap.of("total", page.getTotalRow(), "records", page.getList());
		renderJson(map);
	}

	public void saveOrUpdate() {
		TaskProcess taskProcess = getRawObject(TaskProcess.class);

		if (!StrUtil.isNotEmpty(taskProcess.getId())) {
			String userId = getUserId();
			User user = userService.findById(userId);
			taskProcess.setDeptId(user.getDepartmentId());
			taskProcess.setDataArea(user.getDataArea());
			taskProcess.setModifyDate(new Date());
		} else {
			taskProcess.setModifyDate(new Date());
		}
		Object result = taskProcessService.saveOrUpdate(taskProcess);
		if (result != null) {
			renderJson(Ret.ok());
		} else {
			renderJson(Ret.fail());
		}
	}

	public void delete() {
		if (taskProcessService.deleteById(getPara("id"))) {
			renderJson(Ret.ok());
		} else {
			renderJson(Ret.fail());
		}
	}

	public void deleteByTaskId() {
		taskProcessService.deleteByTaskId(getPara("taskId"));
		renderJson(Ret.ok());
	}

}
