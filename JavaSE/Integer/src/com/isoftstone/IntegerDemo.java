package com.isoftstone;

/**
 * 描述:
 * Integer常用方法
 *
 * @author Ming
 * @create 2020-05-18 15:45
 */
public class IntegerDemo {
    public static void main(String[] args) {
        //构造方法
        Integer i = new Integer(11);
        Integer i2 = new Integer("22");
        System.out.println(i);
        System.out.println(i2);

        // 数字型字符串转整型
        int year = Integer.parseInt("1996");
        System.out.println(year);

        // 十进制整数转换成能二进制、八进制、十六进制
        String binaryString = Integer.toBinaryString(i);
        System.out.println(binaryString);
        String octalString = Integer.toOctalString(i);
        System.out.println(octalString);
        String hexString = Integer.toHexString(i);
        System.out.println(hexString);

    }
}