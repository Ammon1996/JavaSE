package com.isoftstone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/*
 * 内存操作流：用于处理临时存储信息的，程序结束，数据就从内存中消失。
 * 字节数组：
 * 		ByteArrayInputStream
 * 		ByteArrayOutputStream
 * 字符数组：
 * 		CharArrayReader
 * 		CharArrayWriter
 * 字符串：
 * 		StringReader
 * 		StringWriter
 *
 * 这些流是针对内存操作的，数据都是暂时存储在内存中
 *
 * 以字节数组为例，其他两个是一样的用法
 */
public class ByteArrayStreamDemo {
    public static void main(String[] args) throws IOException {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        for (int i = 1; i <= 10; i++) {
            outputStream.write(("hello" + i).getBytes());
        }
        byte[] bys = outputStream.toByteArray();

        ByteArrayInputStream inputStream = new ByteArrayInputStream(bys);
        int by = 0;
        while ((by = inputStream.read()) != -1) {
            System.out.print((char) by);
        }
    }
}
