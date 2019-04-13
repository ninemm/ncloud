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
    public static final String WX_TEMPLETE_SENDSURVEY="wx_templete_sendsurvey";
    public static final String WX_TEMPLETE_SENDSURVEY_URL="wx_templete_sendsurvey_url";
    public static final int IGNORESENDED=1;

    public void sendSurvey(String surveyId, Integer sendWay, Publish publish ,Integer ignoreSended, List<String> contactList, SendRecordService sendRecordService);
}
