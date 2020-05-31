package com.isoftstone;

import java.math.BigDecimal;

/**
 * 描述:
 * BigDecimal类常用方法
 *
 * @author Ming
 * @create 2020-05-18 17:16
 */
public class BigDecimalDemo {
    public static void main(String[] args) {
        // 构造方法
        BigDecimal bigDecimal = new BigDecimal("0.09");
        BigDecimal bigDecimal1 = new BigDecimal("0.01");

        // 避免小数计算丢失精度，使用BigDecimal的方法来进行运算
        BigDecimal add = bigDecimal.add(bigDecimal1);
        BigDecimal subtract = bigDecimal.subtract(bigDecimal1);
        BigDecimal multiply = bigDecimal.multiply(bigDecimal1);
        BigDecimal divide = bigDecimal.divide(bigDecimal1);
        BigDecimal divide1 = bigDecimal.divide(bigDecimal1, 3, BigDecimal.ROUND_HALF_UP);
        System.out.println(add);
        System.out.println(subtract);
        System.out.println(multiply);
        System.out.println(divide);
        System.out.println(divide1);
    }
}