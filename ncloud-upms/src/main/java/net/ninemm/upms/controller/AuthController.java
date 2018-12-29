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

import com.google.inject.Inject;
import com.jfinal.aop.Clear;
import com.jfinal.kit.Ret;
import io.jboot.Jboot;
import io.jboot.component.swagger.ParamType;
import io.jboot.utils.StrUtils;
import io.jboot.web.controller.annotation.RequestMapping;
import io.jboot.web.cors.EnableCORS;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.ninemm.base.common.CacheKey;
import net.ninemm.base.common.Consts;
import net.ninemm.base.common.RestResult;
import net.ninemm.base.interceptor.GlobalCacheInterceptor;
import net.ninemm.base.interceptor.NotNullPara;
import net.ninemm.base.plugin.shiro.ShiroUtils;
import net.ninemm.upms.service.api.DepartmentService;
import net.ninemm.upms.service.api.UserService;
import net.ninemm.upms.service.model.Department;
import net.ninemm.upms.service.model.User;

import java.util.List;

/**
 * 用户登录认证
 *
 * @author Eric.Huang
 * @date 2018-12-26 21:46
 **/
@RequestMapping(value = "/auth")
@Api(description = "用户登录，注销", basePath = "/", tags = "auth", position = 99)
@EnableCORS(allowOrigin = "http://localhost:8080", allowHeaders = "Content-Type,Jwt", allowCredentials = "true")
public class AuthController extends BaseAppController {

    @Inject
    UserService userService;

    @Inject
    DepartmentService departmentService;

    @ApiOperation(value = "用户登录", httpMethod = "POST", notes = "用户登录时，如果用户有多个账套，则会跳转到账套选择页面，选择账套完成之后，跳转到主页面")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "mobile", value = "手机号", paramType = ParamType.FORM, dataType = "string", required = true),
        @ApiImplicitParam(name = "password", value = "密码", paramType = ParamType.FORM, dataType = "string", required = true),
        @ApiImplicitParam(name = "from", value = "接口请求来源", paramType = ParamType.FORM, dataType = "string", allowableValues = "android, ios, wechat", required = false),
        @ApiImplicitParam(name = "deviceAlias", value = "设备别名(用于推送)", paramType = ParamType.FORM, dataType = "string", required = false),
        @ApiImplicitParam(name = "choicedUserId", value = "选中的用户", paramType = ParamType.FORM, dataType = "string", required = false),
        @ApiImplicitParam(name = "choicedSellerId", value = "选中的账套", paramType = ParamType.FORM, dataType = "string", required = false)
    })
    @NotNullPara({"mobile", "password"})
    @Clear(GlobalCacheInterceptor.class)
    public void login(String mobile, String password) {

        List<User> list = userService.findByMobile(mobile);
        User user = list.get(0);

        boolean checkPwd = ShiroUtils.checkPwd(password, user.getPassword(), user.getSalt());
        if (!checkPwd) {
            renderJson(Ret.fail());
            return ;
        }

        // 查询用户的角色，主管，经理，业务员
        /*boolean isManager = ShiroUtils.hasPermission("");
        if (isManager) {
            Department department = departmentService.findDeptDataAreaByDeptId(user.getDepartmentId());
            if (department == null) {
                renderJson(Ret.fail().set("errorMessage", "用户未分配部门，请分配部门"));
                return;
            }
            String dataArea = department.getDataArea();
            if (StrUtils.notBlank(dataArea)) {
                Jboot.me().getCache().put(CacheKey.CACHE_PARENT_DATA_AREA, user.getId(), dataArea);
            }
        }*/

        /** 登录成功移除用户退出标识 */
        Jboot.me().getCache().remove(CacheKey.CACHE_JWT_TOKEN, user.getId());
        setJwtAttr(Consts.JWT_USER_ID, user.getId());

        Ret ret = Ret.ok();
        String token = createJwtToken();
        ret.set("userId", user.getId());
        ret.set("access_token", token);
        ret.set("refresh_token", token);
        renderJson(ret);
    }

    @ApiOperation(value = "用户登出", httpMethod = "GET", notes = "用户登出")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "Jwt", value = "Jwt", paramType = ParamType.HEADER, dataType = "string", required = true)
    })
    public void logout() {

        String userId = getUserId();
//        if (StrKit.notBlank(userId)) {
//            User user = userService.findById(userId);
//            if (user != null) {
//                userJoinPosService.deleteByMobile(user.getMobile());
//            }
//        }

        Jboot.me().getCache().put(CacheKey.CACHE_JWT_TOKEN, getUserId(), getUserId(), 2 * 60 * 60);
//        Jboot.me().getCache().remove(CacheKey.CACHE_SELLER, getUserId());
        Jboot.me().getCache().remove(CacheKey.CACHE_LOGINED_USER, getUserId());
//        Jboot.me().getCache().remove(CacheKey.CACHE_LOGINED_USER,getUserId() + ":" + CacheKey.CACHE_KEY_ROLE);

        renderJson(RestResult.buildSuccess("退出成功！"));
    }

}
