package com.helloworld.epidemicmanagement.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author fsyj
 */
public class DateTimeUtil {

    public static SimpleDateFormat sdf16 = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public static SimpleDateFormat sdf19 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static Date parseToDateBy16(String time) throws ParseException {
        if (time.length() != 16) {
            return null;
        }
        return sdf16.parse(time);
    }
    public static Date parseToDateBy19(String time) throws ParseException {
        if (time.length() != 19) {
            return null;
        }
        return sdf19.parse(time);
    }

    public static String get16SysTime() {
        Date date = new Date();
        return sdf16.format(date);
    }

    public static String get19SysTime() {
        Date date = new Date();
        return sdf19.format(date);
    }

    public static String get10SysTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return sdf.format(date);
    }

    public static String get19StrTime(Date date) {
        return sdf19.format(date);
    }

    public static Date getDayAfter(Date start, Integer interval, int timeUnit) {
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(start);
        startCalendar.add(timeUnit, interval);
        return startCalendar.getTime();
    }
}
