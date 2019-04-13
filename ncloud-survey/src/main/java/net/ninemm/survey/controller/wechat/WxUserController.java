package net.ninemm.survey.controller.wechat;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.ImmutableBiMap;
import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.kit.Ret;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import io.jboot.db.model.Columns;
import io.jboot.utils.StrUtil;
import io.jboot.web.controller.annotation.RequestMapping;
import io.jboot.web.cors.EnableCORS;
import io.swagger.annotations.Api;
import net.ninemm.base.interceptor.NotNullPara;
import net.ninemm.survey.controller.BaseAppController;
import net.ninemm.survey.service.api.WxConfigService;
import net.ninemm.survey.service.model.WxConfig;
import net.ninemm.survey.service.model.WxUser;
import net.ninemm.survey.service.api.WxUserService;
import net.ninemm.upms.service.api.UserService;
import net.ninemm.upms.service.model.User;

import java.util.List;
import java.util.Map;
/**
 * @Description 微信用户信息
 * @author lsy
 * @version V1.0
 * @Date 2019-04-01 11:01:17
 */
@RequestMapping(value = "/wxUser")
@Api(description = "", basePath = "/wxUser", tags = "", position = 0)
@EnableCORS
public class WxUserController extends BaseAppController {
    @Inject
    private WxUserService wxUserService;
    @Inject
    UserService userService;
    @Inject
    WxConfigService wxConfigService;

    public void index() {
        String userId = getUserId();
        User user = userService.findById(userId);
        Page<Record> page= wxUserService.paginate(getPageNumber(), getPageSize(), user.getDepartmentId());
        Map<String, Object> map = ImmutableBiMap.of("total", page.getTotalRow(), "records", page.getList());
        renderJson(Ret.ok("result",map));
    }

    public void findById() {
        WxUser wxUser  = wxUserService.findById(getPara("id"));
        renderJson(wxUser);
    }

    public void findAll() {
        Page<WxUser> page= wxUserService.paginate(getPageNumber(), getPageSize());
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
        Page<WxUser> page = wxUserService.paginateByColumns(getPageNumber(), getPageSize(), columns, orderBy);
        Map<String, Object> map = ImmutableBiMap.of("total", page.getTotalRow(), "records", page.getList());
        renderJson(Ret.ok("result",map));
    }

    @NotNullPara(value = "id")
    public void delete() {
        if(wxUserService.deleteById(getPara("id"))){
            renderJson(Ret.ok());
            return ;
        }else{
            renderJson(Ret.fail());
        }
    }
}
