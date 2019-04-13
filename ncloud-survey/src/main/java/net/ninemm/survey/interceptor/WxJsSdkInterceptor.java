package net.ninemm.survey.interceptor;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import com.jfinal.kit.HashKit;
import com.jfinal.kit.Kv;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.ehcache.CacheKit;
import com.jfinal.weixin.sdk.api.ApiConfigKit;
import com.jfinal.weixin.sdk.api.JsTicket;
import com.jfinal.weixin.sdk.api.JsTicketApi;
import com.jfinal.weixin.sdk.api.JsTicketApi.JsApiType;
import io.jboot.Jboot;

public class WxJsSdkInterceptor implements Interceptor {

	public static final String CACHE_NAME = "wechat_jssdk";
	public static final String CACHE_KEY = "wechat_jsapi_ticket";
	
	@Override
	public void intercept(Invocation inv) {
		Controller controller = inv.getController();
		HttpServletRequest request = controller.getRequest();
		String jsapi_ticket = Jboot.getCache().get(CACHE_NAME,CACHE_KEY);
		if (StrKit.isBlank(jsapi_ticket)) {
			JsTicket jsApiTicket = JsTicketApi.getTicket(JsApiType.jsapi);
			jsapi_ticket = jsApiTicket.getTicket();
			Jboot.getCache().put(CACHE_NAME,CACHE_KEY,jsapi_ticket);
		}

		String nonce_str = create_nonce_str();
		String url = request.getRequestURL()+request.getQueryString();
		String timestamp = create_timestamp();

		String str = "jsapi_ticket=" + jsapi_ticket + "&noncestr=" + nonce_str + "&timestamp=" + timestamp + "&url=" + url;

		String signature = HashKit.sha1(str);

		Kv kv =Kv.create();
		kv.set("appId", ApiConfigKit.getApiConfig().getAppId());
		kv.set("nonceStr", nonce_str);
		kv.set("timestamp", timestamp);
		kv.set("url", url);
		kv.set("signature", signature);
		kv.set("jsapi_ticket", jsapi_ticket);

		controller.renderJson(kv);
		inv.invoke();
	}
	
	public static String create_timestamp() {
		return Long.toString(System.currentTimeMillis() / 1000);
	}

	public static String create_nonce_str() {
		return UUID.randomUUID().toString();
	}

}
