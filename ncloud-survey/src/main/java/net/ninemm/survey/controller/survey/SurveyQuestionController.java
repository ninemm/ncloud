package net.ninemm.survey.controller.survey;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jfinal.aop.Inject;
import com.jfinal.kit.Ret;
import io.jboot.utils.StrUtil;
import io.jboot.web.controller.annotation.RequestMapping;
import io.jboot.web.cors.EnableCORS;
import io.swagger.annotations.Api;
import net.ninemm.survey.controller.BaseAppController;
import net.ninemm.survey.service.api.QuestionService;
import net.ninemm.survey.service.model.Question;
import net.ninemm.upms.service.api.UserService;

import java.util.Date;
import java.util.List;

@RequestMapping(value = "/surveyQuestion")
@Api(description = "问卷题目", basePath = "/surveyQuestion", tags = "", position = 2)
@EnableCORS(allowOrigin = "http://localhost:8080", allowHeaders = "Content-Type,Jwt", allowCredentials = "true")
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

    public void saveQuestions() {
        JSONObject jo = getRawObject();
        String surveyId = jo.getString("surveyId");
        JSONArray questions = jo.getJSONArray("questions");
        List<Question> questionsList = questions.toJavaList(Question.class);
        Boolean res = questionService.saveQuestions(questionsList,surveyId);
        if (res != null) {
            renderJson(Ret.ok());
        } else {
            renderJson(Ret.fail());
        }
    }

    public void findBySurveyId() {
        String surveyId = getPara("surveyId");
        List<Question>  questionList= questionService.findBySurveyId(surveyId);
        renderJson(questionList);
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
