package net.ninemm.survey.controller.survey;

import com.jfinal.aop.Inject;
import com.jfinal.kit.Ret;
import io.jboot.utils.StrUtil;
import io.jboot.web.controller.annotation.RequestMapping;
import io.jboot.web.cors.EnableCORS;
import io.swagger.annotations.Api;
import net.ninemm.survey.controller.BaseAppController;
import net.ninemm.survey.service.api.TemplateCategoryService;
import net.ninemm.survey.service.model.TemplateCategory;
import net.ninemm.upms.service.api.UserService;
import net.ninemm.upms.service.model.User;

import java.util.Date;
import java.util.List;

@RequestMapping(value = "/templateCategory")
@Api(description = "问卷模板分类", basePath = "/templateCategory", tags = "", position = 2)
@EnableCORS(allowOrigin = "http://localhost:8080", allowHeaders = "Content-Type,Jwt", allowCredentials = "true")
public class TemplateCategoryController extends BaseAppController {
    @Inject
    TemplateCategoryService templateCategoryService;
    @Inject
    UserService userService;

    public void saveOrUpdate() {
        TemplateCategory templateCategory = getRawObject(TemplateCategory.class);
        User user = userService.findById(getUserId());
        if(StrUtil.isBlank(templateCategory.getId())){
            templateCategory.setDeptId(user.getDepartmentId());
            templateCategory.setDataArea(user.getDataArea());
        }else{
            templateCategory.setModifyDate(new Date());
        }
        Object result = templateCategoryService.saveOrUpdate(templateCategory);
        if (result != null) {
            renderJson(Ret.ok());
        } else {
            renderJson(Ret.fail());
        }
    }
    public void findByDataArea(){
        String dataArea = getPara("dataArea");
        List<TemplateCategory> templateCategoryList = templateCategoryService.findByDataArea(dataArea);
        renderJson(templateCategoryList);
    }
    public void findAll() {
        renderJson(templateCategoryService.findAll());
    }

    public void delete() {
        if(templateCategoryService.deleteById(getPara("id"))){
            renderJson(Ret.ok());
            return ;
        }else{
            renderJson(Ret.fail());
        }
    }
}
