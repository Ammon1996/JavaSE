package com.isoftstone;

import java.util.Arrays;

/**
 * 描述:
 * 选择排序实现
 *
 * @author Ming
 * @create 2020-05-18 16:36
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] array = {85, 64, 88, 32, 57, 91, 25};
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp;
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}