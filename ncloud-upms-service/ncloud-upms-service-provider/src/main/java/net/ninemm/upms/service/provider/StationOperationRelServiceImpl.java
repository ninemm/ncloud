package net.ninemm.upms.service.provider;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import io.jboot.aop.annotation.Bean;
import io.jboot.service.JbootServiceBase;
import net.ninemm.upms.service.api.StationOperationRelService;
import net.ninemm.upms.service.model.StationOperationRel;

import java.util.List;

@Bean
public class StationOperationRelServiceImpl extends JbootServiceBase<StationOperationRel> implements StationOperationRelService {

    @Override
    public List<String> findListByStationId(String stationId) {
        String sql = "select operation_id from upms_station_operation_rel where station_id = ?";
        return Db.query(sql, stationId);
    }

    @Override
    public void deleteByModuleId(String stationId, String moduleId) {
        String sql = "delete from upms_station_operation_rel where station_id = ? and module_id = ?";
        Db.delete(sql, stationId, moduleId);
    }

    @Override
    public Record findByOperIdAndStationId(String stationId, String id) {
        String sql = "SELECT * FROM upms_station_operation_rel where  station_id = '"+stationId+"' and operation_id = '"+id +"'";
        return Db.findFirst(sql);
    }

    @Override
    public void deleteByOperationId(String id) {
        String sql = "delete from upms_station_operation_rel where operation_id = '"+id +"'";
        Db.delete(sql);
    }

    @Override
    public Record findStationByOpId(String id) {
        String sql = "SELECT s.* FROM upms_station_operation_rel so LEFT JOIN upms_station s on so.station_id = s.id WHERE so.operation_id ='"+id+"' and so.station_id  is not null";
        return Db.findFirst(sql);
    }

    @Override
    public Record findByOperId(String id) {
        String sql = "SELECT * FROM upms_station_operation_rel where operation_id = '"+id +"'";
        return  Db.findFirst(sql);
    }

}