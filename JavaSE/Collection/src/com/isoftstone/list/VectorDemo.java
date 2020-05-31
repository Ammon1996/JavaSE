package com.isoftstone.list;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 描述:
 * Vector类常用方法
 * Vector:底层数据结构使用数组结构array,线程安全
 *
 * @author Ming
 * @create 2020-05-19 13:47
 */
public class VectorDemo {
    public static void main(String[] args) {
        //Vector特有方法
        Vector vector = new Vector();

        //添加元素
        vector.addElement("hello");
        vector.addElement("world");

        //获取元素
        for (int x = 0; x < vector.size(); x++) {
            System.out.println(vector.elementAt(x));
        }
        System.out.println("--------");

        //创建迭代器对象
        Enumeration e = vector.elements();
        while (e.hasMoreElements()) {
            String s = (String) e.nextElement();
            System.out.println(s);
        }
    }
}