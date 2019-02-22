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

import com.google.common.collect.ImmutableMap;
import com.jfinal.aop.Inject;
import com.jfinal.kit.Ret;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import io.jboot.web.controller.annotation.RequestMapping;
import io.jboot.web.cors.EnableCORS;
import net.ninemm.upms.service.api.GroupRoleRelService;
import net.ninemm.upms.service.api.GroupService;
import net.ninemm.upms.service.api.RoleService;
import net.ninemm.upms.service.model.Group;

import java.util.List;
import java.util.Map;

/**
 * 用户分组
 *
 * @author Eric.Huang
 * @date 2018-12-10 10:45
 **/

@RequestMapping(value = "/api/v1/admin/group")
@EnableCORS(allowOrigin = "http://localhost:8080", allowHeaders = "Content-Type,Jwt", allowMethods = "POST,OPTIONS,GET,PUT,DELETE", allowCredentials = "true")
public class GroupController extends BaseAppController {

    @Inject
    RoleService roleService;

    @Inject
    GroupService groupService;

    @Inject
    GroupRoleRelService groupRoleRelService;

    public void list() {
        Map<String, Object> params = getAllParaMap();
        Page<Group> page = groupService.paginate(getPageNumber(), getPageSize(), params);
        Map<String, Object> map = ImmutableMap.of("total", page.getTotalRow(), "records", page.getList());
        renderJson(map);
    }

    public void findCheckedRoleList() {
        String groupId = getPara(0);
        List<String> checkedRoleList = groupRoleRelService.findRoleList(groupId);
        List<Record> roleOptionsList = roleService.findListAsOptions(null);

        Ret ret = Ret.ok();
        ret.set("roleOptions", roleOptionsList);
        ret.set("checkedKeys", checkedRoleList);
        renderJson(ret);
    }

    public void findById() {
        String id = getPara(0);
        if (StrKit.isBlank(id)) {
            renderJson(Ret.fail());
            return;
        }

        Group group = groupService.findById(id);
        renderJson(Ret.ok().set("data", group));
    }

    public void saveOrUpdate() {
        Group group = getRawObject(Group.class);
        Object id = groupService.saveOrUpdate(group);
        if (id != null) {
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
        boolean isDeleted = groupService.deleteById(id);
        if (isDeleted) {
            renderJson(Ret.ok());
            return;
        }
        renderJson(Ret.fail());
    }

    public void updateGroupPermission() {

        Map<String,Object> params = getRawObject(Map.class);
        Object groupId = params.get("groupId");
        Object roleIds = params.get("roleIds");

        if (groupId == null || roleIds == null) {
            renderJson(Ret.fail());
            return;
        }

        boolean result = groupRoleRelService.update(groupId.toString(), roleIds.toString());
        if (!result) {
            renderJson(Ret.fail());
            return ;
        }
        renderJson(Ret.ok());
    }

    public void findListAsOptions() {
        List<Record> list = groupService.findListAsOptions(null);
        renderJson(list);
    }
}
