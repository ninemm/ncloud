package net.ninemm.survey.service.provider;

import io.jboot.aop.annotation.Bean;
import io.jboot.db.model.Column;
import io.jboot.db.model.Columns;
import net.ninemm.survey.service.api.WxPayOrderService;
import net.ninemm.survey.service.model.WxPayOrder;
import io.jboot.service.JbootServiceBase;


@Bean
public class WxPayOrderServiceImpl extends JbootServiceBase<WxPayOrder> implements WxPayOrderService {

    @Override
    public WxPayOrder findByTradeNo(String tradeNo) {

        return DAO.findFirstByColumn(Column.create("",tradeNo));
    }
}
