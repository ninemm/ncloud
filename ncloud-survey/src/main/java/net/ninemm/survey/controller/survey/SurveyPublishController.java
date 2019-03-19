package net.ninemm.survey.controller.survey;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.ImmutableBiMap;
import com.jfinal.aop.Clear;
import com.jfinal.aop.Inject;
import com.jfinal.kit.Kv;
import com.jfinal.kit.PathKit;
import com.jfinal.kit.Ret;
import com.jfinal.plugin.activerecord.Page;
import io.jboot.Jboot;
import io.jboot.components.mq.Jbootmq;
import io.jboot.db.model.Columns;
import io.jboot.utils.StrUtil;
import io.jboot.web.controller.annotation.RequestMapping;
import io.jboot.web.cors.EnableCORS;
import io.swagger.annotations.Api;
import net.ninemm.base.interceptor.GlobalCacheInterceptor;
import net.ninemm.base.message.MessageAction;
import net.ninemm.survey.controller.BaseAppController;
import net.ninemm.survey.service.api.PublishService;
import net.ninemm.survey.service.api.SendRecordService;
import net.ninemm.survey.service.model.Publish;
import net.ninemm.survey.service.model.SendRecord;
import net.ninemm.upms.interceptor.LogInterceptor;
import net.ninemm.upms.service.api.OptionService;
import net.ninemm.upms.service.api.UserService;
import net.ninemm.upms.service.model.User;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RequestMapping(value = "/surveyPublish")
@Api(description = "问卷发布", basePath = "/surveyPublish", tags = "", position = 2)
@EnableCORS(allowOrigin = "http://localhost:8080", allowHeaders = "Content-Type,Jwt", allowCredentials = "true")
public class SurveyPublishController extends BaseAppController {
    @Inject
    PublishService publishService;
    @Inject
    OptionService optionService;
    @Inject
    SendRecordService sendRecordService;
    @Inject
    UserService userService;

    public void saveOrUpdate() {
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
    }

    public void publish(){
        String surveyId = getPara("surveyId");
        String surveyUrl = getPara("surveyUrl");
        /*if(){//先判断是否有答卷,有答卷的话需要先删除答卷 再删除已发布的问卷

        }*/
        try {
            String url = writeHtml(surveyId,getHtmlCode(surveyUrl));

            User user = userService.findById(getUserId());
            Publish publish = new Publish();
            publish.setOriginalLink(url);
            publish.setSurveyId(surveyId);
            publish.setIsValid(1);
            publish.setType(0);
            publish.setDeptId(user.getDepartmentId());
            publish.setDataArea(user.getDataArea());
            publishService.save(publish);

            renderJson(url);
            return ;
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

    @Clear({GlobalCacheInterceptor.class, LogInterceptor.class})
    public void getSurveyByUrl(){
        JSONObject jo = getRawObject();
        String surveyId = jo.get("surveyId").toString();
        String sendWay = jo.get("sendWay").toString();
        List<String> contact = (List<String>) jo.get("contact");
        sendRecordService.findByColums(surveyId, 3, contact)
        String baseUrl = getBaseUrl();
        redirect(baseUrl+"/Html/123.html");
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
        String surveyId = jo.get("surveyId").toString();
        String sendWay = jo.get("sendWay").toString();
        List<String> contact = (List<String>) jo.get("contact");
        if(contact.size()==0){
            renderJson(Ret.fail());
        }
        Kv kv = new Kv();
        kv.set("surveyId",surveyId);
        kv.set("sendWay",sendWay);
        kv.set("contactList",contact);
        /*判断余额的代码
        *
        *
        *
        * */
        Jboot.sendEvent(MessageAction.SendSurvey.SURVEY_SEND,kv);
        renderJson(Ret.ok());
    }
}
