package com.isoftstone;

import java.util.Calendar;

/**
 * 描述:
 * Calendar类常用方法
 *
 * @author Ming
 * @create 2020-05-19 12:32
 */
public class CalendarDemo {
    public static void main(String[] args) {
        //构造方法
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;  //月份默认是从0开始，所以加1
        int date = calendar.get(Calendar.DATE);
        System.out.println("当前时期：" + year + "年" + month + "月" + date + "日");

        // 三年前的今天
        calendar.add(Calendar.YEAR, -3);  //月份，日期同理
        int year2 = calendar.get(Calendar.YEAR);
        int month2 = calendar.get(Calendar.MONTH) + 1;  //月份默认是从0开始，所以加1
        int date2 = calendar.get(Calendar.DATE);
        System.out.println("三年前的今天：" + year2 + "年" + month2 + "月" + date2 + "日");

        // 自定义日期
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(1996,9,25);
        int year3=calendar1.get(Calendar.YEAR);
        int month3=calendar1.get(Calendar.MONTH);
        int date3=calendar1.get(Calendar.DATE);
        System.out.println("自己设置的时间："+year3+"年"+month3+"月"+date3+"日");
    }
}