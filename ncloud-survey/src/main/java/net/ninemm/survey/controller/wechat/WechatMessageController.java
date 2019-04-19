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
package net.ninemm.survey.controller.wechat;

import com.jfinal.aop.Aop;
import com.jfinal.aop.Inject;
import com.jfinal.ext.interceptor.LogInterceptor;

import com.jfinal.weixin.sdk.msg.in.*;
import com.jfinal.weixin.sdk.msg.in.card.*;
import io.jboot.web.controller.annotation.RequestMapping;


import com.jfinal.aop.Before;
import com.jfinal.aop.Clear;
import com.jfinal.weixin.iot.msg.InEquDataMsg;
import com.jfinal.weixin.iot.msg.InEqubindEvent;
import com.jfinal.weixin.sdk.jfinal.MsgController;
import com.jfinal.weixin.sdk.msg.in.event.InCustomEvent;
import com.jfinal.weixin.sdk.msg.in.event.InFollowEvent;
import com.jfinal.weixin.sdk.msg.in.event.InLocationEvent;
import com.jfinal.weixin.sdk.msg.in.event.InMassEvent;
import com.jfinal.weixin.sdk.msg.in.event.InMenuEvent;
import com.jfinal.weixin.sdk.msg.in.event.InNotDefinedEvent;
import com.jfinal.weixin.sdk.msg.in.event.InPoiCheckNotifyEvent;
import com.jfinal.weixin.sdk.msg.in.event.InQrCodeEvent;
import com.jfinal.weixin.sdk.msg.in.event.InShakearoundUserShakeEvent;
import com.jfinal.weixin.sdk.msg.in.event.InTemplateMsgEvent;
import com.jfinal.weixin.sdk.msg.in.event.InVerifyFailEvent;
import com.jfinal.weixin.sdk.msg.in.event.InVerifySuccessEvent;
import com.jfinal.weixin.sdk.msg.in.event.InWifiEvent;
import com.jfinal.weixin.sdk.msg.in.speech_recognition.InSpeechRecognitionResults;
import com.jfinal.weixin.sdk.msg.out.OutTextMsg;
import net.ninemm.base.interceptor.GlobalCacheInterceptor;
import net.ninemm.survey.interceptor.WxApiInterceptor;
import net.ninemm.survey.interceptor.WxUserInterceptor;
import net.ninemm.survey.service.api.ConsumerService;
import net.ninemm.survey.service.api.WxUserService;
import net.ninemm.survey.service.model.Consumer;
import net.ninemm.survey.service.model.WxUser;

/**
 * 微信事件消息处理器
 * @author jy
 */
@RequestMapping(value = "/wechat")
@Clear({GlobalCacheInterceptor.class, LogInterceptor.class})
@Before({WxApiInterceptor.class, WxUserInterceptor.class})
public class WechatMessageController extends MsgController {
	@Inject
	WxUserService wxUserService;
	@Inject
	ConsumerService consumerService;

	@Override
	protected void processInTextMsg(InTextMsg inTextMsg) {
		responseDefault(inTextMsg);
	}

	@Override
	protected void processInImageMsg(InImageMsg inImageMsg) {
		responseDefault(inImageMsg,"收到一张图片");
	}


	@Override
	protected void processInVoiceMsg(InVoiceMsg inVoiceMsg) {
		responseDefault(inVoiceMsg);
	}

	@Override
	protected void processInVideoMsg(InVideoMsg inVideoMsg) {
		responseDefault(inVideoMsg);
	}

	@Override
	protected void processInShortVideoMsg(InShortVideoMsg inShortVideoMsg) {
		responseDefault(inShortVideoMsg);
	}

	@Override
	protected void processInLocationMsg(InLocationMsg inLocationMsg) {
		responseDefault(inLocationMsg);
	}

	@Override
	protected void processInLinkMsg(InLinkMsg inLinkMsg) {
		responseDefault(inLinkMsg);
	}

	@Override
	protected void processInCustomEvent(InCustomEvent inCustomEvent) {
		responseDefault(inCustomEvent);
	}

	@Override
	protected void processInFollowEvent(InFollowEvent inFollowEvent) {
		String event = inFollowEvent.getEvent();
		String openid = inFollowEvent.getFromUserName();
		WxUser wxuser = wxUserService.findByOpenid(openid);
		Consumer consumer = consumerService.findByOpenId(openid);
		String message ="感谢您的关注!";

		if(InFollowEvent.EVENT_INFOLLOW_SUBSCRIBE.equals(event)){
			//关注
			if(wxuser.getSubscribe()==0){
				wxuser.setSubscribe(1);
				wxuser.update();
			}
			if(consumer.getSubscribe()==0){
				consumer.setSubscribe(1);
				consumer.update();
			}
		}else{
			//取关
			if(wxuser.getSubscribe()==1){
				wxuser.setSubscribe(0);
				wxuser.update();
			}
			if(consumer.getSubscribe()==1){
				consumer.setSubscribe(0);
				consumer.update();
			}
		}
		responseDefault(inFollowEvent,message);
	}

