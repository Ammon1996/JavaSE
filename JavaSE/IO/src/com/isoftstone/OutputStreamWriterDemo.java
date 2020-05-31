package com.isoftstone;

import java.io.*;

/**
 * 描述:
 * OutputStreamWriter 流的用法
 * OutputStreamWriter 字符输出流 写数据
 *
 * @author Ming
 * @create 2020-05-20 12:21
 */
public class OutputStreamWriterDemo {
    public static void main(String[] args) throws IOException {
        // 构造对象，两种构造方法，如果不使用第二个参数，就使用系统默认编码
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("IO\\files\\char.txt", true), "UTF-8");

        outputStreamWriter.write("英雄联盟分部");
        outputStreamWriter.write('c');
        outputStreamWriter.write("顺风简自豪", 2, 3);

        outputStreamWriter.flush();
        outputStreamWriter.close();
    }
}