package com.isoftstone;

import java.io.*;

/*
 * 序列化流：把对象按照流一样的方式存入文本文件或者在网络中传输。对象 -- 流数据(ObjectOutputStream)
 * 反序列化流:把文本文件中的流对象数据或者网络中的流对象数据还原成对象。流数据 -- 对象(ObjectInputStream)
 */
public class ObjectStreamDemo {
    public static void main(String[] args) throws IOException,
            ClassNotFoundException {
        write();
        read();
    }

    private static void read() throws IOException, ClassNotFoundException {
        // 创建反序列化流对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                "IO\\files\\oos.txt"));
        Object obj = ois.readObject();
        ois.close();
        System.out.println(obj);
    }

    private static void write() throws IOException {
        // 创建序列化流对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
                "IO\\files\\oos.txt"));
        Person p = new Person("简自豪", 23);
        // 对象信息转成流数据
        oos.writeObject(p);
        oos.close();
    }
}

class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    // 加transient修饰的成员变量不会被序列化
    private String name;
    private transient int age;

    public Person() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Person(String name, int age) {
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

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
}
