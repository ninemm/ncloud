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
 */

package net.ninemm.upms.support;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import net.ninemm.base.plugin.jwt.AbstractJwtAuthorizingRealm;
import net.ninemm.upms.service.api.OperationService;
import net.ninemm.upms.service.api.RoleService;
import net.ninemm.upms.service.api.UserService;
import net.ninemm.upms.service.model.User;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.List;

/**
 * 基于JWT（ JSON WEB TOKEN）的认证域
 *
 * @author Eric
 * @date 2018-06-28 22:05
 */
public class JwtAuthorizingRealm extends AbstractJwtAuthorizingRealm {

    @Inject
    RoleService roleService;

    @Inject
    OperationService operationService;

    @Inject
    UserService userService;

    /**
     * 授权,JWT已包含访问主张只需要解析其中的主张定义就行了
     *
     * @author Eric Huang
     * @date 2018-06-29 22:09
     * @param [principals]
     * @return org.apache.shiro.authz.AuthorizationInfo
     **/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String userId = (String) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        User user = userService.findById(userId);

        /**
         * 角色
         */
        //List<String> roles = roleService.findRolePermissionsByUserId(userId);
        List<String> roles = Lists.newArrayList();
//        roles.add("s")
        info.addRoles(roles);

        /**
         * 权限
         */
//        List<String> perms = operationService.findOperationPermsByUserId(userId, user.getStationId());
        List<String> perms = Lists.newArrayList();
        info.addStringPermissions(perms);
        return info;
    }
}
