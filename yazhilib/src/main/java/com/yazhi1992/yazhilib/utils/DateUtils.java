package com.yazhi1992.yazhilib.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by zengyazhi on 17/5/27.
 */

public class DateUtils {

    private static String[] dayInWeekTime = {"", "周一", "周二", "周三", "周四", "周五", "周六", "周日"};
    static SimpleDateFormat ymdFormat = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 计算周几
     *
     * @param time 格式：yyyy-MM-dd
     * @return
     */
    public static String getDayInWeek(Date time) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(time);
        int i = instance.get(Calendar.DAY_OF_WEEK);
        if (instance.getFirstDayOfWeek() == Calendar.SUNDAY) {
            //如果一周第一天为星期天，则返回 1日，2一，3二。。以此类推
            //如果一周第一天为星期一，则返回 1一，2二，3三。。以此类推
            i = i - 1;
            if (i == 0) {
                //周日
                i = 7;
            }
        }
        return dayInWeekTime[i];
    }

    /**
     * 计算周几
     *
     * @param time 格式：yyyy-MM-dd
     * @return
     */
    public static String getDayInWeek(String time) {
        try {
            return getDayInWeek(ymdFormat.parse(time));
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }
}