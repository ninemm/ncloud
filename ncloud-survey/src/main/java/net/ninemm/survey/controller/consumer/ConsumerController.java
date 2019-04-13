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
import net.ninemm.survey.controller.BaseAppController;
import net.ninemm.survey.service.model.Consumer;
import net.ninemm.survey.service.api.ConsumerService;
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
        Page<Consumer> page = consumerService.paginateByColumns(getPageNumber(), getPageSize(), columns, orderBy);
        Map<String, Object> map = ImmutableBiMap.of("total", page.getTotalRow(), "records", page.getList());
        renderJson(Ret.ok("result",map));
    }

    public void saveOrUpdate() {
        Consumer consumer = getRawObject(Consumer.class);
        consumerService.saveOrUpdate(consumer);
        renderJson(Ret.ok().set("id", consumer.getId()));
    }

    public void delete() {
        if(consumerService.deleteById(getPara("id"))){
            renderJson(Ret.ok());
            return ;
        }else{
            renderJson(Ret.fail());
        }
    }
}
