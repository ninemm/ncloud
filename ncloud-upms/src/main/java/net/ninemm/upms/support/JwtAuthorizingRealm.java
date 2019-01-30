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

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.jfinal.aop.Aop;
import com.jfinal.aop.AopFactory;
import io.jboot.Jboot;
import io.jboot.aop.JbootInjectManager;
import io.jboot.core.rpc.JbootrpcManager;
import io.jboot.utils.StrUtils;
import net.ninemm.base.common.CacheKey;
import net.ninemm.base.plugin.jwt.AbstractJwtAuthorizingRealm;
import net.ninemm.base.plugin.jwt.JwtAuthenticationToken;
import net.ninemm.upms.service.api.OperationService;
import net.ninemm.upms.service.api.RoleService;
import net.ninemm.upms.service.model.Role;
import org.apache.shiro.authc.*;
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

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        JwtAuthenticationToken jwtToken = (JwtAuthenticationToken) token;
        String userId = (String) jwtToken.getPrincipal();

        String uidCache = Jboot.me().getCache().get(CacheKey.CACHE_JWT_TOKEN, userId);
        if (StrUtils.isNotBlank(uidCache)) {
            /** token 已被加入黑名单 */
            throw new UnknownAccountException();
        }

        return new SimpleAuthenticationInfo(userId, jwtToken.getCredentials(), this.getName());
    }

    /**
     * 授权,JWT已包含访问主张只需要解析其中的主张定义就行了
     *
     * @author Eric Huang
     * @date 2018-06-29 22:09
     * @param principals
     * @return org.apache.shiro.authz.AuthorizationInfo
     **/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String userId = (String) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        List<String> roleList = Lists.newArrayList();
        List<String> roleIdList = Lists.newArrayList();

        /** 用户角色 */
        RoleService roleService = Jboot.service(RoleService.class);
        List<Role> list = roleService.findRoleListByUserId(userId);
        list.stream().forEach(role -> {
            roleList.add(role.getRoleCode());
            roleIdList.add(role.getId());
        });
        info.addRoles(roleList);

        /** 用户操作权限 */
        String roleIds = Joiner.on(",").join(roleIdList);
//        OperationService operationService = Jboot.service(OperationService.class);
        OperationService operationService = Jboot.bean(OperationService.class);
        List<String> permissions = operationService.findAllPermissionByUserId(userId, roleIds);
        info.addStringPermissions(permissions);
        return info;
    }
}
