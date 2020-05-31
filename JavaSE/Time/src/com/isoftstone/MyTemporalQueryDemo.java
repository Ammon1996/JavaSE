package com.isoftstone;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;

/**
 * 描述:
 * 学习的时态类对象(LocalDate,LocalTime)都有一个方法叫做query,可以针对日期进行查询.
 * R query(TemporalQuery query)这个方法是一个泛型方法,返回的数据就是传入的泛型类的类 型,
 * TemporalQuery是一个泛型接口,里面有一个抽象方法是 R queryFrom(TemporalAccessor temporal),
 * TemporalAccessor是Temporal的父接口,实际 也就是LocalDate,LocalDateTime相关类的顶级父接口,
 * 这个queryFrom的方法的实现逻辑就是,传入一个日期/时间对象通过自定义逻辑返回数据.
 *
 * @author Ming
 * @create 2020-05-27 15:13
 */
public class MyTemporalQueryDemo {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        Object days = localDate.query(new MyTemporalQuery());
        System.out.println("距离下一个劳动节还有：" + days);
    }
}

// 测试当前日期距离下一个劳动节的天数
class MyTemporalQuery implements TemporalQuery {
    @Override
    public Object queryFrom(TemporalAccessor temporal) {
        int year = temporal.get(ChronoField.YEAR);
        int month = temporal.get(ChronoField.MONTH_OF_YEAR);
        int day = temporal.get(ChronoField.DAY_OF_MONTH);
        LocalDate localDate = LocalDate.of(year, month, day);

        // 封装5月1号日期对象
        LocalDate laborDay = LocalDate.of(year, Month.MAY, 1);
        // 判断是否已过5月1号,过了下一个劳动节就是年份加一
        if (localDate.isAfter(laborDay)) {
            laborDay = laborDay.plusYears(1);
        }
        //通过ChronoUnit的between方法计算两个时间点的差额.
        long days = ChronoUnit.DAYS.between(localDate, laborDay);
        return days;
    }
}