package com.isoftstone;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 描述:
 * BUfferedWriter流用法
 *
 * @author Ming
 * @create 2020-05-20 13:23
 */
public class BufferedWriterDemo {
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("IO\\files\\char.txt"), true));
        bufferedWriter.write("世界第一ADC");
        bufferedWriter.newLine();
        bufferedWriter.write("剑指S10总冠军");
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}