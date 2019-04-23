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

import com.google.common.collect.Lists;
import com.jfinal.aop.Inject;
import com.jfinal.kit.Ret;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Record;
import io.jboot.web.controller.annotation.RequestMapping;
import io.jboot.web.cors.EnableCORS;
import net.ninemm.base.common.Consts;
import net.ninemm.base.interceptor.NotNullPara;
import net.ninemm.base.utils.layer.TreeKit;
import net.ninemm.upms.service.api.DepartmentService;
import net.ninemm.upms.service.api.UserService;
import net.ninemm.upms.service.model.Department;
import net.ninemm.upms.service.model.User;
import net.ninemm.upms.vo.DeptTreeVO;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 组织机构(部门)
 *
 * @author Eric.Huang
 * @date 2018-12-10 10:40
 **/

@RequestMapping(value = "/api/v1/admin/dept")
@EnableCORS
public class DepartmentController extends BaseAppController {

    @Inject
    UserService userService;

    @Inject
    DepartmentService departmentService;

    public void tree() {
        String userId = getUserId();
        String deptName = getPara("deptName");
        Department department = departmentService.findByUserId(userId);
        Map<String, Object> map = new HashMap<>();
        List<Department> list = departmentService.findByDeptDataArea(department.getDataArea()+"%" ,deptName);
        List<DeptTreeVO> deptNodeList = Lists.newArrayList();
        for (Department dept : list) {
            deptNodeList.add(initTreeVO(dept));
        }
        String partId = "";
        if (StrKit.isBlank(deptName) || department.getDeptName().contains(deptName)){
            partId = department.getParentId() ;
        }else{
            partId =department.getId();
        }
        List<DeptTreeVO> treeList = TreeKit.toTree(partId,deptNodeList);
        map.put("state","ok");
        map.put("result",treeList);
        renderJson(map);
    }

