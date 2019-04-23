package net.ninemm.upms.service.provider;

import com.jfinal.plugin.activerecord.Page;
import io.jboot.Jboot;
import io.jboot.aop.annotation.Bean;
import io.jboot.db.model.Columns;
import net.ninemm.base.web.base.BaseService;
import net.ninemm.upms.service.api.SellerService;
import net.ninemm.upms.service.model.Seller;

import java.util.Map;

@Bean
public class SellerServiceImpl extends BaseService<Seller> implements SellerService {

    @Override
    public Page<Seller> paginate(int pageNumber, int pageSize, Map<String, Object> params) {
        Columns columns = Columns.create();
        Object sellerName = params.get("sellerName");
        Object deptId = params.get("deptId");
        if (sellerName != null) {
            columns.likeAppendPercent("seller_name", sellerName);
        }
        if (deptId != null) {
            columns.eq("dept_id", deptId);
        }
        Object isAsc = params.get("isAsc");
        Object orderByField = params.get("orderByField");
        String orderBy = orderBy(orderByField, isAsc);
        return DAO.paginateByColumns(pageNumber, pageSize, columns,orderBy);
    }

    @Override
    protected void clearAllCache() {
        Jboot.getCache().removeAll(Seller.CACHE_NAME);
    }

}
