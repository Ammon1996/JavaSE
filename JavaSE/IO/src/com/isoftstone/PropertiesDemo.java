package com.isoftstone;

import java.io.*;
import java.util.Properties;
import java.util.Set;

/*
 * Properties:属性集合类。是一个可以和IO流相结合使用的集合类。
 * Properties 可保存在流中或从流中加载。属性列表中每个键及其对应值都是一个字符串。
 *
 * 是Hashtable的子类，说明是一个Map集合。
 */
public class PropertiesDemo {
    public static void main(String[] args) throws IOException {
        // 作为Map集合的使用，该类不是一个泛型类,在使用的时候就不能加泛型
        Properties pop = new Properties();
        pop.put("简自豪", 21);
        pop.put("狂小狗", 23);
        pop.put("UZI", 22);

        //添加元素
        pop.setProperty("枣子哥", "25");
        pop.setProperty("澡酱", "25");

        //获取属性值
        String s1 = pop.getProperty("枣子哥");
        System.out.println(s1);

        Set<String> strings = pop.stringPropertyNames();
        System.out.println(strings);    // 获取所有通过setProperty设置的键

        // 遍历集合
        Set<Object> set = pop.keySet();
        for (Object key : set) {
            Object value = pop.get(key);
            System.out.println(key + ":" + value);
        }

        /*
         * Properties和IO流结合
         * 这里的集合必须是Properties集合：
         * public void load(Reader reader):
         * 		把文件中的数据读取到集合中
         * public void store(Writer writer,String comments):
         * 		把集合中的数据存储到文件,第二个参数是一个提示语句，可写可不写
         */

        Properties prop = new Properties();
        String fileName = "IO\\files\\prop.txt";
        // myStore(prop, fileName);
        myLoad(prop, fileName);
    }

    private static void myLoad(Properties prop, String fileName) throws IOException {

        FileReader reader = new FileReader(fileName);
        // 把文件加载到集合中
        prop.load(reader);
        System.out.println(prop);
    }

    private static void myStore(Properties prop, String fileName) throws IOException {
        // 添加元素
        prop.setProperty("RNG", "25");
        prop.setProperty("EDG", "20");
        prop.setProperty("IG", "23");

        // 把集合的数据存储到文件
        FileWriter writer = new FileWriter(fileName);
        prop.store(writer, "This is a comment");
        writer.flush();
        writer.close();
    }
}
