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

package net.ninemm.upms.excel.listener;

import com.alibaba.excel.metadata.BaseRowModel;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import io.jboot.utils.StrUtils;
import net.ninemm.base.plugin.excel.ExcelListener;
import net.ninemm.upms.excel.model.UserPropertyModel;
import net.ninemm.upms.service.api.GroupService;
import net.ninemm.upms.service.api.UserService;
import net.ninemm.upms.service.model.User;

import java.util.List;

/**
 * excle用户导入监听处理类
 *
 * @author Eric.Huang
 * @date 2018-12-23 12:29
 **/

public class ExcelUserListener<T extends BaseRowModel> extends ExcelListener {

    @Inject
    UserService userService;

    @Inject
    GroupService groupService;

    public ExcelUserListener() {
        super();
    }

    public ExcelUserListener(Integer batchNum) {
        super(batchNum);
    }

    @Override
    public void analysis() {
        List<Object> list = getRowDatas();

        if (list.size() > 0) {
            List<User> userList = Lists.newArrayList();
            // JbootmqConfig jbootmqConfig = Jboot.config(JbootmqConfig.class);
            // Jboot.me().getMq().publish(list, jbootmqConfig.getChannel());
            list.stream().forEach(obj -> {
                UserPropertyModel model = (UserPropertyModel) obj;
                User user = userService.findByUsername(model.getUsername());
                if (user == null) {
                    user = new User();
                    user.setId(StrUtils.uuid());
                    user.setUsername(model.getUsername());
                    user.setMobile(model.getMobile());
                    user.setRealname(model.getRealname());

                    String groupId = groupService.findGroupIdByGroupName(model.getGroupName());
                    if (StrUtils.notBlank(groupId)) {
                        user.setGroupId(groupId);
                        user.setGroupName(model.getGroupName());
                    }
                    userList.add(user);
                }
                System.out.println(model.getRealname() + "-" + model.getUsername() + "-" + model.getMobile() + "-" + model.getGroupName());
            });
            userService.batchSave(userList);
        }
    }
}
