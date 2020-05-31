package com.isoftstone;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

/**
 * 描述:  ZoneId相关方法
 *
 * @author Ming
 * @create 2020-05-28 9:01
 */
public class ZoneIdDemo {
    public static void main(String[] args) {
        //获取所有的时区信息
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        for (String availableZoneId : availableZoneIds) {
            System.out.println(availableZoneId);
        }
        // 获取系统时区信息
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println("当前系统所在时区:" + zoneId);

        // 为LocalDateTime对象添加时区信息 返回ZoneDateTime对象
        LocalDateTime localDateTime = LocalDateTime.of(1996, 9, 25, 12, 12, 12);
        System.out.println(localDateTime);
        ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);
        System.out.println(zonedDateTime);

        // 获取同时刻其他时区的时间
        ZonedDateTime tokyo = zonedDateTime.withZoneSameInstant(ZoneId.of("Asia/Tokyo"));
        System.out.println(tokyo);
    }
}