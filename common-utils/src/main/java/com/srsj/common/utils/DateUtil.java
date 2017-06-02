package com.srsj.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by weichen on 2017/6/2.
 */
public class DateUtil {

    public static final int H_M = 0;
    public static final int H_M_S = 1;
    public static final int Y_H_M = 2;
    public static final int Y_H_M_H_M = 3;
    public static final int Y_H_M_H_M_S = 4;
    public static final int Y=5;
    public static final int Y_H=6;
    public static final int Y_H_M_H_M_S_2=7;
    public static final int yyyy_MM_ddTHH_mm_ss_z=8;
    public static final int YMD_HM=9;
    public static final int MD=10;
    public static final int yyyyMMdd = 11 ;
    public static final int Y_H_M_H = 12;
    public static final int YHM = 13;
    public static final String NORMAL_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 根据不同的类型得到不同的格式化工具类
     * @param num 表示类型
     * @return 不同类型的格式化工具类
     */
    private static SimpleDateFormat getFormat(int num){
        SimpleDateFormat dateformat = null;
        switch(num){
            case DateUtil.H_M:
                dateformat = new SimpleDateFormat("HH:mm");
                break;
            case DateUtil.H_M_S:
                dateformat = new SimpleDateFormat("HH:mm:ss");
                break;
            case DateUtil.Y_H_M:
                dateformat = new SimpleDateFormat("yyyy-MM-dd");
                break;
            case DateUtil.Y_H_M_H_M:
                dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                break;
            case DateUtil.Y_H_M_H_M_S:
                dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                break;
            case DateUtil.Y:
                dateformat = new SimpleDateFormat("yyyy年");
                break;
            case DateUtil.Y_H:
                dateformat = new SimpleDateFormat("yyyy年MM月");
                break;
            case DateUtil.Y_H_M_H_M_S_2:
                dateformat = new SimpleDateFormat("yyyyMMddHHmmss");
                break;
            case DateUtil.yyyy_MM_ddTHH_mm_ss_z:
                dateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'+08:00'");
                break;
            case DateUtil.YMD_HM:
                dateformat = new SimpleDateFormat("yyyy.MM.dd HH:mm");
                break;
            case DateUtil.MD:
                dateformat = new SimpleDateFormat("MM.dd");
                break;
            case DateUtil.Y_H_M_H:
                dateformat = new SimpleDateFormat("yyyy-MM-dd HH");
                break;
            case DateUtil.YHM:
                dateformat = new SimpleDateFormat("yyyyMMdd");
                break;
            default:break;
        }
        return dateformat;
    }

    /**
     * @description 返回格式化字符串型日期
     * @param num 类型
     * @param date 需要处理的日期
     * @return 返回需要的日期字符串形式
     */
    public static String getFormatString(int num, Date date){
        if(date == null)
            return "";
        else{
            SimpleDateFormat dateformat = getFormat(num);
            return dateformat==null?"":dateformat.format(date);
        }
    }

