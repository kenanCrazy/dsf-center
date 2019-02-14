
package com.invech.platform.dsfcenterdata.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.springframework.util.StringUtils;

/**
 * 日期时间工具类
 */
public class DateUtil {
//	2018-03-22 13:02:58.0
    private static final int step = 3;
    private static final int fullCursor = 2;
    private static final int fullIndex = 4 * 5;
    private static final String MATCH_TEMPLATE = "yyyy/MM/dd HH:mm:ss:SSS";
    private static final String PATTERN_TEMPLATE = "0000/00/00 00:00:00:000";
    public static final String FORMAT_25_DATE_TIME = "yyyy-MM-dd HH:mm:ss.SSSSSS";
    public static final String FORMAT_22_DATE_TIME = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String FORMAT_18_DATE_TIME = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_18_DATE_TIME2 = "yyyyMMddHHmmss";
    public static final String FORMAT_12_DATE_TIME = "yyyy-MM-dd HH";
    public static final String FORMAT_10_DATE = "yyyy-MM-dd";
    public static final String FORMAT_8_DATE = "yyyyMMdd";
    public static final String FORMAT_DATE_T = "yyyy-MM-dd'T'HH:mm:ss.SSS";
    public static final String DATE_STATE="00:00:00";
    public static final String DATE_END="23:59:59";
    private static String suffix = ".000Z";
    
