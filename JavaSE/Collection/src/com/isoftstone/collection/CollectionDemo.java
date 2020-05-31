package com.isoftstone.collection;

import java.util.*;

/**
 * 描述:
 * Collection类的相关方法
 *
 * @author Ming
 * @create 2020-05-19 12:42
 */
public class CollectionDemo {
    public static void main(String[] args) {
        Collection collection = new ArrayList();
        //添加单个元素
        collection.add("Hello");
        collection.add("World");
        collection.add("java");
        System.out.println(collection);
        //删除单个元素
        collection.remove("World");
        System.out.println(collection);
        //判断是否存在单个元素
        System.out.println(collection.contains("java"));
        System.out.println(collection.isEmpty());
        //长度
        System.out.println(collection.size());

        // 清除集合
        collection.clear();
        System.out.println(collection);

        // 添加另一个集合所有元素
        Character[] chars = {'a', 'b', 'c', 'd'};
        List<Character> list = Arrays.asList(chars);
        collection.addAll(list);       //添加一个集合的元素
        System.out.println(collection);

        boolean b = collection.containsAll(list);//判断是否包含一个集合的元素
        System.out.println(b);

        collection.add('e');
        boolean b1 = collection.retainAll(list);//删除list中没有的元素，也就是保留交集，如果collection发生率改变，返回true
        System.out.println(collection + "" + b1);

        collection.removeAll(list); // 删除一个集合的元素
        System.out.println(collection);

        //迭代器遍历集合
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}