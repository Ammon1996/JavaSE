package com.isoftstone;

import java.util.Random;

/**
 * 描述:
 * Random类的常用方法
 *
 * @author Ming
 * @create 2020-05-19 10:27
 */
public class RandomDemo {
    public static void main(String[] args) {

        System.out.println("无参构造生成的随机值：");
        for (int i = 0; i <= 5; i++) {
            Random random = new Random();       //无参构造使用当前时间做种子
            for (int j = 0; j < 10; j++) {
                //nextInt无参方法返回int类型范围内的值，有参方法返回[0，n)的值
                int i1 = random.nextInt(100);
                System.out.print(i1 + " ");
            }
            System.out.println();
        }

        System.out.println("有参构造生成的随机值：");
        for (int i = 0; i <= 5; i++) {
            Random random1 = new Random(1996);         //无参构造使用当前时间做种子
            for (int j = 0; j < 10; j++) {
                int i2 = random1.nextInt(100);
                System.out.print(i2 + " ");
            }
            System.out.println();
        }

    }
}