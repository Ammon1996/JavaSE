package com.isoftstone;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 描述:
 * 反射应用一   通过配置文件控制类中执行的方法
 *
 * @author Ming
 * @create 2020-05-22 12:23
 */
public class ReflectT1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 创建属性集合类对象
        Properties prop = new Properties();
        // 封装配置文件
        FileReader fileReader = new FileReader("Reflect\\class.properties");
        // 把配置文件加载到集合中
        prop.load(fileReader);
        // 获取数据
        String className = prop.getProperty("className");
        String methodName = prop.getProperty("methodName");

        // 获取Class文件对象
        Class clazz = Class.forName(className);
        // 获取构造方法创建实例对象
        Constructor con = clazz.getConstructor();
        con.setAccessible(true);
        Object obj = con.newInstance();
        // 获取成员方法并调用
        Method method = clazz.getMethod(methodName);
        method.invoke(obj);
    }
}

class Student {
    public Student() {
    }

    public void love() {
        System.out.println("爱生活,爱学习");
    }
}

class Teacher {
    public Teacher() {
    }

    public void love() {
        System.out.println("爱生活,爱睡觉");
    }
}

class Worker {
    public Worker() {
    }

    public void love() {
        System.out.println("爱生活,爱工作");
    }
}