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

package net.ninemm.upms.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.jfinal.kit.PathKit;
import com.jfinal.kit.Ret;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.upload.UploadFile;
import io.jboot.utils.StrUtils;
import io.jboot.web.controller.annotation.RequestMapping;
import io.jboot.web.cors.EnableCORS;
import net.ninemm.base.plugin.excel.ExcelKit;
import net.ninemm.base.utils.AttachmentUtils;
import net.ninemm.upms.excel.listener.ExcelUserListener;
import net.ninemm.upms.excel.model.UserPropertyModel;
import net.ninemm.upms.service.api.GroupService;
import net.ninemm.upms.service.api.StationService;
import net.ninemm.upms.service.api.UserService;
import net.ninemm.upms.service.model.User;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * 管理员
 *
 * @author Eric.Huang
 * @date 2018-12-10 10:44
 **/
@RequestMapping(value = "/api/v1/admin/user")
@EnableCORS(allowOrigin = "http://localhost:8080", allowHeaders = "Content-Type,Jwt", allowCredentials = "true")
public class UserController extends BaseAppController {

    @Inject
    UserService userService;

    @Inject
    GroupService groupService;

    @Inject
    StationService stationService;

    public void list() {
        Map<String, Object> params = getAllParaMap();
        Page<User> page = userService.paginate(getPageNumber(), getPageSize(), params);
        Map<String, Object> map = ImmutableMap.of("total", page.getTotalRow(), "records", page.getList());
        renderJson(map);
    }

    public void findById() {
        String id = getPara(0);
        if (StrKit.isBlank(id)) {
            renderJson(Ret.fail());
            return;
        }

        User user = userService.findById(id);
        List<String> stationIds = Lists.newArrayList();
        List<String> groupIds = Lists.newArrayList();
        String stationId = user.getStationId();

        if (StrUtils.notBlank(stationId)) {
            stationIds = JSON.parseArray(user.getStationId(), String.class);
        }
        user.put("stationIds", stationIds);

        String groupId = user.getGroupId();
        if (StrUtils.notBlank(stationId)) {
            groupIds = JSON.parseArray(user.getGroupId(), String.class);
        }
        user.put("groupIds", groupIds);

        renderJson(user);
    }

    public void saveOrUpdate() {
        User user = getRawObject(User.class);
        boolean result = userService.saveOrUpdate(user);
        if (result) {
            renderJson(Ret.ok());
        } else {
            renderJson(Ret.fail());
        }
    }

    public void delete() {
        String id = getPara(0);
        if (StrKit.isBlank(id)) {
            renderJson(Ret.fail());
            return;
        }
        userService.deleteById(id);
        renderJson(Ret.ok());
    }

    public void batchDelete() {
        String userIds = getPara(0);
        List<String> list = Splitter.on(",").splitToList(userIds);
        for (String userId : list) {
            userService.deleteById(userId);
        }
        renderJson(Ret.ok());
    }

    public void findAllOptions() {
        List<Record> stationOptions = stationService.findListAsOptions(null);
        List<Record> groupOptions = groupService.findListAsOptions(null);
        renderJson(Ret.ok().set("stationOptions", stationOptions).set("groupOptions", groupOptions));
    }

    public void info() {

        String userId = getUserId();
        User user = userService.findById(userId);

        Ret ret = Ret.ok();
        ret.set("sysUser", user);
        ret.set("roles", "ROLE_ADMIN");
        ret.set("permissions", Lists.newArrayList());
        renderJson(ret);
    }

    public void batchImport() {

        UploadFile file = getFile();
        String path = AttachmentUtils.moveFile(file);
        String filePath = PathKit.getWebRootPath() + File.separator + path;
        File newFile = new File(filePath);

        UserPropertyModel userPropertyModel = new UserPropertyModel();
        ExcelUserListener<UserPropertyModel> userListener = new ExcelUserListener<UserPropertyModel>();
        ExcelKit.readExcel(newFile, userListener, userPropertyModel, 1);
        renderJson(Ret.ok());
    }
}
