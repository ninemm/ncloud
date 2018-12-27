package net.ninemm.upms.service.provider;

import com.google.common.base.Splitter;
import com.jfinal.plugin.activerecord.Page;
import io.jboot.aop.annotation.Bean;
import io.jboot.db.model.Columns;
import io.jboot.service.JbootServiceBase;
import net.ninemm.upms.service.api.OperationService;
import net.ninemm.upms.service.model.Operation;

import javax.inject.Singleton;
import java.util.List;
import java.util.Map;

@Bean
@Singleton
public class OperationServiceImpl extends JbootServiceBase<Operation> implements OperationService {

    @Override
    public Page<Operation> paginate(int page, int pageSize, Map<String, Object> params) {
        Columns columns = Columns.create();
        Object operationName = params.get("operationName");
        if (operationName != null) {
            columns.likeAppendPercent("operation_name", operationName);
        }

        Object orderByField = params.get("orderByField");
        String orderByFields = orderByField != null ? orderByField.toString() : "create_date";
        Object isAsc = params.get("isAsc");
        String orderBy = orderBy(orderByFields, isAsc);

        return DAO.paginateByColumns(page, pageSize, columns, orderBy);
    }

    private String orderBy(String orderByFields, Object isAsc) {

        boolean isSort = false;
        if (isAsc != null) {
            isSort = Boolean.valueOf(isAsc.toString());
        }
        String sort = isSort ? "asc" : "desc";

        List<String> list = Splitter.on(",").splitToList(orderByFields);
        StringBuilder sb = new StringBuilder();
        if (list.size() == 1) {
            sb.append(list.get(0)).append(" ").append(sort);
            return sb.toString();
        }

        for (String field : list) {
            sb.append(field).append(" ").append(sort).append(",");
        }
        return sb.substring(0, sb.length() - 1);
    }
}