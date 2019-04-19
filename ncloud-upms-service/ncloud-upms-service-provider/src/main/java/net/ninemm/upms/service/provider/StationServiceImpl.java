package net.ninemm.upms.service.provider;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.jfinal.aop.Inject;
import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.*;
import io.jboot.Jboot;
import io.jboot.aop.annotation.Bean;
import io.jboot.db.model.Columns;
import io.jboot.utils.StrUtil;
import net.ninemm.base.web.base.BaseService;
import net.ninemm.upms.service.api.StationService;
import net.ninemm.upms.service.model.Station;
import net.ninemm.upms.service.model.StationOperationRel;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Bean
public class StationServiceImpl extends BaseService<Station> implements StationService {

    @Inject
    StationOperationRelServiceImpl stationOperationRelService;

    @Override
    public Page<Station> paginate(int page, int pageSize, Map<String, Object> params) {
        Columns columns = Columns.create();
        Object stationName = params.get("stationName");
        Object deptId = params.get("deptId");
        if (deptId!=null){
            columns.eq("dept_id",deptId);
        }
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
        if (StrUtil.isNotBlank(dataArea)) {
            sqlBuilder.append(" AND data_area = ?");
        }

        return Db.find(sqlBuilder.toString());
    }

    /**
     * 更新角色权限
     *
     * @param roleId
     * @param moduleId
     * @param operationIds
     * @return java.util.List<net.ninemm.upms.service.model.Role>
     * @author Eric
     * @date 2018-12-27 14:36
     */
    @Override
    public void updatePermission(final String stationId, final String moduleId, final String operationIds) {

        boolean updated = Db.tx(new IAtom() {
            @Override
            public boolean run() throws SQLException {

                stationOperationRelService.deleteByModuleId(stationId, moduleId);
                List<StationOperationRel> list = Lists.newArrayList();
                if (StrUtil.isBlank(operationIds)) {
                    return true;
                }

                Splitter.on(",").splitToList(operationIds).stream().forEach(operatorId -> {
                    StationOperationRel sor = new StationOperationRel();
                    sor.setId(StrUtil.uuid());
                    sor.setStationId(stationId);
                    sor.setModuleId(moduleId);
                    sor.setOperationId(operatorId);

                    list.add(sor);
                });

                Db.batchSave(list, list.size());
                return true;
            }
        });
    }

    /**
     * 清除 model 缓存
     */
    @Override
    protected void clearAllCache() {
        Jboot.getCache().removeAll(Station.CACHE_NAME);
    }
}