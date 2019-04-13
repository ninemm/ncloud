package net.ninemm.survey.service.provider;

import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.activerecord.SqlPara;
import io.jboot.Jboot;
import io.jboot.aop.annotation.Bean;
import net.ninemm.survey.service.api.WxUserService;
import net.ninemm.survey.service.model.TaskRel;
import net.ninemm.survey.service.model.WxUser;
import io.jboot.service.JbootServiceBase;


@Bean
public class WxUserServiceImpl extends JbootServiceBase<WxUser> implements WxUserService {

    @Override
    public WxUser findByOpenid(String openid) {
        String sql="select * from wx_user where openid= ?";
        return DAO.findFirst(sql,openid);
    }

    @Override
    public void updateUserStatus(String openid, int subscribe) {
        String sql="update wx_user set subscribe=? where openid=?";
        Db.update(sql, subscribe, openid);
    }

    @Override
    public Page<Record> paginate(Integer pageNumber, Integer pageSize, String deptid) {
        String totalrowSql="SELECT count(0) FROM wx_user wx INNER JOIN wx_config wc on wx.appid=wc.appid where wc.dept_id =?";
        String findSql="SELECT wx.*,wc.customer_name FROM wx_user wx INNER JOIN wx_config wc on wx.appid=wc.appid where wc.dept_id =?";

        return Db.paginateByFullSql(pageNumber,pageSize,totalrowSql,findSql,deptid);
    }
}