package net.ninemm.survey.controller.consumer;

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
import net.ninemm.base.message.MessageAction;
import net.ninemm.survey.controller.BaseAppController;
import net.ninemm.survey.service.api.WxConfigService;
import net.ninemm.survey.service.model.Consumer;
import net.ninemm.survey.service.api.ConsumerService;
import net.ninemm.survey.service.model.WxConfig;
import net.ninemm.upms.service.api.UserService;
import java.util.List;
import java.util.Map;
/**
 * @author lsy
 * @version V1.0
 * @Date 2019-03-22 17:14:07
 */
@RequestMapping(value = "/consumer")
@Api(description = "", basePath = "/consumer", tags = "", position = 0)
@EnableCORS
public class ConsumerController extends BaseAppController {
    @Inject
    private ConsumerService consumerService;
    @Inject
    private UserService userService;
    @Inject
    WxConfigService wxConfigService;

    public void index() {
        String userId = getUserId();
        Columns columns = Columns.create("user_id", userId);
        Page<Consumer> page= consumerService.paginateByColumns(getPageNumber(), getPageSize(), columns);
        Map<String, Object> map = ImmutableBiMap.of("total", page.getTotalRow(), "records", page.getList());
        renderJson(Ret.ok("result",map));
    }

    public void findById() {
        Consumer consumer  = consumerService.findById(getPara("id"));
        renderJson(Ret.ok("result",consumer));
    }

    public void findAll() {
        List<Consumer> consumerList = consumerService.findAll();
        renderJson(Ret.ok("result",consumerList));
    }
    /**
    * @Description:  筛选样本信息
    * @Param: []
    * @return: void
    * @Author: lsy
    * @Date: 2019/4/17
    */
    public void findByColum() {
        JSONObject rawObject = getRawObject();
        Columns columns = Columns.create();
        Integer sendWay = rawObject.getInteger("sendWay");
        if (sendWay == MessageAction.SendSurvey.WEIXIN) {
            String appId = rawObject.getString("appId");
            if (!StrUtil.isNotEmpty(appId)) {
                WxConfig wxConfig =wxConfigService.findDefaultConfig();
                appId = wxConfig.getAppid();
            }
            columns.eq("appid",appId);
            //只查询已订阅的微信用户
            columns.eq("subscribe",1);
        }else if(sendWay==MessageAction.SendSurvey.EMAIL){
            columns.is_not_null("email");
        }else if(sendWay==MessageAction.SendSurvey.MOBILE){
            columns.is_not_null("phone");
        }

        columns.eq("email",rawObject.getString("email"));
        columns.eq("phone",rawObject.getString("phone"));
        columns.eq("sex",rawObject.getInteger("sex"));
        String age = rawObject.getString("age");
        if(StrUtil.isNotEmpty(age)){
            String[] split = age.split(",");
            columns.ge("age",split[0]);
            columns.lt("age",split[1]);
        }

        String orderBy = rawObject.getString("orderBy");
        if(StrUtil.isBlank(orderBy)){
            orderBy=" create_date desc ";
        }
        Page<Consumer> page = consumerService.paginateByColumns(getPageNumber(), getPageSize(), columns, orderBy);
        Map<String, Object> map = ImmutableBiMap.of("total", page.getTotalRow(), "records", page.getList());
        renderJson(Ret.ok("result",map));
    }

    public void saveOrUpdate() {
        Consumer consumer = getRawObject(Consumer.class);
        consumerService.saveOrUpdate(consumer);
        renderJson(Ret.ok().set("id", consumer.getId()));
    }

    @NotNullPara(value = "id")
    public void delete() {
        if(consumerService.deleteById(getPara("id"))){
            renderJson(Ret.ok());
            return ;
        }else{
            renderJson(Ret.fail());
        }
    }

    /**
    * @Description:  微信模板发送问卷 筛选消费者
    * @Param: []
    * @return: void
    * @Author: lsy
    * @Date: 2019/4/17
    */
    public void findConsumerByAppid(){
        //consumerService.findByAppid();
    }
}
