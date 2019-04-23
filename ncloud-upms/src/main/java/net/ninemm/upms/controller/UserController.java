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

import cn.hutool.poi.excel.ExcelUtil;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.fastjson.JSON;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.jfinal.aop.Clear;
import com.jfinal.aop.Inject;
import com.jfinal.kit.PathKit;
import com.jfinal.kit.Ret;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.upload.UploadFile;
import io.jboot.utils.StrUtil;
import io.jboot.web.controller.annotation.RequestMapping;
import io.jboot.web.cors.EnableCORS;
import net.ninemm.base.plugin.excel.ExcelException;
import net.ninemm.base.plugin.excel.ExcelKit;
import net.ninemm.base.plugin.excel.ExcelWriterFactory;
import net.ninemm.base.utils.AttachmentUtils;
import net.ninemm.upms.excel.listener.ExcelUserListener;
import net.ninemm.upms.excel.model.UserPropertyModel;
import net.ninemm.upms.service.api.*;
import net.ninemm.upms.service.model.*;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.util.*;

import static com.jfinal.kit.HashKit.sha256;

/**
 * 管理员
 *
 * @author Eric.Huang
 * @date 2018-12-10 10:44
 **/
@RequestMapping(value = "/api/v1/admin/user")
@EnableCORS(allowOrigin = "*", allowHeaders = "Content-Type,Jwt", allowCredentials = "true")
public class UserController extends BaseAppController {

    @Inject
    UserService userService;

    @Inject
    GroupService groupService;

    @Inject
    StationService stationService;

    @Inject
    DictService dictService;

    @Inject
    RoleService roleService;

    @Inject
    OperationService operationService;

    @Inject
    DepartmentService departmentService;

    @Inject
    UserGroupRelService userGroupRelService;

    public void list() {
        String userId = getUserId();
        Department department = departmentService.findByUserId(userId);
        Map<String, Object> params = getAllParaMap();
        params.put("dataArea",department.getDataArea()+"%");
        Page<User> page = userService.paginate(getPageNumber(), getPageSize(), params);
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

        User user = userService.findById(id);
        List<String> stationIds = Lists.newArrayList();
        List<String> groupIds = Lists.newArrayList();
        String stationId = user.getStationId();

        if (StrUtil.notBlank(stationId)) {
            stationIds = JSON.parseArray(user.getStationId(), String.class);
        }
        user.put("stationIds", stationIds);

        String groupId = user.getGroupId();
        if (StrUtil.notBlank(stationId)) {
            groupIds = JSON.parseArray(user.getGroupId(), String.class);
        }
        user.put("groupIds", groupIds);

        renderJson(user);
    }

    public void findGroup(){
        String userId = getUserId();
        Department department = departmentService.findByUserId(userId);
        List<Record> groupList =  groupService.findListByDataArea(department.getDataArea()+"%");
        List<Record> postList =stationService.findByDataArea(department.getDataArea()+"%");
        List<Map<String, Object>> list = new ArrayList<>();
        if (groupList.size()>0){
            for (Record group:groupList) {
                Map<String, Object> map = new HashMap<>();
                map.put("groupId",group.getStr("id"));
                map.put("groupName",group.getStr("group_name"));
                list.add(map);
            }
        }
        if (postList.size()>0){
            for (Record post:postList) {
                Map<String, Object> map = new HashMap<>();
                map.put("stationId",post.getStr("id"));
                map.put("stationName",post.getStr("station_name"));
                list.add(map);
            }
        }
        Map<String, Object> map = new HashMap<>();
        map.put("state","ok");
        map.put("result",list);
        renderJson(map);
    }

    public void resetPassword() {
        String ids = getPara("ids");
        String[] idArr = ids.split(",");
        int count = userService.batchReset(idArr);
        if (count > 0) {
            renderJson(Ret.ok());
        } else {
            renderJson(Ret.fail());
        }
    }

    public void changerUser(){
        String userAId = getPara("idA");
        String userBId = getPara("idB");
        if (StrKit.isBlank(userAId) || StrKit.isBlank(userBId) || userAId.equals(userBId)) {
            renderJson("用户信息错误或用户不能与自己对调");
            return;
        }
        User userA = userService.findById(userAId);
        User userA_copy = new User();
        userA_copy._setAttrs(userA);
        User userB = userService.findById(userBId);

        userA.setRealname(userB.getRealname());
        userA.setMobile(userB.getMobile());
        userA.setNickname(userB.getNickname());
        userA.setAvatar(userB.getAvatar());
        userA.setWechatOpenId(userB.getWechatOpenId());
        userA.setWechatUserid(userB.getWechatUserid());
        userA.update();

        userB.setRealname(userA_copy.getRealname());
        userB.setMobile(userA_copy.getMobile());
        userB.setNickname(userA_copy.getNickname());
        userB.setAvatar(userA_copy.getAvatar());
        userB.setWechatOpenId(userA_copy.getWechatOpenId());
        userB.setWechatUserid(userA_copy.getWechatUserid());
        userB.update();
        renderJson(Ret.ok());
    }

