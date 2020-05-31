package com.isoftstone;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * 描述:  自定义日期调节器
 * 需求：如果日期不是15号就改成15号，如果是周六或者周日就改成上一个周五
 *
 * @author Ming
 * @create 2020-05-27 14:47
 */
public class MyAdjusterDemo {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(1996, 9, 23);
        LocalDate realDate = LocalDate.from(new MyAdjuster().adjustInto(date));
        System.out.println(realDate);
    }
}

class MyAdjuster implements TemporalAdjuster {
    @Override
    public Temporal adjustInto(Temporal temporal) {
        //将Temporal对象转换成LocalDate对象
        LocalDate date = LocalDate.from(temporal);
        int day;
        // 获取当前封装的日期对象的数据信息，来进行判断
        int dayOfMonth = date.getDayOfMonth();
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        if (dayOfMonth != 15) {
            day = 15;
        } else {
            day = date.getDayOfMonth();
        }
        LocalDate readyDate = date.withDayOfMonth(day);
        if (dayOfWeek == DayOfWeek.SUNDAY || dayOfWeek == DayOfWeek.SATURDAY) {
            readyDate = readyDate.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
        }
        return readyDate;
    }
}