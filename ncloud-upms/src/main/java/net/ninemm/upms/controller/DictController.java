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

package net.ninemm.upms.controller;

import com.google.inject.Inject;
import io.jboot.component.swagger.ParamType;
import io.jboot.web.controller.annotation.RequestMapping;
import io.jboot.web.cors.EnableCORS;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.ninemm.base.common.RestResult;
import net.ninemm.base.web.base.BaseController;
import net.ninemm.upms.service.api.DictService;
import net.ninemm.upms.service.model.Dict;

import java.util.List;

/**
 * 数据字典接口
 *
 * @author Eric.Huang
 * @date 2018-06-28 01:07
 **/

@RequestMapping(value = "/api/dict/v1")
@Api(description = "数据字典接口文档", basePath = "/api/dict/v1", tags = "dict", position = 1)
@EnableCORS(allowOrigin = "http://localhost:8080", allowHeaders = "Content-Type,Jwt", allowCredentials = "true")
public class DictController extends BaseController {

    @Inject
    DictService dictService;

    /**
     * 通过字典类型，查询字典列表
     * @author Eric Huang
     * @date  2018-06-28 01:34
     * @param [type]
     * @return void
     **/

    @ApiOperation(value = "数据字典类型列表", httpMethod = "GET", notes = "Dict List")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "Jwt", value = "Jwt", paramType = ParamType.HEADER, dataType = "string", required = true),
        @ApiImplicitParam(name = "type", value = "字典类型", paramType = ParamType.QUERY, dataType = "string", required = true)
    })
    public void list() {
        String type = getPara("type");
        List<Dict> list = dictService.findListByDictType(type);
        renderJson(RestResult.buildSuccess(list));
    }
}
