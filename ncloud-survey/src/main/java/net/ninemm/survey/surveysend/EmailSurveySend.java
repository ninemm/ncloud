package net.ninemm.survey.surveysend;

import com.jfinal.aop.Inject;
import net.ninemm.base.common.RegexKey;
import net.ninemm.base.sms.AlidayuSmsSender;
import net.ninemm.base.utils.ShortUrl;
import net.ninemm.commons.email.Email;
import net.ninemm.survey.service.api.PublishService;
import net.ninemm.survey.service.api.SendRecordService;
import net.ninemm.survey.service.model.Publish;
import net.ninemm.survey.service.model.SendRecord;

import java.util.List;

/**
 * @description:
 * @author: lsy
 * @create: 2019-03-19 19:18
 **/
public class EmailSurveySend implements  SurveySend {

    @Override
    public void sendSurvey(String surveyId, Integer sendWay, Publish publish,Integer ignoreSended, List<String> contactList, SendRecordService sendRecordService) {
        Email email = Email.create().subject(Email.SUBJECT);
        if(ignoreSended==SurveySend.IGNORESENDED){
            List<String> alerdySendList = sendRecordService.findByColums(surveyId,sendWay,contactList);
            contactList.removeAll(alerdySendList);
        }

        for (String contact : contactList) {
            if(RegexKey.isEmail(contact)){
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
                email.content(url).to(contact).send();

                sr.setIsSuccess(1);
                sendRecordService.save(sr);
            }
        }
    }
}
