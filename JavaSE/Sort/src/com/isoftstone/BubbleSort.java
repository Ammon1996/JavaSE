package com.isoftstone;

import java.util.Arrays;

/**
 * 描述:
 * 冒泡排序实现，每比较一轮，最大的数到最后
 *
 * @author Ming
 * @create 2020-05-18 16:28
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {85, 64, 88, 32, 57, 91, 25};
        // 比较的轮数
        for (int i = 0; i < array.length - 1; i++) {
            // 每一轮比较的次数
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp;
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}