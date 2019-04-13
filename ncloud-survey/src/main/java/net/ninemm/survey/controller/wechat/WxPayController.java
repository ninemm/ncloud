package net.ninemm.survey.controller.wechat;

import com.jfinal.aop.Clear;
import com.jfinal.aop.Inject;
import com.jfinal.ext.interceptor.LogInterceptor;
import com.jfinal.kit.HttpKit;
import com.jfinal.kit.StrKit;
import com.jfinal.weixin.sdk.api.PaymentApi;
import com.jfinal.weixin.sdk.kit.IpKit;
import com.jfinal.weixin.sdk.kit.PaymentKit;
import io.jboot.utils.StrUtil;
import io.jboot.web.controller.annotation.RequestMapping;
import net.ninemm.base.interceptor.GlobalCacheInterceptor;
import net.ninemm.base.utils.DateUtils;
import net.ninemm.survey.controller.BaseAppController;
import net.ninemm.survey.service.api.WxPayOrderService;
import net.ninemm.survey.service.model.WxPayOrder;
import net.ninemm.upms.service.api.UserService;
import net.ninemm.upms.service.model.User;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 微信支付 包括统一下单 支付回调等
 * @author: lsy
 * @create: 2019-03-29 16:35
 **/
@RequestMapping(value = "/wxPay")
public class WxPayController extends BaseAppController {
    @Inject
    WxPayOrderService wxPayOrderService;
    @Inject
    UserService userService;

    private static String wxappIdKey = "wxcf12086e850e0885";
    // 微信支付分配的商户号
    private static String partner = "1522637501";
    private static String sendName = "武汉珈研";
    //API密钥
    private static String paternerKey = "7322375DFD0D9C1DBE489E93002D889B";
    //微信证书路径
    private static String certPath = "C://apiclient_cert.p12";

    private static String notifyUrl="http://wxtest.juster.com.cn/wxPay/wxpaynotify";

    public void unifiedorderNative(){
        String productId = "2";
        String body = "武汉珈研微信支付测试";
        String totalFee ="1";
        String tradeNo= StrUtil.uuid();
        String tradeType=PaymentApi.TradeType.NATIVE.name();
        String nonceStr=System.currentTimeMillis() / 1000 + "";

        Map<String, String> params = new HashMap<String, String>();
        params.put("appid", wxappIdKey);
        params.put("mch_id", partner);
        params.put("body", body);
        params.put("product_id", productId);
        params.put("out_trade_no", tradeNo);
        params.put("total_fee", totalFee);
        String ip = IpKit.getRealIp(getRequest());
        if (StrKit.isBlank(ip)) {
            ip = "127.0.0.1";
        }
        params.put("spbill_create_ip", ip);
        params.put("trade_type", tradeType);
        params.put("nonce_str", nonceStr);
        params.put("notify_url", notifyUrl);

        String sign = PaymentKit.createSign(params, paternerKey);
        params.put("sign", sign);
        String xmlResult = PaymentApi.pushOrder(params);

        System.out.println(xmlResult);
        Map<String, String> result = PaymentKit.xmlToMap(xmlResult);

        String return_code = result.get("return_code");
        String return_msg = result.get("return_msg");
        if (StrKit.isBlank(return_code) || !"SUCCESS".equals(return_code)) {
            renderText(return_msg);
            return;
        }
        String result_code = result.get("result_code");
        if (StrKit.isBlank(result_code) || !"SUCCESS".equals(result_code)) {
            renderText(return_msg);
            return;
        }
        // 以下字段在return_code 和result_code都为SUCCESS的时候有返回
        String prepay_id = result.get("prepay_id");
        // trade_type为NATIVE是有返回，可将该参数值生成二维码展示出来进行扫码支付
        String code_url = result.get("code_url");

        User user = userService.findById(getUserId());
        WxPayOrder wxPayOrder = new WxPayOrder();
        wxPayOrder.setId(tradeNo);
        wxPayOrder.setProductId(productId);
        wxPayOrder.setTotalFee(totalFee);
        wxPayOrder.setMchId(partner);
        wxPayOrder.setIp(ip);
        wxPayOrder.setTradeType(tradeType);
        wxPayOrder.setNonceStr(nonceStr);
        wxPayOrder.setSign(sign);
        if (tradeType.equals(PaymentApi.TradeType.NATIVE.name())){
            wxPayOrder.setCodeUrl(prepay_id);
        }
        wxPayOrder.setOrderStatus(0);
        wxPayOrder.setUserId(user.getId());
        wxPayOrder.setDeptId(user.getDepartmentId());
        wxPayOrder.setDataArea(user.getDataArea());
        wxPayOrder.save();
        renderQrCode(code_url,300,300);
    }

    @Clear({GlobalCacheInterceptor.class, LogInterceptor.class})
    public void wxpaynotify(){
        String result = HttpKit.readData(getRequest());
        Map<String, String> map = PaymentKit.xmlToMap(result);
        String sign = map.get("sign");
        String totFee = map.get("total_fee");
        String tradeNo = map.get("out_trade_no");

        String packageSign = PaymentKit.createSign(map, paternerKey);
        //签名验证,并校验返回的订单金额是否与商户侧的订单金额一致，防止数据泄漏导致出现“假通知”
        if (sign.equals(packageSign)) {
            WxPayOrder wxPayOrder = wxPayOrderService.findById(tradeNo);
            if(!totFee.equals(wxPayOrder.getTotalFee())){
                return;
            }else if(wxPayOrder.getOrderStatus()==1 || StrUtil.isNotEmpty(wxPayOrder.getTransactionId()) ){
                //订单状态 0未支付 1已支付
                return;
            }else {
                wxPayOrder.setOrderStatus(1);
                wxPayOrder.setTransactionId(map.get("transaction_id"));
                wxPayOrder.setOpenid(map.get("openid"));
                Date modifyDate = new Date();
                try {
                    modifyDate = DateUtils.parse(map.get("time_end"), "yyyyMMddHHmmss");
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                wxPayOrder.setModifyDate(modifyDate);
            }
            Map<String, String> prepayParams = new HashMap<String, String>();
            prepayParams.put("return_code", "SUCCESS");
            prepayParams.put("return_msg", "OK");
            String xml = PaymentKit.toXml(prepayParams);
            System.out.println(xml);
            renderText(xml);
        }

    }
}
