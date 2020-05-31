package com.isoftstone;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 描述:
 * BufferInputStream流的用法
 * BufferInputStream流 高效字节输入流
 * @author Ming
 * @create 2020-05-20 12:09
 */
public class BufferedInputStreamDemo {
    public static void main(String[] args) throws IOException {
        //构造方法
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("IO\\files\\byte.txt"));
        // 读数据
        //1、 以字节的形式读取
//        int by = 0;
//        while ((by = bufferedInputStream.read()) != -1) {
//            System.out.print((char) by);
//        }

        //2、以字节数组的形式读取
        byte[] bys = new byte[1024];
        int len = 0;
        while ((len = bufferedInputStream.read(bys)) != -1) {
            System.out.println(new String(bys,0,len));
        }

        // 关闭输入流
        bufferedInputStream.close();
    }
}