package com.isoftstone;

/**
 * 描述:
 * String类的常用方法
 *
 * @author Ming
 * @create 2020-05-19 9:36
 */
public class StringDemo {
    public static void main(String[] args) {
        String s = "Hello,IDEA";
        String s1 = "Hello,Java";

        // 获取指定索引的字符
        char c = s.charAt(2);
        System.out.println(c);

        // 比较两个字符串
        int i = s.compareTo(s1);
        System.out.println(i);

        //拼接字符串
        String concat = s.concat(s1);
        System.out.println(concat);

        // 字符数组转成字符串
        char[] chars = {'a','b','c','d'};
        String s2 = String.copyValueOf(chars);
        System.out.println(s2);

        // 字符串分割
        String[] strings = s1.split(",");
        for (String string : strings) {
            System.out.println(string);
        }

        // 清除字符串中的开头和结尾空格
        String s3 = " Hello IntelliJ ";
        String trim = s3.trim();
        System.out.println(trim);

        // 字符串截取
        String substring = s3.substring(7);
        System.out.println(substring);
    }
}