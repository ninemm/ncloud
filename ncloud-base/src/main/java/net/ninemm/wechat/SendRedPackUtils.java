package net.ninemm.wechat;

import java.util.Map;

/**
 * @description:
 * @author: lsy
 * @create: 2019-04-13 12:03
 **/
public class SendRedPackUtils {
    private static String wxappIdKey = "wxcf12086e850e0885";
    private static String partner = "1522637501";
    private static String sendName = "武汉珈研";
    private static String paternerKey = "7322375DFD0D9C1DBE489E93002D889B";
    private static String certPath = "C://apiclient_cert.p12";
    private static String notifyUrl="http://wxtest.juster.com.cn/wxPay/wxpaynotify";

    public static Map<String,Object> sendRedPack(String openid,String appid,String ip){
        /*// 接受红包的用户用户在wxappIdKey下的openid
        String reOpenid = "";
        // 商户订单号
        String mchBillno = System.currentTimeMillis() + "";
        String ip = IpKit.getRealIp(getRequest());

        Map<String, String> params = new HashMap<String, String>();
        // 随机字符串
        params.put("nonce_str", System.currentTimeMillis() / 1000 + "");
        // 商户订单号
        params.put("mch_billno", mchBillno);
        // 商户号
        params.put("mch_id", "1522637501");
        // 公众账号ID
        params.put("wxappIdKey", wxappIdKey);
        // 商户名称
        params.put("send_name", sendName);
        // 用户OPENID
        params.put("re_openid", reOpenid);
        // 付款现金(单位分)
        params.put("total_amount", "100");
        // 红包发放总人数
        params.put("total_num", "1");
        // 红包祝福语
        params.put("wishing", "恭喜您....");
        // 终端IP
        params.put("client_ip", ip);
        // 活动名称
        params.put("act_name", "床垫睡眠日活动");
        // 备注
        params.put("remark", "新年新气象");
        //创建签名
        String sign = PaymentKit.createSign(params, paternerKey);
        params.put("sign", sign);

        String xmlResult = RedPackApi.sendRedPack(params, certPath, partner);
        Map<String, String> result = PaymentKit.xmlToMap(xmlResult);
        System.out.println(result);
        //业务结果
        String result_code = result.get("result_code");
        //此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断
        String return_code = result.get("return_code");
        //
        if (StrKit.isBlank(result_code) || !"SUCCESS".equals(result_code)) {
            System.out.println("发送成功");
        } else {
            System.out.println("发送失败");
        }
        renderJson(result);*/
        return null;
    }
}
