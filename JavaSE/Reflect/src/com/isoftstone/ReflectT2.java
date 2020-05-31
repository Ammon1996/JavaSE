package com.isoftstone;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * 描述:
 * 反射应用2    越过泛型检查
 *
 * @author Ming
 * @create 2020-05-22 12:40
 */
public class ReflectT2 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        // arrayList.add("hello");  编译报错 泛型问题

        // 使用反射机制来越过泛型检查
        Class<? extends ArrayList> clazz = arrayList.getClass();
        // 通过class对象获取add方法
        Method add = clazz.getMethod("add", Object.class);
        add.invoke(arrayList, "hello");
        System.out.println(arrayList);
    }
}