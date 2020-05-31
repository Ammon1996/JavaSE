package com.isoftstone.map;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeMap;

/**
 * 描述:
 * TreeMap累的方法
 *
 * @author Ming
 * @create 2020-05-19 15:44
 */
public class TreeMapDemo {
    public static void main(String[] args) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("Jay", 22);
        treeMap.put("Ammon", 26);
        treeMap.put("Bruce", 22);
        treeMap.put("Yummy", 18);
        System.out.println(treeMap);

        TreeMap<Student, String> treeMap2 = new TreeMap<Student, String>(
                new Comparator<Student>() {
                    @Override
                    public int compare(Student s1, Student s2) {
                        int num1 = s1.getAge() - s2.getAge();
                        int num2 = num1 == 0 ? s1.getName().compareTo(
                                s2.getName()) : num1;
                        return num2;
                    }

                });
        Student s1 = new Student("Kaisa", 18);
        Student s2 = new Student("Zoe", 16);
        Student s3 = new Student("Ezreal", 20);
        Student s4 = new Student("Yasuo", 20);

        treeMap2.put(s1, "峡谷之巅");
        treeMap2.put(s2, "艾欧尼亚");
        treeMap2.put(s3, "黑暗玫瑰");
        treeMap2.put(s4, "水晶之痕");

        Set<Student> set = treeMap2.keySet();
        for (Student key : set) {
            String value = treeMap2.get(key);
            System.out.println(key.getName() + "-" + key.getAge() + "-"
                    + value);
        }
    }
}

class Student {
    private String name;
    private int age;

    public Student() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Student(String name, int age) {
        super();
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

}