/**
 * Copyright (c) 2015-2016, 九毫米(Eric Huang) (hx50859042@gmail.com).
 *
 * Licensed under the GNU Lesser General Public License (LGPL) ,Version 3.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.gnu.org/licenses/lgpl-3.0.txt
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.ninemm.base.sms;

import io.jboot.Jboot;
import io.jboot.utils.StrUtil;
import net.ninemm.base.utils.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;



public class AlidayuSmsSender implements ISmsSender {
	private static final Logger log = LoggerFactory.getLogger(AlidayuSmsSender.class);

	@Override
	public boolean send(SmsMessage sms) {
		String app_key =  Jboot.configValue("jboot.sms_key");
		String app_secret =  Jboot.configValue("jboot.sms_secret");

		String sendResult = doSend(sms, app_key, app_secret);

		if (Jboot.isDevMode()) {
			System.err.println("sms send result:" + sendResult);
		}

		if (StrUtil.areNotEmpty(sendResult)) {
			if (sendResult != null && sendResult.contains("alibaba_aliqin_fc_sms_num_send_response") && sendResult.contains("success") && sendResult.contains("true")) {
				return true;
			}
		}
		return false;
	}
	
	public String sendResult(SmsMessage sms) {
		String app_key =  Jboot.configValue("jboot.sms_key");
		String app_secret =  Jboot.configValue("jboot.sms_secret");
		String sendResult = doSend(sms, app_key, app_secret);
		if (Jboot.isDevMode()) {
			System.err.println("sms send result:" + sendResult);
		}
		return sendResult;
	}

	private static String doSend(SmsMessage sms, String app_key, String app_secret) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("format", "json");
		params.put("method", "alibaba.aliqin.fc.sms.num.send");
		params.put("sign_method", "md5");

		String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		params.put("timestamp", timestamp);
		params.put("v", "2.0");
		params.put("rec_num", sms.getRec_num());
		params.put("sms_free_sign_name", sms.getSign_name());
		params.put("sms_param", sms.getParam());
		params.put("sms_template_code", sms.getTemplate());
		params.put("sms_type", "normal");
		params.put("app_key", app_key);

		String sign = EncryptUtils.signForRequest(params, app_secret);
		params.put("sign", sign);

		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
		try {
			return HttpUtils.post("http://gw.api.taobao.com/router/rest", params, headers);
		} catch (Exception e) {
			log.error("AlidayuSmsSender doSend http exception", e);
		}
		return null;
	}
	
	public static String sendValidateCode(String mobile ,String code) {
    	SmsMessage sms = new SmsMessage();
		sms.setRec_num(mobile);
		sms.setTemplate(Jboot.configValue("jboot.sms_code"));
		sms.setParam("{\"code\":\""+code+"\"}");
		sms.setSign_name(Jboot.configValue("jboot.sms_freeSignName"));
    	String sendResult = new AlidayuSmsSender().sendResult(sms);
    	return sendResult;
	}

	public static String sendSurvey(String mobile, String url) {
		SmsMessage sms = new SmsMessage();
		sms.setRec_num(mobile);
		sms.setTemplate(Jboot.configValue("jboot.sms_code"));
		sms.setParam("{\"url\":\""+url+"\"}");
		sms.setSign_name(Jboot.configValue("jboot.sms_freeSignName"));
		String sendResult = new AlidayuSmsSender().sendResult(sms);
		return sendResult;
	}
}
