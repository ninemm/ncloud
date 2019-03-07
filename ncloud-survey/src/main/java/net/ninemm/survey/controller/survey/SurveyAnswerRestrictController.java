package net.ninemm.survey.controller.survey;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.ImmutableBiMap;
import com.jfinal.aop.Inject;
import com.jfinal.kit.Ret;
import com.jfinal.plugin.activerecord.Page;
import io.jboot.Jboot;
import io.jboot.db.model.Columns;
import io.jboot.web.controller.annotation.RequestMapping;
import io.jboot.web.cors.EnableCORS;
import io.swagger.annotations.Api;
import net.ninemm.base.message.MessageAction;
import net.ninemm.survey.controller.BaseAppController;
import net.ninemm.survey.service.api.AnswerRestrictService;
import net.ninemm.survey.service.api.ConsumerAttrConditionService;
import net.ninemm.survey.service.api.FrequencyConditionService;
import net.ninemm.survey.service.api.TimeConditionService;
import net.ninemm.survey.service.model.AnswerRestrict;
import net.ninemm.survey.service.model.ConsumerAttrCondition;
import net.ninemm.survey.service.model.FrequencyCondition;
import net.ninemm.survey.service.model.TimeCondition;
import net.ninemm.upms.service.api.UserService;
import net.ninemm.upms.service.model.User;

import javax.json.Json;
import javax.json.JsonObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping(value = "/answerRestrict")
@Api(description = "答题限制", basePath = "/answerRestrict", tags = "", position = 2)
@EnableCORS(allowOrigin = "http://localhost:8080", allowHeaders = "Content-Type,Jwt", allowCredentials = "true")
public class SurveyAnswerRestrictController extends BaseAppController {
    @Inject
    AnswerRestrictService answerRestrictService;
    @Inject
    TimeConditionService timeConditionService;
    @Inject
    FrequencyConditionService frequencyConditionService;
    @Inject
    ConsumerAttrConditionService consumerAttrConditionService;
    @Inject
    UserService userService;

    public void save() {
        AnswerRestrict answerRestrict = getRawObject(AnswerRestrict.class);
        JSONObject rawObject = getRawObject();
        String userId = getUserId();
        User users = userService.findById(userId);
        Boolean res = answerRestrictService.saveAnswerLimit(answerRestrict,rawObject,users.getDepartmentId(), users.getDataArea());

        if (res) {
            renderJson(Ret.ok());
        } else {
            renderJson(Ret.fail());
        }
    }

    public void update() {
        AnswerRestrict answerRestrict = getRawObject(AnswerRestrict.class);
        JSONObject rawObject = getRawObject();

        String userId = getUserId();
        User users = userService.findById(userId);

        Boolean res = answerRestrictService.saveAnswerLimit(answerRestrict,rawObject,users.getDepartmentId(), users.getDataArea());

        if (res) {
            renderJson(Ret.ok());
        } else {
            renderJson(Ret.fail());
        }
    }

    public void findBySurveyId() {
        String surveyId = getPara("surveyId");
        AnswerRestrict answerRestrict = answerRestrictService.findBySurveyId(surveyId);
        String answerRestrictId = answerRestrict.getId();

        List<TimeCondition> timeConditions = timeConditionService.findByRestrictId(answerRestrictId);
        List<FrequencyCondition> frequencyConditions = frequencyConditionService.findByRestrictId(answerRestrictId);
        List<ConsumerAttrCondition> consumerAttrConditionS = consumerAttrConditionService.findByRestrictId(answerRestrictId);

        Map<String, Object> map = ImmutableBiMap.of("answerRestrict", answerRestrict,"timeConditions",timeConditions,"frequencyConditions",frequencyConditions,"consumerAttrConditionS",consumerAttrConditionS);
        renderJson(map);
    }

    public void delete() {
        String id = getPara("id");
        if(answerRestrictService.deleteById(id)){
            Jboot.sendEvent(MessageAction.Survey.SURVEY_ANSWER_RESTRICT_DEL,id);
            renderJson(Ret.ok());
            return ;
        }else{
            renderJson(Ret.fail());
        }
    }

    public void deleteBySurveyId() {
        String surveyId = getPara("surveyId");
        if(answerRestrictService.deleteBySurveyId(surveyId)){
            renderJson(Ret.ok());
            return ;
        }else{
            renderJson(Ret.fail());
        }
    }
}
