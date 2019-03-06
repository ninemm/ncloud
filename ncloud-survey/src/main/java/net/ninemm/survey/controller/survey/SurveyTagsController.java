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
import net.ninemm.survey.service.api.TagsService;
import net.ninemm.survey.service.model.Tags;
import net.ninemm.upms.service.api.UserService;
import net.ninemm.upms.service.model.User;

import java.util.Date;
import java.util.Map;

@RequestMapping(value = "/surveyTags")
@Api(description = "问卷标签", basePath = "/surveyTags", tags = "", position = 2)
@EnableCORS(allowOrigin = "http://localhost:8080", allowHeaders = "Content-Type,Jwt", allowCredentials = "true")
public class SurveyTagsController extends BaseAppController {
    @Inject
    TagsService tagsService;
    @Inject
    UserService userService;

    public void saveOrUpdate() {
        Tags tags = getRawObject(Tags.class);
        if(StrUtil.isBlank(tags.getId())){
            User user = userService.findById(getUserId());
            tags.setDeptId(user.getDepartmentId());
            tags.setDataArea(user.getDataArea());
        }
        tags.setModifyDate(new Date());
        Object result = tagsService.saveOrUpdate(tags);
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

        Page<Tags> page = tagsService.paginateByColumns(getPageNumber(), getPageSize(), columns);
        Map<String, Object> map = ImmutableBiMap.of("total", page.getTotalRow(), "records", page.getList());
        renderJson(map);
    }

    public void delete() {
        String id = getPara("id");
        if(tagsService.deleteById(id)){
            renderJson(Ret.ok());
            return ;
        }else{
            renderJson(Ret.fail());
        }
    }

    public void deleteBySurveyId() {
        String surveyId = getPara("surveyId");
        tagsService.deleteBySurveyId(surveyId);
        renderJson(Ret.ok());
    }
}