    private static final ThreadLocal<SimpleDateFormat> local = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat();
        }
    };

    /**
     * 获取SimpleDateFormat实例
     *
     * @param pattern 模式串
     * @return
     */
    public static SimpleDateFormat getSimpleDateFormat(String pattern) {
        SimpleDateFormat format = local.get();
        format.applyPattern(pattern);
        return format;
    }
    /**
     * 获取当前日期向前推某个月的时间
     * @param month
     * @return
     */
    public static Date getBeforeDate(Integer month) {
    	Integer m = 0-month;
    	Date dNow = new Date();   //当前时间
    	Date dBefore = new Date();
    	Calendar calendar = Calendar.getInstance(); //得到日历
    	calendar.setTime(dNow);//把当前时间赋给日历
    	calendar.add(calendar.MONTH, m);  //设置为前多少月
    	dBefore = calendar.getTime();   //得到前多少月的时间 	
    	return dBefore;	    	
 }
    /**
     * 获取两个日期之间所有日期的集合
     * @param dBegin
     * @param dEnd
     * @return
     */
    public static List<Date> findDates(Date dBegin, Date dEnd) {
        List<Date> lDate = new ArrayList<Date>();
        lDate.add(dBegin);
        Calendar calBegin = Calendar.getInstance();
    // 使用给定的 Date 设置此 Calendar 的时间
        calBegin.setTime(dBegin);
        Calendar calEnd = Calendar.getInstance();
    // 使用给定的 Date 设置此 Calendar 的时间
          calEnd.setTime(dEnd);
        // 测试此日期是否在指定日期之后
        while (dEnd.after(calBegin.getTime()))  {
         // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
             calBegin.add(Calendar.DAY_OF_MONTH, 1);
             lDate.add(calBegin.getTime());
        }
        return lDate;
   }
    
    

    /**
     * 获取本周 周一的日期
     *
     * @param pattern
     * @return
     */
    public static String getMonday(String pattern) {
        SimpleDateFormat sf = new SimpleDateFormat(pattern, Locale.CHINA);
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return sf.format(calendar.getTime());
    }

    /**
     * 获取本周 周日的日期
     *
     * @param pattern
     * @return
     */
    public static String getWeek(String pattern) {
        SimpleDateFormat sf = new SimpleDateFormat(pattern, Locale.CHINA);
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        return sf.format(calendar.getTime());
    }

    /**
     * 获取过去第几天的日期
     *
     * @param past
     * @return
     */
    public static String getPastDate(int past, String pattern) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(today);
    }

    /**
     * 获取表示当前时间的字符串
     *
     * @param pattern 模式串
     * @return
     */
    public static String getCurrentDate(String pattern) {
        return format(new Date(), pattern);
    }
    
    public static String getTodayStart(String pattern)
    {
    	return format(new Date(),pattern)+" "+DATE_STATE;
    }

    public static String getTodayEnd(String pattern)
    {
    	return format(new Date(),pattern)+" "+DATE_END;
    }
    /**
     * 获取表示当前美东时间
     *
     * @return
     */
    public static String getAmericaDate(String pattern, Date date) {
        SimpleDateFormat sf = new SimpleDateFormat(pattern);
        sf.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        return sf.format(date);
    }

    /**
     * 日期时间格式化, 自动匹配格式化模式串
     *
     * @param date Date
     * @return
     */
    public static String format(Date date) {
        SimpleDateFormat format = getSimpleDateFormat(MATCH_TEMPLATE);
        String dateStr = format.format(date);
        String ms = dateStr.substring(dateStr.length() - step);
        if (Short.parseShort(ms) == 0) {
            dateStr = dateStr.substring(0, dateStr.length() - step - 1);
        } else {
            return dateStr;
        }
        String time = dateStr.substring(dateStr.length() - step * 3 + 1);
        time = time.replace(":", "");
        if (Integer.parseInt(time) == 0) {
            dateStr = dateStr.substring(0, dateStr.length() - step * 3);
        } else {
            return dateStr;
        }
        return dateStr;
    }

    /**
     * 日期时间格式化
     *
     * @param date    Date
     * @param pattern 模式串
     * @return
     */
    public static String format(Date date, String pattern) {
        SimpleDateFormat format = getSimpleDateFormat(pattern);
        return format.format(date);
    }

    /**
     * 解析字符串类型日期, 为参数自动匹配解析模式串
     *
     * @param date 日期字符串
     * @return
     */
    public static Date parse(String date) {
        try {
            String[] mapper = format(date);
            SimpleDateFormat format = getSimpleDateFormat(mapper[0]);
            return format.parse(mapper[1]);
        } catch (ParseException e) {
            throw new RuntimeException("Unparseable date: \"" + date + "\"");
        } catch (Throwable e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * 解析字符串类型日期
     *
     * @param date    日期字符串
     * @param pattern 模式串
     * @return
     */
    public static Date parse(String date, String pattern) {
        try {
            SimpleDateFormat format = getSimpleDateFormat(pattern);
            return format.parse(date);
        } catch (Throwable e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * 格式化参数日期字符串, 源日期字符填充到预设模板
     *
     * @param date 日期字符串
     * @return
     */
    private static String[] format(String date) {
        char[] origin = date.toCharArray();
        char[] pattern = PATTERN_TEMPLATE.toCharArray();
        char o, p;
        int cursor = 0, j = 0;
        for (int i = 0; i < origin.length; i++, j++) {
            o = origin[i];
            p = pattern[j];
            if (isCursor(o)) {
                if (!isCursor(p)) {
                    moveToNext(pattern, j - 1);
                    j++;
                }
                cursor = j;
            }
            if (isCursor(p)) {
                if (!isCursor(o)) {
                    cursor = j;
                    j++;
                }
            }
            pattern[j] = o;
        }
        j--;
        if (cursor < fullIndex - 1 && j - cursor == 1) {
            moveToNext(pattern, j);
        }
        cursor = pattern.length;
        for (int i = 0; i < fullCursor; i++) {
            if (pattern[cursor - 1] == '0') {
                cursor--;
            } else {
                break;
            }
        }
        if (cursor != pattern.length) {
            char[] target = new char[cursor];
            System.arraycopy(pattern, 0, target, 0, cursor);
            pattern = target;
        }
        char[] match = MATCH_TEMPLATE.toCharArray();
        for (int i = 4; i < fullIndex; i += step) {
            match[i] = pattern[i];
        }
        return new String[]{new String(match), new String(pattern)};
    }

    /**
     * 字符是否为非数值
     *
     * @param ch 被测试的字符
     * @return
     */
    private static boolean isCursor(char ch) {
        if (ch >= '0' && ch <= '9') {
            return false;
        }
        return true;
    }

    /**
     * 后移元素
     *
     * @param pattern 数组
     * @param i       被移动的元素的索引值
     */
    private static void moveToNext(char[] pattern, int i) {
        pattern[i + 1] = pattern[i];
        pattern[i] = '0';
    }

    public static Integer subtractTime(Date expireTime) {
        if (StringUtils.isEmpty(expireTime))
            return 0;
        Long second = (expireTime.getTime() - (new Date()).getTime()) / 1000;
        if (second <= 0) {
            return 0;
        } else {
            return new Integer(String.valueOf(second));
        }
   /*     SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 格式化时间
        String nowtime = d.format(new Date());// 按以上格式 将当前时间转换成字符串
        String testtime = "2011-04-01 14:07:35";// 测试时间
        try {
            long result = (d.parse(nowtime).getTime() - d.parse(testtime)
                    .getTime()) / 3600000;// 当前时间减去测试时间
            // 这个的除以1000得到秒，相应的60000得到分，3600000得到小时
            System.out.println("当前时间减去测试时间=" + result + "小时");
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
    }

    public static Date addTime(Integer second) {
        return new Date(System.currentTimeMillis() + second * 1000);
    }


    /**
     * 求现在n小时前的时间
     * @param hour
     * @return
     */
    public static String getBrforeTime(Date d,Integer hour){
        DateFormat df=new SimpleDateFormat(FORMAT_18_DATE_TIME);
        Calendar cal=Calendar.getInstance();
        cal.setTime(d);
        cal.add(Calendar.HOUR_OF_DAY,-hour);
        return df.format(cal.getTime());
    }

    /**
     * 日期时间格式化 特定获取有效投注
     *
     * @param  date
     * @return
     */
    public static String formatEsDate(String date) {
        SimpleDateFormat format = getSimpleDateFormat(FORMAT_18_DATE_TIME);
        String da = format.format(parse(date, FORMAT_18_DATE_TIME));
        return da.replace(" ", "T") + suffix;
    }
    /** 
     * 得到几天前的时间 
     * @param d 
     * @param day 
     * @return 
     */  
    public static Date getDateBefore(Date d,int day){  
     Calendar now =Calendar.getInstance();  
     now.setTime(d);  
     now.set(Calendar.DATE,now.get(Calendar.DATE)-day);  
     return now.getTime();  
    }  
      
    /** 
     * 得到几天后的时间 
     * @param d 
     * @param day 
     * @return 
     */  
    public static Date getDateAfter(Date d,int day){  
     Calendar now =Calendar.getInstance();  
     now.setTime(d);  
     now.set(Calendar.DATE,now.get(Calendar.DATE)+day);  
     return now.getTime();  
    }
    
	public static String getUTCTimeStr() {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		StringBuffer UTCTimeBuffer = new StringBuffer();
		// 1、取得本地时间：
		Calendar cal = Calendar.getInstance();
		// 2、取得时间偏移量：
		int zoneOffset = cal.get(Calendar.ZONE_OFFSET);
		// 3、取得夏令时差：
		int dstOffset = cal.get(Calendar.DST_OFFSET);
		// 4、从本地时间里扣除这些差量，即可以取得UTC时间：
		cal.add(Calendar.MILLISECOND, -(zoneOffset + dstOffset));
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		int millisecond = cal.get(Calendar.MILLISECOND);
		UTCTimeBuffer.append(year).append("-").append(month).append("-").append(day);
		UTCTimeBuffer.append(" ").append(hour).append(":").append(minute).append(":").append(second).append(".")
				.append(millisecond);
		try {
			format.parse(UTCTimeBuffer.toString());
			return UTCTimeBuffer.toString() + " UTC";
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
//    public static void main(String args[])
//    {
//    	System.out.println(getUTCTimeStr());
//    }
    
	public static int compareDate(String date1, String date2) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date dt1 = null;
		Date dt2 = null;
		try {
			dt1 = sdf.parse(date1);
			dt2 = sdf.parse(date2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (dt1.getTime() <= dt2.getTime()) {
			return 1;
		} else {
			return 0;
		}

	} 
}