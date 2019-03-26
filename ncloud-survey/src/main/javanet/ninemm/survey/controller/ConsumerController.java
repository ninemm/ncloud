package net.ninemm.survey.controller;

import com.google.common.collect.ImmutableBiMap;
import com.jfinal.aop.Inject;
import com.jfinal.kit.Ret;
import com.jfinal.plugin.activerecord.Page;
import io.jboot.db.model.Columns;
import io.jboot.web.controller.annotation.RequestMapping;
import io.jboot.web.cors.EnableCORS;
import io.swagger.annotations.Api;
import net.ninemm.survey.service.model.Consumer;
import net.ninemm.survey.service.api.ConsumerService;
import net.ninemm.upms.service.api.UserService;
import java.util.List;
import java.util.Map;
/**
 * @author lsy
 * @version V1.0
 * @Date 2019-03-22 17:03:57
 */
@RequestMapping(value = "/consumer")
@Api(description = "", basePath = "/consumer", tags = "", position = 0)
@EnableCORS(allowOrigin = "http://localhost:8080", allowHeaders = "Content-Type,Jwt", allowCredentials = "true")
public class ConsumerController extends BaseAppController {
    @Inject
    private ConsumerService consumerService;
    @Inject
    UserService userService;

    public void index() {
        String userId = getUserId();
        Columns columns = Columns.create("user_id", userId);
        Page<Consumer> page= consumerService.paginateByColumns(getPageNumber(), getPageSize(), columns);
        Map<String, Object> map = ImmutableBiMap.of("total", page.getTotalRow(), "records", page.getList());
        renderJson(map);
    }

    public void findById() {
        Consumer consumer  = consumerService.findById(getPara("id"));
        renderJson(consumer);
    }

    public void findAll() {
        List<Consumer> consumerList = consumerService.findAll();
        renderJson(consumerList);
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