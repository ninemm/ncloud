package net.ninemm.survey.listener;

import com.jfinal.aop.Inject;
import com.jfinal.kit.Kv;
import io.jboot.components.event.JbootEvent;
import io.jboot.components.event.JbootEventListener;
import io.jboot.components.event.annotation.EventConfig;
import io.jboot.utils.StrUtil;
import net.ninemm.base.common.RegexKey;
import net.ninemm.base.message.MessageAction;
import net.ninemm.base.sms.AlidayuSmsSender;
import net.ninemm.base.utils.ShortUrl;
import net.ninemm.survey.service.api.PublishService;
import net.ninemm.survey.service.api.SendRecordService;
import net.ninemm.survey.service.model.Publish;
import net.ninemm.survey.service.model.SendRecord;

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
        String surveyId = data.get("surveyId").toString();
        String sendWay = data.get("sendWay").toString();
        List<String> contactList = (List<String>) data.get("contactList");

        Publish publish = publishService.findBySurveyId(surveyId);
        if(publish==null && StrUtil.isBlank(publish.getOriginalLink())){
            return;
        }

        if(MessageAction.SendSurvey.MOBILE.equals(sendWay)){
            List<String> alerdySendList = sendRecordService.findByColums(surveyId,3,contactList);
            contactList.removeAll(alerdySendList);
            sendBySms(surveyId,sendWay,publish,contactList);
        }else if(MessageAction.SendSurvey.EMAIL.equals(sendWay)){
            List<String> alerdySendList = sendRecordService.findByColums(surveyId,1,contactList);
            contactList.removeAll(alerdySendList);
            //sendByEmail(surveyId,sendWay,publish,contactList);
        }else if(MessageAction.SendSurvey.WEIXIN.equals(sendWay)){
            //sendByWeixin(surveyId,sendWay,publish,contactList);
        }
    }

    private void sendBySms(String surveyId, String sendWay, Publish publish, List<String> contactList) {
        for (String contact : contactList) {
            if(RegexKey.isMobile(contact)){
                SendRecord sr =new SendRecord();
                sr.setSurveyId(surveyId);
                sr.setSurveyPublishId(publish.getId());
                sr.setOriginalLink(publish.getOriginalLink());
                sr.setType(3);
                sr.setSendTitle("");
                sr.setSendAddress(contact);
                sr.setResendNum(0);
                sr.setDeptId(publish.getDeptId());
                sr.setDataArea(publish.getDataArea());

                String url = ShortUrl.shortUrl(surveyId+ sendWay + contact);
                sr.setShortLink(url);

                String sendResult = AlidayuSmsSender.sendSurvey(contact, url);
                if (sendResult != null && sendResult.contains("alibaba_aliqin_fc_sms_num_send_response") && sendResult.contains("success") && sendResult.contains("true")) {
                    sr.setIsSuccess(1);
                }else{
                    sr.setIsSuccess(2);
                }
                sendRecordService.save(sr);
            }
        }
    }
}
