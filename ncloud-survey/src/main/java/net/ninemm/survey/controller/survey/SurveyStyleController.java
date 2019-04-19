package net.ninemm.survey.controller.survey;

import com.jfinal.aop.Inject;
import com.jfinal.kit.Ret;
import io.jboot.utils.StrUtil;
import io.jboot.web.controller.annotation.RequestMapping;
import io.jboot.web.cors.EnableCORS;
import io.swagger.annotations.Api;
import net.ninemm.survey.controller.BaseAppController;
import net.ninemm.survey.service.api.StyleService;
import net.ninemm.survey.service.model.Style;
import net.ninemm.upms.service.api.UserService;
import net.ninemm.upms.service.model.User;

import java.util.Date;
import java.util.List;

@RequestMapping(value = "/surveyStyle")
@Api(description = "问卷样式", basePath = "/surveyStyle", tags = "", position = 2)
@EnableCORS(allowOrigin = "*", allowHeaders = "Content-Type,Jwt", allowCredentials = "true")
public class SurveyStyleController extends BaseAppController {
    @Inject
    StyleService styleService;
    @Inject
    UserService userService;

    public void saveOrUpdate() {
        Style style = getRawObject(Style.class);
        if(StrUtil.isBlank(style.getId())){
            User user = userService.findById(getUserId());
            style.setDeptId(user.getDepartmentId());
            style.setDataArea(user.getDataArea());
        }
        style.setModifyDate(new Date());
        Object result = styleService.saveOrUpdate(style);
        if (result != null) {
            renderJson(Ret.ok());
        } else {
            renderJson(Ret.fail());
        }
    }
    public void findBySurveyId() {
        String surveyId = getPara("surveyId");
        /*Columns columns = Columns.create();
        columns.eq("survey_id", surveyId);

        Page<Style> page = styleService.paginateByColumns(getPageNumber(), getPageSize(), columns);
        Map<String, Object> map = ImmutableBiMap.of("total", page.getTotalRow(), "records", page.getList());
        renderJson(map);*/
        List<Style> styleList =styleService.findBySurveyId(surveyId);
        renderJson(styleList);
    }

    public void delete() {
        String id = getPara("id");
        if(styleService.deleteById(id)){
            renderJson(Ret.ok());
            return ;
        }else{
            renderJson(Ret.fail());
        }
    }

    public void deleteBySurveyId() {
        String surveyId = getPara("surveyId");
        styleService.deleteBySurveyId(surveyId);
        renderJson(Ret.ok());
    }
}
