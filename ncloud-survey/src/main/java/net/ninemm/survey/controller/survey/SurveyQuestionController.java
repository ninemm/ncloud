package net.ninemm.survey.controller.survey;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jfinal.aop.Inject;
import com.jfinal.kit.Ret;
import io.jboot.utils.StrUtil;
import io.jboot.web.controller.annotation.RequestMapping;
import io.jboot.web.cors.EnableCORS;
import io.swagger.annotations.Api;
import net.ninemm.base.interceptor.NotNullPara;
import net.ninemm.survey.controller.BaseAppController;
import net.ninemm.survey.service.api.QuestionService;
import net.ninemm.survey.service.model.Question;
import net.ninemm.upms.service.api.UserService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequestMapping(value = "/surveyQuestion")
@Api(description = "问卷题目", basePath = "/surveyQuestion", tags = "", position = 2)
@EnableCORS
public class SurveyQuestionController extends BaseAppController {
    @Inject
    QuestionService questionService;
    @Inject
    UserService userService;

    public void saveOrUpdate() {
        Question question = getRawObject(Question.class);
        if(StrUtil.isBlank(question.getId())){
            question.setModifyDate(new Date());
        }
        Object result = questionService.saveOrUpdate(question);
        if (result != null) {
            renderJson(Ret.ok());
        } else {
            renderJson(Ret.fail());
        }
    }
    /**
    * @Description:  保存问卷题目信息
    * @Param: []
    * @return: void
    * @Author: lsy
    * @Date: 2019/4/16
    */
    public void saveQuestions() {
        JSONObject jo = getRawObject();
        String surveyId = jo.getString("surveyId");
        JSONArray pages = jo.getJSONObject("surveyinfo").getJSONArray("pages");
        Boolean res =  questionService.saveQuestion(pages,surveyId);
        if (res != null) {
            renderJson(Ret.ok());
        } else {
            renderJson(Ret.fail());
        }
    }

    /**
    * @Description:  设计问卷的时候获取之前保存的问卷信息
    * @Param: []
    * @return: void
    * @Author: lsy
    * @Date: 2019/4/16
    */
    public void getQuestions(){
        String surveyId = getPara("surveyId");
        List<Question>  questionList= questionService.findBySurveyId(surveyId);
        if(questionList==null || questionList.size()==0){
            renderJson(Ret.fail("result","请先保存问卷"));
            return;
        }
        String pageName ="";
        StringBuffer sb = new StringBuffer("{ \"pages\": [");
        for (Question question : questionList) {
            if(question.getPageName().equals(pageName)){
                sb.append(",").append(question.getQuestionInfo());
            }else if(pageName.equals("")){
                pageName=question.getPageName();
                sb.append("{\"name\":\"").append(pageName).append("\",").append("\"elements\": [").append(question.getQuestionInfo());
            }else{
                pageName=question.getPageName();
                sb.append("]},").append("{\"name\":\"").append(pageName).append("\",").append("\"elements\": [").append(question.getQuestionInfo());
            }
        }
        sb.append("] }] }");

        renderJson(Ret.ok("result",JSONObject.parse(sb.toString())));
    }

    /**
    * @Description:  问卷预览
    * @Param: []
    * @return: void
    * @Author: lsy
    * @Date: 2019/4/16
    */
    @NotNullPara(value = "surveyId")
    public void findBySurveyId() {
        String surveyId = getPara("surveyId");
        List<Question>  questionList= questionService.findBySurveyId(surveyId);
        if(questionList==null || questionList.size()==0){
            renderJson(Ret.fail("result","请先保存问卷"));
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
        renderJson(Ret.ok("result",JSONObject.parse(sb.toString())));
    }

    public void delete() {
        String id = getPara("id");
        if(questionService.deleteById(id)){
            renderJson(Ret.ok());
            return ;
        }else{
            renderJson(Ret.fail());
        }
    }

    public void deleteBySurveyId() {
        String surveyId = getPara("surveyId");
        questionService.deleteBySurveyId(surveyId);
        renderJson(Ret.ok());
    }
}
