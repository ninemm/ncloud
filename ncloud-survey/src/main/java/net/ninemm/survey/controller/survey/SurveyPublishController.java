package net.ninemm.survey.controller.survey;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.ImmutableBiMap;
import com.jfinal.aop.Before;
import com.jfinal.aop.Clear;
import com.jfinal.aop.Inject;
import com.jfinal.kit.Kv;
import com.jfinal.kit.PathKit;
import com.jfinal.kit.Ret;
import com.jfinal.plugin.activerecord.Page;
import io.jboot.Jboot;
import io.jboot.db.model.Columns;
import io.jboot.utils.StrUtil;
import io.jboot.web.controller.annotation.RequestMapping;
import io.jboot.web.cors.EnableCORS;
import io.swagger.annotations.Api;
import net.ninemm.base.interceptor.GlobalCacheInterceptor;
import net.ninemm.base.interceptor.NotNullPara;
import net.ninemm.base.message.MessageAction;
import net.ninemm.base.utils.ShortUrl;
import net.ninemm.survey.controller.BaseAppController;
import net.ninemm.survey.interceptor.WxJsSdkInterceptor;
import net.ninemm.survey.interceptor.WxUserInterceptor;
import net.ninemm.survey.service.api.*;
import net.ninemm.survey.service.model.*;
import net.ninemm.upms.interceptor.LogInterceptor;
import net.ninemm.upms.service.api.OptionService;
import net.ninemm.upms.service.api.UserService;
import net.ninemm.upms.service.model.User;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

@RequestMapping(value = "/surveyPublish",viewPath="/Html")
@Api(description = "问卷发布", basePath = "/surveyPublish", tags = "", position = 2)
@EnableCORS
public class SurveyPublishController extends BaseAppController {
    @Inject
    PublishService publishService;
    @Inject
    OptionService optionService;
    @Inject
    SurveyService surveyService;
    @Inject
    SendRecordService sendRecordService;
    @Inject
    UserService userService;
    @Inject
    QuestionService questionService;
    @Inject
    WxConfigService wxConfigService;



    /**
    * @Description:  根据问卷id获取问卷发布信息 (获取短链接)
    * @Param: []
    * @return: void
    * @Author: lsy
    * @Date: 2019/4/17
    */
    @NotNullPara(value = "surveyId")
    public void findBySurveyId() {
        Publish publish = publishService.findBySurveyId(getPara("surveyId"));
        if (publish!=null) {
            renderJson(Ret.ok("result",publish).set("url",""));
        }else{
            renderJson(Ret.fail("result","未找到该问卷!"));
        }
    }

    @NotNullPara(value = "surveyId")
    @Clear({GlobalCacheInterceptor.class, LogInterceptor.class})
    public void publishStatic(){
        String surveyId = getPara("surveyId");
        Survey survey = surveyService.findById(surveyId);

        List<Question>  questionList= questionService.findBySurveyId(surveyId);
        if(questionList==null || questionList.size()==0){
            renderJson(Ret.ok("result","问卷中没有题目"));
            return;
        }
        String pageName ="";
        StringBuffer sb = new StringBuffer("{ \"pages\": [");
        for (Question question : questionList) {
            if(question.getPageName().equals(pageName)){
                sb.append(",").append(question.getQuestionInfo());
            }else if(pageName.equals("")){
                pageName=question.getPageName();
                sb.append("{ \"questions\": [").append(question.getQuestionInfo());
            }else{
                sb.append("]},").append("{ \"questions\": [").append(question.getQuestionInfo());
                pageName=question.getPageName();
            }
        }
        sb.append("] }] }");
        setAttr("survey",survey );
        setAttr("questionJson",JSONObject.parse(sb.toString()));
        render("template.html");
    }
    @NotNullPara(value = "surveyId")
    public void publish(){
        String surveyId = getPara("surveyId");
        //静态化页面需要的url
        String surveyUrl = getPara("surveyUrl");
        String appId = getPara("appId");
        //返回结果的url
        String publishUrl = "http://wxtest.juster.com.cn/wxoauth/index?shortUrl=";
        Survey survey = surveyService.findById(surveyId);
        
        //如果问卷是发布状态的话直接回传地址即可
        if (survey.getStatus()== Survey.SurveyStatus.PUBLISH.getStatu()) {
            Publish publish = publishService.findBySurveyId(surveyId);
            if (publish != null && StrUtil.isNotEmpty(publish.getPublishUrl())) {
                renderJson(Ret.ok("result",publish.getPublishUrl()));
                return;
            }
        }
        
        if (!StrUtil.isNotEmpty(appId)) {
            //根据问卷的部门查找对应的微信公众号
            List<WxConfig> wxConfigList = wxConfigService.findByDeptId(survey.getDeptId());
            if (wxConfigList!=null && wxConfigList.size()>0) {
                appId=wxConfigList.get(0).getAppid();
            }else{
                WxConfig wxConfig = wxConfigService.findDefaultConfig();
                appId=wxConfig.getAppid();
            }
        }
        
        /*if(){//先判断是否有答卷,有答卷的话需要先修改问卷状态再删除答卷 再删除已静态化的问卷

        }*/
        try {
            String url = writeHtml(surveyId,getHtmlCode(surveyUrl));
            String shortUrl = ShortUrl.shortUrl(url);
            Publish publish = publishService.findBySurveyId(surveyId);
            if(publish==null){
                publish = new Publish();
            }
            User user = userService.findById(getUserId());
            publish.setOriginalLink(url);
            publish.setSurveyId(surveyId);
            publish.setIsValid(1);
            publish.setType(0);
            publish.setDeptId(user.getDepartmentId());
            publish.setDataArea(user.getDataArea());
            publish.setShortLink(shortUrl);
            publish.setAppid(appId);

            publishUrl+=shortUrl;
            if (StrUtil.isNotEmpty(appId)) {
                publishUrl+="&appIdKey="+appId;
            }
            publish.setPublishUrl(publishUrl);
            publishService.saveOrUpdate(publish);

            survey.setStatus(Survey.SurveyStatus.PUBLISH.getStatu());
            if(!surveyService.update(survey)){
                renderJson(Ret.fail("result","问卷发布失败!"));
                return ;
            }
            renderJson(Ret.ok("result",publishUrl));
            return;
        } catch (Exception e) {
            e.printStackTrace();
            renderJson(Ret.fail());
        }
    }

