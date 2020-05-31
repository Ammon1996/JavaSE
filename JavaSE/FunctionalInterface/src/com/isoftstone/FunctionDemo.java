package com.isoftstone;

import java.util.function.Function;

/**
 * 描述:  Function接口
 * Function<T,R>接口通常用于对参数进行处理，转换(处理逻辑由Lambda表达式实现)，然后返回一个新的值    T被操作的数据类型 R返回值类型
 * R apply(T t) 将此函数应用于给定的参数
 * default Function andThen(Function after)返回一个组合函数，首先将该函数应用于输入，然后将after函数应用于结果
 *
 * @author Ming
 * @create 2020-05-24 11:36
 */
public class FunctionDemo {
    public static void main(String[] args) {
        System.out.println(convert("1996", s -> Integer.parseInt(s)));
        System.out.println(convert(1996, i -> String.valueOf(i)));
        System.out.println(convert("1996", s -> Integer.parseInt(s), i -> String.valueOf(i + 1998)));
    }

    // 把一个字符串转成整型
    private static String convert(Integer i, Function<Integer, String> function) {
        return function.apply(i);
    }

    // 把一个整型转成字符串
    private static Integer convert(String s, Function<String, Integer> function) {
        return function.apply(s);
    }

    // 把一个字符串转成整型，加上一个数再转成字符串
    private static String convert(String s, Function<String, Integer> function, Function<Integer, String> function2) {
//        Integer i = function.apply(s);
//        return function2.apply(i);
        return function.andThen(function2).apply(s);
    }
}