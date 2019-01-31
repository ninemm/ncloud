package net.ninemm.upms.service.provider;

import com.google.common.collect.ComparisonChain;
import com.jfinal.plugin.activerecord.Page;
import io.jboot.Jboot;
import io.jboot.aop.annotation.Bean;
import io.jboot.core.cache.annotation.Cacheable;
import io.jboot.db.model.Columns;
import net.ninemm.base.web.base.BaseService;
import net.ninemm.upms.service.api.DictService;
import net.ninemm.upms.service.model.Dict;

import javax.inject.Singleton;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Bean
@Singleton
public class DictServiceImpl extends BaseService<Dict> implements DictService {

    @Override
    public Page<Dict> paginate(int page, int pageSize, Map<String, Object> params) {
        Columns columns = Columns.create();
        Object groupName = params.get("dictName");
        if (groupName != null) {
            columns.likeAppendPercent("dict_name", groupName);
        }

        Object dataArea = params.get("dataArea");
        if (dataArea != null) {
            columns.like("data_area", dataArea);
        }

        Object isAsc = params.get("isAsc");
        Object orderByField = params.get("orderByField");
        String orderBy = orderBy(orderByField, isAsc);
        return DAO.paginateByColumns(page, pageSize, columns, orderBy);
    }

    @Override
    @Cacheable(name = "upms_dict", key = "list:#(type)")
    public List<Dict> findListByDictType(String type) {
        List<Dict> list = DAO.findListByColumn("type",type);
        Collections.sort(list, new Comparator<Dict>() {
            @Override
            public int compare(Dict src, Dict dest) {
                return ComparisonChain.start()
                    .compare(src.getValue(), dest.getValue())
                    .result();
            }
        });
        return list;
    }

    @Override
    @Cacheable(name = "upms_dict", key = "#(key)")
    public String findDictNameByKey(String key) {
        Dict dict = DAO.findFirstByColumn("value", key);
        if (dict == null) {
            return null;
        }
        return dict.getName();
    }

    @Override
    public boolean deleteById(Object id) {
        clearAllCache();
        return super.deleteById(id);
    }

    @Override
    public boolean delete(Dict model) {
        clearAllCache();
        return super.delete(model);
    }

    @Override
    public boolean save(Dict model) {
        clearAllCache();
        return super.save(model);
    }

    @Override
    public boolean saveOrUpdate(Dict model) {
        clearAllCache();
        return super.saveOrUpdate(model);
    }

    @Override
    public boolean update(Dict model) {
        clearAllCache();
        return super.update(model);
    }

    @Override
    protected void clearAllCache() {
        Jboot.me().getCache().removeAll("upms_dict");
    }
}