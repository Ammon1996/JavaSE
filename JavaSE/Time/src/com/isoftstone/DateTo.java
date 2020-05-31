package com.isoftstone;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * 描述:  传统日期类util包下的Date转换成LocalDate
 * java8为Date添加了toInstant方法，可以将Date转成Instant
 * 通过给 Instant添加时区信息之后就可以转换为LocalDate对象
 *
 * @author Ming
 * @create 2020-05-27 18:35
 */
public class DateTo {
    public static void main(String[] args) {
        //传统日期Date对象转换成LocalDate对象
        Date date = new Date();     // 初始化Date对象
        Instant instant = date.toInstant();       // 转换成Instant对象
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());   // 添加时区信息
        LocalDate localDate = zonedDateTime.toLocalDate();      // 转成LocalDate对象
        System.out.println("转换前的java.util.Date对象:" + date);
        System.out.println("转换后的java.time.LocalDate对象:" + localDate);

        //sql包下的日期Date对象转换成LocalDate
        java.sql.Date date_sql = new java.sql.Date(System.currentTimeMillis());
        LocalDate localDate1 = date_sql.toLocalDate();
        System.out.println("转换前的java.sql.Date对象:" + date);
        System.out.println("转换后的java.time.LocalDate对象:" + localDate1);

        // 先将java.util.Date转换成java.sql.Date再由java.sql.Date转换成LocalDate
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        LocalDate localDate2 = sqlDate.toLocalDate();
        System.out.println("转换后的java.time.LocalDate对象:" + localDate2);
    }
}