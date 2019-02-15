package com.invech.platform.dsfcenterdata.constants;

import java.math.BigDecimal;


public class ApiConstants {

	public static final String SITE_SECURETY_KEY ="Site";

	//TODO 和account 同步
	public static final String PLAYER_LOGGIN_KEY ="Access_Token";

	public static final BigDecimal DEAULT_ZERO_VALUE = new BigDecimal("0.00");
	public static final String USER_TOKEN_SPLIT = "_";// 用户信息token分隔符

	public static final Integer BBIN_TRANSFER_SUCCEED = 11100;// 11100 Transfer Successful 轉帳成功

	public static final Integer BBIN_TRANSFER_FAIL = 10003;// 转账失败

	public static final Integer BBIN_SYS_MAINTENANCE = 44444;// 系统维护中

	public static final Integer BBIN_GM_MAINTENANCE = 44445;// 系统维护中Game is in maintenance

	public static final Integer BBIN_KEY_ERROR = 44000;// key驗證錯誤

	public static final String KAPTCHA_REG_SESSION_KEY = "KAPTCHA_REG_SESSION_KEY";// 注册SESSION key

	public static final String KAPTCHA_LOGIN_SESSION_KEY = "KAPTCHA_LOGIN_SESSION_KEY";// 登陆图片SEESSION key

	public static final String KAPTCHA_RETRVPWD_SESSION_KEY = "KAPTCHA_RETRVPWD_SESSION_KEY";// 找回密码图片SEESSION key

	public static final Integer DEAULT_GROUP_REG = new Integer("0");// 会员默认会员组

	public static final String USER_ID = "userId";// 用户Id

	public static final String NICK_NAME = "nickName";// 用户名

	public static final String WEB_SITE_PREFIX = "webSitePrefix";// 站点前缀

	public static final String WEB_SITE_OBJECT = "webSiteObject";// 站点对象

	public static final String LOGINTIMES_KEY = "logintimes";// 登陆次数限制

	public static final String SMS_UNCODE_GBK = "GBK";

	public static final String COOKIE_JSESSIONID = "JSESSIONID";

	public static final String REDIS_CODE_KEY = "utf-8";// 字符集编码

	public static final String CURRENCY_TYPE = "CNY";// 人民币

	public static final String CURRENCY_TYPE_RMB = "RMB";// 人民币

	public static final String AGIN_BALANCE_INFO = "error";

	public static final String AGIN_BALANCE_MSG = "error:60001";

	public static final Double USER_DEFAULT_BALANCE = new Double("0.00");

	// public static final String COMPANY_ID_KEY="companyId";//商户Id

	// public static final String COMPANY_ID="companyId";//商户Id

	// spring 缓存KEY定义开始

	public static final String REDIS_USER_CACHE_KEY = "usercache";// 根据用户ID缓存用户
	public static final String REDIS_GAME_SITE_CACHE_KEY = "gameSiteCache";// 根据URL地址缓存 站点数据
	public static final String REDIS_GAME_SITECODE_CACHE_KEY = "gameSiteCodeCache";// 根据站点代码缓存站点信息
	public static final String REDIS_GAME_API_CACHE_KEY = "gameApiCache";// 根据用户ID缓存用户
	public static final String REDIS_GAME_COMPANY_CACHE_KEY = "gameCompanyCache";// 每一商户每一游戏缓存
	public static final String REDIS_DEPOT_ACC_KEY = "gameAccCache";// 平台账号缓存
	public static final String REDIS_DEF_GROUP_KEY = "defGroupCache";// 平台默认会员组
	public static final String REDIS_PROTOCOL_USER_KEY = "protocolUserCache";// 用户协议
	public static final String REIDS_LOGIN_PASS_KEY = "loginPassCache";// 用户登陆密码

	public static final String REIDS_LOGIN_TOKEN_KEY = "loginTokenCache";// 用户登入TOKEN
	public static final String REIDS_LOGIN_OFFLINE_KEY = "loginOfflineCache";// 用户登出标记

