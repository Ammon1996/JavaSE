package com.isoftstone;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 数据输入输出流：
 * 		DataOutputStream
 * 		DataInputStream
 * 构造方法摘要
 * 		DataOutputStream(OutputStream out)
 * 		DataInputStream(InputStream input)
 *
 * 		数据输出流写的数据在文件中是看不懂的，只能用数据输入流来读
 */
public class DataStreamDemo {
    public static void main(String[] args) throws IOException {

        DataOutputStream dos = new DataOutputStream(new FileOutputStream(
                "IO\\files\\data.txt", true));

        DataInputStream dis = new DataInputStream(new FileInputStream(
                "IO\\files\\data.txt"));

        dos.writeByte(10);
        dos.writeShort(1);
        dos.writeChar('c');
        dos.writeFloat(12.34F);
        dos.writeDouble(12.34);
        dos.writeBoolean(true);

        byte b = dis.readByte();
        short s = dis.readShort();
        char c = dis.readChar();
        float f = dis.readFloat();
        double d = dis.readDouble();
        boolean boo = dis.readBoolean();
        System.out.println(b);
        System.out.println(s);
        System.out.println(c);
        System.out.println(f);
        System.out.println(d);
        System.out.println(boo);
    }
}
