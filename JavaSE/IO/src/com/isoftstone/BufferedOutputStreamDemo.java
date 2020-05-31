package com.isoftstone;

import java.io.*;

/**
 * 描述:
 * BufferOutputStream流的用法
 * BufferOutputStream 高效字节输出流
 * @author Ming
 * @create 2020-05-20 12:09
 */
public class BufferedOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        //构造方法
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File("IO\\files\\byte.txt"), true));

        // 写数据
        try {
            bufferedOutputStream.write("hello world".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            // 关闭输入流
            bufferedOutputStream.close();
        }

    }
}