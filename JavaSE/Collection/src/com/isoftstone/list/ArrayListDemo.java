package com.isoftstone.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * 描述:
 * ArrayList的常用方法
 * <p>
 * ArrayList是List的一个实现类，List接口是Collection的一个子接口，基础方法都继承了
 * ArrayList:底层数据结构使用数组结构array，查询速度快，增删改慢,线程不安全
 *
 * @author Ming
 * @create 2020-05-19 13:04
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        String[] strings = {"hello", "world", "I", "am", "coming"};
        List<String> stringList = Arrays.asList(strings);

        // ArrayList的特有方法
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(stringList);

        //指定位置添加元素
        arrayList.add(1, "IDEA");
        System.out.println(arrayList);

        // 获取指定位置的元素
        Object o = arrayList.get(3);
        System.out.println(o);

        // 修改指定位置的元素,返回修改的元素
        Object o2 = arrayList.set(3, "i");
        System.out.println(o2);

        // 删除指定位置的元素
        arrayList.remove("1");
        System.out.println(arrayList);

        //list集合迭代器,继承了Iterator
        ListIterator listIterator = arrayList.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }

        // 逆向遍历，之前必须先进行正向遍历，将迭代器的指针转移到尾部，一般无意义，了解一下
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }

        // list集合不使用迭代器遍历
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }

        // 迭代器在进行遍历时候，集合是不允许对元素进行操作的，会抛出ConcurrentModificationException
        /*    while (listIterator.hasNext()) {
                if ("am".equals(listIterator.next())) {
                    arrayList.add("IntelliJ");
                }
            }*/

        // 集合删除元素不安全问题 当出现相同元素连续，删除是只能删除一个的
        ArrayList words = new ArrayList();
        words.add("a");
        words.add("b");
        words.add("b");
        words.add("b");
        words.add("c");
        words.add("d");
        words.remove("b");
        System.out.println(words);

        // jdk8新方法解决删除不安全问题
        words.removeIf(word -> word.equals("b"));
        System.out.println(words);
    }
}