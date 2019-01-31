/*
 * Copyright (c) 2015-2018, Eric Huang 黄鑫 (ninemm@126.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.ninemm.base.common;

/**
 * 常量
 * @author Eric
 *
 */
public class Consts {

	/**
	 * Jwt 对应的userId
	 */
	public static final String JWT_USER_ID = "userId";

	public static final String COOKIE_USER_ID = "cookieUserId";

	/**
	 * session 用户角色key
	 */
	public static final String SESSION_USER_ROLE = "_user_role";
	public static final String SESSION_EAMIL_USER="_email_val";
	public static final String SESSION_MESSAGE = "_message";
	/**
	 * 短信session值
	 */
	public static final String SESSION_SMS = "_sms_val";
	
	/**
	 * 微信授权 token 存储在 session 里 对应的 key
	 */
	public static final String WEIXIN_SESSION_CODE = "_weixin_code";
	
	public static final int PAGE_DEFAULT_SIZE = 10;
	
	/**
	 * 定位当前菜单功能标识
	 */
	public static final String FUNC_TAG = "_func";

	/**
	 * 表单token 防止重复提交
	 */
	public static final String TOKEN_TAG = "_token";

	public static final String CAPTCHA_CODE = "code";

	/**
	 * 跨域访问时，过滤请求类型为 options 的方法
	 */
	public static final String FILTER_OPTIONS_METHOD = "options";

	/**
	 * 账套类型 经销商账套
	 */
	public static final String SELLER_ACCOUNT_TYPE_FIRST = "1";
	/**
	 * 账套类型 直营商账套
	 */
	public static final String SELLER_ACCOUNT_TYPE_SECOND = "0";

	/** 树根节点默认ID */
	public static final Integer TREE_DEFAULT_ROOT_ID = 0;

	/**
	 * 超级管理员权限
	 */
	public static final String SUPER_ADMIN_PERMISSION = "/admin/all";

	/**
	 * 管理员权限
	 */
	public static final String MANAGER_PERMISSION = "/admin/manager";

	/**
	 * APP 版本升级(APK包下载地址)
	 */
	public static final String APP_UPGRADE_URL = "app_upgrade_url";

    /**
     * APP 版本号
     */
	public static final String APP_VERSION_CODE = "app_version_code";

    /**
     * APP 更新内容
     */
	public static final String APP_UPGRADE_CONTENT = "app_upgrade_content";

	/**
	 * 公共返回参数Key
	 *
	 * @author Eric.Huang
	 * @date 2018-06-28 22:58
	 **/
	public interface ResponseKeys {
		/**
		 * 状态位
		 */
		String STATUS = "status";

		/**
		 * 返回提示信息
		 */
		String MESSAGE = "message";

		/**
		 * 签名认证信息
		 */
		String SIGN = "sign";
	}

	/**
	 * 接口公共请求参数KEY
	 *
	 * @author Eric.Huang
	 * @date 2018-06-28 22:56
	 **/
	public interface RequestKeys {
		/**
		 * 时间戳
		 */
		public static final String TIMESTAMP = "timestamp";

		/**
		 * 客户端版本号
		 */
		public static final String VERSION = "version";

		/**
		 * 客户端版本标识
		 */
		public static final String PLATFORM = "platform";

		/**
		 * 签名认证信息
		 */
		public static final String SIGN = "sign";

		/**
		 * 登录令牌
		 */
		public static final String JWT = "Jwt";

		/**
		 * 请求主要数据域
		 */
		public static final String DATA = "data";
	}

	/**
	 * 平台
	 */
	public interface Platform {
		String ANDROID = "android";
		String IOS = "ios";
		String WECHAT = "wechat";
		String QYWECHAT = "qywechat";
	}

	public static final String ES_INDEX_STORE = "tcloud";
	public static final String ES_INDEX_TYPE_CUSTOMER = "customer";


}
