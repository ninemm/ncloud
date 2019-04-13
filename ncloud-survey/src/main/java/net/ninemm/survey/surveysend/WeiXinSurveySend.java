package net.ninemm.survey.surveysend;

import com.jfinal.aop.Aop;
import com.jfinal.aop.Inject;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.weixin.sdk.api.ApiResult;
import com.jfinal.weixin.sdk.api.TemplateData;
import com.jfinal.weixin.sdk.api.TemplateMsgApi;
import io.jboot.Jboot;
import io.jboot.utils.StrUtil;
import net.ninemm.base.common.RegexKey;
import net.ninemm.base.sms.AlidayuSmsSender;
import net.ninemm.base.utils.DateUtils;
import net.ninemm.base.utils.ShortUrl;
import net.ninemm.survey.service.api.PublishService;
import net.ninemm.survey.service.api.SendRecordService;
import net.ninemm.survey.service.api.SurveyService;
import net.ninemm.survey.service.api.WxUserService;
import net.ninemm.survey.service.model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: lsy
 * @create: 2019-03-19 19:18
 **/
public class WeiXinSurveySend implements  SurveySend {
    private static SurveyService surveyService;
    private static WxUserService wxUserService;

    private static String templeteId;
    private static String templeteUrl;
    @Override
    public void sendSurvey(String surveyId, Integer sendWay, Publish publish,Integer ignoreSended, List<String> contactList, SendRecordService sendRecordService) {
        if(StrUtil.isBlank(templeteId) || StrUtil.isBlank(templeteUrl)){
            String sql ="SELECT option_key,option_value from upms_option where is_system=1 and option_key like '"+SurveySend.WX_TEMPLETE_SENDSURVEY+"%' ";
            List<Record> records = Db.find(sql);
            for (Record record : records) {
                if(SurveySend.WX_TEMPLETE_SENDSURVEY.equals(record.getStr("option_key"))){
                    templeteId = record.getStr("option_value");
                }else if(SurveySend.WX_TEMPLETE_SENDSURVEY_URL.equals(record.getStr("option_key"))){
                    templeteUrl=record.getStr("option_value");
                }
            }
        }

        if(ignoreSended==SurveySend.IGNORESENDED){
            List<String> alerdySendList = sendRecordService.findByColums(surveyId,sendWay,contactList);
            contactList.removeAll(alerdySendList);
        }

        if(surveyService==null){
            surveyService = Aop.get(SurveyService.class);
            //surveyService = Jboot.service(SurveyService.class);
        }
        Survey survey = surveyService.findById(surveyId);
        if(survey==null || Survey.SurveyStatus.PUBLISH.getStatu()!=survey.getStatus()){
            //发送消息
            return;
        }

        TemplateData td = TemplateData.New();
        td.add("first","您收到一个问卷 \n", "#44b549");
        td.add("keyword1", survey.getTitle(), "#44b549");
        td.add("keyword2", DateUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss"), "#44b549");
        td.add("keyword3", "未知 \n", "#44b549");
        td.add("remark", "您有一张待回答的问卷","#44b549");
        td.setTemplate_id(templeteId);

        String appid = null;
        for (String openid : contactList) {
            if(wxUserService==null){
                wxUserService = Aop.get(WxUserService.class);
            }
            if(appid==null){
                WxUser wxuser = wxUserService.findByOpenid(openid);
                appid = wxuser.getAppid();
                if(StrUtil.isBlank(appid)){
                    continue;
                }
            }

            String shortUrl = ShortUrl.shortUrl(surveyId+ sendWay + openid);
            String url=templeteUrl.replace("${shortUrl}", shortUrl).replace("${openId}", openid).replace("${appIdKey}", appid);

            td.setTouser(openid);
            td.setUrl(url);
            String build = td.build();
            ApiResult send = TemplateMsgApi.send(build);

            //记录发送结果
            SendRecord sr =new SendRecord();
            sr.setSurveyId(surveyId);
            sr.setSurveyPublishId(publish.getId());
            sr.setOriginalLink(publish.getOriginalLink());
            sr.setType(sendWay);
            sr.setSendTitle("");
            sr.setSendAddress(openid);
            sr.setResendNum(0);
            sr.setIsAnswered(0);
            sr.setDeptId(publish.getDeptId());
            sr.setDataArea(publish.getDataArea());
            sr.setShortLink(shortUrl);
            if (send.isSucceed()) {
                sr.setIsSuccess(1);
            }else{
                sr.setIsSuccess(0);
            }
            sendRecordService.save(sr);
        }
    }
}
