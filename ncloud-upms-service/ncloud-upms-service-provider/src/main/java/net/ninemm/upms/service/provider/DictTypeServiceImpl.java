package net.ninemm.upms.service.provider;

import com.jfinal.plugin.activerecord.Page;
import io.jboot.aop.annotation.Bean;
import io.jboot.db.model.Columns;
import net.ninemm.base.web.base.BaseService;
import net.ninemm.upms.service.api.DictTypeService;
import net.ninemm.upms.service.model.DictType;

import java.util.Map;

@Bean
public class DictTypeServiceImpl extends BaseService<DictType> implements DictTypeService {

    @Override
    public Page<DictType> paginate(int page, int pageSize, Map<String, Object> params) {
        Columns columns = Columns.create();
        Object name = params.get("name");
        if (name != null) {
            columns.likeAppendPercent("name", name);
        }

        Object isAsc = params.get("isAsc");
        Object orderByField = params.get("orderByField");
        String orderBy = orderBy(orderByField, isAsc);
        return DAO.paginateByColumns(page, pageSize, columns, orderBy);
    }

    /**
     * 清除 model 缓存
     */
    @Override
    protected void clearAllCache() {

    }
}