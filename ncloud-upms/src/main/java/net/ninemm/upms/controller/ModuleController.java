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
import com.google.inject.Inject;
import com.jfinal.kit.Ret;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Page;
import io.jboot.utils.StrUtils;
import io.jboot.web.controller.annotation.RequestMapping;
import io.jboot.web.cors.EnableCORS;
import net.ninemm.base.utils.layer.TreeKit;
import net.ninemm.upms.service.api.ModuleService;
import net.ninemm.upms.service.api.SystemsService;
import net.ninemm.upms.service.model.Module;
import net.ninemm.upms.service.model.Systems;
import net.ninemm.upms.vo.DeptTreeVO;
import net.ninemm.upms.vo.ModuleTreeVO;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 系统模块管理
 *
 * @author Eric.Huang
 * @date 2018-12-10 10:48
 **/

@RequestMapping(value = "/api/v1/admin/module")
@EnableCORS(allowOrigin = "http://localhost:8080", allowHeaders = "Content-Type,Jwt", allowCredentials = "true")
public class ModuleController extends BaseAppController {

    @Inject
    ModuleService moduleService;

    @Inject
    SystemsService systemsService;

    public void list() {
        Map<String, Object> params = getAllParaMap();
        Page<Module> page = moduleService.paginate(getPageNumber(), getPageSize(), params);
        String[] attrs = {"name"};
        systemsService.join(page, "system_id", attrs);
        Map<String, Object> map = ImmutableMap.of("total", page.getTotalRow(), "records", page.getList());
        renderJson(map);
    }

    public void moduleTree() {
        List<Module> list = moduleService.findAllAsSort();
        List<ModuleTreeVO> treeList = Lists.newArrayList();
        list.stream().forEach(module -> {
            ModuleTreeVO moduleTreeVO = new ModuleTreeVO();
            moduleTreeVO.setId(module.getId());
            moduleTreeVO.setParentId(module.getParentId());
            moduleTreeVO.setName(module.getModuleName());
            moduleTreeVO.setLeaf(module.getIsParent() == 1 ? false : true);
            treeList.add(moduleTreeVO);
        });

        renderJson(TreeKit.toTree(treeList));
    }

    public void findById() {
        String id = getPara(0);
        if (StrKit.isBlank(id)) {
            renderJson(Ret.fail());
            return;
        }
        Module module = moduleService.findById(id);
        systemsService.join(module, "system_id", "system");
        renderJson(Ret.ok().set("data", module));
    }

    public void save() {
        Module module = getRawObject(Module.class);
        module.setId(StrUtils.uuid());
        module.setCreateDate(new Date());
        module.setIsParent(0);
        boolean saved = moduleService.save(module);
        if (saved) {
            renderJson(Ret.ok());
        } else {
            renderJson(Ret.fail());
        }
    }

    public void update() {
        Module module = getRawObject(Module.class);
        module.setModifyDate(new Date());
        boolean saved = moduleService.update(module);
        if (saved) {
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
        moduleService.deleteById(id);
        renderJson(Ret.ok());
    }

    public void findListAsTree() {
        String parentId = getPara("parentId");
        final List<ModuleTreeVO> treeList = Lists.newArrayList();
        if (StrKit.isBlank(parentId)) {
            Module root = moduleService.findById("0");
            ModuleTreeVO moduleTreeVO = initTreeVO(root);
            moduleTreeVO.setDisabled(true);
            moduleTreeVO.setLeaf(false);
            treeList.add(moduleTreeVO);
        } else {
            List<Module> list = moduleService.findListByParentId(parentId);
            list.stream().forEach(module -> {
                //moduleTreeVO.setLeaf(module.getIsParent() == 1 ? false : true);
                treeList.add(initTreeVO(module));
            });
        }
        renderJson(TreeKit.toTree(parentId, treeList));
    }

    private ModuleTreeVO initTreeVO(Module module) {
        ModuleTreeVO moduleTreeVO = new ModuleTreeVO();
        moduleTreeVO.setId(module.getId());
        moduleTreeVO.setParentId(module.getParentId());
        moduleTreeVO.setName(module.getModuleName());
        return moduleTreeVO;
    }
}
