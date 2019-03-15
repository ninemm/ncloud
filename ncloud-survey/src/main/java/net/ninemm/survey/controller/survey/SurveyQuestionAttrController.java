package net.ninemm.survey.controller.survey;

import com.jfinal.aop.Inject;
import com.jfinal.kit.Ret;
import io.jboot.utils.StrUtil;
import io.jboot.web.controller.annotation.RequestMapping;
import io.jboot.web.cors.EnableCORS;
import io.swagger.annotations.Api;
import net.ninemm.survey.controller.BaseAppController;
import net.ninemm.survey.service.api.QuestionAttrService;
import net.ninemm.survey.service.model.QuestionAttr;
import net.ninemm.upms.service.api.UserService;

import java.util.Date;
import java.util.List;

@RequestMapping(value = "/surveyQuestionAttr")
@Api(description = "问卷题目", basePath = "/surveyQuestionAttr", tags = "", position = 2)
@EnableCORS(allowOrigin = "http://localhost:8080", allowHeaders = "Content-Type,Jwt", allowCredentials = "true")
public class SurveyQuestionAttrController extends BaseAppController {
    @Inject
    QuestionAttrService questionAttrService;
    @Inject
    UserService userService;

    public void saveOrUpdate() {
        QuestionAttr questionAttr = getRawObject(QuestionAttr.class);
        if(StrUtil.isBlank(questionAttr.getId())){
            questionAttr.setModifyDate(new Date());
        }
        Object result = questionAttrService.saveOrUpdate(questionAttr);
        if (result != null) {
            renderJson(Ret.ok());
        } else {
            renderJson(Ret.fail());
        }
    }

    public void findBySurveyId() {
        String surveyId = getPara("surveyId");
        List<QuestionAttr>  questionAttrList= questionAttrService.findBySurveyId(surveyId);
        renderJson(questionAttrList);
    }

    public void findByQurstionId() {
        String questionId = getPara("questionId");
        List<QuestionAttr>  questionAttrList= questionAttrService.findByQurstionId(questionId);
        renderJson(questionAttrList);
    }

    public void delete() {
        String id = getPara("id");
        if(questionAttrService.deleteById(id)){
            renderJson(Ret.ok());
            return ;
        }else{
            renderJson(Ret.fail());
        }
    }

    public void deleteByQurstionId() {
        String questionId = getPara("questionId");
        questionAttrService.deleteByQuestionId(questionId);
        renderJson(Ret.ok());

    }

    public void deleteBySurveyId() {
        String surveyId = getPara("surveyId");
        questionAttrService.deleteBySurveyId(surveyId);
        renderJson(Ret.ok());
    }
}
