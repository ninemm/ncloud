package net.ninemm.upms.controller;

import com.google.common.base.Predicate;
import com.jfinal.aop.Inject;
import com.jfinal.kit.Ret;
import com.jfinal.plugin.activerecord.Page;
import io.jboot.utils.StrUtil;
import io.jboot.web.controller.annotation.RequestMapping;
import io.jboot.web.cors.EnableCORS;
import net.ninemm.upms.service.api.OptionService;
import net.ninemm.upms.service.model.Option;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 配置管理
 *
 * @author Eric.Huang
 * @date 2018-12-10 10:16
 **/

@RequestMapping(value = "/api/v1/admin/option")
@EnableCORS(allowOrigin = "*", allowHeaders = "Content-Type,Jwt", allowCredentials = "true")
public class OptionController extends BaseAppController {

    @Inject
    OptionService optionService;

    public void findAll() {
        List<Option> list = optionService.findAllSystemSettingList();
        Predicate<Option> p = new Predicate<Option>() {
            @Override
            public boolean apply(@Nullable Option option) {
                if (StrUtil.isBlank(option.getOptionValue())) {
                    return false;
                }
                return true;
            }
        };
        list = list.stream().filter(p).collect(Collectors.toList());
        Map<String, String> map = list.stream().collect(Collectors.toMap(Option::getOptionKey, Option::getOptionValue));
        renderJson(map);
    }

    public void saveOrUpdate() {
        Map<String, Object> paraMap = getRawObject(Map.class);
        if (paraMap == null || paraMap.isEmpty()) {
            renderJson(Ret.fail("msg", "para is empty"));
            return;
        }

        /*HashMap<String, String> datasMap = Maps.newHashMap();
        for (Map.Entry<String, String[]> entry : paraMap.entrySet()) {
            if (entry.getValue() != null && entry.getValue().length > 0) {
                String value = null;
                for (String v : entry.getValue()) {
                    if (StrUtils.isNotEmpty(v)) {
                        value = v;
                        break;
                    }
                }
                datasMap.put(entry.getKey(), value);
            }
        }
*/

        for (Map.Entry<String, Object> entry : paraMap.entrySet()) {
            String value = null;
            Object object = entry.getValue();
            if (object != null) {
                value = object.toString();
            }
            optionService.saveOrUpdate(entry.getKey(), value);
            // JPressOptions.set(entry.getKey(), entry.getValue());
        }
        renderJson(Ret.ok());
    }

}
