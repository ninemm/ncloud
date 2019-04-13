package net.ninemm.survey.controller.survey;

import com.jfinal.aop.Inject;
import com.jfinal.kit.Ret;
import io.jboot.utils.StrUtil;
import io.jboot.web.controller.annotation.RequestMapping;
import io.jboot.web.cors.EnableCORS;
import io.swagger.annotations.Api;
import net.ninemm.survey.controller.BaseAppController;
import net.ninemm.survey.service.api.TagService;
import net.ninemm.survey.service.model.Tag;
import net.ninemm.upms.service.api.UserService;
import net.ninemm.upms.service.model.User;

import java.util.Date;

@RequestMapping(value = "/tag")
@Api(description = "问卷标签", basePath = "/tag", tags = "", position = 2)
@EnableCORS
public class TagController extends BaseAppController {
    @Inject
    TagService tagService;
    @Inject
    UserService userService;

    public void saveOrUpdate() {
        Tag tag = getRawObject(Tag.class);
        if(StrUtil.isBlank(tag.getId())){
            User user = userService.findById(getUserId());
            tag.setDeptId(user.getDepartmentId());
            tag.setDataArea(user.getDataArea());
        }else{
            tag.setModifyDate(new Date());
        }
        Object result = tagService.saveOrUpdate(tag);
        if (result != null) {
            renderJson(Ret.ok());
        } else {
            renderJson(Ret.fail());
        }
    }

    public void findAll(){
        renderJson(Ret.ok("result",tagService.findAll()));
    }

    public void delete() {
        String id = getPara("id");
        if(tagService.deleteById(id)){
            renderJson(Ret.ok());
            return ;
        }else{
            renderJson(Ret.fail());
        }
    }
}
