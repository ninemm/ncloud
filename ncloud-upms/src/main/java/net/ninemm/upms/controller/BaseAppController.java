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

import com.jfinal.core.NotAction;
import com.jfinal.log.Log;
import io.jboot.Jboot;
import io.jboot.utils.StrUtils;
import net.ninemm.base.common.CacheKey;
import net.ninemm.base.common.Consts;
import net.ninemm.base.web.base.BaseController;

import java.util.Map;
import java.util.TreeMap;

/**
 * APP Controller 基类
 *
 * @author Eric.Huang
 * @date 2018-06-29 13:36
 **/

public class BaseAppController extends BaseController {

    private static final Log LOG = Log.getLog(BaseAppController.class);

    private Map<String, Object> responseMap = new TreeMap<String, Object>();

    @NotAction
    public String getUserId() {
        return getJwtPara(Consts.JWT_USER_ID);
    }

    @NotAction
    public String getDataArea() {

        String defaultDataArea = Jboot.me().getCache().get(CacheKey.CACHE_DEALER_DATA_AREA, getUserId());
        String role = Jboot.me().getCache().get(CacheKey.CACHE_LOGINED_USER, getUserId() + ":" + CacheKey.CACHE_KEY_ROLE);
        if (CacheKey.CACHE_MANAGER_ROLE.equals(role)) {
            return defaultDataArea;
        }
        return null;
    }

    /**
     * 设置响应参数
     */
    @NotAction
    protected BaseController setResponseMap(String key, Object value){
        responseMap.put(key, value);
        return this;
    }

    /**
     * 通用的基础数据验证方法(不满足需求的需要在子类中重写)
     * @param map 需要验证的参数
     * @param authentication 是否需要鉴权
     * @return
     * 返回类型：boolean
     */
    @NotAction
    protected boolean validCommonPackge(Map<String, Object> map, boolean authentication) {
        if(null == map || map.isEmpty()){
            return false;
        }
        String version = (String) map.get(Consts.RequestKeys.VERSION);
        if(StrUtils.isBlank(version)){
            return false;
        }
        String platform = (String) map.get(Consts.RequestKeys.PLATFORM);
        if(StrUtils.isBlank(platform)){
            return false;
        }
        String data = (String) map.get(Consts.RequestKeys.DATA);
        if(StrUtils.isBlank(data)){
            return false;
        }

        return true;
    }

}
