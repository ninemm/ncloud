package net.ninemm.survey.controller.survey;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.ImmutableBiMap;
import com.jfinal.aop.Inject;
import com.jfinal.kit.Ret;
import io.jboot.Jboot;
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

import java.util.Date;
import java.util.List;
import java.util.Map;

@RequestMapping(value = "/answerRestrict")
@Api(description = "答题限制", basePath = "/answerRestrict", tags = "", position = 2)
@EnableCORS(allowOrigin = "*", allowHeaders = "Content-Type,Jwt", allowCredentials = "true")
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

    public void updateAnswerRestrict() {
        AnswerRestrict answerRestrict = getRawObject(AnswerRestrict.class);
        answerRestrict.setModifyDate(new Date());
        if (answerRestrictService.update(answerRestrict)) {
            renderJson(Ret.ok());
        } else {
            renderJson(Ret.fail());
        }
    }

    public void updateTimeCondition() {
        TimeCondition timeCondition = getRawObject(TimeCondition.class);
        timeCondition.setModifyDate(new Date());
        if (timeConditionService.update(timeCondition)) {
            renderJson(Ret.ok());
        } else {
            renderJson(Ret.fail());
        }
    }

    public void updateFrequencyCondition() {
        FrequencyCondition frequencyCondition = getRawObject(FrequencyCondition.class);
        frequencyCondition.setModifyDate(new Date());
        if (frequencyConditionService.update(frequencyCondition)) {
            renderJson(Ret.ok());
        } else {
            renderJson(Ret.fail());
        }
    }

    public void updateConsumerAttrCondition() {
        ConsumerAttrCondition consumerAttrCondition = getRawObject(ConsumerAttrCondition.class);
        if (consumerAttrConditionService.update(consumerAttrCondition)) {
            renderJson(Ret.ok());
        } else {
            renderJson(Ret.fail());
        }
    }

    public void deleteTimeConditionById() {
        if (timeConditionService.deleteById(getPara("id"))) {
            renderJson(Ret.ok());
        } else {
            renderJson(Ret.fail());
        }
    }

    public void deleteFrequencyConditionById() {
        if (frequencyConditionService.deleteById(getPara("id"))) {
            renderJson(Ret.ok());
        } else {
            renderJson(Ret.fail());
        }
    }

    public void deleteConsumerAttrConditionById() {
        if (consumerAttrConditionService.deleteById(getPara("id"))) {
            renderJson(Ret.ok());
        } else {
            renderJson(Ret.fail());
        }
    }
}
