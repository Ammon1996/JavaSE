package com.isoftstone;

/**
 * 描述:
 * 二分查找底层实现 ,二分查找前提有序
 *
 * @author Ming
 * @create 2020-05-18 16:43
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {11, 22, 33, 44, 55, 66};
        int index = binarySearch(array, 55);
        System.out.println(index);

    }

    public static int binarySearch(int[] array, int value) {
        int min = 0;
        int max = array.length - 1;
        int mid = (min + max) / 2;
        while (value != array[mid]) {
            if (value > array[mid]) {
                min = mid + 1;
            } else if (value < array[mid]) {
                max = mid - 1;
            }
            mid = (min + max) / 2;
            if (min >= max) {
                return -1;
            }
        }
        return mid;
    }
}