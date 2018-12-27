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
import com.google.inject.Inject;
import com.jfinal.kit.StrKit;
import io.jboot.web.controller.annotation.RequestMapping;
import io.jboot.web.cors.EnableCORS;
import net.ninemm.base.interceptor.NotNullPara;
import net.ninemm.base.utils.layer.TreeKit;
import net.ninemm.upms.service.api.DepartmentService;
import net.ninemm.upms.service.model.Department;
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
    DepartmentService departmentService;

    public void tree() {
        List<Department> list = departmentService.findAllAsSort();
        List<DeptTreeVO> deptNodeList = Lists.newArrayList();
        for (Department dept : list) {
            DeptTreeVO deptTree = new DeptTreeVO();
            deptTree.setId(dept.getId());
            deptTree.setName(dept.getDeptName());
            deptTree.setParentId(dept.getParentId());
            deptNodeList.add(deptTree);
        }

        List<DeptTreeVO> treeList = TreeKit.toTree(deptNodeList);
        renderJson(treeList);
    }

    @NotNullPara("id")
    public void findById(String id) {
        Department department = departmentService.findById(id);
        departmentService.join(department, "parent_id");
        renderJson(department);
    }

    public void doSave() {}

    public void delete() {}

    public void update() {}

    public void findListAsTree() {

        String parentId = getPara("parentId");
        final List<DeptTreeVO> treeList = Lists.newArrayList();
        if (StrKit.isBlank(parentId)) {
            Department root = departmentService.findById("0");
            DeptTreeVO tree = initTreeVO(root);
            tree.setDisabled(true);
            tree.setLeaf(false);
            treeList.add(tree);
        } else {
            List<Department> list = departmentService.findListByParentId(parentId);
            list.stream().forEach(department -> {
                treeList.add(initTreeVO(department));
            });
        }
        renderJson(TreeKit.toTree(parentId, treeList));
    }

    private DeptTreeVO initTreeVO(Department department) {
        DeptTreeVO deptTreeVO = new DeptTreeVO();
        deptTreeVO.setId(department.getId());
        deptTreeVO.setName(department.getDeptName());
        deptTreeVO.setParentId(department.getParentId());
        deptTreeVO.setLeaf(department.getIsParent() == 1 ? false : true);
        return deptTreeVO;
    }

}
