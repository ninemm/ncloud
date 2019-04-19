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

import java.util.List;

/**
 * 组织机构(部门)
 *
 * @author Eric.Huang
 * @date 2018-12-10 10:40
 **/

@RequestMapping(value = "/api/v1/admin/dept")
@EnableCORS(allowOrigin = "http://localhost:8080", allowHeaders = "Content-Type,Jwt", allowCredentials = "true")
public class DepartmentController extends BaseAppController {

    @Inject
    UserService userService;

    @Inject
    DepartmentService departmentService;

    public void tree() {

        List<Department> list = departmentService.findAllAsSort();
        List<DeptTreeVO> deptNodeList = Lists.newArrayList();
        for (Department dept : list) {
            deptNodeList.add(initTreeVO(dept));
        }

        List<DeptTreeVO> treeList = TreeKit.toTree(deptNodeList);
        renderJson(treeList);
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
            deptTreeVO.setIsLeaf(false);

            treeList.add(deptTreeVO);
            treeList = TreeKit.toTree(parentId, treeList, true);
        }
        renderJson(treeList);
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

    public void saveOrUpdate() {
        Department department = getRawObject(Department.class);
        Object result = departmentService.saveOrUpdate(department);
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
            tree.setIsLeaf(false);
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
                deptTree.setName(user.getRealname());
                deptTree.setParentId(parentId);
                deptTree.setIsLeaf(true);
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
        deptTreeVO.setKey(department.getId());
        deptTreeVO.setName(department.getDeptName());
        deptTreeVO.setTitle(department.getDeptName());
        deptTreeVO.setParentId(department.getParentId());
        deptTreeVO.setIsLeaf(department.getIsParent() == 1 ? false : true);
        return deptTreeVO;
    }

}
