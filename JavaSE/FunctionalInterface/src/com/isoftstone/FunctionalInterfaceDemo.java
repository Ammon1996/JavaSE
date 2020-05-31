package com.isoftstone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 描述:函数式接口 有且仅有一个抽象方法的接口   添加了@FunctionalInterface
 *
 * @author Ming
 * @create 2020-05-24 10:25
 */
public class FunctionalInterfaceDemo {
    private static String s1;
    private static String s2;

    public static void main(String[] args) {
        userInter(() -> System.out.println("函数式接口"));

        // 函数式接口作为参数
        new Thread(() -> System.out.println(Thread.currentThread().getName() + "启动了")).start();

        // 函数式接口作为返回值   
        ArrayList<String> array = new ArrayList<>();
        array.add("Hello");
        array.add("A");
        array.add("Hi");
        array.add("Bad");
        System.out.println("排序前：" + array);
        Collections.sort(array, getComparator());
        System.out.println("排序后：" + array);

    }

    public static void userInter(Inter inter) {
        inter.show();
    }

    private static Comparator<java.lang.String> getComparator() {
        return (s1, s2) -> s1.length() - s2.length();
    }
}

@FunctionalInterface
interface Inter {
    void show();
}