	public static final String REIDS_MAIL_SET_KEY = "mailsetCache";
	public static final String REIDS_SMS_SET_KEY = "SMSsetCache";
	public static final String REIDS_STATION_SET_KEY = "StationsetCache";

	public static final String REIDS_LOGIN_PT2TOKEN_KEY = "loginPt2TokenCache";// pt代理账号用户登入token

	public static final String REIDS_LOGIN_NTTOKEN_KEY = "loginNtTokenCache";// Nt代理账号用户登入token

	public static final String REIDS_LOGIN_PNGTOKEN_KEY = "loginPngTokenCache";// PNG会员账号用户登入token

	public static final String  REDIS_PROXY_CATCH="redisProxyCache";//代理缓存

	public static final Integer REIDS_TOKEN_DEFTIME_KEY = 1800;// 默认半个小时

	public static final String SUCC_CODE = "1";

	public static final String SITE_CODE ="sys:siteCode:";
	public static final String SCHEMA_NAME ="sys:schemaName:";
	// 平台ID常量
	public interface DepotId {
		int BBIN = 1; // BBIN平台
		int AGIN = 2;// AGIN平台
		int MG = 5;// MG平台
		int PT = 6;// PT平台
		int PTNEW = 12;// 新PT
		int NT = 13;// NT 平台
		int PNG = 14;// PNG 平台
		int OPUSSB = 9;// OPUS平台_体育
		int T188 = 10;// 188平台
		int IBC = 11;// IBC平台
		int EG = 15;// EV平台
		int OPUSLIVE = 16;// OPUS平台_真人
		int PB = 17;// 平博
	}

	public interface Transfer {
		String in = "IN";// 从网站账号转款到游戏账号;
		String out = "OUT";// 從遊戲账號转款到網站賬號
	}
	// 邮箱常量

	public static final String MAIL_SMTP_AUTH = "mail.smtp.auth";
	public static final String MAIL_SMTP_TIMEOUT = "mail.smtp.timeout";
	public static final String MAIL_SMTP_SSL_ENABLE = "mail.smtp.ssl.enable";
	public static final String MAIL_SMTP_SSL_SOCKETFACTORY = "mail.smtp.ssl_socketFactory";
	public static final String MAIL_DEBUG = "mail.debug";

	public interface Terminal {
		Byte pc = 0;//
		Byte mobile = 1;
	}

	public interface HttpTime {
		int connectTimeout = 15000;// 时间太短，有些平台忙响应慢引起不能正常反回结果。太长可能引起进程堆
		int requestTimeout = 15000;
		int socketTimeout = 15000;
	}

	public interface HttpDefSet {
		String contentType = "Content-Type";
		String contentTypeVal = "text/xml; charset=utf-8";
		String charSet = "utf-8";
		String contentTypeValJson = "application/json";
	}

	public interface TransferStates {
		Integer suc = 0;// 成功
		Integer fail = 1;// 失败
		Integer progress = 2;// 挂起
	}


	public interface ActionMod {
		String GET = "GET";
		String POST = "POST";
		String PUT = "PUT";
		String DELETE = "DELETE";
		String PATCH = "PATCH";
	}

	public interface CharSet {
		String UTF8 = "UTF-8";
		String GBK = "GBK";
	}

	public interface BodyType {
		String APPLICATION_JSON = "application/json";
		String APPLICATION_FORM_URLENCODED = "application/x-www-form-urlencoded";
	}

	public interface DefaultSet {
		String DEFAULT_CHARSET = CharSet.UTF8;
		String DEFAULT_METHOD = ActionMod.GET;
		Boolean DEFAULT_LOG=true;
	}

	public interface ProxyAttribute {
//		String ip = "192.168.5.31";
//		Integer port = 1090;
//		 String ip="10.111.135.58";
//		 Integer port=1080;
	}
	public interface SocketType
	{
		String HTTP="HTTP";
		String DIRECT="DIRECT";
		String SOCKS="SOCKS";
	}

	public interface SiteAvilable {
		Byte AVILABLE = Byte.valueOf("1");
		Byte NOT_AVILABLE = Byte.valueOf("0");
	}
}
