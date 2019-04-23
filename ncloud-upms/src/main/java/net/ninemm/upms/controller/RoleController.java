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
import io.jboot.utils.StrUtil;
import io.jboot.web.controller.annotation.RequestMapping;
import io.jboot.web.cors.EnableCORS;
import io.swagger.annotations.ApiOperation;
import net.ninemm.upms.service.api.*;
import net.ninemm.upms.service.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色管理
 *
 * @author Eric.Huang
 * @date 2018-12-10 10:45
 **/

@RequestMapping(value = "/api/v1/admin/role")
@EnableCORS(allowOrigin = "*", allowHeaders = "Content-Type,Jwt", allowMethods = "POST,OPTIONS,GET,PUT,DELETE", allowCredentials = "true")
public class RoleController extends BaseAppController {

    @Inject
    RoleService roleService;

    @Inject
    DepartmentService departmentService;

    @Inject
    RoleOperationRelService roleOperationRelService;

    @Inject
    UserService userService;

    @Inject
    OperationService operationService;


    public void list() {
        String userId = getUserId();
        Department department = departmentService.findByUserId(userId);
        Map<String, Object> params = getAllParaMap();
        params.put("dataArea",department.getDataArea());
        Page<Role> page = roleService.paginate(getPageNumber(), getPageSize(), params);
        String[] attrs = {"dept_name"};
        departmentService.join(page, "dept_id", attrs);
        Map<String, Object> mapPage = ImmutableMap.of("total", page.getTotalRow(), "records", page.getList());
        Map<String, Object> map = new HashMap<>();
        map.put("state","ok");
        map.put("result",mapPage);
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

    public void getPermission(){
        String moduleId = getPara("mid");
        String roleId = getPara("roleId");
        List<Record> list =optionService.findByModuleId(moduleId,roleId);
        for (Record record :list){
            if (StrKit.notBlank(record.getStr("hava"))){
                record.set("show",true);
            }else{
                record.set("show",false);
            }
        }
        Map<String, Object> map = new HashMap<>();
        map.put("state","ok");
        map.put("result",list);
        renderJson(map);
    }

    public void save() {
        Role role = getRawObject(Role.class);
        if (StrKit.notBlank(role.getId())){
            roleService.update(role);
            renderJson(Ret.ok());
            return;
        }
        String userId = getUserId();
        User user = userService.findById(userId);
        role.setDeptId(user.getDepartmentId());
        role.setDataArea(user.getDataArea());
        Object id = roleService.save(role);
        if (id != null) {
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

    public void updateRolePermission(){
        String roleId = getPara("roleId");
        String show = getPara("show");
        String operationId = getPara("operationId");
        Operation operation = operationService.findById(operationId);
        if (show.equals("true")){
            RoleOperationRel roleOperationRel = new RoleOperationRel();
            roleOperationRel.setId(StrUtil.uuid());
            roleOperationRel.setOperationId(operationId);
            roleOperationRel.setRoleId(roleId);
            roleOperationRel.setModuleId(operation.getModuleId());
            roleOperationRelService.save(roleOperationRel);
        }else{
            roleOperationRelService.deleteByRoleIdAndOpId(roleId,operationId);
        }
        renderJson(Ret.ok());
    }

    public void saveOrUpdate() {
        Role role = getRawObject(Role.class);
        Object id = roleService.saveOrUpdate(role);
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
        roleService.deleteById(id);
        renderJson(Ret.ok());
    }

    /**
     * @Description:  批量物理删除
     * @Param: []
     * @return: void
     * @Author: lsy
     * @Date: 2019/3/18
     */
    public void batchDelete(){
        String ids = getPara("ids");
        roleService.deleteByIds(ids);
        renderJson(Ret.ok());
    }

    @ApiOperation(value = "角色已分配的功能权限", httpMethod = "GET,POST", notes = "用户登录时，如果用户有多个账套，则会跳转到账套选择页面，选择账套完成之后，跳转到主页面")
    public void findAllocatedPermission() {
        String roleId = getPara(0);
        List<String> list = roleOperationRelService.findListByRoleId(roleId);
        renderJson(list.toArray());
    }

    @ApiOperation(value = "更新角色的功能权限", httpMethod = "PUT", notes = "用户登录时，如果用户有多个账套，则会跳转到账套选择页面，选择账套完成之后，跳转到主页面")
    public void updatePermission() {
        Map<String, String> paramMap = getRawObject(Map.class);
        String roleId = paramMap.get("roleId");
        String moduleId = paramMap.get("moduleId");
        String operationIds = paramMap.get("operationIds");

        roleService.updatePermission(roleId, moduleId, operationIds);
        renderJson(Ret.ok());
    }
}
