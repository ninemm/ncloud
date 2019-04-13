package net.ninemm.survey.service.provider;

import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import io.jboot.aop.annotation.Bean;
import net.ninemm.survey.service.api.WxRedpackResultService;
import net.ninemm.survey.service.model.WxRedpackResult;
import io.jboot.service.JbootServiceBase;


@Bean
public class WxRedpackResultServiceImpl extends JbootServiceBase<WxRedpackResult> implements WxRedpackResultService {

    @Override
    public Page<Record> paginate(Integer pageNumber, Integer pageSize, String departmentId) {
        String findSql="select wrr.*,wc.customer_name,sy.title from wx_redpack_result wrr INNER JOIN wx_config wc on wrr.wxappid=wc.appid INNER JOIN survey sy on  wrr.survey_id=sy.id " +
                            "where wc.dept_id =? ";
        String totalrowSql="select count(0) from wx_redpack_result wrr INNER JOIN wx_config wc on wrr.wxappid=wc.appid INNER JOIN survey sy on  wrr.survey_id=sy.id " +
                        "where wc.dept_id =? ";
        return Db.paginateByFullSql(pageNumber,pageSize,totalrowSql,findSql,departmentId);
    }

    @Override
    public Page<Record> paginateBySurveyId(Integer pageNumber, Integer pageSize, Kv kv) {
        String findSql="select wrr.*,wc.customer_name,sy.title from wx_redpack_result wrr INNER JOIN wx_config wc on wrr.wxappid=wc.appid INNER JOIN survey sy on  wrr.survey_id=sy.id  where wrr.survey_id =?";
        String totalrowSql="select count(0) from wx_redpack_result wrr INNER JOIN wx_config wc on wrr.wxappid=wc.appid INNER JOIN survey sy on  wrr.survey_id=sy.id  where wrr.survey_id =?";
        return Db.paginateByFullSql(pageNumber,pageSize,totalrowSql,findSql,kv.getStr("surveyId"));
    }
}