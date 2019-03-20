package net.ninemm.survey.surveysend;

import net.ninemm.base.common.RegexKey;
import net.ninemm.base.sms.AlidayuSmsSender;
import net.ninemm.base.utils.ShortUrl;
import net.ninemm.survey.service.api.SendRecordService;
import net.ninemm.survey.service.model.Publish;
import net.ninemm.survey.service.model.SendRecord;

import java.util.List;

/**
 * @description:
 * @author: lsy
 * @create: 2019-03-19 19:18
 **/
public class SMSsurveySend implements SurveySend {

    @Override
    public void sendSurvey(String surveyId, Integer sendWay,Publish publish, List<String> contactList,SendRecordService sendRecordService) {
        List<String> alerdySendList = sendRecordService.findByColums(surveyId,sendWay,contactList);
        contactList.removeAll(alerdySendList);
        for (String contact : contactList) {
            if(RegexKey.isMobile(contact)){
                SendRecord sr =new SendRecord();
                sr.setSurveyId(surveyId);
                sr.setSurveyPublishId(publish.getId());
                sr.setOriginalLink(publish.getOriginalLink());
                sr.setType(sendWay);
                sr.setSendTitle("");
                sr.setSendAddress(contact);
                sr.setResendNum(0);
                sr.setIsAnswered(0);
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
