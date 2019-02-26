package net.ninemm.upms.service.provider;

import io.jboot.aop.annotation.Bean;
import io.jboot.components.cache.annotation.CacheEvict;
import io.jboot.components.cache.annotation.Cacheable;
import io.jboot.service.JbootServiceBase;
import net.ninemm.upms.service.api.OptionService;
import net.ninemm.upms.service.model.Option;

import java.util.List;

@Bean
public class OptionServiceImpl extends JbootServiceBase<Option> implements OptionService {

    @Override
    @CacheEvict(name = "option", key = "#(key)")
    public Object saveOrUpdate(String key, String value) {
        Option option = DAO.findFirstByColumn("option_key", key);

        if (option == null) {
            option = new Option();
            option.setOptionKey(key);
        }

        option.setOptionValue(value);

        return saveOrUpdate(option);
    }

    /**
     * 系统配置
     *
     * @param isSystem
     * @return void
     * @date 2019-01-27 22:47
     */
    @Override
    public List<Option> findAllSystemSettingList() {
        String sql = "select option_key, option_value from upms_option where is_system = 1";
        return DAO.find(sql);
    }

    @Override
    @Cacheable(name = "option", key = "#(key)")
    public Option findByKey(String key) {
        return DAO.findFirstByColumn("option_key", key);
    }
}