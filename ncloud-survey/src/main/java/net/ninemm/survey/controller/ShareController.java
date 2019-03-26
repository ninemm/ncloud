package net.ninemm.survey.controller;

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
import net.ninemm.survey.service.model.Share;
import net.ninemm.survey.service.api.ShareService;
import net.ninemm.upms.service.api.UserService;
import java.util.List;
import java.util.Map;
/**
 * @author lsy
 * @version V1.0
 * @Date 2019-03-22 17:24:35
 */
@RequestMapping(value = "/share")
@Api(description = "", basePath = "/share", tags = "", position = 0)
@EnableCORS(allowOrigin = "http://localhost:8080", allowHeaders = "Content-Type,Jwt", allowCredentials = "true")
public class ShareController extends BaseAppController {
    @Inject
    private ShareService shareService;
    @Inject
    UserService userService;

    public void index() {
        String userId = getUserId();
        Columns columns = Columns.create("user_id", userId);
        Page<Share> page= shareService.paginateByColumns(getPageNumber(), getPageSize(), columns);
        Map<String, Object> map = ImmutableBiMap.of("total", page.getTotalRow(), "records", page.getList());
        renderJson(Ret.ok("records",map));
    }

    @NotNullPara(value = "id")
    public void findById() {
        Share share  = shareService.findById(getPara("id"));
        renderJson(Ret.ok("records",share));
    }

    public void findAll() {
        List<Share> shareList = shareService.findAll();
        renderJson(Ret.ok("records",shareList));
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
        Page<Share> page = shareService.paginateByColumns(getPageNumber(), getPageSize(), columns, orderBy);
        Map<String, Object> map = ImmutableBiMap.of("total", page.getTotalRow(), "records", page.getList());
        renderJson(Ret.ok("records",map));
    }

    public void saveOrUpdate() {
        Share share = getRawObject(Share.class);
        shareService.saveOrUpdate(share);
        renderJson(Ret.ok().set("id", share.getId()));
    }

    @NotNullPara(value = "id")
    public void delete() {
        if(shareService.deleteById(getPara("id"))){
            renderJson(Ret.ok());
            return ;
        }else{
            renderJson(Ret.fail("msg","删除失败,请检查id是否正确"));
        }
    }
}