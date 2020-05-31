package com.isoftstone;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 描述:
 * Date类的常用方法
 * <p>
 * Date的无参构造是创建当前日期时间对象
 * 带参构造是创建基于标准基准时间的日期时间对象
 * 标准基准时间是1970 01 01 00:00:00 GMT
 * 北京时间处于东八区，加8小时
 *
 * @author Ming
 * @create 2020-05-19 10:38
 */
public class DateDemo {
    public static void main(String[] args) throws ParseException {
        // 构造方法
        Date date = new Date();
        Date date1 = new Date(1000 * 60 * 60);
        System.out.println(date);
        System.out.println(date1);

        // 获取时间毫秒值
        long time = date.getTime();
        System.out.println(time);

        // 日期转换成字符串
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy年MM日dd日 HH:mm:ss");
        String format = simpleFormat.format(date);
        System.out.println(format);

        // 字符串转成日期
        String dateTime = "2019年12日31日 00:00:00";
        Date parse = simpleFormat.parse(dateTime);
        System.out.println(parse);

        Scanner scanner = new Scanner(System.in);
        System.out.print("输入你的出生年月日:");
        String birthday = scanner.nextLine();
        long days = getDays(birthday);
        System.out.println("你出生到今天已经过了" + days + "天");
    }

    public static long getDays(String birthday) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
        Date date = simpleDateFormat.parse(birthday);

        long start = date.getTime();
        long end = System.currentTimeMillis();
        long days = (end - start) / 1000 / 60 / 60 / 24;
        return days;
    }
}