package net.ninemm.survey.controller.answer;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.ImmutableBiMap;
import com.jfinal.aop.Clear;
import com.jfinal.aop.Inject;
import com.jfinal.ext.interceptor.LogInterceptor;
import com.jfinal.kit.Kv;
import com.jfinal.kit.Ret;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.weixin.sdk.kit.IpKit;
import io.jboot.Jboot;
import io.jboot.db.model.Columns;
import io.jboot.utils.StrUtil;
import io.jboot.web.controller.annotation.RequestMapping;
import io.jboot.web.cors.EnableCORS;
import io.swagger.annotations.Api;
import net.ninemm.base.interceptor.GlobalCacheInterceptor;
import net.ninemm.base.interceptor.NotNullPara;
import net.ninemm.base.message.MessageAction;
import net.ninemm.survey.controller.BaseAppController;
import net.ninemm.survey.service.model.AnswerSheet;
import net.ninemm.survey.service.api.AnswerSheetService;
import net.ninemm.upms.service.api.UserService;
import net.ninemm.upms.service.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
/**
 * @Description
 * @author lsy
 * @version V1.0
 * @Date 2019-04-12 09:31:00
 */
@RequestMapping(value = "/answerSheet")
@Api(description = "", basePath = "/answerSheet", tags = "", position = 0)
@EnableCORS
public class AnswerSheetController extends BaseAppController {
    @Inject
    private AnswerSheetService answerSheetService;
    @Inject
    UserService userService;

    public void index() {
        String userId = getUserId();
        Columns columns = Columns.create("user_id", userId);
        Page<AnswerSheet> page= answerSheetService.paginateByColumns(getPageNumber(), getPageSize(), columns);
        Map<String, Object> map = ImmutableBiMap.of("total", page.getTotalRow(), "records", page.getList());
        renderJson(Ret.ok("result",map));
    }

    @NotNullPara(value = "id")
    public void findById() {
        AnswerSheet answerSheet  = answerSheetService.findById(getPara("id"));
        renderJson(answerSheet);
    }

    public void findAll() {
        List<AnswerSheet> answerSheetList = answerSheetService.findAll();
        renderJson(answerSheetList);
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
        Page<AnswerSheet> page = answerSheetService.paginateByColumns(getPageNumber(), getPageSize(), columns, orderBy);
        Map<String, Object> map = ImmutableBiMap.of("total", page.getTotalRow(), "records", page.getList());
        renderJson(Ret.ok("result",map));
    }

    public void saveOrUpdate() {
        AnswerSheet answerSheet = getRawObject(AnswerSheet.class);
        String userId = getUserId();
        User user = userService.findById(userId);
        if (StrUtil.isBlank(answerSheet.getId())) {

        }
        answerSheetService.saveOrUpdate(answerSheet);
        renderJson(Ret.ok().set("id", answerSheet.getId()));
    }

    @NotNullPara(value = "id")
    public void delete() {
        if(answerSheetService.deleteById(getPara("id"))){
            renderJson(Ret.ok());
            return ;
        }else{
            renderJson(Ret.fail());
        }
    }

    @NotNullPara(value = "surveyId")
    public void findBySurveyId(){
        /*WxRedpackConfig wxRedpackConfig = wxRedpackConfigService.findBySurveyId(getPara("surveyId"));
        renderJson(Ret.ok("result",wxRedpackConfig));*/
    }

    @Clear({GlobalCacheInterceptor.class, LogInterceptor.class})
    public void save(){
        //{"result":result,"lat":lat,"lng":lng,"userAgent":window.navigator.userAgent},
        /*JSONObject result = JSON.parseObject(getPara("result"));
        String lat = getPara("lat");
        String lng = getPara("lng");
        String userAgent = getPara("userAgent");

        //Jboot.getM().enqueue();
        Kv kv = Kv.create();
        kv.set("result",result);
        kv.set("lat",lat);
        kv.set("lng",lng);
        kv.set("userAgent",userAgent);*/
        HttpServletRequest request = getRequest();
        Map<String, Object> paraMap = getAllParaMap();
        paraMap.put("ip",IpKit.getRealIp(request));
        Jboot.sendEvent(MessageAction.saveSurveyResult.SURVEY_RESULT_SAVE,paraMap);
        renderJson(Ret.ok());
    }
}
