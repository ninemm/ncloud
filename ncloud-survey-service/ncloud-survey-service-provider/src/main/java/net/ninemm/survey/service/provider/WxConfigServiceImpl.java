package net.ninemm.survey.service.provider;

import com.jfinal.plugin.activerecord.Db;
import io.jboot.aop.annotation.Bean;
import io.jboot.db.model.Column;
import net.ninemm.survey.service.api.WxConfigService;
import net.ninemm.survey.service.model.WxConfig;
import io.jboot.service.JbootServiceBase;

import java.util.List;


@Bean
public class WxConfigServiceImpl extends JbootServiceBase<WxConfig> implements WxConfigService {

    @Override
    public List<WxConfig> findOpenConfig() {
        String sql="select * from wx_config where is_open = 1";
        return DAO.find(sql);
    }

    @Override
    public WxConfig findByAppId(String appIdKey) {
        String sql="select * from wx_config where is_open = 1 and appid= ? ";
        return DAO.findFirst(sql,appIdKey);
    }

    @Override
    public List<WxConfig> findByDeptId(String deptId) {
        Column column = Column.create("dept_id", deptId);
        return DAO.findListByColumn(column);
    }

    @Override
    public String findStringAppid(String departmentId) {
        String sql ="select GROUP_CONCAT(appid) from wx_config where is_open=1 and dept_id=?";
        return Db.queryStr(sql,departmentId);
    }

    @Override
    public WxConfig findDefaultConfig() {
        String sql="select * from wx_config where is_open = 1 and is_default=1 ";
        return DAO.findFirst(sql);
    }
}
