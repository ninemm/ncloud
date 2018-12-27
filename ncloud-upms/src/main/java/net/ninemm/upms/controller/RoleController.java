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
import com.google.inject.Inject;
import com.jfinal.kit.Ret;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import io.jboot.web.controller.annotation.RequestMapping;
import io.jboot.web.cors.EnableCORS;
import net.ninemm.upms.service.api.DepartmentService;
import net.ninemm.upms.service.api.RoleService;
import net.ninemm.upms.service.model.Role;

import java.util.List;
import java.util.Map;

/**
 * 角色管理
 *
 * @author Eric.Huang
 * @date 2018-12-10 10:45
 **/

@RequestMapping(value = "/api/v1/admin/role")
@EnableCORS(allowOrigin = "http://localhost:8080", allowHeaders = "Content-Type,Jwt", allowMethods = "POST,OPTIONS,GET,PUT,DELETE", allowCredentials = "true")
public class RoleController extends BaseAppController {

    @Inject
    RoleService roleService;

    @Inject
    DepartmentService departmentService;

    public void list() {
        Map<String, Object> params = getAllParaMap();
        Page<Role> page = roleService.paginate(getPageNumber(), getPageSize(), params);
        String[] attrs = {"dept_name"};
        departmentService.join(page, "dept_id", attrs);
        Map<String, Object> map = ImmutableMap.of("total", page.getTotalRow(), "records", page.getList());
        renderJson(map);
    }

    public void findListAsSelect() {
        List<Record> list = roleService.findListAsOptions(null);
        renderJson(list);
    }

    public void findById() {
        String id = getPara(0);
        if (StrKit.isBlank(id)) {
            renderJson(Ret.fail());
            return;
        }
        Role role = roleService.findById(id);
        departmentService.join(role, "dept_id", "department");
        renderJson(Ret.ok().set("data", role));
    }

    public void save() {
        Role role = getRawObject(Role.class);
        boolean saved = roleService.save(role);
        if (saved) {
            renderJson(Ret.ok());
        } else {
            renderJson(Ret.fail());
        }
    }

    public void update() {
        Role role = getRawObject(Role.class);
        boolean saved = roleService.update(role);
        if (saved) {
            renderJson(Ret.ok());
        } else {
            renderJson(Ret.fail());
        }
    }

    public void saveOrUpdate() {
        Role role = getRawObject(Role.class);
        boolean result = roleService.saveOrUpdate(role);
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
        roleService.deleteById(id);
        renderJson(Ret.ok());
    }
}
