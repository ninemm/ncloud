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
import io.swagger.annotations.ApiOperation;
import net.ninemm.base.message.MessageAction;
import net.ninemm.survey.controller.BaseAppController;
import net.ninemm.survey.service.api.SurveyService;
import net.ninemm.survey.service.model.Survey;
import net.ninemm.upms.service.api.UserService;
import net.ninemm.upms.service.model.User;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RequestMapping(value = "/survey")
@Api(description = "问卷", basePath = "/survey", tags = "", position = 2)
@EnableCORS(allowOrigin = "http://localhost:8080", allowHeaders = "Content-Type,Jwt", allowCredentials = "true")
public class SurveyController extends BaseAppController {
    @Inject
    SurveyService surveyService;
    @Inject
    UserService userService;

    public void index() {
        String userId = getUserId();
        Columns columns = Columns.create("user_id", userId);
        Page<Survey> page = surveyService.paginateByColumns(getPageNumber(), getPageSize(), columns," create_date desc ");
        Map<String, Object> map = ImmutableBiMap.of("total", page.getTotalRow(), "records", page.getList());
        renderJson(map);
    }

    @ApiOperation(value = "数据字典列表", httpMethod = "GET", notes = "getall")
    public void findAll() {
        List<Survey> allSurvey = surveyService.findAll();
        renderJson(allSurvey);
    }

    public void findById() {
    	JSONObject rawObject = getRawObject();
        Survey surve = surveyService.findById(rawObject.get("id"));
        renderJson(surve);
    }

    /**
     * 多字段查询
     */
    public void findByColum() {
        JSONObject rawObject = getRawObject();

        Columns columns = Columns.create();
        columns.eq("category_id", rawObject.get("categoryId"));
        columns.eq("type", rawObject.get("type"));
        columns.eq("status", rawObject.get("status"));
        columns.likeAppendPercent("title", rawObject.get("title"));
        columns.likeAppendPercent("realname", rawObject.get("realname"));
        columns.like("data_area",rawObject.get("dataArea"));
        columns.ge("create_date",rawObject.get("startDate"));
        columns.le("create_date",rawObject.get("endDate"));

        String orderBy = rawObject.get("orderBy")==null?null:rawObject.get("orderBy").toString();
        if(StrUtil.isBlank(orderBy)){
            orderBy=" create_date desc ";
        }

        Page<Survey> page = surveyService.paginateByColumns(getPageNumber(), getPageSize(), columns,orderBy);
        Map<String, Object> map = ImmutableBiMap.of("total", page.getTotalRow(), "records", page.getList());
        renderJson(map);
    }

    public void saveOrUpdate() {
        Survey survey = getRawObject(Survey.class);
        String userId = getUserId();

        User user = userService.findById(userId);
        if(!StrUtil.isNotEmpty(survey.getId())){
            survey.setDataArea(user.getDataArea());
            survey.setUserId(userId);
            survey.setDeptId(user.getDepartmentId());
            survey.setRealname(user.getRealname());
            survey.setDeptId(user.getDepartmentId());
        }
        survey.setModifyDate(new Date());
        Object result = surveyService.saveOrUpdate(survey);
        if (result != null) {
            renderJson(Ret.ok());
        } else {
            renderJson(Ret.fail());
        }
    }

    public void delete() {
        String id = getPara("id");
    	Survey surve = surveyService.findById(id);
    	if(surve==null){
    		renderJson(Ret.fail());
    		return ;
    	}
        if(surveyService.deleteById(id)){
            Jboot.sendEvent(MessageAction.Survey.SURVEY_DEL,surve);
        }
        renderJson(Ret.ok());
    }
}
