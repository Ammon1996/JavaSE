package com.isoftstone;

import java.lang.reflect.Field;

/**
 * 描述:
 * 反射应用三 做一个通用工具类
 *
 * @author Ming
 * @create 2020-05-22 12:50
 */
public class ReflectT3 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Man man = new Man();
        Dog dog = new Dog();
        Tool.setProperty(man, "sex", '男');
        Tool.setProperty(man, "age", 25);
        System.out.println(man.toString());
        Tool.setProperty(dog, "sex", '公');
        Tool.setProperty(dog, "price", 1688.0);
        System.out.println(dog.toString());
    }

}

class Tool {
    public static void setProperty(Object obj, String propertyName, Object value) throws NoSuchFieldException, IllegalAccessException {
        // 获取class对象
        Class<?> clazz = obj.getClass();
        // 获取成员变量
        Field field = clazz.getDeclaredField(propertyName);
        //给属性赋值
        field.setAccessible(true);
        field.set(obj, value);
    }
}

class Dog {
    private char sex;
    private double price;

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Dog() {
        super();
    }

    @Override
    public String toString() {
        return "Dog{" +
                "sex=" + sex +
                ", price=" + price +
                '}';
    }
}

class Man {
    private char sex;
    private int age;

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Man() {
        super();
    }

    @Override
    public String toString() {
        return "Man{" +
                "sex=" + sex +
                ", age=" + age +
                '}';
    }
}