    /**
     * @description 返回格日期
     * @param num 格式化类型标识
     * @param stringDate 日期的字符串形式
     * @return Date对象
     */
    public static Date getFormatDate(int num, String stringDate){
        Date resultDate = null;
        SimpleDateFormat dateformat = getFormat(num);
        try {
            if(dateformat!=null)
                resultDate = dateformat.parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultDate;
    }

    /**
     * @description 返回格日期
     * @param num 格式化类型标识
     * @param date 日期
     * @return Date对象
     */
    public static Date getFormatDate(int num, Date date){
        Date resultDate = null;
        if(date == null){
            return null;
        }
        SimpleDateFormat dateformat = getFormat(num);
        try {
            if(dateformat!=null){
                String stringDate = dateformat.format(date);
                resultDate = dateformat.parse(stringDate);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultDate;
    }

    static class CalendarFactory {
        private ThreadLocal<Calendar> calendarRef = new ThreadLocal<Calendar>() {
            protected Calendar initialValue() {
                return new GregorianCalendar();
            }
        };
        private static CalendarFactory instance = new CalendarFactory();

        public static CalendarFactory getFactory() { return instance; }

        public Calendar getCalendar() {
            return calendarRef.get();
        }

        // Don't let outsiders create new factories directly
        private CalendarFactory() {}
    }

    /**
     *  格式化日期
     *
     *  @param  dateStr
     *                        字符型日期
     *  @param  format
     *                        格式
     *  @return  返回日期
     */
    public static java.util.Date parseDate(String dateStr, String format) {
        java.util.Date date = null;
        try {
            DateFormat df = new SimpleDateFormat(format);
            date = df.parse(dateStr);
        } catch (Exception e) {
        }
        return date;
    }

    public static java.util.Date parseDate(String dateStr) {
        return parseDate(dateStr, "yyyy-MM-dd");
    }

    public static java.util.Date parseDate(java.sql.Date date) {
        return date;
    }

    public static java.sql.Date parseSqlDate(java.util.Date date) {
        if (date != null)
            return new java.sql.Date(date.getTime());
        else
            return null;
    }

    public static java.sql.Date parseSqlDate(String dateStr, String format) {
        java.util.Date date = parseDate(dateStr, format);
        return parseSqlDate(date);
    }

    public static java.sql.Date parseSqlDate(String dateStr) {
        return parseSqlDate(dateStr, "yyyy/MM/dd");
    }

    public static java.sql.Timestamp parseTimestamp(String dateStr,
                                                    String format) {
        java.util.Date date = parseDate(dateStr, format);
        if (date != null) {
            long t = date.getTime();
            return new java.sql.Timestamp(t);
        } else
            return null;
    }

    public static java.sql.Timestamp parseTimestamp(String dateStr) {
        return parseTimestamp(dateStr, "yyyy/MM/dd  HH:mm:ss");
    }

    /**
     *  格式化输出日期
     *
     *  @param  date
     *                        日期
     *  @param  format
     *                        格式
     *  @return  返回字符型日期
     */
    public static String format(java.util.Date date, String format) {
        String result = "";
        try {
            if (date != null) {
                java.text.DateFormat df = new java.text.SimpleDateFormat(format);
                result = df.format(date);
            }
        } catch (Exception e) {
        }
        return result;
    }

    public static String format(java.util.Date date) {
        return format(date, "yyyy/MM/dd");
    }

    /**
     *  返回年份
     *
     *  @param  date
     *                        日期
     *  @return  返回年份
     */
    public static int getYear(java.util.Date date) {
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTime(date);
        return c.get(java.util.Calendar.YEAR);
    }

    /**
     *  返回月份
     *
     *  @param  date
     *                        日期
     *  @return  返回月份
     */
    public static int getMonth(java.util.Date date) {
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTime(date);
        return c.get(java.util.Calendar.MONTH) + 1;
    }

    /**
     *  返回日份
     *
     *  @param  date
     *                        日期
     *  @return  返回日份
     */
    public static int getDay(java.util.Date date) {
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTime(date);
        return c.get(java.util.Calendar.DAY_OF_MONTH);
    }

    /**
     *  返回小时
     *
     *  @param  date
     *                        日期
     *  @return  返回小时
     */
    public static int getHour(java.util.Date date) {
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTime(date);
        return c.get(java.util.Calendar.HOUR_OF_DAY);
    }

    /**
     *  返回分钟
     *
     *  @param  date
     *                        日期
     *  @return  返回分钟
     */
    public static int getMinute(java.util.Date date) {
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTime(date);
        return c.get(java.util.Calendar.MINUTE);
    }

    /**
     *  返回秒钟
     *
     *  @param  date
     *                        日期
     *  @return  返回秒钟
     */
    public static int getSecond(java.util.Date date) {
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTime(date);
        return c.get(java.util.Calendar.SECOND);
    }

    /**
     *  返回毫秒
     *
     *  @param  date
     *                        日期
     *  @return  返回毫秒
     */
    public static long getMillis(java.util.Date date) {
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTime(date);
        return c.getTimeInMillis();
    }

    /**
     *  返回字符型日期
     *
     *  @param  date
     *                        日期
     *  @return  返回字符型日期
     */
    public static String getDate(java.util.Date date) {
        return format(date, "yyyy/MM/dd");
    }

    /**
     *  返回字符型时间
     *
     *  @param  date
     *                        日期
     *  @return  返回字符型时间
     */
    public static String getTime(java.util.Date date) {
        return format(date, "HH:mm:ss");
    }

    /**
     *  返回字符型日期时间
     *
     *  @param  date
     *                        日期
     *  @return  返回字符型日期时间
     */
    public static String getDateTime(java.util.Date date) {
        return format(date, "yyyy/MM/dd  HH:mm:ss");
    }

    /**
     *  日期相加
     *
     *  @param  date
     *                        日期
     *  @param  day
     *                        天数
     *  @return  返回相加后的日期
     */
    public static java.util.Date addDate(java.util.Date date, int day) {
        if(date == null){
            return null;
        }
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTimeInMillis(getMillis(date) + ((long) day) * 24 * 3600 * 1000);
        return c.getTime();
    }

    /**
     *  日期相减
     *
     *  @param  date
     *                        日期
     *  @param  date1
     *                        日期
     *  @return  返回相减后的日期
     *
     *  @author nash
     */
    public static int diffDate(java.util.Date date, java.util.Date date1) {
        return (int) ((getMillis(date) - getMillis(date1)) / (24 * 3600 * 1000));
    }

    /**
     *  时间差，毫秒级别
     *
     *  @param  date
     *                        日期
     *  @param  date1
     *                        日期
     *  @return  返回相减后的时间差
     */
    public static long diffMillis(java.util.Date date, java.util.Date date1) {
        return getMillis(date) - getMillis(date1);
    }

    /**
     * 获得两个日期的天数差
     *
     */
    public static int getTwoDatesDifDay(Date begin, Date end) {

        long total = end.getTime() -  begin.getTime();
        if (begin.after(end)) {
            total = begin.getTime() -  end.getTime();
        }
        long seconds = total / 1000;
        long day = seconds / 60 / 60 / 24;
        return Integer.parseInt(day+"");
    }

    public static String getDateName(Date date) {
        int dateDiff = DateUtil.getTwoDatesDifDay(DateUtil.format(new Date(), "yyyy-MM-dd"), DateUtil.format(date, "yyyy-MM-dd")) ;
        String datename = DateUtil.format(date, "MM月dd日") ;
        if(dateDiff == 0) {
            datename = "今天" ;
        } else if(dateDiff == 1) {
            datename = "明天" ;
        } else if(dateDiff == 2) {
            datename = "后天" ;
        }
        return datename ;
    }

    public static String getDatetimeName(Date date) {
        int dateDiff = DateUtil.getTwoDatesDifDay(DateUtil.format(new Date(), "yyyy-MM-dd"), DateUtil.format(date, "yyyy-MM-dd")) ;
        String datename = DateUtil.format(date, "MM-dd ") ;
        if(dateDiff == 0) {
            datename = "今天  " ;
        }
        datename += DateUtil.format(date, "HH:mm") ;
        return datename ;
    }

    public static String getBeforeDateTimeShow(Date date) {
        Date now = new Date();

        int dateDiff = DateUtil.getTwoDatesDifDay(DateUtil.format(now, "yyyy-MM-dd"), DateUtil.format(date, "yyyy-MM-dd")) ;
        String time = DateUtil.format(date, "HH:mm") ;
        String day = "";
        if(dateDiff == 0) {
            day = "今天" ;
        } else if(dateDiff == 1) {
            day = "昨天" ;
        } else if(dateDiff == 2) {
            day = "前天" ;
        }else {
            if(now.getYear() == date.getYear()){
                day = DateUtil.format(date, "MM-dd") ;
            }else{
                day = DateUtil.format(date, "yy-MM-dd") ;
            }
        }
        return day +" "+ time ;
    }

    /**
     * 获得两个日期的天数差，有正负数的
     *
     */
    public static int getTwoDateSpace(Date begin, Date end) {

        long total = end.getTime() -  begin.getTime();
        long seconds = total / 1000;
        long day = seconds / 60 / 60 / 24;
        return Integer.parseInt(day+"");
    }

    /**
     * 获得两个日期的天数差 "yyyy-MM-dd"
     *
     */
    public static int getTwoDatesDifDay(String beginStr, String endStr) {
        Date beginDay = parseDate(beginStr);
        Date endDay = parseDate(endStr);
        return getTwoDatesDifDay(beginDay, endDay) ;
    }

    public static int getDayNumFromNowToTargetDate(Date targetDate){
        String nowDateStr = format(new Date(), "yyyy-MM-dd");
        String targetDateStr = format(targetDate, "yyyy-MM-dd");
        return getTwoDatesDifDay(nowDateStr, targetDateStr) + 1;
    }

    /**
     * 取得某天是星期几
     */
    public static int getWeekOfDate(Date dt) {
        Calendar cal = CalendarFactory.getFactory().getCalendar();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return w;
    }

    /**
     * 星期几中文名
     */
    public static final Map<Integer, String>  weekChiMap= new HashMap<Integer, String>() ;
    static {
        weekChiMap.put(0, "日");
        weekChiMap.put(1, "一");
        weekChiMap.put(2, "二");
        weekChiMap.put(3, "三");
        weekChiMap.put(4, "四");
        weekChiMap.put(5, "五");
        weekChiMap.put(6, "六");
    }

    /**
     * 获取当前的日期，格式是yyyy-mm-dd
     *
     * @return
     */
    public static Date getYMDDate(){
        Calendar calendar = CalendarFactory.getFactory().getCalendar();
        // Calendar calendar=Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND,0);
        return calendar.getTime();
    }

    /**
     * 获取当前的日期，格式是yyyy-mm-dd
     *
     * @return
     */
    public static Date getYMDDate(Date date){
        Calendar calendar = CalendarFactory.getFactory().getCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND,0);
        return calendar.getTime();
    }

    /**
     * 对日期按照指定的类型进行添加或者减少
     *
     * @param date
     * @param type
     * @param num
     * @return
     * @throws Exception
     * @Author: zhanghuajie
     * @Create: 2013-5-10 下午6:16:07
     */
    public static Date getAddDate(Date date,int type,int num) throws Exception{
        Calendar cal = CalendarFactory.getFactory().getCalendar();
        try {
            cal.setTime(date);
            if(type==1){
                cal.add(Calendar.DAY_OF_MONTH, num);
            }else if(type==2){
                cal.add(Calendar.HOUR, num);
            }else if(type==3){
                cal.add(Calendar.MINUTE, num);
            }else if(type==4){
                cal.add(Calendar.SECOND, num);
            }else if(type==5){
                cal.add(Calendar.MONTH, num);
            }else if(type==6){
                cal.add(Calendar.YEAR, num);
            }
        } catch (Exception e) {
            throw e;
        }
        return cal.getTime();
    }

    /**
     * 获取当天零点到day的时刻毫秒数
     *
     * @return
     */
    public static long getNowZeroMillis(long day) {

        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTimeInMillis(day);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND,0);

        return day - calendar.getTimeInMillis() ;
    }

    public static Date getTodayStartDate(){
        Calendar cal = GregorianCalendar.getInstance();

        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static Date getTodayEndDate(){
        Calendar cal = GregorianCalendar.getInstance();

        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal.getTime();
    }

    public static Date getStartDate(Date d){
        Calendar cal = GregorianCalendar.getInstance();
        if(d != null)
            cal.setTime(d);

        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static Date getEndDate(Date d){
        Calendar cal = GregorianCalendar.getInstance();
        if(d != null)
            cal.setTime(d);

        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal.getTime();
    }

    /**
     * 获取day的星期数
     * @param day
     * @return
     */
    public static int getWeek(long day){
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTimeInMillis(day);

        return calendar.get(Calendar.DAY_OF_WEEK) ;
    }

    //判断A时间点 是否在B与C时间点之间   		A   B   C
    //返回：
    //1：在B之前，2：在B与C中间 ， 3，在C之后   0: 错误
    public static int isInsideTwoTime(Date A , Date B , Date C){
        int result = 0;
        A = getFormatDate(2, A);
        B = getFormatDate(2, B);
        C = getFormatDate(2, C);
        long a = A.getTime();
        long b = B.getTime();
        long c = C.getTime();
        if(b >= c){
            return 0;
        }else if(a >= b && a <= c){
            result = 2;
        }else if(a < b){
            result = 1;
        }else if(a > c){
            result = 3;
        }
        return result;
    }

    /**
     * 日期<code>d1</code>是不是和<code>d2</code>
     * 在同一天,或者第二天
     * @param d1
     * @param d2
     * @return
     */
    public static boolean isSameTodayOrTomorrow(Date d1,Date d2) {
        //需要去设置两次 还是复制代码改改

        if(isSameDay(d1, d2)){
            return true;
        }

        try {
            d1 = getAddDate(d1, 1, 1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return isSameDay(d1, d2);
    }

    public static boolean isSameDay(Date d1, Date d2){
        if(d1 == null || d2 == null){
            return false;
        }
        Calendar c1 = GregorianCalendar.getInstance();
        c1.setTime(d1);
        int year1 = c1.get(Calendar.YEAR);
        int month1 = c1.get(Calendar.MONTH);
        int day1 = c1.get(Calendar.DAY_OF_MONTH);

        Calendar c2 = GregorianCalendar.getInstance();
        c2.setTime(d2);
        int year2 = c2.get(Calendar.YEAR);
        int month2 = c2.get(Calendar.MONTH);
        int day2 = c2.get(Calendar.DAY_OF_MONTH);

        return (year1 == year2) && (month1 == month2) && (day1 == day2);
    }

    static SimpleDateFormat monthDayformat = new SimpleDateFormat("MMdd");

    public static String getMonthDayString(Date date){
        return monthDayformat.format(date);
    }

    public static Date getWeekBegin(int gap) {
        int mondayPlus;
        Calendar cd = Calendar.getInstance();
        // 获得今天是一周的第几天，星期日是第一天，星期二是第二天......
        int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK) - 1; // 因为按中国礼拜一作为第一天所以这里减1
        if (dayOfWeek == 1) {
            mondayPlus = 0;
        } else {
            mondayPlus = 1 - dayOfWeek;
        }
        GregorianCalendar cal = new GregorianCalendar();
        cal.add(GregorianCalendar.DAY_OF_MONTH, mondayPlus);
        cal.add(Calendar.WEEK_OF_MONTH, gap);

        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static String getNowWeekBegin() {
        int mondayPlus;
        Calendar cd = Calendar.getInstance();
        // 获得今天是一周的第几天，星期日是第一天，星期二是第二天......
        int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK) - 1; // 因为按中国礼拜一作为第一天所以这里减1
        if (dayOfWeek == 1) {
            mondayPlus = 0;
        } else {
            mondayPlus = 1 - dayOfWeek;
        }
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus);
        Date monday = currentDate.getTime();
        DateFormat df = DateFormat.getDateInstance();
        String preMonday = df.format(monday);
        return preMonday + " 00:00:00";
    }

    public static String getNowMonthBegin() {
        int mondayPlus;
        Calendar cd = Calendar.getInstance();
        int dayOfWeek = cd.get(Calendar.DAY_OF_MONTH);
        if (dayOfWeek == 1) {
            mondayPlus = 0;
        } else {
            mondayPlus = 1 - dayOfWeek;
        }
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus);
        Date monday = currentDate.getTime();
        DateFormat df = DateFormat.getDateInstance();
        String preMonday = df.format(monday);
        return preMonday + " 00:00:00";
    }

    public static Date getNowMonthBeginDate() {
        int mondayPlus;
        Calendar cd = Calendar.getInstance();
        int dayOfWeek = cd.get(Calendar.DAY_OF_MONTH);
        if (dayOfWeek == 1) {
            mondayPlus = 0;
        } else {
            mondayPlus = 1 - dayOfWeek;
        }
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus);
        return currentDate.getTime();
    }

    /**
     * 获得当前时间的字符串
     * @param time  现在到当天零点的毫秒数
     * @return
     */
    public static String getTime(long time) {
        time = time/1000 ;
        int second = (int) (time%60) ;
        time = (time - second )/60 ;
        int munite = (int) (time % 60) ;
        time = (time - munite)/60 ;
        StringBuilder stringBuilder = new StringBuilder() ;
        if(time < 10) {
            stringBuilder.append("0").append(time) ;
        } else {
            stringBuilder.append(time) ;
        }
        stringBuilder.append(":") ;
        if(munite<10) {
            stringBuilder.append("0").append(munite) ;
        } else {
            stringBuilder.append(munite) ;
        }
        stringBuilder.append(":") ;
        if(second < 10) {
            stringBuilder.append("0").append(second) ;
        } else {
            stringBuilder.append(second) ;
        }

        return stringBuilder.toString() ;
    }

    public static String getTodayStr(){
        return format(new Date(), "yyyy-MM-dd");
    }

    public static int getYMD(Date date) {
        int flag = 0 ;
        try {
            String str = format(date, "yyyyMMdd") ;
            flag = Integer.parseInt(str) ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag ;
    }

    private static final SimpleDateFormat shortFormat = new SimpleDateFormat("MM月dd日");

    private static final long hour_millis = 60 * 60 * 1000;

    /**
     * 明天08:00，乘客xxx和您顺路，求搭车。时间显示逻辑：
     1）日期显示：今天、明天、本周XX，下周XX
     2）时刻显示：00:00-5:59：凌晨4:00；6:00-11:59：上午9:00；12:00-12:59：中午12:30；13:00之后，就正常显示，不需要加前缀
     * @return
     */
    public static String getHintTime(Date useTime){
        Calendar now = GregorianCalendar.getInstance();
        Calendar useCal = GregorianCalendar.getInstance();
        useCal.setTime(useTime);
        String dayStr = null;
        int dayGap = DateUtil.getTwoDatesDifDay(DateUtil.format(now.getTime(), "yyyy-MM-dd"), DateUtil.format(useTime, "yyyy-MM-dd")) ;
        if(dayGap == 0)
            dayStr="今天";
        else if(dayGap == 1)
            dayStr="明天";
        else{
            String week = DateUtil.weekChiMap.get(useCal.get(Calendar.DAY_OF_WEEK)-1);
            Date nowWeekBegin = getWeekBegin(now);
            Date useWeekBegin = getWeekBegin(useCal);
            long timeGap = useWeekBegin.getTime() - nowWeekBegin.getTime();
            if (timeGap == 0){
                dayStr="本周";
            }else {
                if(timeGap == 24 * hour_millis * 7){
                    dayStr="下周";
                }
            }
            if(dayStr == null){
                dayStr = shortFormat.format(useTime) + "周"+week;
            }else{
                dayStr += week;
            }
        }
        int hour = useCal.get(Calendar.HOUR_OF_DAY);
        int minute = useCal.get(Calendar.MINUTE);
        String prefix="";
        if(hour>=0 && hour <= 5){
            prefix="凌晨";
        }else if(hour <= 11){
            prefix="上午";
        }else if(hour == 12){
            prefix="中午";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(dayStr).append(prefix);
        if(hour < 10){
            sb.append("0").append(hour);
        }else{
            sb.append(hour);
        }
        sb.append(":");
        if(minute < 10){
            sb.append("0").append(minute);
        }else{
            sb.append(minute);
        }
        return sb.toString();
    }

    public static Date getWeekBegin(Calendar cd) {
        int dayPlus;
        int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == 1) {
            dayPlus = -6;
        } else {
            dayPlus = 2 - dayOfWeek;
        }
        Calendar cal = (Calendar) cd.clone();
        cal.add(GregorianCalendar.DATE, dayPlus);

        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 返回当前时间所在周的开始期
     * @param currD
     * @return
     */
    public static String getWeekStartTime() {
        Calendar c = Calendar.getInstance();
        int dayOfWeek = getDayOfWeek(c.get(Calendar.DAY_OF_WEEK));
        Date d = addDate(new Date(), -dayOfWeek+1);
        return getFormatString(Y_H_M, d) + " 00:00:00";
    }

    /**
     * 返回当前时间所在周的开始日期
     * @return
     */
    public static String getWeekEndTime() {
        Calendar c = Calendar.getInstance();
        int dayOfWeek = getDayOfWeek(c.get(Calendar.DAY_OF_WEEK));
        Date d = addDate(new Date(), 7-dayOfWeek);
        return getFormatString(Y_H_M, d) + " 23:59:59";
    }

    /**
     * 返回下周一日期
     * @return
     */
    public static String getNextMondayDate() {
        Calendar c = Calendar.getInstance();
        int dayOfWeek = getDayOfWeek(c.get(Calendar.DAY_OF_WEEK));
        Date d = addDate(new Date(), 7-dayOfWeek+1);
        String rv = getFormatString(MD, d) ;
        if ( rv.startsWith("0") ) {
            rv = rv.substring(1);
        }

        return rv;
    }

    /**
     * 获取当前时间戳（秒）
     * @return
     */
    public static long getTimeInSecond() {
        return new Date().getTime() / 1000;
    }

    private static int getDayOfWeek(int dw) {
        if ( dw == 1 ) {//周日
            return  7;
        }

        return --dw;
    }

    public static void main(String[] args) throws Exception {
        Date d1 = new Date();
        Thread.sleep(2000);
        Date d2 = new Date();
        System.out.println(DateUtil.diffMillis(d1, d2));
        System.out.println(DateUtil.parseDate("0000-00-00 00:00:00", NORMAL_FORMAT));
        System.out.println(DateUtil.getTimeInSecond());
        System.out.println(DateUtil.diffDate(DateUtil.parseDate("2016-06-25 09:00:00", "yyyy-MM-dd HH:mm:ss"), DateUtil.parseDate("2016-06-24 10:00:00", "yyyy-MM-dd HH:mm:ss")));
        System.out.println(DateUtil.diffMillis(DateUtil.parseDate("2016-06-25 09:00:00", "yyyy-MM-dd HH:mm:ss"), DateUtil.parseDate("2016-06-24 10:00:00", "yyyy-MM-dd HH:mm:ss")));
        System.out.println(DateUtil.format(new Date(), "yyyy-MM-dd"));
        System.out.println(DateUtil.addDate(DateUtil.getYMDDate(), -1));
    }

}