package net.ninemm.survey.interceptor;

import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import com.jfinal.kit.StrKit;
import com.jfinal.weixin.sdk.api.ApiResult;
import com.jfinal.weixin.sdk.api.UserApi;
import io.jboot.utils.StrUtil;
import net.ninemm.survey.service.api.WxUserService;
import net.ninemm.survey.service.model.WxUser;

import java.util.Map;

/**
 * @description: 拦截器 所有微信用户操作之前先将用户的信息存储到数据库
 * @author: lsy
 * @create: 2019-03-28 18:26
 **/
public class WxUserInterceptor implements Interceptor {
    @Inject
    WxUserService wxUserService;

    @Override
    public void intercept(Invocation inv) {
        Controller controller = inv.getController();

        //开发者中心配置时跳过该拦截器
        if(StrKit.notBlank(controller.getPara("echostr"))){
            inv.invoke();
            return;
        }
        //openid为空时跳过该拦截器
        String openid = controller.getPara("openid");
        if (StrUtil.isBlank(openid)) {
            inv.invoke();
            return;
        }

        String appIdKey = controller.getPara("appIdKey");
        WxUser wxuser = wxUserService.findByOpenid(openid);
        if(wxuser==null){
            wxuser=new WxUser();
            ApiResult apiResult = UserApi.getUserInfo(openid);
            if (apiResult.isSucceed() && apiResult.getInt("subscribe")==1){
                wxuser.setId(StrUtil.uuid());
                wxuser.setSubscribe(apiResult.getInt("subscribe"));
                wxuser.setNickname((apiResult.getStr("nickname")));
                wxuser.setSex(apiResult.getInt("sex"));
                wxuser.setCity(apiResult.getStr("city"));
                wxuser.setProvince(apiResult.getStr("province"));
                wxuser.setCountry(apiResult.getStr("country"));
                wxuser.setHeadimgurl(apiResult.getStr("headimgurl"));
                wxuser.setUnionid(apiResult.getStr("unionid"));
                wxuser.setOpenid(openid);
                wxuser.setAppid(appIdKey);
                wxuser.save();
            }
        }
        inv.invoke();
    }
}
