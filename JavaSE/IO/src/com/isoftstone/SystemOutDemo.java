package com.isoftstone;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class SystemOutDemo {
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(
                System.out));
        bufferedWriter.write("hello");
        bufferedWriter.newLine();
        bufferedWriter.write("world");
        bufferedWriter.newLine();
        bufferedWriter.write("java");
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
