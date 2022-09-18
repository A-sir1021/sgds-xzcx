package com.example.Commen.Util;

import com.sun.jmx.snmp.Timestamp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class DateUtil {
    public static final String dateTime_ymdhms = "yyyyMMddHHmmss";
    public static final String dateTime_y_m_d = "yyyy-MM-dd";
    public static final String dateTime_ymd = "yyyyMMdd";
    public static final String dateTime_china_ymd = "yyyy年MM月dd日";
    public static final String dateTime_china_ymdhms = "yyyy年MM月dd日  HH时mm分ss秒";
    public static final String dateTime_y_m_dhms = "yyyy-MM-dd HH:mm:ss";
    public static final String dateTime_default = "yyyy/MM/dd";
    public static final String dateTime_hms = "HHmmss";

    /** 一天的毫秒数 */
    public static final long dayMillSec = 86400000L;
    static Logger logger = LoggerFactory.getLogger(DateUtil.class);
    /**
     * 取得日期
     *
     * @return 格式为：yyyy-MM-dd hh:mm:ss
     */
    public static String getDateTime_y_m_dhms() throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateTime_y_m_dhms);
        return simpleDateFormat.format(new Date());
    }

    /**
     * 取得日期
     *
     * @return 格式为：yyyy/MM/dd
     */
    public static String getDateTime_default() throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateTime_default);
        return simpleDateFormat.format(new Date());
    }

    /**
     * 得到时间戳
     */
    public static long getTimeCurrent() throws Exception{
        long time = new Date().getTime();
        return time;
    }

    public static long getTimeCurr_second() throws Exception{
        long time = new Date().getTime()/1000;
        return time;
    }
    /**
     * 在时间上加MESS
     * @return 返回字符串  yyyyMMddHHmmss
     */
    public static String timeAddMess(int mess) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateTime_ymdhms);
        long time = getTimeCurrent()+mess*1000;
        Date date = new Date(time);
        String format = simpleDateFormat.format(date);
        return format;

    }

    /**
     *
     * @return
     * @throws Exception
     */
    public static String local_time() throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateTime_ymdhms);
        long time = getTimeCurrent()- 60*60*8;
        Date date = new Date(time);
        String format = simpleDateFormat.format(date);
        return format;

    }
    /**
     * 取得日期
     *
     * @return 格式为：yyyy年MM月dd日
     */
    public static String getDateTime_china_ymd() throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateTime_china_ymd);
        return simpleDateFormat.format(new Date());
    }

    /**
     * 取得日期 8位
     *
     * @return 格式为：yyyyMMdd
     */
    public static String getDateTime_ymd() throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateTime_ymd);
        return simpleDateFormat.format(new Date());
    }

    /**
     * 取得日期
     *
     * @return 格式为：yyyy-MM-dd
     */
    public static String getDateTime_y_m_d() throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateTime_y_m_d);
        return simpleDateFormat.format(new Date());
    }

    /**
     * 取得一个yyyy年MM月dd日 HH时mm分ss秒 格式的时间
     *
     * @return 一个yyyy年MM月dd日 HH时mm分ss秒 格式的时间
     */
    public static String getDateTime_china_ymdhms() throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateTime_china_ymdhms);
        return simpleDateFormat.format(new Date());
    }

    /**
     * 取得14位 格式的时间
     *
     * @return 14位格式的时间
     */
    public static String getDateTime_ymdhms() throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateTime_ymdhms);
        return simpleDateFormat.format(new Date());
    }

    /**
     * 取得格式为HHmmss的时间
     *
     * @return 格式为：HHmmss
     */
    public static String getDateTime_hms() throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateTime_hms);
        return simpleDateFormat.format(new Date());
    }

    /**
     * 格式化日期
     *
     * @param pattern
     *            匹配模式
     * @param datestr
     *            8位日期格式，如 20120410
     * @return 格式化后的日期
     * @throws ParseException
     */
    public static String format(String pattern, String datestr) throws ParseException, java.text.ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = simpleDateFormat.parse(datestr);
        simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

    /**
     * 格式化日期
     *
     * @param pattern
     *            匹配模式
     * @param datestr
     *            8位日期格式，如 2012年04月10日
     * @return 格式化后的日期
     * @throws ParseException
     */
    public static String formatYear(String pattern, String datestr) throws ParseException, java.text.ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        Date date = simpleDateFormat.parse(datestr);
        simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }
    /**
     * 格式化日期
     *
     * @param pattern
     *            格式化模式
     * @param date
     *            日期
     * @return 格式化后的日期
     */
    public static String format(String pattern, Date date) throws Exception {
        return new SimpleDateFormat((pattern == null || "".equals(pattern)) ? dateTime_default : pattern).format(date);
    }

    /**
     * 比较两个日期，返回它们之间相差的天数,不足一天返回0
     *
     * @param date1
     *            java.util.Date
     * @param date2
     *            java.util.Date
     * @return 相差的天数，如果 date1 小于 date2 返回 负数 <br>
     */
    public static int compareDateOnDay(Date date1, Date date2) throws Exception {
        long ss = date1.getTime() - date2.getTime();
        return Integer.parseInt(ss / dayMillSec + "");
    }

    /**
     * 比较两个日期，返回它们之间相差的天数,不足一天返回0
     *
     * @param dateString1
     *            yyyyMMdd
     * @param dateString2
     *            yyyyMMdd
     * @return 相差的天数，如果 date1 小于 date2 返回 负数 <br>
     * @throws Exception
     */
    public static int compareDateOnDay(String dateString1, String dateString2) throws Exception {
        Date date1 = parse(dateTime_ymd, dateString1);
        Date date2 = parse(dateTime_ymd, dateString2);
        return compareDateOnDay(date1, date2);
    }

    /**
     * 转换日期
     *
     * @param pattern
     *            匹配模式
     * @param datestr
     *            日期
     * @return 格式化后的日期
     * @throws ParseException
     */
    public static Date parse(String pattern, String datestr) throws ParseException, java.text.ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.parse(datestr);
    }

    /**
     * 获取数据库日期
     *
     * @param date
     *            日期对象
     * @return 数据库日期
     */
    public static Timestamp getSqlTime(Date date) throws Exception {
        return new Timestamp(date.getTime());
    }

    /**
     * 获取系统日期
     *
     * @return 系统日期
     */
    public static Timestamp getSystemTime() throws Exception {
        return getSqlTime(new Date());
    }

    /**
     * 获取当前月的第一天日期
     *
     * @return 日期字符串
     */
    public static String getFirstDayThisMonth() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-01");
        return sdf.format(new Date());
    }

    /**
     * 获取当天的字符串
     *
     * @return 当天字符串
     */
    public static String getCurrentDate() throws Exception {
        return getDateTime_ymd();
    }

    /*
     * 去除10位日期的分隔符 如：2012-07-02 return 20120702
     */
    public static String formatDate(String strDate) throws Exception {
        if (null == strDate || "".equals(strDate)) {
            return "";
        }
        return strDate.replaceAll("-", "");
    }

    /**
     * 格式化日期格式为yyyy-MM-dd HH:mm:ss
     *
     * @param dateStr
     *            日期格式为yyyyMMddHHmmss
     * @return
     * @throws Exception
     */
    public static String fmtDate_yMdHms(String dateStr) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = simpleDateFormat.parse(dateStr);
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }

}


