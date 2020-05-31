package com.isoftstone;

import java.util.function.Consumer;

/**
 * 描述:  Consumer接口也被称为消费型接口，它消费的数据的数据类型由泛型指定
 * Consumer：包含两个方法
 * void accept(T t) 对给定的参数执行此操作
 * default Consumer andThen(Consumer after)返回一个组合的Consumer，依次执行此操作，然后执行 after操作
 *
 * @author Ming
 * @create 2020-05-24 10:55
 */
public class ConsumerDemo {
    public static void main(String[] args) {
        operateString("张三丰", s -> System.out.println(s));
        operateString("张三丰", s -> System.out.println(s.replaceAll("三", "*")));

        operateString("张三丰", s -> System.out.println(s),
                s -> System.out.println(s.replaceAll("三", "*")));

        // 练习
        String[] array = {"张三丰,30", "李四狗,25", "刘五虎,18"};
        printInfo(array, str -> {
            String name = str.split(",")[0];
            System.out.print("姓名：" + name);
        }, str -> {
            int age = Integer.parseInt(str.split(",")[1]);
            System.out.println(",年龄：" + age);
        });
    }

    // 消费一个字符串两次
    private static void operateString(String name, Consumer<String> con1, Consumer<String> con2) {
//        con1.accept(name);
//        con2.accept(name);
        con1.andThen(con2).accept(name);
    }

    // 消费一个字符串
    private static void operateString(String name, Consumer<String> consumer) {
        consumer.accept(name);
    }

    // 练习
    private static void printInfo(String[] array, Consumer<String> con1, Consumer<String> con2) {
        for (String str : array) {
            con1.andThen(con2).accept(str);
        }
    }
}