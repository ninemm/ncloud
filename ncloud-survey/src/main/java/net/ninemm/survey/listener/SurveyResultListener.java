package net.ninemm.survey.listener;

import com.alibaba.fastjson.JSONObject;
import com.jfinal.aop.Inject;
import eu.bitwalker.useragentutils.UserAgent;
import io.jboot.components.event.JbootEvent;
import io.jboot.components.event.JbootEventListener;
import io.jboot.components.event.annotation.EventConfig;
import io.jboot.utils.StrUtil;
import net.ninemm.base.message.MessageAction;
import net.ninemm.base.utils.BroswerUtils;
import net.ninemm.base.utils.GaoDeUtils;
import net.ninemm.survey.service.api.*;
import net.ninemm.survey.service.model.*;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author: lsy
 * @create: 2019-04-12 18:57
 **/
@EventConfig(action = {MessageAction.saveSurveyResult.SURVEY_RESULT_SAVE})
public class SurveyResultListener implements JbootEventListener {
    @Inject
    SendRecordService sendRecordService;
    @Inject
    PublishService publishService;
    @Inject
    AnswerSheetService answerSheetService;
    @Inject
    AnswerService answerService;
    @Inject
    AnswerValueService answerValueService;
    @Override
    public void onEvent(JbootEvent event) {
        Map<String, Object> map= event.getData();
        JSONObject jsonObject = new JSONObject(map);

        JSONObject result = jsonObject.getJSONObject("result");
        Double lat = jsonObject.getDouble("lat");
        Double lng = jsonObject.getDouble("lng");
        String userAgent = jsonObject.getString("userAgent");
        String surveyUrl = jsonObject.getString("surveyUrl");
        String openid = jsonObject.getString("openid");
        String shortUrl = jsonObject.getString("shortUrl");
        String answerSheetId = StrUtil.uuid();
        String surveyId = null;
        Integer answerSheetFrom = 0;
        JSONObject addresJson = GaoDeUtils.getAddresJson("792626a8e422ea6fc7bc2ead87661b78", lng, lat);

        SendRecord sendRecord = sendRecordService.findByShortUrl(shortUrl);
        if (sendRecord!=null) {//如果为null说明不是通过短信 微信 邮件方式发送给的
            surveyId = sendRecord.getSurveyId();
            answerSheetFrom=sendRecord.getType();
        }else {
            Publish publish = publishService.findByShortUrl(shortUrl);
            surveyId=publish.getSurveyId();
        }
        UserAgent ua =new UserAgent(userAgent);
        //暂时未使用的字段 start_time,end_time,total_score,shorturl,params.consumer_id,remark
        AnswerSheet answerSheet = new AnswerSheet();
        answerSheet.setId(answerSheetId);
        answerSheet.setSurveyId(surveyId);
        answerSheet.setUserId(openid);
        answerSheet.setIp(jsonObject.getString("ip"));
        answerSheet.setLat(new BigDecimal(lat));
        answerSheet.setLon(new BigDecimal(lng));
        answerSheet.setProvince(addresJson.getString("province"));
        answerSheet.setCity(addresJson.getString("city"));
        answerSheet.setCountry(addresJson.getString("district"));
        answerSheet.setAddress(addresJson.getString("address"));
        answerSheet.setIsValid(0);
        answerSheet.setIsBreakPoint(0);
        answerSheet.setBrowserType(BroswerUtils.getUserAgentType(userAgent));
        answerSheet.setOsType(ua.getOperatingSystem().toString());
        answerSheet.setIsPreSubmit(0);
        answerSheet.setAnswerSheetFrom(answerSheetFrom);
        answerSheet.setTotalScore(new BigDecimal(0));
        answerSheet.setShorturl(shortUrl);
        answerSheet.save();

       /* //questionid order_list score row_option_id row_option_order col_option_id col_option_order list_option_id option_value  is_correct待处理
        AnswerValue answerValue = new AnswerValue();
        answerValue.setId(StrUtil.uuid());
        answerValue.setSurveyId(surveyId);
        answerValue.setAnswerSheetId(answerSheetId);
        answerValue.save();

        // question_id category sub_category score
        Answer answer = new Answer();
        answer.setId(StrUtil.uuid());
        answer.setSurveyId(surveyId);
        answer.setAnswerSheetId(answerSheetId);*/

    }
}