    public void getUserAll(){
        String userId = getUserId();
        Department department = departmentService.findByUserId(userId);
        List<Record> list = userService.findByDateArea(department.getDataArea()+"%");
        Map<String, Object> map = new HashMap<>();
        map.put("state","ok");
        map.put("result",list);
        renderJson(map);
    }

    public void findNotPost(){
        String id = getPara(0);
        Map<String, Object> map = new HashMap<>();
        User user = userService.findById(id);
        String userId = getUserId();
        Department department = departmentService.findByUserId(userId);
        List<Record> notList = null ;
        List<Record> list =null ;
        if (StrKit.notBlank(user.getStationId())){
            notList =  stationService.findNotListByDataArea(department.getDataArea()+"%",user.getStationId().substring(1,user.getStationId().length()-1));
            list =stationService.findByIds(user.getStationId().substring(1,user.getStationId().length()-1));
        }else{
            notList = stationService.findByDataArea(department.getDataArea()+"%");
        }
        Map<String,Object> mappage = new HashMap<>();
        mappage.put("notList",notList);
        mappage.put("list",list);
        map.put("state","ok");
        map.put("result",mappage);
        renderJson(map);
    }

    public void findNotGroup(){
        String id = getPara(0);
        String userId = getUserId();
        Department department = departmentService.findByUserId(userId);
        Map<String, Object> map = new HashMap<>();
        List<Record> notList = userGroupRelService.findNotGroup(id,department.getDataArea()+"%");
        List<Record> list = userGroupRelService.findGroupListByUserId(id);
        Map<String,Object> mappage = new HashMap<>();
        mappage.put("notList",notList);
        mappage.put("list",list);
        map.put("state","ok");
        map.put("result",mappage);
        renderJson(map);
    }

    public void saveUserPost(){
        String id = getPara("userId");
        String[] ids = getParaValues("postIds[]");
        User user = userService.findById(id);
        if (ids==null){
            user.setStationId(null);
            user.setStationName(null);
            userService.update(user);
            renderJson(Ret.ok());
            return;
        }
        String stationId = "[";
        String stationName = "";
        for (int i = 0 ; i<ids.length ;i++){
            stationId +='"';
            stationId+=ids[i];
            stationId +='"';
            stationId +=',';
            Station station = stationService.findById(ids[i]);
            stationName+=station.getStationName();
            stationName+=',';
        }
        stationId =stationId.substring(0,stationId.length()-1)+"]";
        stationName =stationName.substring(0,stationName.length()-1);
        user.setStationId(stationId);
        user.setStationName(stationName);
        userService.update(user);
        renderJson(Ret.ok());
    }

    public void saveUserGroup(){
        String id = getPara("userId");
        String[] ids = getParaValues("groupIds[]");
        userGroupRelService.deleteByUserId(id);
        User user = userService.findById(id);
        if (ids==null){
            user.setGroupId(null);
            user.setGroupName(null);
            userService.update(user);
            renderJson(Ret.ok());
            return;
        }
        UserGroupRel userGroupRel = new UserGroupRel();
        userGroupRel.setUserId(id);
        for (int i = 0 ; i<ids.length ;i++){
            userGroupRel.setId(StrUtil.uuid());
            userGroupRel.setGroupId(ids[i]);
            userGroupRelService.save(userGroupRel);
        }
        String groupId = "[";
        String groupName = "";
        for (int i = 0 ; i<ids.length ;i++){
            groupId +='"';
            groupId+=ids[i];
            groupId +='"';
            groupId +=',';
            Group group = groupService.findById(ids[i]);
            groupName+=group.getGroupName();
            groupName+=',';
        }
        groupId =groupId.substring(0,groupId.length()-1)+"]";
        groupName =groupName.substring(0,groupName.length()-1);
        user.setGroupId(groupId);
        user.setGroupName(groupName);
        userService.update(user);
        renderJson(Ret.ok());
    }

