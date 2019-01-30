package net.ninemm.upms.service.provider;

import com.jfinal.plugin.activerecord.Db;
import io.jboot.aop.annotation.Bean;
import io.jboot.service.JbootServiceBase;
import net.ninemm.upms.service.api.StationOperationRelService;
import net.ninemm.upms.service.model.RoleOperationRel;
import net.ninemm.upms.service.model.StationOperationRel;

import javax.inject.Singleton;
import java.util.List;

@Bean
@Singleton
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

}