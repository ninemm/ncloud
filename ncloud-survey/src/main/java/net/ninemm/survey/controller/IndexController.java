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

package net.ninemm.survey.controller;

import com.jfinal.aop.Clear;
import com.jfinal.aop.Inject;
import io.jboot.web.controller.annotation.RequestMapping;
import io.jboot.web.cors.EnableCORS;
import io.swagger.annotations.Api;
import net.ninemm.base.interceptor.GlobalCacheInterceptor;
import net.ninemm.upms.controller.BaseAppController;
import net.ninemm.upms.service.api.OptionService;
import net.ninemm.upms.service.model.Option;

import java.util.List;

/**
 * 用户登录、注销
 *
 * @author Eric.Huang
 * @date 2018-12-10 16:56
 **/

@RequestMapping(value = "/test")
@Api(description = "用户登录，注销", basePath = "/", tags = "index", position = 98)
@EnableCORS(allowOrigin = "http://localhost:8080", allowHeaders = "Content-Type,Jwt", allowCredentials = "true")
public class IndexController extends BaseAppController {

    @Inject
    OptionService optionService;

    public void index() {
        System.out.println("=================================>123");
        List<Option> all = optionService.findAll();
        renderJson(all);
    }

    @Clear(GlobalCacheInterceptor.class)
    public void code() {
        renderCaptcha();
    }

}
