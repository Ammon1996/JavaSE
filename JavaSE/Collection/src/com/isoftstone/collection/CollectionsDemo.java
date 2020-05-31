package com.isoftstone.collection;

import java.util.*;

/**
 * 描述:
 * Collections工具类的使用
 *
 * @author Ming
 * @create 2020-05-19 15:08
 */
public class CollectionsDemo {
    public static void main(String[] args) {
        String[] strings = {"hello", "world", "I", "am", "coming"};
        List<String> stringList = Arrays.asList(strings);

        ArrayList arrayList = new ArrayList();
        arrayList.addAll(stringList);

        //排序
        System.out.println("排序前：" + arrayList);
        Collections.sort(arrayList);
        System.out.println("排序后：" + arrayList);

        //二分查找
        int index = Collections.binarySearch(arrayList, "am");
        System.out.println(index);

        // 集合翻转
        Collections.reverse(arrayList);
        System.out.println(arrayList);

        // 随机置换
        Collections.shuffle(arrayList);
        System.out.println(arrayList);
    }
}