    public void export(){
        String userId = getUserId();
        Department department = departmentService.findByUserId(userId);
        Map<String, Object> params = getAllParaMap();
        params.put("departmentId",department.getId());
        Page<User> page = userService.paginate(1, Integer.MAX_VALUE, params);
        List<User> list = page.getList();
        List<UserPropertyModel> exportList = Lists.newArrayList();
        for (User user:list) {
            UserPropertyModel model = new UserPropertyModel();
            model.setRealname(user.getRealname());
            model.setMobile(user.getMobile());
            model.setGroupName(user.getGroupName());
            model.setUsername(user.getUsername());
            exportList.add(model);
        }
        ExcelKit.writeExcel(getResponse(), exportList, "用户信息", "用户", new UserPropertyModel());
        renderNull();
    }

    public void employ(){
        String id = getPara("id");
        String status = getPara("status");
        if (status.equals("1")){
            status ="0";
        }else{
            status ="1";
        }
        userService.updateStatusById(id,status);
        renderJson(Ret.ok());
    }

    public void save(){
        User user = getRawObject(User.class);
        String[] groupids = getParaValues("userGroup[]");
        User u = userService.findByUsername(user.getUsername());
        String uuid = StrUtil.uuid();
        UserGroupRel userGroupRel = new UserGroupRel();
        if (StrKit.isBlank(user.getId())){
            user.setSalt(salt());
            user.setPassword(encryptPassword(user.getPassword(), user.getSalt()));
            if(u!=null){
                renderJson("用户名已存在！");
                return;
            }
            List<User> users = userService.findByMobile(user.getMobile());
            for(User us : users) {
                if(StrKit.isBlank(us.getWechatOpenId()) && StrKit.isBlank(us.getWechatUserid())) {
                    continue;
                }else {
                    user.setWechatOpenId(us.getWechatOpenId());
                    user.setWechatUserid(us.getWechatUserid());
                    break;
                }
            }
            for(User us : users) {
                if (StrKit.notBlank(us.getAvatar())) {
                    user.setAvatar(us.getAvatar());
                    break;
                }
            }
            String userId = getUserId();
            Department department = departmentService.findByUserId(userId);
            String dataArea = department.getDataArea() + StrKit.getRandomUUID().substring(0, 4);
            user.setDataArea(dataArea);
            user.setId(uuid);
            getUserGroup(groupids, uuid,userGroupRel);
            userService.save(user);
            renderJson(Ret.ok());
            return;
        }
        userGroupRelService.deleteByUserId(user.getId());
        getUserGroup(groupids, user.getId(),userGroupRel);
        if(u!=null && u.getUsername().equals(user.getUsername()) && !user.getId().equals(u.getId())) {
            renderJson("用户名已存在！");
            return;
        }
        if (u!=null && !u.getDepartmentId().equals(user.getDepartmentId())) {
            Department dept = departmentService.findById(user.getDepartmentId());
            String dataArea = dept.getDataArea() + StrKit.getRandomUUID().substring(0, 4);
            user.setDataArea(dataArea);
        }
        userService.update(user);
        renderJson(Ret.ok());
    }

    private void getUserGroup(String[] groupids, String id ,UserGroupRel userGroupRel) {
        userGroupRel.setUserId(id);
        for (int i = 0; i < groupids.length; i++) {
            userGroupRel.setId(StrUtil.uuid());
            userGroupRel.setGroupId(groupids[i]);
            userGroupRelService.save(userGroupRel);
        }
    }

    public void saveOrUpdate() {
        User user = getRawObject(User.class);
        Object id = userService.saveOrUpdate(user);
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
        List<Dict> typeOptions = dictService.findListByDictType("user_type");
        renderJson(Ret.ok()
            .set("stationOptions", stationOptions)
            .set("groupOptions", groupOptions)
            .set("typeOptions", typeOptions)
        );
    }

    public void info() {

        String userId = getUserId();
        User user = userService.findById(userId);

        List<String> roleList = Lists.newArrayList();
        List<String> roleIdList = Lists.newArrayList();
        List<Role> list = roleService.findRoleListByUserId(userId);
        list.stream().forEach(role -> {
            roleList.add(role.getRoleCode());
            roleIdList.add(role.getId());
        });

        String roleIds = Joiner.on(",").join(roleIdList);
        List<String> permissions = operationService.findAllPermissionByUserId(userId, roleIds);

        Ret ret = Ret.ok();
        ret.set("sysUser", user);
        ret.set("roles", roleList.toArray());
        ret.set("permissions", permissions.toArray());
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

    @Clear
    public void findAccountOptions() {
        String mobile = getPara("mobile");
        List<Record> list = userService.findAllAccount(mobile);
        renderJson(list);
    }

    private static String salt() {
        int random = (int) (10 + (Math.random() * 10));
        return UUID.randomUUID().toString().replace("-", "").substring(random);// 随机长度
    }

    private static String encryptPassword(String password, String salt) {
        return sha256(password + salt);
    }
}
