package com.isoftstone;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * 描述:  LocalDateTime常用方法
 *
 * @author Ming
 * @create 2020-05-28 9:12
 */
public class LocalDateTimeDemo {
    public static void main(String[] args) {
        // 创建当前系统时间的LocalDateTime对象
        LocalDateTime now = LocalDateTime.now();

        // 使用of方法创建任意时刻的LocalDateTime对象
        LocalDateTime localDateTime = LocalDateTime.of(1996, 9, 25, 20, 30, 25);
        System.out.println("自定义的日期对象:" + localDateTime);

        // of方法的重载形式，使用LocalDate对象与LocalTime对象做参数
        LocalDate date = LocalDate.of(1996, 9, 25);
        LocalTime time = LocalTime.of(20, 30, 25, 0);
        LocalDateTime localDateTime1 = LocalDateTime.of(date, time);
        System.out.println("自定义的日期对象:" + localDateTime1);

        // 使用with方法修改封装好的日期对象中的某一项数值,返回一个新的日期对象，原来的对象并不会改变
        LocalDateTime localDateTime2 = localDateTime.withYear(1998).withMonth(2).withDayOfMonth(27).withHour(8).withMinute(0);
        System.out.println("修改之前日期对象:" + localDateTime);
        System.out.println("修改之后日期对象:" + localDateTime2);

        // 使用plus方法对日期对象的某一项进行增加，minus进行减少 用法一样
        LocalDateTime localDateTime3 = localDateTime.plusYears(24).plusMonths(1).plusDays(3).plusHours(2).plusMinutes(15);
        System.out.println("修改之前日期对象:" + localDateTime);
        System.out.println("增加之后日期对象:" + localDateTime3);

        // plus方法重载2 封装一个时间段进行增加Period.of封装了一个年月日时间段
        LocalDateTime localDateTime4 = localDateTime.plus(Period.of(1, 2, 3));
        System.out.println("增加时间段后日期对象:" + localDateTime4);

        // plus方法重载3 一次添加指定数量的时间值   DECADES 10年 HALF_DAYS 半天
        LocalDateTime localDateTime5 = localDateTime.plus(5, ChronoUnit.DECADES).plus(10, ChronoUnit.HALF_DAYS);
        System.out.println("增加时间段后日期对象:" + localDateTime5);
    }
}