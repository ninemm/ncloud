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
import net.ninemm.upms.service.api.*;
import net.ninemm.upms.service.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户分组
 *
 * @author Eric.Huang
 * @date 2018-12-10 10:45
 **/

@RequestMapping(value = "/api/v1/admin/group")
@EnableCORS(allowOrigin = "*", allowHeaders = "Content-Type,Jwt", allowMethods = "POST,OPTIONS,GET,PUT,DELETE", allowCredentials = "true")
public class GroupController extends BaseAppController {

    @Inject
    RoleService roleService;

    @Inject
    GroupService groupService;

    @Inject
    GroupRoleRelService groupRoleRelService;

    @Inject
    DepartmentService departmentService;

    @Inject
    UserService userService;

    @Inject
    UserGroupRelService userGroupRelService;

    public void list() {
        String userId = getUserId();
        Department department = departmentService.findByUserId(userId);
        Map<String, Object> params = getAllParaMap();
        params.put("dataArea",department.getDataArea()+"%");
        Page<Group> page = groupService.paginate(getPageNumber(), getPageSize(), params);
        String[] attrs = {"dept_name"};
        departmentService.join(page, "dept_id", attrs);
        Map<String, Object> mapPage = ImmutableMap.of("total", page.getTotalRow(), "records", page.getList());
        Map<String, Object> map = new HashMap<>();
        map.put("state","ok");
        map.put("result",mapPage);
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

    public void  findUserAndRole(){
        String userId = getUserId();
        Department department = departmentService.findByUserId(userId);
        List<Record> userList = userService.findByDateArea(department.getDataArea()+"%");
        List<Record> roleList =  roleService.findByDateArea(department.getDataArea()+"%");
        List<Map<String, Object>> list = new ArrayList<>();
        if (roleList.size()>0){
            for (Record role:roleList) {
                Map<String, Object> map = new HashMap<>();
                map.put("roleId",role.getStr("id"));
                map.put("roleName",role.getStr("role_name"));
                list.add(map);
            }
        }
        if (userList.size()>0){
            for (Record user:userList) {
                Map<String, Object> map = new HashMap<>();
                map.put("userId",user.getStr("id"));
                map.put("userName",user.getStr("realname"));
                list.add(map);
            }
        }
        Map<String, Object> map = new HashMap<>();
        map.put("state","ok");
        map.put("result",list);
        renderJson(map);
    }

    public void findNotRole(){
        String id = getPara(0);
        String userId = getUserId();
        Department department = departmentService.findByUserId(userId);
        List<Record> notRole =groupRoleRelService.findNotRole(id,department.getDataArea()+"%");
        List<Record> roleList =groupRoleRelService.findRoleListByGroupId(id);
        Map<String,Object> mappage = new HashMap<>();
        mappage.put("notRole",notRole);
        mappage.put("roleList",roleList);
        Map<String, Object> map = new HashMap<>();
        map.put("state","ok");
        map.put("result",mappage);
        renderJson(map);
    }

    public void findNotUser(){
        String id = getPara(0);
        String userId = getUserId();
        Department department = departmentService.findByUserId(userId);
        List<Record> notUser =userGroupRelService.findNotUser(id,department.getDataArea()+"%");
        List<Record> userList =userGroupRelService.findUserListByGroupId(id);
        Map<String,Object> mappage = new HashMap<>();
        mappage.put("notUser",notUser);
        mappage.put("userList",userList);
        Map<String, Object> map = new HashMap<>();
        map.put("state","ok");
        map.put("result",mappage);
        renderJson(map);
    }

    public void findOwnUserAndRole(){
        String id = getPara(0);
        List<Record> roleList = groupRoleRelService.findRoleListByGroupId(id);
        List<Record> userList =userGroupRelService.findUserListByGroupId(id);
        Map<String,Object> mappage = new HashMap<>();
        mappage.put("roleList",roleList);
        mappage.put("userList",userList);
        Map<String, Object> map = new HashMap<>();
        map.put("state","ok");
        map.put("result",mappage);
        renderJson(map);
    }

    public void saveGroupRole(){
        String id = getPara("groupId");
        String[] ids = getParaValues("roleIds[]");
        groupRoleRelService.deleteByGroupId("'"+id+"'");
        if (ids==null){
            renderJson(Ret.ok());
            return;
        }
        GroupRoleRel groupRoleRel = new GroupRoleRel();
        groupRoleRel.setGroupId(id);
        for (int i = 0 ; i<ids.length ;i++){
            groupRoleRel.setId(StrUtil.uuid());
            groupRoleRel.setRoleId(ids[i]);
            groupRoleRelService.save(groupRoleRel);
        }
        renderJson(Ret.ok());
    }

    public void saveUserGroup(){
        String id = getPara("groupId");
        String[] ids = getParaValues("userIds[]");
        userGroupRelService.deleteByGroupId("'"+id+"'");
        if (ids==null){
            renderJson(Ret.ok());
            return;
        }
        UserGroupRel userGroupRel = new UserGroupRel();
        userGroupRel.setGroupId(id);
        for (int i = 0; i < ids.length; i++) {
            userGroupRel.setId(StrUtil.uuid());
            userGroupRel.setUserId(ids[i]);
            userGroupRelService.save(userGroupRel);
        }
        renderJson(Ret.ok());
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

    public void save(){
        Group group = getRawObject(Group.class);
        String userIds = getPara("userIds");
        String roleIds = getPara("roleIds");
        if (StrKit.isBlank(group.getId())){
            String uuid = StrUtil.uuid();
            String id = getUserId();
            User user = userService.findById(id);
            group.setId(uuid);
            group.setDeptId(user.getDepartmentId());
            group.setDataArea(getDeptDataAreaByCurUserDataArea(user.getDataArea()));
            groupService.save(group);
            if (StrKit.notBlank(userIds)){
                saveUserGroupRel(userIds, uuid);
            }
            if (StrKit.notBlank(roleIds)){
                saveGroupRoleRel(roleIds, uuid);
            }
            renderJson(Ret.ok());
            return;
        }
        if (StrKit.notBlank(userIds)){
            userGroupRelService.deleteByGroupId("'"+group.getId()+"'");
            saveUserGroupRel(userIds, group.getId());
        }
        if (StrKit.notBlank(roleIds)){
            groupRoleRelService.deleteByGroupId("'"+group.getId()+"'");
            saveGroupRoleRel(roleIds,group.getId());
        }
        groupService.update(group);
        renderJson(Ret.ok());
    }

    private void saveGroupRoleRel(String roleIds, String uuid) {
        GroupRoleRel groupRoleRel = new GroupRoleRel();
        groupRoleRel.setGroupId(uuid);
        String[] roleId = roleIds.split(",");
        for (int i = 0 ; i<roleId.length ;i++){
            groupRoleRel.setId(StrUtil.uuid());
            groupRoleRel.setRoleId(roleId[i]);
            groupRoleRelService.save(groupRoleRel);
        }
    }

    private void saveUserGroupRel(String userIds, String id2) {
        UserGroupRel userGroupRel = new UserGroupRel();
        userGroupRel.setGroupId(id2);
        String[] userId = userIds.split(",");
        for (int i = 0; i < userId.length; i++) {
            userGroupRel.setId(StrUtil.uuid());
            userGroupRel.setUserId(userId[i]);
            userGroupRelService.save(userGroupRel);
        }
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
            groupRoleRelService.deleteByGroupId("'"+id+"'");
            userGroupRelService.deleteByGroupId("'"+id+"'");
            renderJson(Ret.ok());
            return;
        }
        renderJson(Ret.fail());
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
        groupService.deleteByIds(ids);
        String[] arr = ids.split(",");
        for (int i = 0; i<arr.length ; i++){
            groupRoleRelService.deleteByGroupId(arr[i]);
            userGroupRelService.deleteByGroupId(arr[i]);
        }
        renderJson(Ret.ok());
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

    private  String getDeptDataAreaByCurUserDataArea(String dataArea) {

        if (StrKit.notBlank(dataArea))
            return dataArea.substring(0, dataArea.length() - 4);

        return null;
    }
}
