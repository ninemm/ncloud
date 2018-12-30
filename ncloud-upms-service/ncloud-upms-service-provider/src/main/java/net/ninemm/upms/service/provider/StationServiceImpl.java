package net.ninemm.upms.service.provider;

import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.activerecord.SqlPara;
import io.jboot.Jboot;
import io.jboot.aop.annotation.Bean;
import io.jboot.db.model.Columns;
import io.jboot.utils.StrUtils;
import net.ninemm.base.web.base.BaseService;
import net.ninemm.upms.service.api.StationService;
import net.ninemm.upms.service.model.Station;

import javax.inject.Singleton;
import java.util.List;
import java.util.Map;

@Bean
@Singleton
public class StationServiceImpl extends BaseService<Station> implements StationService {

    @Override
    public Page<Station> paginate(int page, int pageSize, Map<String, Object> params) {
        Columns columns = Columns.create();
        Object stationName = params.get("stationName");
        if (stationName != null) {
            columns.likeAppendPercent("station_name", stationName);
        }

        Object isAsc = params.get("isAsc");
        Object orderByField = params.get("orderByField");
        String orderBy = orderBy(orderByField, isAsc);
        return DAO.paginateByColumns(page, pageSize, columns, orderBy);
    }

    @Override
    public List<Record> findOperationPermsByStationId(String stationId, String dataArea) {
        Kv params = Kv.by("stationId", stationId);
        SqlPara sqlPara = Db.getSqlPara("upms-station.findOperationPermsByStationId", params);
        return Db.find(sqlPara);
    }

    @Override
    public List<Record> findListAsOptions(String dataArea) {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("select id, station_name as name from upms_station where 1=1");
        if (StrUtils.isNotBlank(dataArea)) {
            sqlBuilder.append(" AND data_area = ?");
        }

        return Db.find(sqlBuilder.toString());
    }

    /**
     * 清除 model 缓存
     */
    @Override
    protected void clearAllCache() {
        Jboot.me().getCache().removeAll(Station.CACHE_NAME);
    }
}