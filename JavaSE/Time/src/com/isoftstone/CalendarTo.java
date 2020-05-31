package com.isoftstone;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * 描述:  传统Calendar对象转换成LocalDateTime与ZoneDateTime对象
 *
 * @author Ming
 * @create 2020-05-27 19:01
 */
public class CalendarTo {
    public static void main(String[] args) {
        // 初始化Calendar对象
        Calendar calendar = Calendar.getInstance();
        // 获取年月日时分秒
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        // calendar的月份是从0开始，转换时候要加1
        LocalDateTime localDateTime = LocalDateTime.of(year, month + 1, day, hour, minute, second);
        System.out.println("转换前的Calendar对象是:" + calendar);
        System.out.println("转换后的LocalDateTime对象是:" + localDateTime);

        // 获取时区对象
        TimeZone timeZone = calendar.getTimeZone();
        // 获取时区id
        ZoneId zoneId = timeZone.toZoneId();
        // 初始化ZoneDateTime对象
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(calendar.toInstant(), zoneId);
        System.out.println("转换前的Calendar对象:" + calendar);
        System.out.println("转换后的ZoneDateTime对象:" + zonedDateTime);
    }
}