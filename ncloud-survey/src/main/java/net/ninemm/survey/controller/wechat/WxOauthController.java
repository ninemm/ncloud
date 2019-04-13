package net.ninemm.survey.controller.wechat;

import com.jfinal.aop.Before;
import com.jfinal.aop.Clear;
import com.jfinal.aop.Inject;
import com.jfinal.ext.interceptor.LogInterceptor;
import com.jfinal.kit.HashKit;
import com.jfinal.kit.Kv;
import com.jfinal.kit.StrKit;
import com.jfinal.weixin.sdk.api.*;
import com.jfinal.weixin.sdk.kit.IpKit;
import com.jfinal.weixin.sdk.kit.PaymentKit;
import io.jboot.Jboot;
import io.jboot.utils.StrUtil;
import io.jboot.web.controller.JbootController;
import io.jboot.web.controller.annotation.RequestMapping;
import io.jboot.web.cors.EnableCORS;
import net.ninemm.base.interceptor.GlobalCacheInterceptor;
import net.ninemm.survey.interceptor.WxApiInterceptor;
import net.ninemm.survey.interceptor.WxJsSdkInterceptor;
import net.ninemm.survey.service.api.WxConfigService;
import net.ninemm.survey.service.api.WxUserService;
import net.ninemm.survey.service.model.WxConfig;
import net.ninemm.survey.service.model.WxUser;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
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

    public void index(){
        String url = null;
        String state = getPara("shortUrl");
        if (isWechatBrowser()) {
            String appIdKey = getPara("appIdKey");
            String redirectUri = "http://wxtest.juster.com.cn/wxoauth/callback?appIdKey="+appIdKey;
            url = SnsAccessTokenApi.getAuthorizeURL(appIdKey, redirectUri, state, false);
        }else{
            url="http://wxtest.juster.com.cn/surveyPublish/getSurveyByShortUrl?shortUrl="+state;
        }
        System.out.println(url);
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
        ApiResult userInfo = SnsApi.getUserInfo(snsAccessToken.getAccessToken(), openid);
        if (userInfo.isSucceed()){
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

    // 商户相关资料
    private static String wxappIdKey = "wxcf12086e850e0885";
    // 微信支付分配的商户号
    private static String partner = "1522637501";
    private static String sendName = "武汉珈研";
    //API密钥
    private static String paternerKey = "7322375DFD0D9C1DBE489E93002D889B";
    //微信证书路径
    private static String certPath = "C://apiclient_cert.p12";
    public void sendRedPack(){
        // 接受红包的用户用户在wxappIdKey下的openid
        String reOpenid = "";
        // 商户订单号
        String mchBillno = System.currentTimeMillis() + "";
        String ip = IpKit.getRealIp(getRequest());

        Map<String, String> params = new HashMap<String, String>();
        // 随机字符串
        params.put("nonce_str", System.currentTimeMillis() / 1000 + "");
        // 商户订单号
        params.put("mch_billno", mchBillno);
        // 商户号
        params.put("mch_id", "1522637501");
        // 公众账号ID
        params.put("wxappIdKey", wxappIdKey);
        // 商户名称
        params.put("send_name", sendName);
        // 用户OPENID
        params.put("re_openid", reOpenid);
        // 付款现金(单位分)
        params.put("total_amount", "100");
        // 红包发放总人数
        params.put("total_num", "1");
        // 红包祝福语
        params.put("wishing", "恭喜您....");
        // 终端IP
        params.put("client_ip", ip);
        // 活动名称
        params.put("act_name", "床垫睡眠日活动");
        // 备注
        params.put("remark", "新年新气象");
        //创建签名
        String sign = PaymentKit.createSign(params, paternerKey);
        params.put("sign", sign);

        String xmlResult = RedPackApi.sendRedPack(params, certPath, partner);
        Map<String, String> result = PaymentKit.xmlToMap(xmlResult);
        System.out.println(result);
        //业务结果
        String result_code = result.get("result_code");
        //此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断
        String return_code = result.get("return_code");
        //
        if (StrKit.isBlank(result_code) || !"SUCCESS".equals(result_code)) {
            System.out.println("发送成功");
        } else {
            System.out.println("发送失败");
        }
        renderJson(result);
    }
}
