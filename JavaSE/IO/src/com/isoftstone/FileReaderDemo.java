package com.isoftstone;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 描述:
 * FileReader流的用法
 *
 * @author Ming
 * @create 2020-05-20 12:48
 */
public class FileReaderDemo {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(new File("IO\\files\\char.txt"));
        // 读数据
//        //以字符的形式读取
//        int ch = 0;
//        while ((ch = fileReader.read()) != -1) {
//            System.out.print((char) ch);
//        }

        // 以字符数组的形式读取
        char[] chars = new char[1024];
        int len = 0;
        while ((len = fileReader.read(chars)) != -1) {
            System.out.println(new String(chars, 0, len));
        }
        fileReader.close();
    }
}