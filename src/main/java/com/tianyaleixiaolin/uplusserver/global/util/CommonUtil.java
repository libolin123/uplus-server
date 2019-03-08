package com.tianyaleixiaolin.uplusserver.global.util;


import com.xiaoleilu.hutool.crypto.digest.DigestUtil;
import com.xiaoleilu.hutool.date.DatePattern;
import com.xiaoleilu.hutool.date.DateUtil;
import com.xiaoleilu.hutool.io.file.FileReader;
import com.xiaoleilu.hutool.lang.Base64;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Mr.li wrote on 2018/10/26.
 */
public class CommonUtil {
    public static Date getNow() {
        return new Date();
    }

    public static String md5(String str) {
        return DigestUtil.md5Hex(str);
    }

    public static String base64(String str) {
        return Base64.encode(str);
    }

    public static String base64Decode(String str) {
        return Base64.decodeStr(str);
    }

    public static String filterEmoji(String source) {
        if (StringUtils.isEmpty(source)) {
            return source;
        }
        StringBuilder buf = null;
        int len = source.length();
        for (int i = 0; i < len; i++) {
            char codePoint = source.charAt(i);
            if (isEmojiCharacter(codePoint)) {
                if (buf == null) {
                    buf = new StringBuilder(source.length());
                }
                buf.append(codePoint);
            }
        }
        if (buf == null) {
            return source;
        } else {
            if (buf.length() == len) {
                buf = null;
                return source;
            } else {
                return buf.toString();
            }
        }
    }

    public static boolean containsEmoji(String source) {
        int len = source.length();
        boolean isEmoji = false;
        for (int i = 0; i < len; i++) {
            char hs = source.charAt(i);
            if (0xd800 <= hs && hs <= 0xdbff) {
                if (source.length() > 1) {
                    char ls = source.charAt(i + 1);
                    int uc = ((hs - 0xd800) * 0x400) + (ls - 0xdc00) + 0x10000;
                    if (0x1d000 <= uc && uc <= 0x1f77f) {
                        return true;
                    }
                }
            } else {
                // non surrogate
                if (0x2100 <= hs && hs <= 0x27ff && hs != 0x263b) {
                    return true;
                } else if (0x2B05 <= hs && hs <= 0x2b07) {
                    return true;
                } else if (0x2934 <= hs && hs <= 0x2935) {
                    return true;
                } else if (0x3297 <= hs && hs <= 0x3299) {
                    return true;
                } else if (hs == 0xa9 || hs == 0xae || hs == 0x303d
                        || hs == 0x3030 || hs == 0x2b55 || hs == 0x2b1c
                        || hs == 0x2b1b || hs == 0x2b50 || hs == 0x231a) {
                    return true;
                }
                if (!isEmoji && source.length() > 1 && i < source.length() - 1) {
                    char ls = source.charAt(i + 1);
                    if (ls == 0x20e3) {
                        return true;
                    }
                }
            }
        }
        return isEmoji;
    }

