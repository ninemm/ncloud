package net.ninemm.survey.config;

import com.jfinal.aop.Aop;
import com.jfinal.template.Engine;
import com.jfinal.weixin.sdk.api.ApiConfig;
import com.jfinal.weixin.sdk.api.ApiConfigKit;
import io.jboot.Jboot;
import io.jboot.components.mq.Jbootmq;
import io.jboot.core.listener.JbootAppListenerBase;
import net.ninemm.survey.listener.mqListener.MqTest;
import net.ninemm.survey.service.api.WxConfigService;
import net.ninemm.survey.service.model.WxConfig;

import java.util.List;

/**
 * @description:
 * @author: lsy
 * @create: 2019-03-28 11:18
 **/
public class AppStartConfig extends JbootAppListenerBase {

    @Override
    public void onStart() {
        this.putApiConfig();

        Jbootmq mq = Jboot.getMq();
        mq.addMessageListener(new MqTest(),"ncloud-channel");
        mq.startListening();
    }

    private void putApiConfig() {
        WxConfigService wxConfigService = Aop.get(WxConfigService.class);
        List<WxConfig> wxConfigList = wxConfigService.findOpenConfig();
        for (WxConfig wxConfig : wxConfigList) {
            ApiConfig apiConfig=new ApiConfig();
            apiConfig.setAppId(wxConfig.getAppid());
            apiConfig.setAppSecret(wxConfig.getAppsecret());
            apiConfig.setToken(wxConfig.getToken());
            if(wxConfig.getMessageencrypt()==1){
                apiConfig.setEncryptMessage(true);
                apiConfig.setEncodingAesKey(wxConfig.getEncodingaeskey());
            }
            ApiConfigKit.putApiConfig(apiConfig);

        }
    }
}
