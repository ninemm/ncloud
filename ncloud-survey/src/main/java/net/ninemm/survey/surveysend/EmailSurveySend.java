package net.ninemm.survey.surveysend;

import com.jfinal.aop.Inject;
import net.ninemm.base.common.RegexKey;
import net.ninemm.base.sms.AlidayuSmsSender;
import net.ninemm.base.utils.ShortUrl;
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
    public void sendSurvey(String surveyId, Integer sendWay, Publish publish, List<String> contactList, SendRecordService sendRecordService) {

    }
}
