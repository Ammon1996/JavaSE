package com.isoftstone;

import java.util.Arrays;

/**
 * 描述:
 * Arrays类的常用方法
 *
 * @author Ming
 * @create 2020-05-18 15:10
 */
public class ArraysDemo {
    public static void main(String[] args) {
        int[] array1 = {15, 8, 16, 22, 20};
        int[] array2 = {66, 77, 88, 99, 100};
        // 数组转字符串
        String s = Arrays.toString(array1);
        System.out.println(s);

        // 数组排序
        Arrays.sort(array1);
        System.out.println(Arrays.toString(array1));

        //二分查找
        int i = Arrays.binarySearch(array2, 99);
        System.out.println(i);
    }
}