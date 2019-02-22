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
import com.jfinal.aop.Clear;
import com.jfinal.aop.Inject;
import io.jboot.app.JbootApplication;
import io.jboot.web.controller.JbootController;
import io.jboot.web.controller.annotation.RequestMapping;
import net.ninemm.base.interceptor.GlobalCacheInterceptor;
import net.ninemm.base.utils.layer.TreeKit;
import net.ninemm.upms.service.api.MenuService;
import net.ninemm.upms.service.model.Menu;
import net.ninemm.upms.vo.MenuTreeVO;

import java.util.List;

@RequestMapping(value = "/menuTest")
@Clear(GlobalCacheInterceptor.class)
public class MenuControllerTest extends JbootController {

    @Inject
    MenuService menuService;

    public static void main(String[] args) {
        JbootApplication.setBootArg("jboot.datasource.type", "mysql");
        JbootApplication.setBootArg("jboot.datasource.url", "jdbc:mysql://127.0.0.1:3306/ncloud");
        JbootApplication.setBootArg("jboot.datasource.user", "root");
        JbootApplication.setBootArg("jboot.datasource.password", "123456");
        JbootApplication.run(args);
    }

    public void menuTree() {
        List<Menu> list = menuService.findAllAsSort();
        List<MenuTreeVO> trees = Lists.newArrayList();
        for (Menu menu : list) {
//            MenuTree node = new MenuTree();
             MenuTreeVO node = new MenuTreeVO();
            node.setId(menu.getId());
            node.setParentId(menu.getParentId());
            node.setName(menu.getName());
            node.setUrl(menu.getCode());
            node.setPath(menu.getCode());
            node.setCode(menu.getCode());
            node.setLabel(menu.getName());
            node.setComponent(menu.getComponent());
            node.setIcon(menu.getIcon());
            node.setSort(menu.getOrderList());

//            menuItem.setId(menu.getId());
//            menuItem.setParentId(menu.getParentId());
//            menuItem.setName(menu.getName());
            trees.add(node);
        }

        List<MenuTreeVO> menus = TreeKit.toTree("0", trees);
        renderJson(menus);
    }

}