    private String getHtmlCode(String surveyUrl) {
        String htmlCode = "";
        try {
            InputStream in;
            URL url = new java.net.URL(surveyUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/4.0");
            connection.connect();
            in = connection.getInputStream();
            java.io.BufferedReader breader = new BufferedReader(new InputStreamReader(in, "utf-8"));
            String currentLine;
            while ((currentLine = breader.readLine()) != null) {
                htmlCode += currentLine;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return htmlCode;
    }

    private String writeHtml(String surveyId, String surveyHtmlInfo) {
        String url = null;
        try {
            String filePath = PathKit.getRootClassPath()+"/webapp/Html";
            File folder = new File(filePath);
            if (!folder.exists()) {
                folder.mkdirs();
            }
            File file = new File(filePath+"/"+surveyId+".html");
            if(file.exists()){
                file.delete();
            }
            file.createNewFile();

            FileOutputStream fos = new FileOutputStream(file, true);
            Writer os = new OutputStreamWriter(fos, "utf-8");
            os.write(surveyHtmlInfo);
            os.flush();
            fos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        url="/Html/"+surveyId+".html";
        return url;
    }

    /**
     * @Description: 问卷发送
     * @Param:
     * @return:
     * @Author: lsy
     * @Date: 2019/3/18
     */
    public void sendSurvey(){
        JSONObject jo = getRawObject();
        String surveyId = jo.getString("surveyId");
        List<String> contact = (List<String>) jo.get("contact");
        if(contact.size()==0){
            renderJson(Ret.fail());
        }
        Kv kv = new Kv();
        kv.set("surveyId",surveyId);
        kv.set("contactList",contact);
        kv.set("sendWay",jo.getInteger("sendWay"));
        kv.set("ignoreSended",jo.getInteger("ignoreSended"));
        /*判断余额的代码
        *
        *
        *
        * */
        Jboot.sendEvent(MessageAction.SendSurvey.SURVEY_SEND,kv);
        renderJson(Ret.ok());
    }
    /**
    * @Description:  根据问卷短链接答题
    * @Param:
    * @return:
    * @Author: lsy
    * @Date: 2019/3/26
    */
    @Clear({GlobalCacheInterceptor.class, LogInterceptor.class})
    @Before({WxUserInterceptor.class})
    public void getSurveyByShortUrl(){
        String shortUrl = getPara("shortUrl");
        String openid = getPara("openid");
        String appIdKey = getPara("appIdKey");
        System.out.println(shortUrl+"  "+openid);

        String surveyId = null;
        String originaLink = null;
        String shortLink= "";
        Publish publish = publishService.findByShortUrl(shortUrl);

        //如果不为null则说明不是针对特殊人群答题
        if(publish!=null){
            surveyId=publish.getSurveyId();
            originaLink=publish.getOriginalLink();
            shortLink = publish.getShortLink();
            // 需要考虑是否有限制同一IP只能答题一次规则
            // 考虑是否已到答卷数限制
            // 检测是否设置了密码

        }else{ //(通过短信 邮件 发送的链接答题)
            SendRecord sendRecord = sendRecordService.findByShortUrl(shortUrl);
            if(sendRecord!=null){
                surveyId=sendRecord.getSurveyId();
                originaLink=sendRecord.getOriginalLink();
                if(sendRecord.getIsAnswered()==1){
                    renderJson(Ret.fail("message", "问卷已回答!"));
                    return;
                }
            }else {
                renderJson(Ret.fail("message","对不起找不到该问卷!"));
                return;
            }
            Publish ph = publishService.findBySurveyId(surveyId);
            shortLink = ph.getShortLink();
        }

        String shareUrl = "http://wxtest.juster.com.cn/wxoauth/index?shortUrl="+shortLink;
        if (StrUtil.isNotEmpty(appIdKey)) {
            shareUrl+="&appIdKey="+appIdKey;
        }

        //取出该问卷判断问卷的状态
        Survey survey = surveyService.findById(surveyId);
        if(survey==null || survey.getStatus()!=Survey.SurveyStatus.PUBLISH.getStatu()){
            renderJson(Ret.fail("message","问卷未处于收集中!"));
            return;
        }
        // 检测是否已经到回答时间了 未到回答时间还不能作答 已过回答时间就不能作答
        /*if(){
            待完善
        }*/
        String redirectUrl = originaLink+"?shortUrl="+shortUrl;
        if(StrUtil.isNotBlank(openid)){
            redirectUrl+="&openid="+openid;
        }
        System.out.println(redirectUrl+"&shareUrl="+shareUrl);
        redirect(redirectUrl+"&shareUrl="+shareUrl);
    }

}
