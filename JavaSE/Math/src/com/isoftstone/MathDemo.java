package com.isoftstone;

import java.util.Scanner;

/**
 * 描述:
 * Math类的常用方法
 *
 * @author Ming
 * @create 2020-05-19 10:10
 */
public class MathDemo {
    public static void main(String[] args) {
        System.out.println(Math.PI);
        System.out.println(Math.abs(-5.8));
        System.out.println(Math.max(15, 56));
        System.out.println(Math.ceil(2.4));
        System.out.println(Math.floor(2.8));
        System.out.println(Math.pow(2, 3));
        System.out.println(Math.random());
        System.out.println(Math.round(2.6));
        System.out.println(Math.sqrt(25));

        Scanner sc = new Scanner(System.in);
        System.out.print("请输入起始值：");
        int start = sc.nextInt();
        System.out.print("请输入终止值：");
        int end = sc.nextInt();
        double number = getNumber(start, end);
        System.out.println(number);
    }

    public static double getNumber(int start, int end) {
        return Math.random() * (end - start + 1) - start;
    }
}