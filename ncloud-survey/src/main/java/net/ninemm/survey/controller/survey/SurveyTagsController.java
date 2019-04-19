package net.ninemm.survey.controller.survey;

import com.jfinal.aop.Inject;
import com.jfinal.kit.Ret;
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
import java.util.List;
@Deprecated
@RequestMapping(value = "/surveyTags")
@Api(description = "问卷标签", basePath = "/surveyTags", tags = "", position = 2)
@EnableCORS(allowOrigin = "*", allowHeaders = "Content-Type,Jwt", allowCredentials = "true")
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
    public void findAll(){
        Ret.ok("result",tagsService.findAll());
    }

    public void findBySurveyId() {
        List<Tags> tagsList = tagsService.findBySurveyId(getPara("surveyId"));
        renderJson(tagsList);
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
