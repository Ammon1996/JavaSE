package com.isoftstone;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * 描述:  TimeStamp时间戳转换成LocalDateTime
 *
 * @author Ming
 * @create 2020-05-27 18:46
 */
public class TimeStampToLocalDateTime {
    public static void main(String[] args) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        LocalDateTime localDateTime = timestamp.toLocalDateTime();
        System.out.println("转换前的java.sql.Timestamp对象:" + timestamp);
        System.out.println("转换后的java.time.localDateTime对象:" + localDateTime);
    }
}