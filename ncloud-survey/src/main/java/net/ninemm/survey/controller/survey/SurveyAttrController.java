package net.ninemm.survey.controller.survey;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.ImmutableBiMap;
import com.jfinal.aop.Inject;
import com.jfinal.kit.Ret;
import com.jfinal.plugin.activerecord.Page;
import io.jboot.Jboot;
import io.jboot.db.model.Columns;
import io.jboot.utils.StrUtil;
import io.jboot.web.controller.annotation.RequestMapping;
import io.jboot.web.cors.EnableCORS;
import io.swagger.annotations.Api;
import net.ninemm.base.message.MessageAction;
import net.ninemm.survey.controller.BaseAppController;
import net.ninemm.survey.service.api.AttrService;
import net.ninemm.survey.service.api.SurveyService;
import net.ninemm.survey.service.model.Attr;
import net.ninemm.survey.service.model.Survey;
import net.ninemm.upms.service.api.UserService;
import net.ninemm.upms.service.model.User;

import java.util.Date;
import java.util.Map;

@RequestMapping(value = "/surveyAttr")
@Api(description = "问卷属性", basePath = "/surveyAttr", tags = "", position = 2)
@EnableCORS(allowOrigin = "http://localhost:8080", allowHeaders = "Content-Type,Jwt", allowCredentials = "true")
public class SurveyAttrController extends BaseAppController {
    @Inject
    AttrService attrService;
    @Inject
    UserService userService;

    public void saveOrUpdate() {
        Attr attr = getRawObject(Attr.class);
        Object result = attrService.saveOrUpdate(attr);
        if (result != null) {
            renderJson(Ret.ok());
        } else {
            renderJson(Ret.fail());
        }
    }
    public void findBySurveyId() {
        String surveyId = getPara("surveyId");
        //JSONObject rawObject = getRawObject();
        Columns columns = Columns.create();
        columns.eq("survey_id", surveyId);

        Page<Attr> page = attrService.paginateByColumns(getPageNumber(), getPageSize(), columns);
        Map<String, Object> map = ImmutableBiMap.of("total", page.getTotalRow(), "records", page.getList());
        renderJson(map);
    }

    public void delete() {
        JSONObject rawObject = getRawObject();
        if(attrService.deleteById(rawObject.get("id"))){
            renderJson(Ret.ok());
            return ;
        }else{
            renderJson(Ret.fail());
        }
    }

    public void deleteBySurveyId() {
        String surveyId = getPara("surveyId");
        attrService.deleteBySurveyId(surveyId);
        renderJson(Ret.ok());
    }
}
