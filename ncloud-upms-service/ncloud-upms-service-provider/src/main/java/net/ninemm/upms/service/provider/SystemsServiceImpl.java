package net.ninemm.upms.service.provider;

import com.jfinal.plugin.activerecord.Page;
import io.jboot.Jboot;
import io.jboot.aop.annotation.Bean;
import io.jboot.db.model.Columns;
import net.ninemm.base.web.base.BaseService;
import net.ninemm.upms.service.api.SystemsService;
import net.ninemm.upms.service.model.Systems;

import javax.inject.Singleton;
import java.util.List;
import java.util.Map;

@Bean
@Singleton
public class SystemsServiceImpl extends BaseService<Systems> implements SystemsService {

    @Override
    public Page<Systems> paginate(int page, int pageSize, Map<String, Object> params) {

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

    @Override
    public boolean deleteById(Object id) {
        clearAllCache();
        return super.deleteById(id);
    }

    @Override
    public boolean save(Systems model) {
        clearAllCache();
        return super.save(model);
    }

    @Override
    public boolean saveOrUpdate(Systems model) {
        clearAllCache();
        return super.saveOrUpdate(model);
    }

    @Override
    public boolean update(Systems model) {
        clearAllCache();
        return super.update(model);
    }

    @Override
    public List<Systems> findListAsSelect() {
        String sql = "select id, name from upms_systems order by order_list asc";
        return DAO.findByCache(Systems.CACHE_NAME, Systems.CACHE_SELECT_LIST_KEY, sql);
    }

    @Override
    protected void clearAllCache() {
        Jboot.me().getCache().removeAll(Systems.CACHE_NAME);
    }
}