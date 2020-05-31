package com.isoftstone;

import java.time.*;

/**
 * 描述:  java8新的日期API对象实例化
 *
 * @author Ming
 * @create 2020-05-28 9:00
 */
public class TimeDemo {
    public static void main(String[] args) {
        //使用now方法创建Instant的实例对象.
        Instant instantNow = Instant.now();
        //使用now方法创建LocalDate的实例对象.
        LocalDate localDateNow = LocalDate.now();
        //使用now方法创建LocalTime的实例对象.
        LocalTime localTimeNow = LocalTime.now();
        //使用now方法创建LocalDateTime的实例对象.
        LocalDateTime localDateTimeNow = LocalDateTime.now();
        //使用now方法创建ZonedDateTime的实例对象.
        ZonedDateTime zonedDateTimeNow = ZonedDateTime.now();

        System.out.println("Instant:" + instantNow);
        System.out.println("LocalDate:" + localDateNow);
        System.out.println("LocalTime:" + localTimeNow);
        System.out.println("LocalDateTime:" + localDateTimeNow);
        System.out.println("ZonedDateTime:" + zonedDateTimeNow);

        // 初始化Year的实例对象
        Year year = Year.now();
        System.out.println(year);
        //初始化YearMonth实例对象
        YearMonth yearMonth = YearMonth.now();
        System.out.println(yearMonth);
        //初始化MonthDay实例对象
        MonthDay monthDay = MonthDay.now();
        System.out.println(monthDay);
    }
}