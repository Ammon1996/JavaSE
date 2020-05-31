package com.isoftstone;

import java.math.BigInteger;

/**
 * 描述:
 * BigInteger类的常用方法,通常用来处理超过Integer范围的大数据
 *
 * @author Ming
 * @create 2020-05-19 10:01
 */
public class BigIntegerDemo {
    public static void main(String[] args) {
        BigInteger bigInteger = new BigInteger("1515145111581");
        BigInteger bigInteger1 = new BigInteger("1145151151515");

        BigInteger add = bigInteger.add(bigInteger1);
        System.out.println(add);

        BigInteger subtract = bigInteger.subtract(bigInteger1);
        System.out.println(subtract);

        BigInteger multiply = bigInteger.multiply(bigInteger1);
        System.out.println(multiply);

        BigInteger divide = bigInteger.divide(bigInteger1);
        System.out.println(divide);

        // 商与余数组成的数组
        BigInteger[] bigIntegers = bigInteger.divideAndRemainder(bigInteger1);
        for (BigInteger integer : bigIntegers) {
            System.out.println(integer);
        }
    }
}