	@Override
	protected void processInQrCodeEvent(InQrCodeEvent inQrCodeEvent) {
		responseDefault(inQrCodeEvent);
	}

	@Override
	protected void processInLocationEvent(InLocationEvent inLocationEvent) {
		String location_x = inLocationEvent.getLatitude();
		String location_y = inLocationEvent.getLongitude();
		responseDefault(inLocationEvent,"地理位置:"+location_x+","+location_y);
	}

	@Override
	protected void processInMassEvent(InMassEvent inMassEvent) {
		responseDefault(inMassEvent);
	}

	@Override
	protected void processInMenuEvent(InMenuEvent inMenuEvent) {
		responseDefault(inMenuEvent);
	}

	@Override
	protected void processInSpeechRecognitionResults(InSpeechRecognitionResults inSpeechRecognitionResults) {
		responseDefault(inSpeechRecognitionResults);
	}

	@Override
	protected void processInTemplateMsgEvent(InTemplateMsgEvent inTemplateMsgEvent) {
		responseDefault(inTemplateMsgEvent);
	}

	@Override
	protected void processInShakearoundUserShakeEvent(InShakearoundUserShakeEvent inShakearoundUserShakeEvent) {
		responseDefault(inShakearoundUserShakeEvent);
	}

	@Override
	protected void processInVerifySuccessEvent(InVerifySuccessEvent inVerifySuccessEvent) {
		responseDefault(inVerifySuccessEvent);
	}

	@Override
	protected void processInVerifyFailEvent(InVerifyFailEvent inVerifyFailEvent) {
		responseDefault(inVerifyFailEvent);
	}

	@Override
	protected void processInPoiCheckNotifyEvent(InPoiCheckNotifyEvent inPoiCheckNotifyEvent) {
		responseDefault(inPoiCheckNotifyEvent);
	}

	@Override
	protected void processInWifiEvent(InWifiEvent inWifiEvent) {
		responseDefault(inWifiEvent);
	}

	@Override
	protected void processInUserCardEvent(InUserCardEvent inUserCardEvent) {
		responseDefault(inUserCardEvent);
	}

	@Override
	protected void processInUpdateMemberCardEvent(InUpdateMemberCardEvent inUpdateMemberCardEvent) {
		responseDefault(inUpdateMemberCardEvent);
	}

	@Override
	protected void processInUserPayFromCardEvent(InUserPayFromCardEvent inUserPayFromCardEvent) {
		responseDefault(inUserPayFromCardEvent);
	}

	@Override
	protected void processInMerChantOrderEvent(InMerChantOrderEvent inMerChantOrderEvent) {
		responseDefault(inMerChantOrderEvent);
	}

	@Override
	protected void processIsNotDefinedEvent(InNotDefinedEvent inNotDefinedEvent) {
		responseDefault(inNotDefinedEvent);
	}

	@Override
	protected void processIsNotDefinedMsg(InNotDefinedMsg inNotDefinedMsg) {
		responseDefault(inNotDefinedMsg);
	}

	@Override
	protected void processInUserGiftingCardEvent(InUserGiftingCardEvent msg) {
		responseDefault(msg);
	}

	@Override
	protected void processInUserGetCardEvent(InUserGetCardEvent msg) {
		responseDefault(msg);
	}

	@Override
	protected void processInUserConsumeCardEvent(InUserConsumeCardEvent msg) {
		responseDefault(msg);
	}

	@Override
	protected void processInCardSkuRemindEvent(InCardSkuRemindEvent msg) {
		responseDefault(msg);
	}

	@Override
	protected void processInCardPayOrderEvent(InCardPayOrderEvent msg) {
		responseDefault(msg);
	}

	@Override
	protected void processInCardPassCheckEvent(InCardPassCheckEvent msg) {
		responseDefault(msg);
	}

	@Override
	protected void processInEqubindEvent(InEqubindEvent msg) {
		responseDefault(msg);
	}

	@Override
	protected void processInEquDataMsg(InEquDataMsg msg) {
		responseDefault(msg);
	}
	private void responseDefault(InMsg inMsg) {
		OutTextMsg outMsg = new OutTextMsg(inMsg);
		outMsg.setContent("感谢您的关注!");
		render(outMsg);
	}

	private void responseDefault(InMsg inMsg,String message) {
		OutTextMsg outMsg = new OutTextMsg(inMsg);
		outMsg.setContent(message);
		render(outMsg);
	}
}
