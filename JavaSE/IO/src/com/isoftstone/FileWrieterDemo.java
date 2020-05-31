package com.isoftstone;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 描述:
 * FileWriter 流的用法
 *
 * @author Ming
 * @create 2020-05-20 12:50
 */
public class FileWrieterDemo {
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter(new File("IO\\files\\char.txt"), true);
        fileWriter.write("永不言弃");
        fileWriter.flush();
        fileWriter.close();
    }
}