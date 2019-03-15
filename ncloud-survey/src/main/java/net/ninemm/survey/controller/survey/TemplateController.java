package net.ninemm.survey.controller.survey;

import com.jfinal.aop.Inject;
import com.jfinal.kit.Ret;
import io.jboot.utils.StrUtil;
import io.jboot.web.controller.annotation.RequestMapping;
import io.jboot.web.cors.EnableCORS;
import io.swagger.annotations.Api;
import net.ninemm.survey.controller.BaseAppController;
import net.ninemm.survey.service.api.TemplateService;
import net.ninemm.survey.service.model.Template;
import net.ninemm.upms.service.api.UserService;
import net.ninemm.upms.service.model.User;

import java.util.Date;
import java.util.List;

@RequestMapping(value = "/template")
@Api(description = "问卷模板", basePath = "/template", tags = "", position = 2)
@EnableCORS(allowOrigin = "http://localhost:8080", allowHeaders = "Content-Type,Jwt", allowCredentials = "true")
public class TemplateController extends BaseAppController {
    @Inject
    TemplateService templateService;
    @Inject
    UserService userService;

    public void saveOrUpdate() {
        Template template = getRawObject(Template.class);
        if(StrUtil.isBlank(template.getId())){
            User user = userService.findById(getUserId());
            template.setDeptId(user.getDepartmentId());
            template.setDataArea(user.getDataArea());
        }else{
            template.setModifyDate(new Date());
        }
        Object result = templateService.saveOrUpdate(template);
        if (result != null) {
            renderJson(Ret.ok());
        } else {
            renderJson(Ret.fail());
        }
    }

    public void findByDataArea(){
        String dataArea = getPara("dataArea");
        List<Template> templateList = templateService.findByDataArea(dataArea);
        renderJson(templateList);
    }
    public void findAll() {

        renderJson(templateService.findAll());
    }

    public void delete() {
        if(templateService.deleteById(getPara("id"))){
            renderJson(Ret.ok());
            return ;
        }else{
            renderJson(Ret.fail());
        }
    }
}
