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
import net.ninemm.base.utils.layer.TreeKit;
import net.ninemm.upms.service.api.MenuService;
import net.ninemm.upms.service.api.RoleService;
import net.ninemm.upms.service.model.Menu;
import net.ninemm.upms.vo.MenuOptionVO;
import net.ninemm.upms.vo.MenuTreeVO;

import java.util.List;

/**
 * 菜单管理
 *
 * @author Eric.Huang
 * @date 2018-12-10 10:49
 **/

@RequestMapping(value = "/api/v1/admin/menu")
@EnableCORS(allowOrigin = "http://localhost:8080", allowHeaders = "Content-Type,Jwt", allowCredentials = "true")
public class MenuController extends BaseAppController {

    @Inject
    MenuService menuService;

    @Inject
    RoleService roleService;

    public void userMenu() {
        List<Menu> list = menuService.findAllAsSort();
        List<MenuTreeVO> menuTreeVOList = toTreeEntityList(list);
        List<MenuTreeVO> menuTreeList = TreeKit.toTree("0", menuTreeVOList);
        List<Menu> headerMenuList = menuService.findHeaderMenuSet();

        List<MenuTreeVO> headerMenuTreeList = toTreeEntityList(headerMenuList);
        List<MenuTreeVO> headerMenuSet = TreeKit.toTree("0", headerMenuTreeList);
        renderJson(Ret.ok().set("allMenu", menuTreeList).set("headerMenuSet", headerMenuSet));
    }

    public void allMenuTree() {
        List<Menu> list = menuService.findAllAsSort();
        List<MenuTreeVO> menuTreeVOList = toTreeEntityList(list);
        List<MenuTreeVO> menuTreeList = TreeKit.toTree(menuTreeVOList);
        List<MenuOptionVO> menuOptions = toMenuOptions(menuTreeList);
        renderJson(Ret.ok().set("menuTreeData", menuTreeList).set("menuOptions", menuOptions));
    }

    public void findById() {
        String id = getPara(0);
        if (StrKit.isBlank(id)) {
            renderJson(Ret.fail());
            return;
        }

        Menu menu = menuService.findById(id);
        menuService.join(menu, "parent_id", "parent");
        renderJson(menu);
    }

    public void saveOrUpdate() {
        Menu menu = getRawObject(Menu.class);
        Object id = menuService.saveOrUpdate(menu);
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
        boolean result = menuService.deleteById(id);
        if (result) {
            renderJson(Ret.ok());
        } else {
            renderJson(Ret.fail());
        }
    }

    private List<MenuOptionVO> toMenuOptions(List<MenuTreeVO> menuTreeList) {
        List<MenuOptionVO> list = Lists.newArrayList();
        menuTreeList.stream().forEach(menuTreeVO -> {
            MenuOptionVO menuOption = new MenuOptionVO();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < menuTreeVO.getLevel(); i++) {
                sb.append("-");
            }

            menuOption.setKey(menuTreeVO.getId());
            menuOption.setValue(sb.toString() + menuTreeVO.getName());
            list.add(menuOption);
            if (menuTreeVO.getChildren() != null) {
                list.addAll(toMenuOptions(menuTreeVO.getChildren()));
            }
        });
        return list;
    }

    private List<MenuTreeVO> toTreeEntityList(List<Menu> list) {
        List<MenuTreeVO> menuTreeVOList = Lists.newArrayList();
        for (Menu menu : list) {
            MenuTreeVO menuNode = new MenuTreeVO();
            menuNode.setId(menu.getId());
            menuNode.setParentId(menu.getParentId());
            menuNode.setName(menu.getName());

            menuNode.setUrl(menu.getPath());
            menuNode.setPath(menu.getPath());
            menuNode.setCode(menu.getCode());
            menuNode.setLabel(menu.getName());

            menuNode.setIcon(menu.getIcon());
            menuNode.setSort(menu.getOrderList());
            menuNode.setRedirect(menu.getRedirect());
            menuNode.setComponent(menu.getComponent());

            menuNode.setLevel(menu.getLevel());
            menuTreeVOList.add(menuNode);
        }
        return menuTreeVOList;
    }

}
