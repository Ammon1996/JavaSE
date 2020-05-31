package com.isoftstone;

import java.util.Scanner;

/**
 * 描述:
 * Character类常用方法
 *
 * @author Ming
 * @create 2020-05-18 15:26
 */
public class CharacterDemo {
    public static void main(String[] args) {
        // 构造方法
        Character c = new Character('a');
        Character c2 = new Character('B');

        // 判断字符大小写
        System.out.println(Character.isUpperCase(c));
        System.out.println(Character.isLowerCase(c));

        //字符大小写转换
        System.out.println(Character.toUpperCase(c));
        System.out.println(Character.toLowerCase(c2));

        //pandaUN字符是否是数字
        System.out.println(Character.isDigit(c));

        count();
    }

    // 统计输入的字符串大写字母，小写字母，数字以及其他字符的个数
    public static void count() {
        int upperCase = 0;
        int lowerCase = 0;
        int digit = 0;
        int other = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入字符串：");
        String s = scanner.nextLine();

        // 字符串转成字符数组
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isUpperCase(chars[i])) {
                upperCase++;
            } else if (Character.isLowerCase(chars[i])) {
                lowerCase++;
            } else if (Character.isDigit(chars[i])) {
                digit++;
            } else {
                other++;
            }
        }
        System.out.println("大写字母：" + upperCase + "\n小写字母：" + lowerCase + "\n数字个数：" + digit + "\n其他字符：" + other);
    }
}