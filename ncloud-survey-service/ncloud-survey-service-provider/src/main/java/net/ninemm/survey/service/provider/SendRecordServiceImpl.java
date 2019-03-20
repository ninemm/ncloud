package net.ninemm.survey.service.provider;

import com.jfinal.plugin.activerecord.Db;
import io.jboot.aop.annotation.Bean;
import io.jboot.db.model.Column;
import net.ninemm.survey.service.api.SendRecordService;
import net.ninemm.survey.service.model.SendRecord;
import io.jboot.service.JbootServiceBase;

import java.util.List;


@Bean
public class SendRecordServiceImpl extends JbootServiceBase<SendRecord> implements SendRecordService {

    @Override
    public List<String> findByColums(String surveyId, int sendWay, List<String> contactList) {
        String str = contactList.toString().replace("[","").replace("]","");
        String sql ="select send_address from survey_send_record where survey_id=? and type=? and is_success=1 and send_address in ("+str+")";
        return Db.query(sql,surveyId,sendWay);
    }

    @Override
    public SendRecord findByShortUrl(String shortUrl) {
        Column colum = Column.create("short_link", shortUrl);
        return DAO.findFirstByColumn(colum,"create_date desc ");
    }

}