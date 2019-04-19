package net.ninemm.survey.controller.wechat;

import com.jfinal.aop.Before;
import com.jfinal.aop.Clear;
import com.jfinal.aop.Inject;
import com.jfinal.ext.interceptor.LogInterceptor;
import com.jfinal.kit.HashKit;
import com.jfinal.kit.Kv;
import com.jfinal.kit.StrKit;
import com.jfinal.weixin.sdk.api.*;
import io.jboot.Jboot;
import io.jboot.utils.StrUtil;
import io.jboot.web.controller.JbootController;
import io.jboot.web.controller.annotation.RequestMapping;
import net.ninemm.base.interceptor.GlobalCacheInterceptor;
import net.ninemm.survey.interceptor.WxApiInterceptor;
import net.ninemm.survey.interceptor.WxJsSdkInterceptor;
import net.ninemm.survey.service.api.PublishService;
import net.ninemm.survey.service.api.WxConfigService;
import net.ninemm.survey.service.api.WxUserService;
import net.ninemm.survey.service.model.Publish;
import net.ninemm.survey.service.model.WxConfig;
import net.ninemm.survey.service.model.WxUser;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @description:
 * @author: lsy
 * @create: 2019-03-29 16:35
 **/
@RequestMapping(value = "/wxoauth")
@Clear({GlobalCacheInterceptor.class, LogInterceptor.class})
public class WxOauthController extends JbootController {
    @Inject
    WxConfigService wxConfigService;
    @Inject
    WxUserService wxUserService;
    @Inject
    PublishService publishService;

    public void index(){
        String url = null;
        String state = getPara("shortUrl");
        if (isWechatBrowser()) {
            String appIdKey = getPara("appIdKey");
            if (!StrUtil.isNotEmpty(appIdKey)) {
                //先查看发布问卷时有没有记录问卷的公众号归属 如果没有则归属到默认公众号
                Publish publish = publishService.findByShortUrl(state);
                if (StrUtil.isNotEmpty(publish.getAppid())) {
                    appIdKey=publish.getAppid();
                }else{
                    WxConfig wxconfig = wxConfigService.findDefaultConfig();
                    appIdKey = wxconfig.getAppid();
                }
            }
            String redirectUri = "http://wxtest.juster.com.cn/wxoauth/callback?appIdKey="+appIdKey;
            url = SnsAccessTokenApi.getAuthorizeURL(appIdKey, redirectUri, state, false);
        }else{
            url="http://wxtest.juster.com.cn/surveyPublish/getSurveyByShortUrl?shortUrl="+state;
        }
        redirect(url);
    }

    @Before(WxApiInterceptor.class)
    public void callback(){

        String code = getPara("code");
        String state = getPara("state");
        String appIdKey = getPara("appIdKey");
        String url="http://wxtest.juster.com.cn/surveyPublish/getSurveyByShortUrl?shortUrl="+state;
        WxConfig wxConfig = wxConfigService.findByAppId(appIdKey);

        SnsAccessToken snsAccessToken = SnsAccessTokenApi.getSnsAccessToken(appIdKey, wxConfig.getAppsecret(), code);
        if(snsAccessToken.isAvailable()){
            String openid = snsAccessToken.getOpenid();
            saveWxUser(snsAccessToken,openid,appIdKey);
            url = url+"&openid="+openid+"&appIdKey="+appIdKey;
        }
        redirect(url);
    }

    private void saveWxUser(SnsAccessToken snsAccessToken,String openid,String appIdKey) {
        WxUser wxuser = wxUserService.findByOpenid(openid);
        if (wxuser==null) {
            wxuser=new WxUser();
            ApiResult userInfo = SnsApi.getUserInfo(snsAccessToken.getAccessToken(), openid);
            wxuser.setId(StrUtil.uuid());
            wxuser.setSubscribe(userInfo.getInt("subscribe"));
            wxuser.setNickname((userInfo.getStr("nickname")));
            wxuser.setSex(userInfo.getInt("sex"));
            wxuser.setCity(userInfo.getStr("city"));
            wxuser.setProvince(userInfo.getStr("province"));
            wxuser.setCountry(userInfo.getStr("country"));
            wxuser.setHeadimgurl(userInfo.getStr("headimgurl"));
            wxuser.setUnionid(userInfo.getStr("unionid"));
            wxuser.setOpenid(openid);
            wxuser.setAppid(appIdKey);
            wxuser.save();
        }
    }

    /**
    * @Description:  微信网页授权获取jssdk
    * @Param:
    * @return:
    * @Author: lsy
    * @Date: 2019/4/10
    */
    public void getJsSdk(){
        String jsapi_ticket = Jboot.getCache().get(WxJsSdkInterceptor.CACHE_NAME,WxJsSdkInterceptor.CACHE_KEY);
        if (StrKit.isBlank(jsapi_ticket)) {
            JsTicket jsApiTicket = JsTicketApi.getTicket(JsTicketApi.JsApiType.jsapi);
            jsapi_ticket = jsApiTicket.getTicket();
            Jboot.getCache().put(WxJsSdkInterceptor.CACHE_NAME,WxJsSdkInterceptor.CACHE_KEY,jsapi_ticket,3600);
        }

        String nonce_str = WxJsSdkInterceptor.create_nonce_str();
        // 注意 URL 一定要动态获取，不能 hardcode.
        Map<String, String[]> paraMap = getParaMap();
        HttpServletRequest request = getRequest();
        String url=getPara("url");
        String timestamp = WxJsSdkInterceptor.create_timestamp();

        String str = "jsapi_ticket=" + jsapi_ticket + "&noncestr=" + nonce_str + "&timestamp=" + timestamp + "&url="  + url;
        String signature = HashKit.sha1(str);
        Kv kv =Kv.create();
        kv.set("appId", ApiConfigKit.getApiConfig().getAppId());
        kv.set("nonceStr", nonce_str);
        kv.set("timestamp", timestamp);
        kv.set("url", url);
        kv.set("signature", signature);
        kv.set("jsapi_ticket", jsapi_ticket);
        renderJson(kv);
    }
}
