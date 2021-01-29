//package com.github.bluecatlee.gs4d.sequence.utils;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.sql.Time;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.GregorianCalendar;
//import java.util.StringTokenizer;
//
//public class D {
//
//    private static final String Z = "yyyy-MM-dd";
//
//    private static final int aa = "yyyy-MM-dd".length();
//
//    private static final String ab = "yyyy-MM-dd HH:mm:ss";
//
//    private static final String ac = "yyyy年MM月dd日";
//
//    protected static Logger logger = LoggerFactory.getLogger(D.class);
//
//    public static boolean isSpecialTime(String date) {
//        Integer integer1 = Integer.valueOf(0);
//        Integer integer2 = Integer.valueOf(0);
//        logger.info("序列号来自哪里fromWhere====="+ date.trim());
//        if (date.trim().equals("common")) {
//            integer1 = Integer.valueOf(2354);
//            integer2 = Integer.valueOf(2356);
//        } else if (date.trim().equals("auto")) {
//            integer1 = Integer.valueOf(2400);
//            integer2 = Integer.valueOf(2402);
//        }
//        Boolean bool = Boolean.valueOf(false);
//        try {
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            String str1 = simpleDateFormat.format(new Date());
//            int i = Integer.parseInt(str1.substring(11, 13));   // 小时数(24时)
//            String str2 = str1.substring(14, 16);               // 分钟数
//            if (i < 12) {
//                i += 24;    // ?? 个位数小时数的位数不够的原因吗
//            }
//            String str3 = String.valueOf(i) + str2;
//            int j = Integer.parseInt(str3);
//            if (integer1.intValue() <= j && j <= integer2.intValue()) {
//                bool = Boolean.valueOf(true);                               // 小时分钟数(如： 1801)在2354~2356之间返回true？？？   这三分钟系统在做什么处理吗？
//            }
//        } catch (Exception exception) {
//            exception.printStackTrace();
//        }
//        return bool.booleanValue();
//    }
//
////    public static boolean c() {
////        String str1 = "23:30";
////        String str2 = "24:30";
////        Boolean bool = Boolean.valueOf(false);
////        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
////        Date date1 = null;
////        Date date2 = null;
////        Date date3 = null;
////        try {
////            date1 = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
////            date2 = simpleDateFormat.parse(str1);
////            date3 = simpleDateFormat.parse(str2);
////            Calendar calendar1 = Calendar.getInstance();
////            calendar1.setTime(date1);
////            Calendar calendar2 = Calendar.getInstance();
////            calendar2.setTime(date2);
////            Calendar calendar3 = Calendar.getInstance();
////            calendar3.setTime(date3);
////            if (calendar1.after(calendar2) && calendar1.before(calendar3))
////                bool = Boolean.valueOf(true);
////        } catch (Exception exception) {
////            exception.printStackTrace();
////        }
////        return bool.booleanValue();
////    }
////
////    public static Date b(String paramString) {
////        if (null != paramString && paramString.length() > 0)
////            try {
////                if (paramString.length() <= aa)
////                    return (new SimpleDateFormat("yyyy-MM-dd")).parse(paramString);
////                return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(paramString);
////            } catch (ParseException parseException) {
////                return null;
////            }
////        return null;
////    }
////
////    public static Date c(String paramString) {
////        if (b(paramString) == null || paramString.length() < 1)
////            return null;
////        return new Date(b(paramString).getTime());
////    }
////
////    public static String a(Date paramDate) {
////        if (paramDate == null)
////            return null;
////        return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(paramDate);
////    }
////
////    public static String a(java.sql.Date paramDate) {
////        if (paramDate == null)
////            return null;
////        return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(paramDate);
////    }
////
////    public static String b(java.sql.Date paramDate) {
////        if (paramDate == null)
////            return null;
////        return (new SimpleDateFormat("yyyy年MM月dd日")).format(paramDate);
////    }
////
////    public static String d(String paramString) {
////        if (paramString == null || "".equals(paramString))
////            return "";
////        Date date = b(paramString);
////        return b(date);
////    }
////
////    public static String b(Date paramDate) {
////        if (paramDate == null)
////            return null;
////        return (new SimpleDateFormat("yyyy-MM-dd")).format(paramDate);
////    }
////
////    public static String a(Date paramDate, String paramString) {
////        return (new SimpleDateFormat(paramString)).format(paramDate);
////    }
////
//    public static String c(Date paramDate) {
//        if (paramDate == null)
//            return null;
//        return (new SimpleDateFormat("yyyy-MM-dd")).format(paramDate);
//    }
////
////    public static Date getCurrentDate() {
////        return new Date((new Date()).getTime());
////    }
////
////    public static Date getCurrentDateTime() {
////        return Calendar.getInstance().getTime();
////    }
////
////    public static Date d(Date paramDate) {
////        return new Date(paramDate.getTime());
////    }
////
////    public static Date c(java.sql.Date paramDate) {
////        return new Date(paramDate.getTime());
////    }
////
////    public static Date a(Date paramDate, Time paramTime) {
////        if (null == paramDate || null == paramTime)
////            return null;
////        GregorianCalendar gregorianCalendar1 = new GregorianCalendar();
////        gregorianCalendar1.setTimeInMillis(paramDate.getTime());
////        GregorianCalendar gregorianCalendar2 = new GregorianCalendar();
////        gregorianCalendar2.setTimeInMillis(paramTime.getTime());
////        GregorianCalendar gregorianCalendar3 = new GregorianCalendar();
////        int i = gregorianCalendar1.get(1);
////        int j = gregorianCalendar1.get(2);
////        int k = gregorianCalendar1.get(5);
////        int m = gregorianCalendar2.get(11);
////        int n = gregorianCalendar2.get(12);
////        int i1 = gregorianCalendar2.get(13);
////        int i2 = gregorianCalendar2.get(14);
////        gregorianCalendar3.set(i, j, k, m, n, i1);
////        gregorianCalendar3.set(14, i2);
////        return d(gregorianCalendar3.getTime());
////    }
////
////    public static Date e(String paramString) {
////        long l = 0L;
////        try {
////            StringTokenizer stringTokenizer = new StringTokenizer(paramString, " ");
////            String str = stringTokenizer.nextToken();
////            Date date = java.sql.Date.valueOf(str);
////            l = date.getTime();
////            try {
////                String str1 = stringTokenizer.nextToken();
////                StringTokenizer stringTokenizer1 = new StringTokenizer(str1, ":");
////                l += (Integer.parseInt(stringTokenizer1.nextToken()) * 60 * 60 * 1000);
////                l += (Integer.parseInt(stringTokenizer1.nextToken()) * 60 * 1000);
////                l += (Integer.parseInt(stringTokenizer1.nextToken()) * 1000);
////            } catch (Exception exception) {
////                l = date.getTime();
////            }
////        } catch (Exception exception) {
////            return new Date();
////        }
////        return new Date(l);
////    }
////
////    public static String d() {
////        return f(new Date());
////    }
////
////    public static String a(long paramLong) {
////        return f(new Date(paramLong));
////    }
////
////    public static String b(long paramLong) {
////        return e(new Date(paramLong));
////    }
////
////    public static String e(Date paramDate) {
////        String str = "";
////        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy 年 MM 月 dd 日");
////        try {
////            str = simpleDateFormat.format(paramDate);
////        } catch (Exception exception) {
////            str = simpleDateFormat.format(new Date());
////        }
////        return str;
////    }
////
////    public static String f(Date paramDate) {
////        String str = "";
////        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
////        try {
////            str = simpleDateFormat.format(paramDate);
////        } catch (Exception exception) {
////            str = simpleDateFormat.format(new Date());
////        }
////        return str;
////    }
////
////    public static String g(Date paramDate) {
////        String str = "";
////        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
////        try {
////            str = simpleDateFormat.format(paramDate);
////        } catch (Exception exception) {
////            str = simpleDateFormat.format(new Date());
////        }
////        return str;
////    }
////
////    public static String e() {
////        return g(new Date());
////    }
////
////    public static String c(long paramLong) {
////        return g(new Date(paramLong));
////    }
////
////    public static String h(Date paramDate) {
////        String str = "";
////        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
////        try {
////            str = simpleDateFormat.format(paramDate);
////        } catch (Exception exception) {
////            str = "";
////        }
////        return str;
////    }
////
////    public static String f() {
////        return h(new Date());
////    }
////
////    public static String d(long paramLong) {
////        return h(new Date(paramLong));
////    }
////
////    public static String i(Date paramDate) {
////        String str = "";
////        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
////        try {
////            str = simpleDateFormat.format(paramDate);
////        } catch (Exception exception) {
////            str = simpleDateFormat.format(new Date());
////        }
////        return str;
////    }
////
////    public static String g() {
////        return i(new Date());
////    }
////
////    public static String e(long paramLong) {
////        return i(new Date(paramLong));
////    }
////
////    public static Date a(int paramInt1, int paramInt2) {
////        Calendar calendar = Calendar.getInstance();
////        calendar.set(1, paramInt1);
////        calendar.set(2, paramInt2 - 1);
////        calendar.set(5, 1);
////        calendar.set(11, 0);
////        calendar.set(12, 0);
////        calendar.set(13, 0);
////        return calendar.getTime();
////    }
////
////    public static Calendar a(int paramInt1, int paramInt2, int paramInt3) {
////        Calendar calendar = Calendar.getInstance();
////        calendar.set(1, paramInt1);
////        calendar.set(2, paramInt2 - 1);
////        calendar.set(5, paramInt3);
////        calendar.set(11, 0);
////        calendar.set(12, 0);
////        calendar.set(13, 0);
////        return calendar;
////    }
////
////    public static Calendar j(Date paramDate) {
////        Calendar calendar = Calendar.getInstance();
////        calendar.setTime(paramDate);
////        return calendar;
////    }
////
////    public static Date k(Date paramDate) {
////        Calendar calendar = Calendar.getInstance();
////        calendar.setTime(paramDate);
////        calendar.add(13, 1);
////        return calendar.getTime();
////    }
////
////    public static Date a(Date paramDate, int paramInt) {
////        Calendar calendar = Calendar.getInstance();
////        calendar.setTime(paramDate);
////        calendar.add(13, paramInt);
////        return calendar.getTime();
////    }
////
////    public static Date b(Date paramDate, int paramInt) {
////        Calendar calendar = Calendar.getInstance();
////        calendar.setTime(paramDate);
////        calendar.add(5, -paramInt);
////        return calendar.getTime();
////    }
////
////    public static Date a(int paramInt) {
////        Calendar calendar = Calendar.getInstance();
////        calendar.setTime(new Date());
////        calendar.add(5, -paramInt);
////        return calendar.getTime();
////    }
////
////    public static String l(Date paramDate) {
////        String str = "";
////        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
////        try {
////            str = simpleDateFormat.format(paramDate);
////        } catch (Exception exception) {
////            str = "";
////        }
////        return str;
////    }
////
////    public static Boolean m(Date paramDate) {
////        if (null != paramDate)
////            return Boolean.valueOf(true);
////        return Boolean.valueOf(false);
////    }
////
////    public static String getDateLong() {
////        return String.valueOf((new Date()).getTime());
////    }
////
////    static char[] ad = new char[] { '零', '一', '二', '三', '四', '五', '六', '七', '八', '九'};
////
////    public static void main(String[] paramArrayOfString) {}
////
////    public static String b(int paramInt) {
////        char[] arrayOfChar = String.valueOf(paramInt).toCharArray();
////        int i = arrayOfChar.length;
////        StringBuilder stringBuilder = new StringBuilder();
////        for (byte b = 0; b < i; b++) {
////            String str = arrayOfChar[b] + "";
////            int j = Integer.valueOf(str).intValue();
////            boolean bool = (j == 0) ? true : false;
////            if (bool) {
////                if ('0' != arrayOfChar[b - 1])
////                    stringBuilder.append(ad[j]);
////            } else {
////                stringBuilder.append(ad[j]);
////            }
////        }
////        return stringBuilder.toString();
////    }
////
////    private static String a(double paramDouble) {
////        String str = String.valueOf(paramDouble);
////        int i = str.indexOf(".");
////        int j = Integer.valueOf(str.substring(0, i)).intValue();
////        int k = Integer.valueOf(str.substring(i + 1)).intValue();
////        return b(j) + "." + c(k);
////    }
////
////    private static String c(int paramInt) {
////        char[] arrayOfChar = String.valueOf(paramInt).toCharArray();
////        int i = arrayOfChar.length;
////        StringBuilder stringBuilder = new StringBuilder();
////        for (byte b = 0; b < i; b++) {
////            int j = Integer.valueOf(arrayOfChar[b] + "").intValue();
////            stringBuilder.append(ad[j]);
////        }
////        return stringBuilder.toString();
////    }
//}
