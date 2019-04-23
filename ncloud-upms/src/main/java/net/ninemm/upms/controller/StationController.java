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
import io.swagger.annotations.ApiOperation;
import net.ninemm.base.utils.layer.TreeKit;
import net.ninemm.upms.service.api.DepartmentService;
import net.ninemm.upms.service.api.StationOperationRelService;
import net.ninemm.upms.service.api.StationService;
import net.ninemm.upms.service.api.UserService;
import net.ninemm.upms.service.model.Department;
import net.ninemm.upms.service.model.Station;
import net.ninemm.upms.service.model.User;
import net.ninemm.upms.vo.DeptTreeVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 岗位管理
 *
 * @author Eric.Huang
 * @date 2018-12-10 10:46
 **/

@RequestMapping(value = "/api/v1/admin/station")
@EnableCORS(allowOrigin = "*", allowHeaders = "Content-Type,Jwt", allowCredentials = "true")
public class StationController extends BaseAppController {

    @Inject
    StationService stationService;

    @Inject
    StationOperationRelService stationOperationRelService;

    @Inject
    DepartmentService departmentService;

    @Inject
    UserService userService;

    public void list() {
        String userId = getUserId();
        Department department = departmentService.findByUserId(userId);
        Map<String, Object> params = getAllParaMap();
        params.put("dataArea",department.getDataArea()+"%");
        Page<Station> page = stationService.paginate(getPageNumber(), getPageSize(), params);
        String[] attrs = {"dept_name","id"};
        departmentService.join(page, "dept_id", attrs);
        Map<String, Object> mapPage = ImmutableMap.of("total", page.getTotalRow(), "records", page.getList());
        Map<String, Object> map = new HashMap<>();
        map.put("state","ok");
        map.put("result",mapPage);
        renderJson(map);
    }

    public void trees(){
        String userId = getUserId();
        Department department = departmentService.findByUserId(userId);
        Map<String, Object> mapPage = new HashMap<>();
        List<Record> list = stationService.findByDataArea(department.getDataArea()+"%");
        List<DeptTreeVO> deptNodeList = Lists.newArrayList();
        List<DeptTreeVO> treeList = Lists.newArrayList();
        DeptTreeVO dept = getTree();
        if (list.size()>0){
            for (Record station : list) {
                deptNodeList.add(initTreeVO(station));
            }
            dept.setChildren(TreeKit.toTree("0",deptNodeList));
        }
        treeList.add(dept);
        mapPage.put("result",treeList);
        mapPage.put("state","ok");
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

        Station station = stationService.findById(id);
        renderJson(Ret.ok().set("data", station));
    }

    public void save() {
        Station station = getRawObject(Station.class);
        if (StrKit.isBlank(station.getId())){
            String userId = getUserId();
            User user = userService.findById(userId);
            station.setDeptId(user.getDepartmentId());
            station.setDataArea(getDeptDataAreaByCurUserDataArea(user.getDataArea()));
            station.setId(StrUtil.uuid());
            stationService.save(station);
            renderJson(Ret.ok());
            return ;
        }
        if (station.getId().equals(station.getParentId())){
            Map<String,Object> map = new HashMap<>();
            map.put("state","no");
            map.put("result","上级岗位不能选择当前岗位");
            renderJson(map);
            return;
        }
        stationService.update(station);
        renderJson(Ret.ok());
    }

    public void update() {}

    public void saveOrUpdate() {
        Station station = getRawObject(Station.class);
        Object id = stationService.saveOrUpdate(station);
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
        stationService.deleteById(id);
        renderJson(Ret.ok());
    }

    public void findListAsOptions() {
        List<Record> list = stationService.findListAsOptions(null);
        renderJson(list);
    }

    @ApiOperation(value = "岗位已分配权限", httpMethod = "GET,POST", notes = "查询该岗位已分配权限")
    public void findAllocatedPermission() {
        String stationId = getPara(0);
        List<String> list = stationOperationRelService.findListByStationId(stationId);
        renderJson(list.toArray());
    }

    @ApiOperation(value = "更新岗位的权限", httpMethod = "PUT", notes = "给岗位分配权限")
    public void updatePermission() {
        Map<String, String> paramMap = getRawObject(Map.class);
        String moduleId = paramMap.get("moduleId");
        String stationId = paramMap.get("stationId");
        String operationIds = paramMap.get("operationIds");

        stationService.updatePermission(stationId, moduleId, operationIds);
        renderJson(Ret.ok());
    }

    private DeptTreeVO initTreeVO(Record station) {
        DeptTreeVO deptTreeVO = new DeptTreeVO();
        deptTreeVO.setId(station.getStr("id"));
        deptTreeVO.setLabel(station.getStr("station_name"));
        deptTreeVO.setParentId(station.getStr("parent_id"));
        return deptTreeVO;
    }

    private DeptTreeVO getTree(){
        DeptTreeVO deptTreeVO = new DeptTreeVO();
        deptTreeVO.setId("0");
        deptTreeVO.setLabel("岗位根节点");
        return  deptTreeVO ;
    }

    private  String getDeptDataAreaByCurUserDataArea(String dataArea) {

        if (StrKit.notBlank(dataArea))
            return dataArea.substring(0, dataArea.length() - 4);

        return null;
    }
}
