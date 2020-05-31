package com.isoftstone;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 描述:
 * BufferedReader流的用法
 *
 * @author Ming
 * @create 2020-05-20 13:16
 */
public class BufferedReaderDemo {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("IO\\files\\char.txt"));
        // 读数据
//        //以字符的形式读取
//        int ch = 0;
//        while ((ch = fileReader.read()) != -1) {
//            System.out.print((char) ch);
//        }

        // 以字符数组的形式读取
        char[] chars = new char[1024];
        int len = 0;
        while ((len = bufferedReader.read(chars)) != -1) {
            System.out.println(new String(chars, 0, len));
        }
        bufferedReader.close();
    }
}