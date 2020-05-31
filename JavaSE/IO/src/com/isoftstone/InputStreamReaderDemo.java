package com.isoftstone;

import java.io.*;

/**
 * 描述:
 * InputStreamReader 流的用法
 * InputStreamReader 字符输入流 读取数据
 *
 * @author Ming
 * @create 2020-05-20 12:21
 */
public class InputStreamReaderDemo {
    public static void main(String[] args) throws IOException {
        // 构造对象，两种构造方法，如果不使用第二个参数，就使用系统默认编码
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("IO\\files\\char.txt"), "UTF-8");
        // 读数据
//        //以字符的形式读取
//        int ch = 0;
//        while ((ch = inputStreamReader.read()) != -1) {
//            System.out.print((char) ch);
//        }

        // 以字符数组的形式读取
        char[] chars = new char[1024];
        int len = 0;
        while ((len = inputStreamReader.read(chars)) != -1) {
            System.out.println(new String(chars, 0, len));
        }
        inputStreamReader.close();
    }
}