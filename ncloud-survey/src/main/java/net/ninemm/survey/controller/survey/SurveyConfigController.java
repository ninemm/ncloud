package net.ninemm.survey.controller.survey;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.ImmutableBiMap;
import com.jfinal.aop.Inject;
import com.jfinal.kit.Ret;
import com.jfinal.plugin.activerecord.Page;
import io.jboot.db.model.Columns;
import io.jboot.web.controller.annotation.RequestMapping;
import io.jboot.web.cors.EnableCORS;
import io.swagger.annotations.Api;
import net.ninemm.survey.controller.BaseAppController;
import net.ninemm.survey.service.api.ConfigService;
import net.ninemm.survey.service.model.Config;
import net.ninemm.upms.service.api.UserService;

import java.util.Map;

@RequestMapping(value = "/surveyConfig")
@Api(description = "问卷配置", basePath = "/surveyConfig", tags = "", position = 2)
@EnableCORS(allowOrigin = "http://localhost:8080", allowHeaders = "Content-Type,Jwt", allowCredentials = "true")
public class SurveyConfigController extends BaseAppController {
    @Inject
    ConfigService configService;
    @Inject
    UserService userService;

    public void saveOrUpdate() {
        Config config = getRawObject(Config.class);
        Object result = configService.saveOrUpdate(config);
        if (result != null) {
            renderJson(Ret.ok());
        } else {
            renderJson(Ret.fail());
        }
    }
    public void findBySurveyId() {
        String surveyId = getPara("surveyId");
        Columns columns = Columns.create();
        columns.eq("survey_id", surveyId);

        Page<Config> page = configService.paginateByColumns(getPageNumber(), getPageSize(), columns);
        Map<String, Object> map = ImmutableBiMap.of("total", page.getTotalRow(), "records", page.getList());
        renderJson(map);
    }

    public void delete() {
        String id = getPara("id");
        if(configService.deleteById(id)){
            renderJson(Ret.ok());
            return ;
        }else{
            renderJson(Ret.fail());
        }
    }

    public void deleteBySurveyId() {
        String surveyId = getPara("surveyId");
        configService.deleteBySurveyId(surveyId);
        renderJson(Ret.ok());
    }

}
