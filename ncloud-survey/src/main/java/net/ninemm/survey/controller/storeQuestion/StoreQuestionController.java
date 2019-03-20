package net.ninemm.survey.controller.storeQuestion;

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
import net.ninemm.survey.service.api.StoreQuestionService;
import net.ninemm.survey.service.model.StoreQuestion;
import net.ninemm.upms.service.api.UserService;
import net.ninemm.upms.service.model.User;

import java.util.Date;
import java.util.Map;

@RequestMapping(value = "/storeQuestion")
@Api(description = "问卷题库", basePath = "/storeQuestion", tags = "", position = 2)
@EnableCORS(allowOrigin = "http://localhost:8080", allowHeaders = "Content-Type,Jwt", allowCredentials = "true")
public class StoreQuestionController extends BaseAppController {
    @Inject
    StoreQuestionService storeQuestionService;
    @Inject
    UserService userService;

    public void saveOrUpdate() {
        StoreQuestion storeQuestion = getRawObject(StoreQuestion.class);
        if(StrUtil.isBlank(storeQuestion.getId())){
            User user = userService.findById(getUserId());
            storeQuestion.setDeptId(user.getDepartmentId());
            storeQuestion.setDataArea(user.getDataArea());
        }else{
            storeQuestion.setModifyDate(new Date());
        }
        Object result = storeQuestionService.saveOrUpdate(storeQuestion);
        if (result != null) {
            renderJson(Ret.ok());
        } else {
            renderJson(Ret.fail());
        }
    }
    public void findByColums() {
        JSONObject rawObject = getRawObject();
        Columns columns = Columns.create();
        columns.eq("type", rawObject.get("type"));
        columns.eq("concept_groupId", rawObject.get("conceptGroupId"));
        columns.likeAppendPercent("title", rawObject.get("title"));
        columns.like("data_area",rawObject.get("dataArea"));
        columns.ge("create_date",rawObject.get("startDate"));
        columns.le("create_date",rawObject.get("endDate"));
        String orderBy = rawObject.get("orderBy")==null?null:rawObject.get("orderBy").toString();
        if(StrUtil.isBlank(orderBy)){
            orderBy=" create_date desc ";
        }
        Page<StoreQuestion> page = storeQuestionService.paginateByColumns(getPageNumber(), getPageSize(), columns,orderBy);
        Map<String, Object> map = ImmutableBiMap.of("total", page.getTotalRow(), "records", page.getList());
        renderJson(map);
    }

    public void delete() {
        if(storeQuestionService.deleteById(getPara("id"))){
            renderJson(Ret.ok());
            return ;
        }else{
            renderJson(Ret.fail());
        }
    }
}
