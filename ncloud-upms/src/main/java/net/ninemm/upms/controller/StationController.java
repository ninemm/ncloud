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

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.jfinal.kit.Ret;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import io.jboot.web.controller.annotation.RequestMapping;
import io.jboot.web.cors.EnableCORS;
import net.ninemm.upms.service.api.StationService;
import net.ninemm.upms.service.model.Station;

import java.util.List;
import java.util.Map;

/**
 * 岗位管理
 *
 * @author Eric.Huang
 * @date 2018-12-10 10:46
 **/

@RequestMapping(value = "/api/v1/admin/station")
@EnableCORS(allowOrigin = "http://localhost:8080", allowHeaders = "Content-Type,Jwt", allowCredentials = "true")
public class StationController extends BaseAppController {

    @Inject
    StationService stationService;

    public void list() {
        Map<String, Object> params = getAllParaMap();
        Page<Station> page = stationService.paginate(getPageNumber(), getPageSize(), params);
        Map<String, Object> map = ImmutableMap.of("total", page.getTotalRow(), "records", page.getList());
        renderJson(map);
    }

    public void findById() {
        String id = getPara(0);
        if (StrKit.isBlank(id)) {
            renderJson(Ret.fail());
            return;
        }

        Station station = stationService.findById(id);
        renderJson(Ret.ok().set("data", station));
    }

    public void save() {}

    public void update() {}

    public void saveOrUpdate() {
        Station station = getRawObject(Station.class);
        boolean result = stationService.saveOrUpdate(station);
        if (result) {
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
        stationService.deleteById(id);
        renderJson(Ret.ok());
    }

    public void findListAsOptions() {
        List<Record> list = stationService.findListAsOptions(null);
        renderJson(list);
    }
}
