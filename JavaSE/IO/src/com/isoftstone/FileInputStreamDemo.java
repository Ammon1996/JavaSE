package com.isoftstone;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 描述:
 * FileInputStream流的用法
 * FileInputStream流 字节输入流 读取数据
 *
 * @author Ming
 * @create 2020-05-20 11:42
 */
public class FileInputStreamDemo {
    public static void main(String[] args) throws IOException {
        //创建字节输入流对象
        FileInputStream fileInputStream = new FileInputStream("IO\\files\\byte.txt");
        // 读数据
        //1、 以字节的形式读取
//        int by = 0;
//        while ((by = fileInputStream.read()) != -1) {
//            System.out.print((char) by);
//        }

        //2、以字节数组的形式读取
        byte[] bys = new byte[1024];
        int len = 0;
        while ((len = fileInputStream.read(bys)) != -1) {
            System.out.println(new String(bys,0,len));
        }

        // 关闭输入流
        fileInputStream.close();
    }
}