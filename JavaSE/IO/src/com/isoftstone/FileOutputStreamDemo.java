package com.isoftstone;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 描述:
 * FileOutPutStream流的用法
 * FileOutPutStream流 字节输出流 写数据
 *
 * @author Ming
 * @create 2020-05-20 11:58
 */
public class FileOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        // 构造方法，第二个参数表示接着末尾写
        // FileOutputStream fileOutputStream = new FileOutputStream(new File("IO\\files\\byte.txt"));
        FileOutputStream fileOutputStream = new FileOutputStream(new File("IO\\files\\byte.txt"), true);
        try {
            fileOutputStream.write("Hello World".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            fileOutputStream.close();
        }
    }
}