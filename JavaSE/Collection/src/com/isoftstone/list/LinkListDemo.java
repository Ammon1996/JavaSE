package com.isoftstone.list;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 描述:
 * LinkList类常用方法
 * <p>
 * LinkedList:底层数据结构采用链表数据结构，插入和删除速度快，访问速度慢，线程不安全
 *
 * @author Ming
 * @create 2020-05-19 13:37
 */
public class LinkListDemo {
    public static void main(String[] args) {
        String[] strings = {"hello", "world", "I", "am", "coming"};
        List<String> stringList = Arrays.asList(strings);

        //LinkList特有方法
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(stringList);

        // 头插，尾插
        linkedList.addFirst("Woo");
        linkedList.addLast("!");
        System.out.println(linkedList);

        // 头取，尾取
        Object first = linkedList.getFirst();
        Object last = linkedList.getLast();
        System.out.println(first + "," + last);

        // 头删，尾删
        Object o = linkedList.removeFirst();
        Object o1 = linkedList.removeLast();
        System.out.println(o + "," + o1);
        System.out.println(linkedList);
    }
}