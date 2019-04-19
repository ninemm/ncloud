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
import com.jfinal.kit.PathKit;
import com.jfinal.kit.Ret;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.upload.UploadFile;
import io.jboot.db.model.Columns;
import io.jboot.utils.StrUtil;
import io.jboot.web.controller.annotation.RequestMapping;
import io.jboot.web.cors.EnableCORS;
import io.swagger.annotations.Api;
import net.ninemm.base.utils.AttachmentUtils;
import net.ninemm.survey.controller.BaseAppController;
import net.ninemm.survey.service.api.TaskAttachmentService;
import net.ninemm.survey.service.api.TaskService;
import net.ninemm.survey.service.model.Task;
import net.ninemm.survey.service.model.TaskAttachment;
import net.ninemm.upms.service.api.UserService;
import net.ninemm.upms.service.model.User;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

@RequestMapping(value = "/taskAttachmentProcess")
@Api(description = "任务附件", basePath = "/taskAttachmentProcess", tags = "", position = 3)
@EnableCORS
public class TaskAttachmentController extends BaseAppController {
	@Inject
	TaskAttachmentService taskAttachmentService;
	@Inject
	TaskService taskService;
	@Inject
	UserService userService;

	public void findById(String id) {
		TaskAttachment taskAttachment = taskAttachmentService.findById(getPara("id"));
		renderJson(Ret.ok("result",taskAttachment));
	}

	/**
	 * 
	 */
	public void findByColum() {
		JSONObject rawObject = getRawObject();

		Columns columns = Columns.create();
		columns.eq("task_id", rawObject.get("taskId"));
		columns.like("attachment_name", rawObject.get("attachmentName"));
		columns.like("data_area", rawObject.get("dataArea"));
		columns.ge("create_date", rawObject.get("startDate"));
		columns.le("create_date", rawObject.get("endDate"));

		String orderBy = rawObject.get("orderBy") == null ? null : rawObject.get("orderBy").toString();
		if (StrUtil.isBlank(orderBy)) {
			orderBy = " create_date desc ";
		}

		Page<TaskAttachment> page = taskAttachmentService.paginateByColumns(getPageNumber(), getPageSize(), columns, orderBy);
		Map<String, Object> map = ImmutableBiMap.of("total", page.getTotalRow(), "records", page.getList());
		renderJson(Ret.ok("result",map));
	}

	public void saveOrUpdate() {
		TaskAttachment taskAttachment = getRawObject(TaskAttachment.class);

		if (!StrUtil.isNotEmpty(taskAttachment.getId())) {
			String userId = getUserId();
			User user = userService.findById(userId);
			taskAttachment.setDeptId(user.getDepartmentId());
			taskAttachment.setDataArea(user.getDataArea());
			taskAttachment.setModifyDate(new Date());
		} else {
			taskAttachment.setModifyDate(new Date());
		}
		Object result = taskAttachmentService.saveOrUpdate(taskAttachment);
		if (result != null) {
			renderJson(Ret.ok());
		} else {
			renderJson(Ret.fail());
		}
	}

	public void delete() {
		if (taskAttachmentService.deleteById(getPara("id"))) {
			renderJson(Ret.ok());
		} else {
			renderJson(Ret.fail());
		}
	}

	public void deleteByTaskId() {
		taskAttachmentService.deleteByTaskId(getPara("taskId"));
		renderJson(Ret.ok());
	}
	/*id
			task_id
	attachment_name
			attachment_path
	dept_id
			data_area
	create_date
			modify_date*/

	public void saveAttachs(){
		Task task = taskService.findById(getPara("taskId"));
		TaskAttachment ta = new TaskAttachment();
		ta.setId(StrUtil.uuid());
		ta.setTaskId(task.getId());
		ta.setDataArea(task.getDataArea());
		ta.setDeptId(task.getDeptId());

		UploadFile file = getFile("file");
		String path = AttachmentUtils.moveFile(file);
		String filePath = PathKit.getWebRootPath() + File.separator + path;
		File newFile = new File(filePath);

		ta.setAttachmentName(file.getFileName());
		ta.setAttachmentPath(filePath);
		try {
			newFile.createNewFile();
			ta.save();
		} catch (IOException e) {
			e.printStackTrace();
			renderJson(Ret.fail("result","附件上传失败!"));
		}
		renderJson(Ret.ok("result",filePath));
	}

}
