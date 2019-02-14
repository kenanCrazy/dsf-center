package com.invech.platform.dsfcenterdao.utlis;

import com.alibaba.druid.util.StringUtils;
import com.invech.platform.dsfcenterdao.service.TSiteService;
import com.invech.platform.dsfcenterdata.constants.ApiConstants;
import com.invech.platform.dsfcenterdata.utils.AESUtil;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Slf4j
public class DomainUtil {

	/**
	 * bigDecimal 保留上数位 系统固定2位 不进行四舍五入
	 * 
	 * @param bigDecimal
	 * @return
	 */
	public static BigDecimal adjustScale(BigDecimal bigDecimal) {
		return bigDecimal.setScale(2, BigDecimal.ROUND_DOWN);
	}

	/**
	 * 获取Ip
	 * 
	 * @param request
	 * @return
	 */
	public static String getIpAddress(HttpServletRequest request) {
		String ip = null;
		try {
			ip = request.getHeader("x-forwarded-for");
			if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("Proxy-Client-IP");
			}
			if (StringUtils.isEmpty(ip) || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("WL-Proxy-Client-IP");
			}
			if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("HTTP_CLIENT_IP");
			}
			if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("HTTP_X_FORWARDED_FOR");
			}
			if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getRemoteAddr();
			}
		} catch (Exception e) {
		}

		// //使用代理，则获取第一个IP地址
		// if(StringUtils.isEmpty(ip) && ip.length() > 15) {
		// if(ip.indexOf(",") > 0) {
		// ip = ip.substring(0, ip.indexOf(","));
		// }
		// }

		return ip;
	}

	public static String localServerIp() {
		String host = null;
		try {
			host = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			// log.error("get server host Exception e:", e);
		}
		return host;
	}
	
	public static String  requestUrl(String weburl)
	{
		java.net.URL url = null;
		try {
			url = new java.net.URL(weburl);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		String host = url.getHost();// 获取主机名
		return host;

	}

	/**
	 * 去除空行和空格
	 * 
	 * @param item
	 * @return
	 */
	public static String remKong(String item) {

		return item != null ? item.replaceAll("\\n", "").replaceAll("\\s", "") : null;
	}

	public static String genRandomNum(int min,int max){  
	      int  maxNum = 36;  
	      int i;  
	      int count = 0;  
	      char[] str = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',  
	        'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',  
	        'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };      
	      StringBuffer pwd = new StringBuffer("");  
	      Random r = new Random(); 
	      int s= r.nextInt(max)%(max-min+1) + min;
	      while(count < s){  
	       i = Math.abs(r.nextInt(maxNum));     
	       if (i >= 0 && i < str.length) {  
	        pwd.append(str[i]);
	        count ++;  
	       }  
	      }  
	      return pwd.toString();  
	    }
	public static String genRandom(int min,int max){  
	      int  maxNum = 36;  
	      int i;  
	      int count = 0;  
	      char[] str = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };      
	      StringBuffer pwd = new StringBuffer("");  
	      Random r = new Random(); 
	      int s= r.nextInt(max)%(max-min+1) + min;
	      while(count < s){  
	       i = Math.abs(r.nextInt(maxNum));     
	       if (i >= 0 && i < str.length) {  
	        pwd.append(str[i]);
	        count ++;  
	       }  
	      }  
	      return pwd.toString();  
	    }

	public static String genRandomNum(int number){
		return genRandomNum(number, number);
	}	
	public static String getRandomNum() {
		return genRandomNum(12);
	}
	public static String getRandomCode() {
		return genRandom(5,5);
	}


	public static String getSchemaName(){
		RequestAttributes attr = RequestContextHolder.getRequestAttributes();
		if(attr != null) {
			HttpServletRequest request = ((ServletRequestAttributes) attr).getRequest();
			if (request != null) {
				//注释语句从这里开始
				String siteCode = AESUtil.decrypt(request.getHeader(ApiConstants.SITE_SECURETY_KEY));
				if (StringUtils.isEmpty(siteCode)) {
					log.info("无法获取"+ApiConstants.SITE_SECURETY_KEY);
					return  "test";
				}
				return TSiteService.schemaName.get(siteCode);
			}
		}
		return null;
	}

	public static String getSiteCode(){
		if(RequestContextHolder.getRequestAttributes() != null) {
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
			if (request != null) {
				String siteCode = AESUtil.decrypt(request.getHeader(ApiConstants.SITE_SECURETY_KEY));
				if(!StringUtils.isEmpty(TSiteService.schemaName.get(siteCode))){
					return siteCode ;
				}else {
					log.info("无法获取schemaName , siteCode = "+siteCode);
				}
			}
		}
		return null;
	}
	/**
	 * 根据URL获取一级 domain
	 * @param url
	 * @return
	 */
	public static String getDomainForUrl(String url) {
		String domainUrl = null;
		if (url == null) {
			return null;
		} else if (url.contains("localhost")) {
			return "localhost";
		}else {
			Pattern p = Pattern.compile("((?<=http://|\\.)[^.]*?\\.(com|cn|net|org|biz|info|cc|tv|hk|co))",Pattern.CASE_INSENSITIVE);
			Matcher matcher = p.matcher(url);
			while(matcher.find()){
				domainUrl = matcher.group();
			}
			//增加对ip地址的支持
			if(!matcher.find()) {
				p = Pattern.compile("((?:(?:25[0-5]|2[0-4]\\d|(?:1\\d{2}|[1-9]?\\d))\\.){3}(?:25[0-5]|2[0-4]\\d|(?:1\\d{2}|[1-9]?\\d)))", Pattern.CASE_INSENSITIVE);
				matcher = p.matcher(url);
				while (matcher.find()) {

					domainUrl = requestUrl(url.startsWith("http://")?url:"http://"+url);
				}
			}
			return domainUrl;
		}
	}
}