    public void findDeptUserTree() {
        String parentId = getPara("parentId", Consts.TREE_DEFAULT_ROOT_ID.toString());
        Boolean isLoadUser = getParaToBoolean("isLoadUser");
        List<DeptTreeVO> treeList = Lists.newArrayList();
        if (isLoadUser != null && isLoadUser) {
            treeList = toDeptTreeList(parentId);
            treeList = TreeKit.toTree(parentId, treeList);
            loadUser(treeList, parentId);
        } else {
            Department parent = departmentService.findById(parentId);
            DeptTreeVO deptTreeVO = initTreeVO(parent);
            deptTreeVO.setDisabled(true);
            deptTreeVO.setLeaf(false);

            treeList.add(deptTreeVO);
            treeList = TreeKit.toTree(parentId, treeList, true);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("state","ok");
        map.put("result",treeList);
        renderJson(map);
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
        String[] idArr = ids.split(",");
        for (int i=0 ; i<idArr.length ;i++){
            List<Record> listDept = userService.findByDepTid(idArr[i]);
            if (listDept.size()>0){
                renderJson(Ret.fail());
                return;
            }
        }
        departmentService.deleteByIds(ids);
        renderJson(Ret.ok());
    }

    public void findUserTree(){
        String userId = getUserId();
        Department department = departmentService.findByUserId(userId);
        Map<String, Object> map = new HashMap<>();
        List<Department> list = departmentService.findByDeptDataArea(department.getDataArea()+"%",null);
        List<DeptTreeVO> deptNodeList = Lists.newArrayList();
        for (Department dep: list) {
            List<User> userList = userService.findListByDeptId(dep.getId());
            if (userList.size()>0){
                addTree(userList,dep,deptNodeList);
            }
        }
        for (Department dept : list) {
            deptNodeList.add(initTreeVO(dept));
        }
        List<DeptTreeVO> treeList = TreeKit.toTree(department.getParentId(),deptNodeList);
        map.put("state","ok");
        map.put("result",treeList);
        renderJson(map);
    }

    private void addTree(List<User> userList,Department dep,List<DeptTreeVO> deptNodeList){
        Department department = new Department();
        department.setIsParent(0);
        department.setParentId(dep.getId());
        for (User user:userList) {
            department.setId(user.getId());
            department.setDeptName(user.getUsername());
            deptNodeList.add(initUserTree(department));
        }
    }

    @NotNullPara("id")
    public void findById(String id) {
        Department department = departmentService.findById(id);
        departmentService.join(department, "parent_id");
        userService.join(department, "principal_user_id", "leader");
        userService.join(department, "order_reviewer_id", "reviewer");
        renderJson(department);
    }

    public void delete() {
        String id = getPara(0);
        if (StrKit.isBlank(id)) {
            renderJson(Ret.fail());
            return;
        }
        departmentService.deleteById(id);
        renderJson(Ret.ok());
    }

    public void findByDeptName() {
        String deptName = getPara("deptName");
        List<Department> list = departmentService.findByDeptName(deptName);
        if(list.size()>0){
            Department department = list.get(0);
            String parentId = department.getParentId() ;
            List<DeptTreeVO> deptNodeList = Lists.newArrayList();
            for (Department dept : list) {
                deptNodeList.add(initTreeVO(dept));
            }
            List<DeptTreeVO> treeList = TreeKit.toTree(parentId,deptNodeList);
            renderJson(treeList);
        }else{
            renderJson(Ret.fail());
        }
    }

    public void saveOrUpdate() {
        Department department = getRawObject(Department.class);
        Object result = departmentService.saveOrUpdate(department);
        if (result != null) {
            renderJson(Ret.ok());
        } else {
            renderJson(Ret.fail());
        }
    }

    public void save(){
        Department department = getRawObject(Department.class);
        Department parent = departmentService.findById(department.getParentId());
        String dataArea = "";
        List<Department> parentList = departmentService.findListByParentId(department.getParentId());
        if (parentList.size()>0){
            dataArea = "00" + String.valueOf(new BigDecimal(parentList.get(0).getDataArea()).add(new BigDecimal(1)));
        }else{
            dataArea = parent.getDataArea()+"001";
        }
        department.setDataArea(dataArea);
        department.setIsParent(0);
        Object result = departmentService.save(department);
        if (result != null) {
            renderJson(Ret.ok());
        } else {
            renderJson(Ret.fail());
        }
    }

    public void findListAsTree() {

        String parentId = getPara("parentId");
        List<DeptTreeVO> treeList = Lists.newArrayList();
        if (StrKit.isBlank(parentId)) {
            Department root = departmentService.findById(Consts.TREE_DEFAULT_ROOT_ID);
            DeptTreeVO tree = initTreeVO(root);
            tree.setDisabled(true);
            tree.setLeaf(false);
            treeList.add(tree);
        } else {
            treeList = toDeptTreeList(parentId);
        }
        renderJson(TreeKit.toTree(parentId, treeList));
    }

    private void loadUser(List<DeptTreeVO> treeList, String parentId) {
        List<User> userList = userService.findListByDeptId(parentId);
        if (userList != null && userList.size() > 0) {
            for( User user : userList) {
                DeptTreeVO deptTree = new DeptTreeVO();
                deptTree.setId(user.getId());
                deptTree.setLabel(user.getRealname());
                deptTree.setParentId(parentId);
                deptTree.setLeaf(true);
                deptTree.setDisabled(false);
                treeList.add(deptTree);
            };
        }
    }

    private List<DeptTreeVO> toDeptTreeList(String parentId) {
        List<DeptTreeVO> treeList = Lists.newArrayList();
        List<Department> list = departmentService.findListByParentId(parentId);
        list.stream().forEach(department -> {
            DeptTreeVO tmp = initTreeVO(department);
            tmp.setDisabled(true);
            treeList.add(tmp);
        });
        return treeList;
    }

    private DeptTreeVO initTreeVO(Department department) {
        DeptTreeVO deptTreeVO = new DeptTreeVO();
        deptTreeVO.setId(department.getId());
        deptTreeVO.setLabel(department.getDeptName());
        deptTreeVO.setParentId(department.getParentId());
        deptTreeVO.setLeaf(department.getIsParent() == 1 ? false : true);
        return deptTreeVO;
    }

    private DeptTreeVO initUserTree(Department department) {
        DeptTreeVO deptTreeVO = new DeptTreeVO();
        deptTreeVO.setId(department.getId());
        deptTreeVO.setLabel(department.getDeptName());
        deptTreeVO.setParentId(department.getParentId());
        deptTreeVO.setLeaf(department.getIsParent() == 1 ? false : true);
        deptTreeVO.setUser(true);
        return deptTreeVO;
    }

}
