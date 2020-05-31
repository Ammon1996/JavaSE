package com.isoftstone;

import java.util.function.Predicate;

/**
 * 描述:
 * Predicate接口通常用于判断参数是否满足指定的条件
 * boolean test(T t)   对给定的参数进行判断(判断逻辑由Lambda表达式实现)，返回 一个布尔值
 * default Predicate negate() 返回一个逻辑的否定，对应逻辑非
 * default Predicate and(Predicate other)  返回一个组合判断，对应短路与
 * default Predicate or(Predicate other)   返回一个组合判断，对应短路或
 *
 * @author Ming
 * @create 2020-05-24 11:20
 */
public class PredicateDemo {
    public static void main(String[] args) {
        System.out.println(checkString("HelloWorld", s -> s.length() > 8));
        System.out.println(checkString("HelloWorld", s -> s.length() > 8, s -> s.length() < 10));
    }

    // 判定给定的字符串是否满足要求
    private static boolean checkString(String s, Predicate<String> predicate) {
        // return predicate.test(s);
        return predicate.negate().test(s);      // 对逻辑结果进行逻辑非处理
    }

    // 同一个字符串给出两个判断条件，在进行逻辑与运算作为最终结果
    private static boolean checkString(String s, Predicate<String> predicate, Predicate<String> predicate2) {
        // return predicate.and(predicate2).test(s);
        return predicate.or(predicate2).test(s);

    }
}