package net.ninemm.survey.surveysend;

import net.ninemm.survey.service.api.SendRecordService;
import net.ninemm.survey.service.model.Publish;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import java.util.List;

/**
 * @author: lsy
 * @create: 2019-03-19 19:16
 **/
public interface SurveySend {
    public void sendSurvey(String surveyId, Integer sendWay, Publish publish , List<String> contactList, SendRecordService sendRecordService);
}