    private static boolean isEmojiCharacter(char codePoint) {
        return (codePoint == 0x0) || (codePoint == 0x9) || (codePoint == 0xA)
                || (codePoint == 0xD)
                || ((codePoint >= 0x20) && (codePoint <= 0xD7FF))
                || ((codePoint >= 0xE000) && (codePoint <= 0xFFFD))
                || ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF));
    }
    /**
     * 生成uuid
     */
    public static String token() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 是否是直辖市里的区县
     *
     * @param cityCode
     *         区县码
     * @return 是否是直辖市里的
     */
    public static boolean isZhiXiaShi(Integer cityCode) {
        //110000北京，120000天津，310000上海， 500000重庆，810000香港，820000澳门
        int city = cityCode / 1000;
        return city == 110 || city == 120 || city == 310 || city == 500 || city == 810 || city == 820;
    }

    /**
     * 截取double2位
     *
     * @param d
     *         d
     * @return 截取后结果
     */
    public static Double cutDouble2(Double d) {
        if (d == null) {
            return 0.00;
        }
        DecimalFormat df = new DecimalFormat("######0.000");
        return Double.parseDouble(df.format(d));
    }

    public static Double parsePercent(Integer var1, Integer var2) {
        try {
            return cutDouble2(var1 * 1.0 / var2);
        } catch (Exception e) {
            return 0.000;
        }
    }

    /**
     * 只接受这样的格式2017-09-3，不能带时分秒
     *
     * @param date
     *         年月日
     * @return 该天的开始
     */
    public static Date beginOfDay(String date) {
        DateFormat dateFormat = new SimpleDateFormat(DatePattern.NORM_DATETIME_PATTERN);
        try {
            return dateFormat.parse(date + " 00:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 只接受这样的格式2017-09-3，不能带时分秒
     *
     * @param date
     *         年月日
     * @return 该天的结束
     */
    public static Date endOfDay(String date) {
        DateFormat dateFormat = new SimpleDateFormat(DatePattern.NORM_DATETIME_PATTERN);
        try {
            return dateFormat.parse(date + " 23:59:59");
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String parseDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        return sdf.format(date);
    }

    /**
     * 将object转为long
     *
     * @param object
     *         object
     * @return long
     */
    public static Long parseObject(Object object) {
        if (object instanceof Integer) {
            return ((Integer) object).longValue();
        }
        if (object instanceof Long) {
            return (Long) object;
        }
        return 0L;
    }

    public static boolean isMobile(String phone) {
        String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
        if (phone.length() != 11) {
            return false;
        }
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(phone);
        return m.matches();
    }

    public static String secToTime(Integer time) {
        String timeStr;
        int hour;
        int minute;
        int second;
        if (time <= 0) {
            return "00:00";
        } else {
            minute = time / 60;
            if (minute < 60) {
                second = time % 60;
                timeStr = unitFormat(minute) + ":" + unitFormat(second);
            } else {
                hour = minute / 60;
                if (hour > 99) {
                    return "99:59:59";
                }
                minute = minute % 60;
                second = time - hour * 3600 - minute * 60;
                timeStr = unitFormat(hour) + ":" + unitFormat(minute) + ":" + unitFormat(second);
            }
        }
        return timeStr;
    }

    private static String unitFormat(int i) {
        String retStr;
        if (i >= 0 && i < 10) {
            retStr = "0" + Integer.toString(i);
        } else {
            retStr = "" + i;
        }
        return retStr;
    }

    public static void main(String[] args) {
        String datestr = "2018-01-26 00:00:00";
        System.out.println(DateUtil.betweenDay(CommonUtil.getNow(), DateUtil.parseDate(datestr), true));
        jisuan();
    }

    private static void jisuan() {
        FileReader fileReader = new FileReader("/Users/wuwf/Downloads/2.csv", "gbk");
        List<String> list = fileReader.readLines();
        list.remove(0);
        for (String line : list) {
            String[] array = line.split(",");
            String finish = array[4];
            //取电话次数
            int a = finish.indexOf("\"");
            int b = finish.indexOf("次");
            int cishu = Integer.valueOf(finish.substring(a + 1, b));

            int begin = finish.indexOf("：");
            int end = finish.indexOf("秒");
            String s = finish.substring(begin + 1, end);
            int userSeconds = getSeconds(s);
            DecimalFormat df = new DecimalFormat("######0.00");
            double scale = userSeconds * 100.0 / 3600;
            double noscale = (3600 - userSeconds) * 100.0 / 3600;
            String result = array[0].replace("\"", "") + "," +
                    "60分钟" + ",已打" + secToTime(userSeconds) + ",未打" + secToTime(3600 - userSeconds) + ",电话完成率"
                    + df.format(scale) + "%,未完成率" + df.format(noscale) + "%" + ",拜访" + array[9].replace("\"", "") +
                    "人,"
                    + "加上折算、累计次数" + (cishu + Integer.valueOf(array[9].replace("\"", "")) * 20) + ",还欠次数" + (60 -
                    (cishu + Integer.valueOf(array[9].replace("\"", "")) * 20));
            System.out.println(result);
        }
    }

    private static Integer getSeconds(String hourStr) {
        int count = 0;
        if (hourStr.contains("小时")) {
            Integer hour = Integer.valueOf(hourStr.substring(0, hourStr.indexOf("小时")));
            count += hour * 3600;
            hourStr = hourStr.replace(hour + "小时", "");
        }
        if (hourStr.contains("分")) {
            Integer hour = Integer.valueOf(hourStr.substring(0, hourStr.indexOf("分")));
            count += hour * 60;
            hourStr = hourStr.replace(hour + "分", "");
        }
        count += Integer.valueOf(hourStr);
        return count;
    }
}
