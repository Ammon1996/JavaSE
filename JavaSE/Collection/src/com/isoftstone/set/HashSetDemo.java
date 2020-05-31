package com.isoftstone.set;

import java.util.HashSet;
import java.util.Objects;

/**
 * 描述:
 * HashSet类常用方法
 * set集合与list集合不同的是，set集合中不允许元素重复
 * hashSet存储时无序
 *
 * @author Ming
 * @create 2020-05-19 14:21
 */
public class HashSetDemo {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add("hello");
        hashSet.add("world");
        hashSet.add("hello");
        hashSet.add("java");
        System.out.println(hashSet);

        // hashSet存储对象，要在对象中重写hashCode方法
        HashSet personHashSet = new HashSet();
        Person person = new Person("张三", 22);
        Person person2 = new Person("李四", 22);
        Person person3 = new Person("李四", 28);
        personHashSet.add(person);
        personHashSet.add(person2);
        personHashSet.add(person3);
        System.out.println(personHashSet);
    }
}

class Person implements Comparable<Person> {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(Person p) {
        int num = this.getAge() - p.getAge();
        int num2 = num == 0 ? this.getName().length() - p.getName().length() : num;
        int num3 = num2 == 0 ? this.getName().compareTo(p.getName()) : num2;
        return num3;
    }
}