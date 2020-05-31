package com.isoftstone;

import java.util.Arrays;

/**
 * 描述:
 * System类常用方法，System类不能被实例化
 *
 * @author Ming
 * @create 2020-05-19 11:51
 */
public class SystemDemo {
    public static void main(String[] args) {

        Person person = new Person("方友明", 24);
        System.out.println(person.toString());
        person = null;
        //运行垃圾回收器
        System.gc();
        //System.out.println(person.toString());  对象被回收 空指针异常

        // 获取当前系统时间
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println(currentTimeMillis);

        // 复制数组内容
        int[] array = {11, 22, 33, 44};
        int[] array1 = {55, 66, 77, 88};

        System.arraycopy(array, 2, array1, 0, 2);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array1));

        //终止虚拟机
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                System.exit(0);     //0正常终止，非0异常终止
            } else {
                System.out.println(i);
            }
        }

    }
}

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
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
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}