package com.isoftstone;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * 描述: java8日期时间API的格式化
 * 新版本的日期/时间API的格式化与解析不需要在创建转换器对象再进行转换了,
 * 通过时间日期对象的parse/format方法可以直接进行转换
 *
 * @author Ming
 * @create 2020-05-27 19:10
 */
public class DateTimeFormatterDemo {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        String result1 = localDateTime.format(DateTimeFormatter.ISO_DATE_TIME);
        String result2 = localDateTime.format(DateTimeFormatter.ISO_DATE);
        System.out.println("ISO_DATE_TIME格式化之后的String是:" + result1);
        System.out.println("ISO_DATE格式化之后的String是:" + result2);
        LocalDateTime localDateTime2 = LocalDateTime.parse(result1);
        System.out.println("解析了字符串之后的LocalDateTime是:" + localDateTime2);

        // 对日期格式的相关格式化
        //  Full:全显示(年月日+星期) Long:全显示(年月日)
        //  Medium:缩略显示(没有年月日汉字) SHORT:精简显示(精简年+月日)
        String full = localDateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
        String long_ = localDateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
        String medium = localDateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM));
        String short_ = localDateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
        System.out.println("FULL:" + full);
        System.out.println("LONG:" + long_);
        System.out.println("MEDIUM:" + medium);
        System.out.println("SHORT:" + short_);

        // 自定义格式化格式 DateTimeFormatter.ofPattern()
        String format = localDateTime.format(DateTimeFormatter.ofPattern("yyyy/mm/dd HH:mm:ss"));
        System.out.println("LocalDateTime格式化前是:" + localDateTime);
        System.out.println("LocalDateTime格式化后是:" + format);

    }
}