package net.ninemm.survey.controller.answer;
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
import net.ninemm.survey.service.model.AnswerValue;
import net.ninemm.survey.service.api.AnswerValueService;
import net.ninemm.upms.service.api.UserService;
import net.ninemm.upms.service.model.User;
import java.util.List;
import java.util.Map;
/**
 * @Description
 * @author lsy
 * @version V1.0
 * @Date 2019-04-12 09:31:00
 */
@RequestMapping(value = "/answerValue")
@Api(description = "", basePath = "/answerValue", tags = "", position = 0)
@EnableCORS
public class AnswerValueController extends BaseAppController {
    @Inject
    private AnswerValueService answerValueService;
    @Inject
    UserService userService;

    public void index() {
        String userId = getUserId();
        Columns columns = Columns.create("user_id", userId);
        Page<AnswerValue> page= answerValueService.paginateByColumns(getPageNumber(), getPageSize(), columns);
        Map<String, Object> map = ImmutableBiMap.of("total", page.getTotalRow(), "records", page.getList());
        renderJson(Ret.ok("result",map));
    }

    @NotNullPara(value = "id")
    public void findById() {
        AnswerValue answerValue  = answerValueService.findById(getPara("id"));
        renderJson(answerValue);
    }

    public void findAll() {
        List<AnswerValue> answerValueList = answerValueService.findAll();
        renderJson(answerValueList);
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
        Page<AnswerValue> page = answerValueService.paginateByColumns(getPageNumber(), getPageSize(), columns, orderBy);
        Map<String, Object> map = ImmutableBiMap.of("total", page.getTotalRow(), "records", page.getList());
        renderJson(Ret.ok("result",map));
    }

    public void saveOrUpdate() {
        AnswerValue answerValue = getRawObject(AnswerValue.class);
        String userId = getUserId();
        User user = userService.findById(userId);
        if (StrUtil.isBlank(answerValue.getId())) {

        }
        answerValueService.saveOrUpdate(answerValue);
        renderJson(Ret.ok().set("id", answerValue.getId()));
    }

    @NotNullPara(value = "id")
    public void delete() {
        if(answerValueService.deleteById(getPara("id"))){
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
}
