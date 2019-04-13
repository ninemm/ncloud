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
import net.ninemm.survey.service.api.TagMappingService;
import net.ninemm.survey.service.model.Survey;
import net.ninemm.survey.service.model.TagMapping;
import net.ninemm.upms.service.api.UserService;
import net.ninemm.upms.service.model.User;

import java.util.Map;

@RequestMapping(value = "/tagMapping")
@Api(description = "问卷量表中间表", basePath = "/tagMapping", tags = "", position = 2)
@EnableCORS
public class TagMappingController extends BaseAppController {
    @Inject
    TagMappingService tagMappingService;
    @Inject
    UserService userService;

    public void saveOrUpdate() {
        TagMapping tagMapping = getRawObject(TagMapping.class);
        Object result = tagMappingService.saveOrUpdate(tagMapping);
        if (result != null) {
            renderJson(Ret.ok());
        } else {
            renderJson(Ret.fail());
        }
    }

    public void findByColums() {
        JSONObject rawObject = getRawObject();
        Columns columns = Columns.create();
        columns.eq("survey_id", rawObject.get("surveyId"));
        columns.eq("question_id", rawObject.get("questionId"));
        columns.eq("tag_id", rawObject.get("tagId"));
        columns.eq("tag_type", rawObject.get("tagType"));
        columns.eq("is_questionTag", rawObject.get("isQuestionTag"));
        columns.likeAppendPercent("tag_name", rawObject.get("tagName"));
        Page<TagMapping> page = tagMappingService.paginateByColumns(getPageNumber(), getPageSize(), columns);
        Map<String, Object> map = ImmutableBiMap.of("total", page.getTotalRow(), "records", page.getList());
        renderJson(Ret.ok("result",map));
    }

    public void delete() {
        String id = getPara("id");
        if(tagMappingService.deleteById(id)){
            renderJson(Ret.ok());
            return ;
        }else{
            renderJson(Ret.fail());
        }
    }
}
