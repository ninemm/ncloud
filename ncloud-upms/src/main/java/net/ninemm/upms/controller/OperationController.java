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
import io.jboot.utils.StrUtil;
import io.jboot.web.controller.annotation.RequestMapping;
import io.jboot.web.cors.EnableCORS;
import net.ninemm.upms.service.api.DepartmentService;
import net.ninemm.upms.service.api.MenuService;
import net.ninemm.upms.service.api.OperationService;
import net.ninemm.upms.service.model.Department;
import net.ninemm.upms.service.model.Operation;

import java.util.List;
import java.util.Map;

/**
 * 功能菜单管理
 *
 * @author Eric.Huang
 * @date 2018-12-10 10:47
 **/

@RequestMapping(value = "/api/v1/admin/operation")
@EnableCORS(allowOrigin = "*", allowHeaders = "Content-Type,Jwt", allowCredentials = "true")
public class OperationController extends BaseAppController {

    @Inject
    OperationService operationService;

    @Inject
    MenuService menuService;

    @Inject
    DepartmentService departmentService;

    public void list() {
        String userId = getUserId();
        Department department = departmentService.findByUserId(userId);
        Map<String, Object> params = getAllParaMap();
        params.put("deptId",department.getId());
        Page<Operation> page = operationService.paginate(getPageNumber(), getPageSize(), params);
        Map<String, Object> map = ImmutableMap.of("total", page.getTotalRow(), "records", page.getList());
        renderJson(map);
    }

    public void findById() {
        String id = getPara(0);
        if (StrKit.isBlank(id)) {
            renderJson(Ret.fail());
            return;
        }

        Operation operation = operationService.findById(id);
        renderJson(Ret.ok().set("data", operation));
    }

    public void save() {
        Operation operation = getRawObject(Operation.class);
        operation.setId(StrUtil.uuid());
        Object id = operationService.save(operation);
        if (id != null) {
            renderJson(Ret.ok());
        } else {
            renderJson(Ret.fail());
        }
    }

    public void update() {
        Operation operation = getRawObject(Operation.class);
        boolean saved = operationService.update(operation);
        if (saved) {
            renderJson(Ret.ok());
        } else {
            renderJson(Ret.fail());
        }
    }

    public void saveOrUpdate() {
        Operation operation = getRawObject(Operation.class);
        Object id = operationService.saveOrUpdate(operation);
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
        operationService.deleteById(id);
        renderJson(Ret.ok());
    }

    /**
     * @Description:  关闭验证
     * @Param: String
     * @return: void
     * @Author: yz
     * @Date: 2019/4/18
     */
    public void employ(){
        String id = getPara("id");
        operationService.updateIsPrivilegeById(id);
        renderJson(Ret.ok());
    }

    public void addMenu() {
        String id = getPara(0);
        Operation operation = operationService.findById(id);
        Object newId = menuService.save(operation);
        if (newId != null) {
            renderJson(Ret.fail());
            return ;
        }
        renderJson(Ret.ok());
    }

    public void enable(){
        String id = getPara(0);
        Operation operation = operationService.findById(id);
        if (operation.getIsPrivilege() ==1 ){
            operation.setIsPrivilege(0);
        }else{
            operation.setIsPrivilege(1);
        }
        operationService.update(operation);
        renderJson(Ret.ok());
    }

    public void findListByModuleId() {
        String moduleId = getPara(0);
        List<Operation> list = operationService.findListByModuleId(moduleId);
        renderJson(list);
    }
}
