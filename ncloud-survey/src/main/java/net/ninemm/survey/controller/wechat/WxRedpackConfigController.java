package net.ninemm.survey.controller.wechat;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.ImmutableBiMap;
import com.jfinal.aop.Inject;
import com.jfinal.kit.Ret;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.render.Render;
import io.jboot.db.model.Columns;
import io.jboot.utils.StrUtil;
import io.jboot.web.controller.annotation.RequestMapping;
import io.jboot.web.cors.EnableCORS;
import io.swagger.annotations.Api;
import net.ninemm.base.interceptor.NotNullPara;
import net.ninemm.survey.controller.BaseAppController;
import net.ninemm.survey.service.model.WxRedpackConfig;
import net.ninemm.survey.service.api.WxRedpackConfigService;
import net.ninemm.upms.service.api.UserService;
import net.ninemm.upms.service.model.User;

import java.util.Date;
import java.util.List;
import java.util.Map;
/**
 * @Description 微信红包配置
 * @author lsy
 * @version V1.0
 * @Date 2019-04-01 11:02:18
 */
@RequestMapping(value = "/wxRedpackConfig")
@Api(description = "", basePath = "/wxRedpackConfig", tags = "", position = 0)
@EnableCORS
public class WxRedpackConfigController extends BaseAppController {
    @Inject
    private WxRedpackConfigService wxRedpackConfigService;
    @Inject
    UserService userService;

    public void index() {
        String userId = getUserId();
        Columns columns = Columns.create("user_id", userId);
        Page<WxRedpackConfig> page= wxRedpackConfigService.paginateByColumns(getPageNumber(), getPageSize(), columns);
        Map<String, Object> map = ImmutableBiMap.of("total", page.getTotalRow(), "records", page.getList());
        renderJson(Ret.ok("result",map));
    }

    public void findById() {
        WxRedpackConfig wxRedpackConfig  = wxRedpackConfigService.findById(getPara("id"));
        renderJson(wxRedpackConfig);
    }

    public void findAll() {
        List<WxRedpackConfig> wxRedpackConfigList = wxRedpackConfigService.findAll();
        renderJson(wxRedpackConfigList);
    }

    public void findByColum() {
        JSONObject rawObject = getRawObject();

        Columns columns = Columns.create();
        columns.eq("", rawObject.get(""));
        columns.likeAppendPercent("", rawObject.get(""));
        columns.like("data_area",rawObject.get("dataArea"));
        columns.ge("create_date",rawObject.get("startDate"));
        columns.le("create_date",rawObject.get("endDate"));

        String orderBy = rawObject.getString("orderBy");
        if(StrUtil.isBlank(orderBy)){
            orderBy=" create_date desc ";
        }
        Page<WxRedpackConfig> page = wxRedpackConfigService.paginateByColumns(getPageNumber(), getPageSize(), columns, orderBy);
        Map<String, Object> map = ImmutableBiMap.of("total", page.getTotalRow(), "records", page.getList());
        renderJson(Ret.ok("result",map));
    }

    public void saveOrUpdate() {
        WxRedpackConfig wxRedpackConfig = getRawObject(WxRedpackConfig.class);
        String userId = getUserId();
        User user = userService.findById(userId);
        if (StrUtil.isBlank(wxRedpackConfig.getId())) {
            wxRedpackConfig.setUserId(userId);
            wxRedpackConfig.setDeptId(user.getDepartmentId());
            wxRedpackConfig.setDataArea(user.getDataArea());
        }else {
            wxRedpackConfig.setModifyUser(userId);
            wxRedpackConfig.setModifyDate(new Date());
        }
        wxRedpackConfigService.saveOrUpdate(wxRedpackConfig);
        renderJson(Ret.ok().set("id", wxRedpackConfig.getId()));
    }

    @NotNullPara(value = "id")
    public void delete() {
        if(wxRedpackConfigService.deleteById(getPara("id"))){
            renderJson(Ret.ok());
            return ;
        }else{
            renderJson(Ret.fail());
        }
    }
    @NotNullPara(value = "surveyId")
    public void findBySurveyId(){
        WxRedpackConfig wxRedpackConfig = wxRedpackConfigService.findBySurveyId(getPara("surveyId"));
        renderJson(Ret.ok("result",wxRedpackConfig));
    }

}
