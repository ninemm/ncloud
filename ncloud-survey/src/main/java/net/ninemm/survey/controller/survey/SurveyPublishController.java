package net.ninemm.survey.controller.survey;

import com.alibaba.fastjson.JSONObject;
import com.jfinal.aop.Before;
import com.jfinal.aop.Clear;
import com.jfinal.aop.Inject;
import com.jfinal.kit.Kv;
import com.jfinal.kit.PathKit;
import com.jfinal.kit.Ret;
import io.jboot.Jboot;
import io.jboot.utils.StrUtil;
import io.jboot.web.controller.annotation.RequestMapping;
import io.jboot.web.cors.EnableCORS;
import io.swagger.annotations.Api;
import net.ninemm.base.interceptor.GlobalCacheInterceptor;
import net.ninemm.base.message.MessageAction;
import net.ninemm.base.utils.ShortUrl;
import net.ninemm.survey.controller.BaseAppController;
import net.ninemm.survey.interceptor.WxJsSdkInterceptor;
import net.ninemm.survey.interceptor.WxUserInterceptor;
import net.ninemm.survey.service.api.PublishService;
import net.ninemm.survey.service.api.SendRecordService;
import net.ninemm.survey.service.api.SurveyService;
import net.ninemm.survey.service.model.Publish;
import net.ninemm.survey.service.model.SendRecord;
import net.ninemm.survey.service.model.Survey;
import net.ninemm.upms.interceptor.LogInterceptor;
import net.ninemm.upms.service.api.OptionService;
import net.ninemm.upms.service.api.UserService;
import net.ninemm.upms.service.model.User;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@RequestMapping(value = "/surveyPublish")
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

    /*public void saveOrUpdate() {
        Publish publish = getRawObject(Publish.class);
        if(StrUtil.isBlank(publish.getId())){
            User user = userService.findById(getUserId());
            publish.setDeptId(user.getDepartmentId());
            publish.setDataArea(user.getDataArea());
        }
        publish.setModifyDate(new Date());
        Object result = publishService.saveOrUpdate(publish);
        if (result != null) {
            renderJson(Ret.ok());
        } else {
            renderJson(Ret.fail());
        }
    }
    public void findBySurveyId() {
        JSONObject rawObject = getRawObject();
        Columns columns = Columns.create();
        columns.eq("survey_id", rawObject.get("surveyId"));

        Page<Publish> page = publishService.paginateByColumns(getPageNumber(), getPageSize(), columns);
        Map<String, Object> map = ImmutableBiMap.of("total", page.getTotalRow(), "records", page.getList());
        renderJson(map);
    }

    public void delete() {
        String id = getPara("id");
        if(publishService.deleteById(id)){
            renderJson(Ret.ok());
            return ;
        }else{
            renderJson(Ret.fail());
        }
    }

    public void deleteBySurveyId() {
        String surveyId = getPara("surveyId");
        publishService.deleteBySurveyId(surveyId);
        renderJson(Ret.ok());
    }*/

    public void publish(){
        String surveyId = getPara("surveyId");
        String surveyUrl = getPara("surveyUrl");
        Survey survey = new Survey();
        survey.setId(surveyId);

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
            publishService.saveOrUpdate(publish);

            /*//往发送记录里面插入一条数据
            SendRecord sr =new SendRecord();
            sr.setSurveyId(surveyId);
            sr.setSurveyPublishId(publish.getId());
            sr.setOriginalLink(url);
            sr.setType(0);
            sr.setSendTitle("");
            sr.setSendAddress("");
            sr.setResendNum(0);
            sr.setIsAnswered(0);
            sr.setDeptId(publish.getDeptId());
            sr.setDataArea(publish.getDataArea());
            sr.setIsSuccess(1);
            sendRecordService.save(sr);*/

            survey.setStatus(Survey.SurveyStatus.PUBLISH.getStatu());
            if(!surveyService.update(survey)){
                renderJson(Ret.fail("result","问卷发布失败!"));
                return ;
            }
            renderJson(Ret.ok("result",getBaseUrl()+"/surveyPublish/getSurveyByShortUrl?shortUrl="+shortUrl));
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
        System.out.println(shortUrl+"  "+openid);

        String surveyId = null;
        String originaLink = null;
        Publish publish = publishService.findByShortUrl(shortUrl);
        //如果不为null则说明不是针对特殊人群答题
        if(publish!=null){
            surveyId=publish.getSurveyId();
            originaLink=publish.getOriginalLink();
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
        System.out.println(redirectUrl);
        redirect(redirectUrl);
    }

}
