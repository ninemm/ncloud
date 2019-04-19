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

import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableMap;
import com.jfinal.aop.Inject;
import com.jfinal.kit.Ret;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Page;
import io.jboot.support.swagger.ParamType;
import io.jboot.web.controller.annotation.RequestMapping;
import io.jboot.web.cors.EnableCORS;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.ninemm.base.web.base.BaseController;
import net.ninemm.upms.service.api.DictTypeService;
import net.ninemm.upms.service.model.DictType;

import java.util.List;
import java.util.Map;

/**
 * 数据字典接口
 *
 * @author Eric.Huang
 * @date 2018-06-28 01:07
 **/

@RequestMapping(value = "/api/v1/admin/dictType")
@Api(description = "数据字典接口文档", basePath = "/api/v1/admin/dictType", tags = "dict", position = 1)
@EnableCORS(allowOrigin = "*", allowHeaders = "Content-Type,Jwt", allowMethods = "POST,OPTIONS,GET,PUT,DELETE", allowCredentials = "true")
public class DictTypeController extends BaseController {

    @Inject
    DictTypeService dictTypeService;

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
        @ApiImplicitParam(name = "name", value = "类型名称", paramType = ParamType.QUERY, dataType = "string", required = true),
        @ApiImplicitParam(name = "page", value = "页码", paramType = ParamType.QUERY, dataType = "int", required = true),
        @ApiImplicitParam(name = "limit", value = "每页数量", paramType = ParamType.QUERY, dataType = "int", required = true)
    })
    public void list() {
        Map<String, Object> params = getAllParaMap();
        Page<DictType> page = dictTypeService.paginate(getPageNumber(), getPageSize(), params);
        Map<String, Object> map = ImmutableMap.of("total", page.getTotalRow(), "records", page.getList());
        renderJson(map);
    }

    @ApiOperation(value = "数据字典实体", httpMethod = "GET", notes = "Dict Object")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "Jwt", value = "Jwt", paramType = ParamType.HEADER, dataType = "string", required = true),
        @ApiImplicitParam(name = "id", value = "字典ID", paramType = ParamType.QUERY, dataType = "string", required = true)
    })
    public void findById() {
        String id = getPara(0);
        if (StrKit.isBlank(id)) {
            renderJson(Ret.fail());
            return;
        }

        DictType dictType = dictTypeService.findById(id);
        renderJson(Ret.ok().set("data", dictType));
    }

    @ApiOperation(value = "新增或更新数据字典", httpMethod = "POST, PUT", notes = "Dict Object")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "Jwt", value = "Jwt", paramType = ParamType.HEADER, dataType = "string", required = true),
        @ApiImplicitParam(name = "id", value = "字典ID", paramType = ParamType.QUERY, dataType = "string", required = true)
    })
    public void saveOrUpdate() {
        DictType dictType = getRawObject(DictType.class);
        Object id = dictTypeService.saveOrUpdate(dictType);
        if (id != null) {
            renderJson(Ret.ok());
        } else {
            renderJson(Ret.fail());
        }
    }

    @ApiOperation(value = "删除字典类型", httpMethod = "DELETE", notes = "DELETE Dict Object")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "Jwt", value = "Jwt", paramType = ParamType.HEADER, dataType = "string", required = true),
        @ApiImplicitParam(name = "id", value = "字典ID", paramType = ParamType.QUERY, dataType = "string", required = true)
    })
    public void delete() {
        String id = getPara(0);
        if (StrKit.isBlank(id)) {
            renderJson(Ret.fail());
            return;
        }
        boolean deleted = dictTypeService.deleteById(id);
        if (deleted) {
            renderJson(Ret.ok());
            return;
        }
        renderJson(Ret.fail());
    }

    @ApiOperation(value = "批量删除字典类型", httpMethod = "DELETE", notes = "DELETE Dict Object")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "Jwt", value = "Jwt", paramType = ParamType.HEADER, dataType = "string", required = true),
        @ApiImplicitParam(name = "ids", value = "字典IDs", paramType = ParamType.QUERY, dataType = "string", required = true)
    })
    public void batchDelete() {
        String userIds = getPara(0);
        List<String> list = Splitter.on(",").splitToList(userIds);
        for (String dictId : list) {
            dictTypeService.deleteById(dictId);
        }
        renderJson(Ret.ok());
    }
}
