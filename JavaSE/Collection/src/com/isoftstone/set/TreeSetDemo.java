package com.isoftstone.set;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * 描述:
 * TreeSet类方法
 * TreeSet存储有序
 *
 * @author Ming
 * @create 2020-05-19 14:44
 */
public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet();
        treeSet.add(15);
        treeSet.add(8);
        treeSet.add(12);
        treeSet.add(15);
        System.out.println(treeSet);

        // TreeSet存储对象，需要实现Comparable接口,实现compare方法
        TreeSet personTreeSet = new TreeSet();
        Person p1 = new Person("张三", 18);
        Person p2 = new Person("张三", 19);
        Person p3 = new Person("李四", 17);
        personTreeSet.add(p1);
        personTreeSet.add(p2);
        personTreeSet.add(p3);
        System.out.println(personTreeSet);

        // 通过匿名内部类来实现
        TreeSet personTreeSet2 = new TreeSet(new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                int num = p2.getAge() - p1.getAge();
                int num2 = num == 0 ? p2.getName().compareTo(p1.getName()) : num;
                return num2;
            }
        });
        Person p4 = new Person("张三", 18);
        Person p5 = new Person("张三丰", 18);
        Person p6 = new Person("李四", 17);
        personTreeSet2.add(p4);
        personTreeSet2.add(p5);
        personTreeSet2.add(p6);
        System.out.println(personTreeSet2);
    }
}

