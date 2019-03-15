package net.ninemm.survey.controller.survey;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.ImmutableBiMap;
import com.jfinal.aop.Inject;
import com.jfinal.kit.Ret;
import com.jfinal.plugin.activerecord.Page;
import io.jboot.db.model.Columns;
import io.jboot.utils.StrUtil;
import io.jboot.web.controller.annotation.RequestMapping;
import io.jboot.web.cors.EnableCORS;
import io.swagger.annotations.Api;
import net.ninemm.survey.controller.BaseAppController;
import net.ninemm.survey.service.api.PublishService;
import net.ninemm.survey.service.model.Publish;
import net.ninemm.upms.service.api.UserService;
import net.ninemm.upms.service.model.User;

import java.util.Date;
import java.util.Map;

@RequestMapping(value = "/surveyPublish")
@Api(description = "问卷发布", basePath = "/surveyPublish", tags = "", position = 2)
@EnableCORS(allowOrigin = "http://localhost:8080", allowHeaders = "Content-Type,Jwt", allowCredentials = "true")
public class SurveyPublishController extends BaseAppController {
    @Inject
    PublishService publishService;
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
}
