package net.ninemm.survey.service.provider;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import io.jboot.aop.annotation.Bean;
import net.ninemm.survey.service.api.ConsumerService;
import net.ninemm.survey.service.model.Consumer;
import io.jboot.service.JbootServiceBase;


@Bean
public class ConsumerServiceImpl extends JbootServiceBase<Consumer> implements ConsumerService {

    @Override
    public Consumer findByOpenId(String openid) {
        String sql ="select * from survey_consumer where openid=? ";
        return DAO.findFirst(sql,openid);
    }
}
