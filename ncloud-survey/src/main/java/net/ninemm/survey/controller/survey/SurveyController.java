package net.ninemm.survey.controller.survey;

import cn.hutool.system.SystemUtil;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.ImmutableBiMap;
import com.jfinal.aop.Clear;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.kit.PathKit;
import com.jfinal.kit.Ret;
import com.jfinal.plugin.activerecord.Page;
import io.jboot.Jboot;
import io.jboot.db.model.Columns;
import io.jboot.utils.StrUtil;
import io.jboot.web.controller.JbootController;
import io.jboot.web.controller.annotation.RequestMapping;
import io.jboot.web.cors.EnableCORS;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.ninemm.base.interceptor.GlobalCacheInterceptor;
import net.ninemm.base.message.MessageAction;
import net.ninemm.survey.controller.BaseAppController;
import net.ninemm.survey.service.api.*;
import net.ninemm.survey.service.model.Survey;
import net.ninemm.upms.interceptor.LogInterceptor;
import net.ninemm.upms.service.api.UserService;
import net.ninemm.upms.service.model.User;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping(value = "/survey")
@Api(description = "问卷", basePath = "/survey", tags = "", position = 2)
@EnableCORS(allowOrigin = "*", allowHeaders = "Content-Type,Jwt", allowCredentials = "true")
public class SurveyController extends BaseAppController {
    @Inject
    SurveyService surveyService;
    @Inject
    AttrService attrService;
    @Inject
    ConfigService configService;
    @Inject
    QuestionService questionService;
    @Inject
    QuestionAttrService questionAttrService;
    @Inject
    StyleService styleService;
    @Inject
    UserService userService;

    public void index() {
        String userId = getUserId();
        Columns columns = Columns.create("user_id", userId);
        columns.le("status",Survey.SurveyStatus.DELETE);
        Page<Survey> page = surveyService.paginateByColumns(getPageNumber(), getPageSize(), columns," create_date,status desc ");
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
        String orderBy = rawObject.getString("orderBy");
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
    /**
    * @Description:  逻辑删除
    * @Param: []
    * @return: void
    * @Author: lsy
    * @Date: 2019/3/18
    */
    public void deleteLogic() {
        String id = getPara("id");
        Survey survey = new Survey();
        survey.setId(id);
        survey.setStatus(Survey.SurveyStatus.DELETE.getStatu());
        surveyService.update(survey);
        renderJson(Ret.ok());
    }

    /**
    * @Description:  彻底删除
    * @Param:
    * @return:
    * @Author: lsy
    * @Date: 2019/3/18
    */
    public void delete() {
        String id = getPara("id");
        Survey survey = new Survey();
        survey.setId(id);
        survey.setStatus(Survey.SurveyStatus.DELETED.getStatu());
        surveyService.update(survey);
        renderJson(Ret.ok());
        /*Survey survey = surveyService.findById(id);
        if(surveyService.deleteById(id)){
            Jboot.sendEvent(MessageAction.Survey.SURVEY_DEL,survey);
        }
        renderJson(Ret.ok());*/
    }
    /**
    * @Description:  批量逻辑删除
    * @Param: []
    * @return: void
    * @Author: lsy
    * @Date: 2019/3/18
    */
    public void deleteByIds() {
        String ids = getPara("ids");
        surveyService.deleteByIds(ids);
        renderJson(Ret.ok());
        /*Survey survey = surveyService.findById(id);
        if(surveyService.deleteById(id)){
            Jboot.sendEvent(MessageAction.Survey.SURVEY_DEL,survey);
        }
        renderJson(Ret.ok());*/
    }

    /**
    * @Description:  问卷垃圾箱
    * @Param:
    * @return:
    * @Author: lsy
    * @Date: 2019/3/18
    */
    public void findBack(){
        String userId = getUserId();
        Columns columns = Columns.create("user_id", userId);
        columns.eq("status",Survey.SurveyStatus.DELETE.getStatu());
        Page<Survey> page = surveyService.paginateByColumns(getPageNumber(), getPageSize(), columns," create_date desc ");
        Map<String, Object> map = ImmutableBiMap.of("total", page.getTotalRow(), "records", page.getList());
        renderJson(map);
    }
    /** 
    * @Description: 问卷找回 
    * @Param:  
    * @return:  
    * @Author: lsy 
    * @Date: 2019/3/18 
    */ 
    public void findBackById(){
        String id = getPara("id");
        Survey survey = new Survey();
        survey.setId(id);
        survey.setStatus(Survey.SurveyStatus.DRAFT.getStatu());
        surveyService.update(survey);
        renderJson(Ret.ok());
    }

    /**
    * @Description:  根据问卷id获取问卷信息,题目,限制等信息
    * @Param: []
    * @return: void
    * @Author: lsy
    * @Date: 2019/3/14
    */
    public void findBySurveyId(){
        String surveyId = getPara("surveyId");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("surve",surveyService.findById(surveyId));
        map.put("attrList",attrService.findBySurveyId(surveyId));
        map.put("configList",configService.findBySurveyId(surveyId));
        map.put("questionList",questionService.findBySurveyId(surveyId));
        map.put("questionAttrList",questionAttrService.findBySurveyId(surveyId));
        map.put("styleList",styleService.findBySurveyId(surveyId));
        renderJson(map);
    }
}
