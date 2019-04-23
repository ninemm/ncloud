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
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Bean
public class StationServiceImpl extends BaseService<Station> implements StationService {

    @Inject
    StationOperationRelServiceImpl stationOperationRelService;

//    @Override
//    public Page<Station> paginate(int page, int pageSize, Map<String, Object> params) {
//        Columns columns = Columns.create();
//        Object stationName = params.get("stationName");
//        Object dataArea = params.get("dataArea");
//        if (dataArea!=null){
//            columns.likeAppendPercent("data_area",dataArea);
//        }
//        if (stationName != null) {
//            columns.likeAppendPercent("station_name", stationName);
//        }
//        Object isAsc = params.get("isAsc");
//        Object orderByField = params.get("orderByField");
//        String orderBy = orderBy(orderByField, isAsc);
//        return DAO.paginateByColumns(page, pageSize, columns, orderBy);
//    }

    @Override
    public Page<Station> paginate(int page, int pageSize, Map<String, Object> params) {
        String select = "SELECT s.*,us.station_name parentName ";
        StringBuilder fromBuilder = new StringBuilder("FROM upms_station s LEFT JOIN upms_station us on us.id = s.parent_id ");
        LinkedList<Object> param = new LinkedList<Object>();
        Object stationName = params.get("stationName");
        Object dataArea = params.get("dataArea");
        if (dataArea!=null){
            fromBuilder.append("where s.data_area like ? ");
            param.add(dataArea);
        }
        if (stationName != null) {
            fromBuilder.append("and s.station_name like ? ");
            param.add("%"+stationName+"%");
        }
        return DAO.paginate(page, pageSize, select, fromBuilder.toString(), param.toArray());
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

    @Override
    public List<Record> findByDataArea(String dataArea) {
        String sql ="SELECT * FROM upms_station where data_area like '"+dataArea+"' order by data_area desc";
        return Db.find(sql);
    }

    @Override
    public List<Record> findNotListByDataArea(String s, String substring) {
        String sql = "SELECT * FROM upms_station where data_area like '"+s+"' and id not in("+substring+")";
        return Db.find(sql);
    }

    @Override
    public List<Record> findByIds(String substring) {
        String sql = "SELECT * FROM upms_station where id in("+substring+")";
        return Db.find(sql);
    }

    /**
     * 清除 model 缓存
     */
    @Override
    protected void clearAllCache() {
        Jboot.getCache().removeAll(Station.CACHE_NAME);
    }
}