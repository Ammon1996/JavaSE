package com.isoftstone;

import java.util.Arrays;

/**
 * 描述:
 * 快速排序实现
 *
 * @author Ming
 * @create 2020-05-18 16:59
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = {6, 8, 5, 9, 4, 3, 7};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] arr, int low, int high) {
        int i, j, temp, t;
        if (low > high) {
            return;
        }
        i = low;
        j = high;

        temp = arr[low];

        while (i < j) {
            while (temp <= arr[j] && i < j) {
                j--;
            }
            while (temp >= arr[i] && i < j) {
                i++;
            }
            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }
        arr[low] = arr[i];
        arr[i] = temp;
        quickSort(arr, low, j - 1);
        quickSort(arr, j + 1, high);
    }
}