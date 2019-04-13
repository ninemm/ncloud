package net.ninemm.survey.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import com.jfinal.weixin.sdk.api.ApiConfigKit;
import com.jfinal.weixin.sdk.jfinal.ApiController;
import com.jfinal.weixin.sdk.jfinal.ApiInterceptor;
import com.jfinal.weixin.sdk.jfinal.AppIdParser;

/**
 * @description:
 * @author: lsy
 * @create: 2019-04-01 14:29
 **/
public class WxApiInterceptor implements Interceptor {
    @Override
    public void intercept(Invocation inv) {
        Controller controller = inv.getController();
        try {
            String appIdKey = controller.getPara("appIdKey");
            ApiConfigKit.setThreadLocalAppId(appIdKey);
            inv.invoke();
        } finally {
            ApiConfigKit.removeThreadLocalAppId();

        }
    }
}
