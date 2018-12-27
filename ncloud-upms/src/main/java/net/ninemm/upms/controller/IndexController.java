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
import net.ninemm.upms.service.api.UserService;
import net.ninemm.upms.service.model.User;

import java.util.List;

/**
 * 用户登录、注销
 *
 * @author Eric.Huang
 * @date 2018-12-10 16:56
 **/

@RequestMapping(value = "/")
@Api(description = "用户登录，注销", basePath = "/", tags = "index", position = 98)
@EnableCORS(allowOrigin = "http://localhost:8080", allowHeaders = "Content-Type,Jwt", allowCredentials = "true")
public class IndexController extends BaseAppController {

    public void index() {
        renderNull();
    }

    @Clear(GlobalCacheInterceptor.class)
    public void code() {
        renderCaptcha();
    }

}
