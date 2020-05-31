package com.isoftstone;

import java.util.Arrays;
import java.util.function.Supplier;

/**
 * 描述:
 * Supplier接口也被称为生产接口，有一个无参get()，会根据lambda表达式逻辑返回一个数据，类型由接口泛型指定
 *
 * @author Ming
 * @create 2020-05-24 10:43
 */
public class SupplierDemo {
    public static void main(String[] args) {
        String s = getString(() -> {
            return "张三丰";
        });
        System.out.println(s);

        Integer i = getIntegerAction(() -> {
            return 1996;
        });
        System.out.println(i);

        int[] array = {1, 4, 7, 2, 5, 8, 3, 6, 9};
        Integer max = getMax(() -> {
            Arrays.sort(array);
            return array[array.length - 1];
        });
        System.out.println(max);
    }

    private static String getString(Supplier<String> supplier) {
        return supplier.get();
    }

    private static Integer getIntegerAction(Supplier<Integer> supplier) {
        return supplier.get();
    }

    private static Integer getMax(Supplier<Integer> supplier) {
        return supplier.get();
    }
}