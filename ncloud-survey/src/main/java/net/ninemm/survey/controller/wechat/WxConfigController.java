package net.ninemm.survey.controller.wechat;

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
import net.ninemm.base.interceptor.NotNullPara;
import net.ninemm.survey.controller.BaseAppController;
import net.ninemm.survey.service.api.WxConfigService;
import net.ninemm.survey.service.api.WxUserService;
import net.ninemm.survey.service.model.WxConfig;
import net.ninemm.upms.service.api.UserService;
import net.ninemm.upms.service.model.User;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 多微信配置
 * @author lsy
 * @version V1.0
 * @Date 2019-04-01 11:02:18
 */
@RequestMapping(value = "/wxConfig")
@Api(description = "", basePath = "/wxConfig", tags = "", position = 0)
@EnableCORS
public class WxConfigController extends BaseAppController {
    @Inject
    private WxConfigService wxConfigService;
    @Inject
    UserService userService;

    public void index() {
        String userId = getUserId();
        Columns columns = Columns.create("user_id", userId);
        Page<WxConfig> page= wxConfigService.paginateByColumns(getPageNumber(), getPageSize(), columns);
        Map<String, Object> map = ImmutableBiMap.of("total", page.getTotalRow(), "records", page.getList());
        renderJson(Ret.ok("result",map));
    }

    public void findById() {
        WxConfig wxConfig  = wxConfigService.findById(getPara("id"));
        renderJson(wxConfig);
    }

    public void findAll() {
        Page<WxConfig> page= wxConfigService.paginate(getPageNumber(), getPageSize());
        Map<String, Object> map = ImmutableBiMap.of("total", page.getTotalRow(), "records", page.getList());
        renderJson(Ret.ok("result",map));
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
        Page<WxConfig> page = wxConfigService.paginateByColumns(getPageNumber(), getPageSize(), columns, orderBy);
        Map<String, Object> map = ImmutableBiMap.of("total", page.getTotalRow(), "records", page.getList());
        renderJson(Ret.ok("result",map));
    }

    public void saveOrUpdate() {
        WxConfig wxConfig = getRawObject(WxConfig.class);
        String userId = getUserId();
        User user = userService.findById(userId);
        if (StrUtil.isBlank(wxConfig.getId())) {
            wxConfig.setDeptId(user.getDepartmentId());
            wxConfig.setDataArea(user.getDataArea());
        }else {
            wxConfig.setModifyDate(new Date());
        }
        wxConfigService.saveOrUpdate(wxConfig);
        renderJson(Ret.ok().set("id", wxConfig.getId()));
    }
    @NotNullPara(value = "id")
    public void delete() {
        if(wxConfigService.deleteById(getPara("id"))){
            renderJson(Ret.ok());
            return ;
        }else{
            renderJson(Ret.fail());
        }
    }
    @NotNullPara(value = "deptId")
    public void findByDeptId(){
        Columns columns = Columns.create("dept_id",getPara("deptId"));
        String orderBy = getPara("orderBy");
        if(StrUtil.isBlank(orderBy)){
            orderBy=" create_date desc ";
        }
        Page<WxConfig> page = wxConfigService.paginateByColumns(getPageNumber(), getPageSize(), columns, orderBy);
        Map<String, Object> map = ImmutableBiMap.of("total", page.getTotalRow(), "records", page.getList());
        renderJson(Ret.ok("result",map));
    }
}
