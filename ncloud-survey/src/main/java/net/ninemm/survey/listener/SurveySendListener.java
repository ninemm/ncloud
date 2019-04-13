package net.ninemm.survey.listener;

import com.jfinal.aop.Inject;
import com.jfinal.kit.Kv;
import io.jboot.components.event.JbootEvent;
import io.jboot.components.event.JbootEventListener;
import io.jboot.components.event.annotation.EventConfig;
import io.jboot.utils.StrUtil;
import net.ninemm.base.message.MessageAction;
import net.ninemm.survey.service.api.PublishService;
import net.ninemm.survey.service.api.SendRecordService;
import net.ninemm.survey.service.model.Publish;
import net.ninemm.survey.surveysend.EmailSurveySend;
import net.ninemm.survey.surveysend.SmsSurveySend;
import net.ninemm.survey.surveysend.SurveySend;
import net.ninemm.survey.surveysend.WeiXinSurveySend;

import java.util.List;

/**
 * @author: lsy
 * @create: 2019-03-01 18:57
 **/
@EventConfig(action = {MessageAction.SendSurvey.SURVEY_SEND})
public class SurveySendListener implements JbootEventListener {
    @Inject
    SendRecordService sendRecordService;
    @Inject
    PublishService publishService;
    @Override
    public void onEvent(JbootEvent event) {
        Kv data = event.getData();
        String surveyId = data.getStr("surveyId");
        Integer sendWay = data.getInt("sendWay");
        Integer ignoreSended = data.getInt("ignoreSended");
        List<String> contactList = (List<String>) data.get("contactList");

        Publish publish = publishService.findBySurveyId(surveyId);
        if(publish==null && StrUtil.isBlank(publish.getOriginalLink())){
            return;
        }
        SurveySend surveySend = null;
        if(MessageAction.SendSurvey.MOBILE==sendWay){
            surveySend= new SmsSurveySend();
        }else if(MessageAction.SendSurvey.EMAIL==sendWay){
            surveySend= new EmailSurveySend();
        }else if(MessageAction.SendSurvey.WEIXIN==sendWay){
            surveySend= new WeiXinSurveySend();
        }
        surveySend.sendSurvey(surveyId,sendWay,publish,ignoreSended,contactList,sendRecordService);
    }
}
