package net.ninemm.survey.controller.wechat;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.ImmutableBiMap;
import com.jfinal.aop.Inject;
import com.jfinal.kit.Kv;
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
import net.ninemm.survey.service.model.WxRedpackResult;
import net.ninemm.survey.service.api.WxRedpackResultService;
import net.ninemm.upms.service.api.UserService;
import net.ninemm.upms.service.model.User;

import java.util.List;
import java.util.Map;
/**
 * @Description 微信红包发放结果
 * @author lsy
 * @version V1.0
 * @Date 2019-04-01 11:02:18
 */
@RequestMapping(value = "/wxRedpackResult")
@Api(description = "", basePath = "/wxRedpackResult", tags = "", position = 0)
@EnableCORS
public class WxRedpackResultController extends BaseAppController {
    @Inject
    private WxRedpackResultService wxRedpackResultService;
    @Inject
    UserService userService;

    public void index() {
        String userId = getUserId();
        User user = userService.findById(userId);
        Page<Record> page= wxRedpackResultService.paginate(getPageNumber(), getPageSize(), user.getDepartmentId());
        Map<String, Object> map = ImmutableBiMap.of("total", page.getTotalRow(), "records", page.getList());
        renderJson(Ret.ok("result",map));
    }

    @NotNullPara(value = "surveyId")
    public void findDetailBySurveyId(){
        Kv kv= Kv.create();
        kv.set("surveyId",getPara("surveyId"));
        Page<Record> page= wxRedpackResultService.paginateBySurveyId(getPageNumber(), getPageSize(), kv);
        Map<String, Object> map = ImmutableBiMap.of("total", page.getTotalRow(), "records", page.getList());
        renderJson(Ret.ok("result",map));
    }

    public void findById() {
        WxRedpackResult wxRedpackResult  = wxRedpackResultService.findById(getPara("id"));
        renderJson(wxRedpackResult);
    }

    public void findAll() {
        List<WxRedpackResult> wxRedpackResultList = wxRedpackResultService.findAll();
        renderJson(wxRedpackResultList);
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
        Page<WxRedpackResult> page = wxRedpackResultService.paginateByColumns(getPageNumber(), getPageSize(), columns, orderBy);
        Map<String, Object> map = ImmutableBiMap.of("total", page.getTotalRow(), "records", page.getList());
        renderJson(Ret.ok("result",map));
    }

    public void saveOrUpdate() {
        WxRedpackResult wxRedpackResult = getRawObject(WxRedpackResult.class);
        wxRedpackResultService.saveOrUpdate(wxRedpackResult);
        renderJson(Ret.ok().set("id", wxRedpackResult.getId()));
    }

    public void delete() {
        if(wxRedpackResultService.deleteById(getPara("id"))){
            renderJson(Ret.ok());
            return ;
        }else{
            renderJson(Ret.fail());
        }
    }
}
