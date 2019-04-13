package net.ninemm.survey.controller.wechat;

import com.jfinal.aop.Before;
import com.jfinal.aop.Clear;
import com.jfinal.core.NotAction;
import com.jfinal.ext.interceptor.LogInterceptor;
import com.jfinal.kit.HttpKit;
import com.jfinal.kit.StrKit;
import com.jfinal.log.Log;
import com.jfinal.weixin.iot.msg.InEquDataMsg;
import com.jfinal.weixin.iot.msg.InEqubindEvent;
import com.jfinal.weixin.sdk.api.ApiConfigKit;
import com.jfinal.weixin.sdk.api.ApiResult;
import com.jfinal.weixin.sdk.jfinal.MsgInterceptor;
import com.jfinal.weixin.sdk.kit.MsgEncryptKit;
import com.jfinal.weixin.sdk.msg.InMsgParser;
import com.jfinal.weixin.sdk.msg.in.*;
import com.jfinal.weixin.sdk.msg.in.card.*;
import com.jfinal.weixin.sdk.msg.in.event.*;
import com.jfinal.weixin.sdk.msg.in.speech_recognition.InSpeechRecognitionResults;
import com.jfinal.weixin.sdk.msg.out.OutMsg;
import com.jfinal.weixin.sdk.msg.out.OutTextMsg;
import io.jboot.web.controller.annotation.RequestMapping;
import io.jboot.web.cors.EnableCORS;
import io.jboot.wechat.controller.JbootWechatController;
import io.swagger.annotations.Api;
import net.ninemm.base.interceptor.GlobalCacheInterceptor;

/**
 * @description:
 * @author: lsy
 * @create: 2019-03-28 16:33
 **/
@Deprecated
@RequestMapping(value = "/wxLogin")
@Clear({GlobalCacheInterceptor.class, LogInterceptor.class})
public class WechateController extends JbootWechatController {

    @Override
    public Object doGetUserByOpenId(String openid) {
        return null;
    }

    @Override
    public Object doSaveOrUpdateUserByApiResult(ApiResult apiResult) {
        return null;
    }
}
