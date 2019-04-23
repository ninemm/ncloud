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
import com.google.common.collect.Lists;
import com.jfinal.aop.Inject;
import com.jfinal.kit.Ret;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import io.jboot.utils.StrUtil;
import io.jboot.web.controller.annotation.RequestMapping;
import io.jboot.web.cors.EnableCORS;
import net.ninemm.base.utils.layer.TreeKit;
import net.ninemm.upms.service.api.*;
import net.ninemm.upms.service.model.*;
import net.ninemm.upms.vo.DeptTreeVO;

import java.util.HashMap;
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

    @Inject
    ModuleService moduleService;

    @Inject
    UserService userService;

    @Inject
    StationOperationRelService stationOperationRelService;

    @Inject
    StationService stationService;

    public void list() {
        String userId = getUserId();
        Department department = departmentService.findByUserId(userId);
        Map<String, Object> params = getAllParaMap();
        Page<Operation> page = operationService.paginate(getPageNumber(), getPageSize(), params);
        Map<String, Object> mapPage = ImmutableMap.of("total", page.getTotalRow(), "records", page.getList());
        Map<String, Object> map = new HashMap<>();
        map.put("state","ok");
        map.put("result",mapPage);
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

    public void moduleTrees(){
        Map<String, Object> map = new HashMap<>();
        List<Module> list = moduleService.findAll();
        List<DeptTreeVO> deptNodeList = Lists.newArrayList();
        for (Module module : list) {
            deptNodeList.add(initTreeVO(module));
        }
        List<DeptTreeVO> treeList = TreeKit.toTree("0", deptNodeList);
        map.put("result",treeList);
        map.put("state","ok");
        renderJson(map);
    }

    public void postTrees(){
        Map<String, Object> map = new HashMap<>();
        List<Station> list = stationService.findAll();
        List<DeptTreeVO> deptNodeList = Lists.newArrayList();
        for (Station station : list) {
            deptNodeList.add(initTreeSt(station));
        }
        List<DeptTreeVO> treeList = TreeKit.toTree("0", deptNodeList);
        map.put("result",treeList);
        map.put("state","ok");
        renderJson(map);
    }

    public void save() {
        Operation operation = getRawObject(Operation.class);
        String stationId = getPara("stationId");
        if (StrKit.isBlank(operation.getId())){
            String userId = getUserId();
            User user = userService.findById(userId);
            operation.setDeptId(user.getDepartmentId());
            operation.setDataArea(getDeptDataAreaByCurUserDataArea(user.getDataArea()));
            operation.setId(StrUtil.uuid());
            Object save = operationService.save(operation);
            if (save!=null && StrKit.notBlank(stationId)){
                StationOperationRel stationOperationRel = new StationOperationRel();
                stationOperationRel.setStationId(stationId);
                stationOperationRel.setOperationId(operation.getId());
                stationOperationRel.setId(StrUtil.uuid());
                stationOperationRelService.save(stationOperationRel);
            }
            renderJson(Ret.ok());
            return;
        }
        if (StrKit.notBlank(stationId)){
            StationOperationRel stationOperation = new StationOperationRel();
            Record stationOperationRel =stationOperationRelService.findByOperId(operation.getId());
            if (stationOperationRel != null && StrKit.notBlank(stationOperationRel.getStr("station_id"))){
                stationOperation.setStationId(stationId);
                stationOperation.setOperationId(operation.getId());
                stationOperation.setId(stationOperationRel.getStr("id"));
                if (StrKit.notBlank(stationOperationRel.getStr("module_id"))){
                    stationOperation.setModuleId(stationOperationRel.getStr("module_id"));
                }
                stationOperationRelService.update(stationOperation);
            }else{
                stationOperation.setStationId(stationId);
                stationOperation.setOperationId(operation.getId());
                stationOperation.setId(StrUtil.uuid());
                stationOperationRelService.save(stationOperation);
            }
        }
        operationService.update(operation);
        renderJson(Ret.ok());
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
        Record stationOperationRel =stationOperationRelService.findByOperId(id);
        if (stationOperationRel!=null){
            StationOperationRel stationOperation = new StationOperationRel();
            stationOperation.setId(stationOperationRel.getStr("id"));
            stationOperation.setOperationId(stationOperationRel.getStr("operation_id"));
            if (StrKit.notBlank(stationOperationRel.getStr("module_id"))){
                stationOperation.setModuleId(stationOperationRel.getStr("module_id"));
            }
            stationOperation.setStationId(null);
            stationOperationRelService.save(stationOperation);
        }
        if (StrKit.isBlank(id)) {
            renderJson(Ret.fail());
            return;
        }
        operationService.deleteById(id);
        renderJson(Ret.ok());
    }

    /**
     * @Description:  关闭与开启验证
     * @Param: String
     * @return: void
     * @Author: yz
     * @Date: 2019/4/18
     */
    public void employ(){
        String id = getPara(0);
        Operation operation = operationService.findById(id);
        if (operation.getIsPrivilege() == 1){
            operation.setIsPrivilege(0);
        }else{
            operation.setIsPrivilege(1);
        }
        operationService.update(operation);
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

    public void getPost(){
        String id = getPara(0);
        Record record = stationOperationRelService.findStationByOpId(id);
        Map<String, Object> map = new HashMap<>();
        map.put("result",record);
        map.put("state","ok");
        renderJson(map);
    }

    private DeptTreeVO initTreeVO(Module module) {
        DeptTreeVO deptTreeVO = new DeptTreeVO();
        deptTreeVO.setId(module.getId());
        deptTreeVO.setLabel(module.getModuleName());
        deptTreeVO.setParentId(module.getParentId());
        return deptTreeVO;
    }

    private DeptTreeVO initTreeSt(Station station) {
        DeptTreeVO deptTreeVO = new DeptTreeVO();
        deptTreeVO.setId(station.getId());
        deptTreeVO.setLabel(station.getStationName());
        deptTreeVO.setParentId(station.getParentId());
        return deptTreeVO;
    }

    private  String getDeptDataAreaByCurUserDataArea(String dataArea) {

        if (StrKit.notBlank(dataArea))
            return dataArea.substring(0, dataArea.length() - 4);

        return null;
    }
}
