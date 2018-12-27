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

package net.ninemm.upms.config;

import com.google.inject.Binder;
import com.jfinal.captcha.CaptchaManager;
import com.jfinal.config.Constants;
import com.jfinal.config.Interceptors;
import com.jfinal.config.Routes;
import com.jfinal.template.Engine;
import io.jboot.Jboot;
import io.jboot.aop.jfinal.JfinalHandlers;
import io.jboot.aop.jfinal.JfinalPlugins;
import io.jboot.server.ContextListeners;
import io.jboot.server.JbootServer;
import io.jboot.server.Servlets;
import io.jboot.server.listener.JbootAppListenerBase;
import net.ninemm.base.captcha.CaptchaCache;
import net.ninemm.base.common.AppInfo;
import net.ninemm.base.handler.OptionsHandler;
import net.ninemm.base.interceptor.BusinessExceptionInterceptor;
import net.ninemm.base.interceptor.GlobalCacheInterceptor;
import net.ninemm.base.interceptor.NotNullParaInterceptor;
import net.ninemm.base.plugin.shiro.ShiroCacheUtils;
import net.ninemm.upms.interceptor.LogInterceptor;

/**
 * 应用程序初始化入口
 * @author eric
 */
public class NCloudAppConfigListener extends JbootAppListenerBase {

	@Override
    public void onJfinalConstantConfig(Constants constants) {
    }

    @Override
    public void onJfinalRouteConfig(Routes routes) {
//        routes.setBaseViewPath("/template");
    }

    @Override
    public void onJfinalEngineConfig(Engine engine) {
        engine.setDevMode(true);
        AppInfo app = Jboot.config(AppInfo.class);
        engine.addSharedObject("APP", app);
        engine.addSharedObject("RESOURCE_HOST", app.getResourceHost());
    }

    @Override
    public void onInterceptorConfig(Interceptors interceptors) {
        interceptors.add(new NotNullParaInterceptor("/template/exception.html"));
        interceptors.add(new BusinessExceptionInterceptor("/template/exception.html"));
        interceptors.add(new GlobalCacheInterceptor());
        interceptors.add(new LogInterceptor());
    }

    @Override
    public void onJfinalPluginConfig(JfinalPlugins plugins) {
    }

    @Override
    public void onHandlerConfig(JfinalHandlers handlers) {
        handlers.add(new OptionsHandler());
    }

    @Override
    public void onJFinalStarted() {
    }

    @Override
    public void onJFinalStop() {
    }

    @Override
    public void onJbootStarted() {
        /** 集群模式下验证码使用 redis 缓存 */
        CaptchaManager.me().setCaptchaCache(new CaptchaCache());
        ShiroCacheUtils.clearAuthorizationInfoAll();
    }

    @Override
    public void onAppStartBefore(JbootServer jbootServer) {
    }

    @Override
    public void onJbootDeploy(Servlets servlets, ContextListeners listeners) {

    }

    @Override
    public void onGuiceConfigure(Binder binder) {

    }
	
}
