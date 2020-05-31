package com.isoftstone;

import java.io.IOException;
import java.io.RandomAccessFile;

/*
 * 随机访问流：
 * 		RandomAccessFile类不属于流，是Object类的子类。
 * 		但它融合了InputStream和OutputStream的功能。
 * 		支持对文件的随机访问读取和写入。
 *
 * public RandomAccessFile(String name,String mode)：第一个参数是文件路径，第二个参数是操作文件的模式。
 * 		模式有四种，我们最常用的一种叫"rw",这种方式表示我既可以写数据，也可以读取数据
 * 可以通过 getFilePointer方法读取文件指针位置，也可以通过 seek方法设置指针位置。
 */
public class RandomAccessFileDemo {
	public static void main(String[] args) throws IOException {
		write();
		read();
	}

	private static void write() throws IOException {

		RandomAccessFile raf = new RandomAccessFile("IO\\files\\raf.txt", "rw");

		raf.writeByte(10);
		raf.writeChar('c');
		raf.writeUTF("hello");
		raf.close();
	}

	private static void read() throws IOException {
		RandomAccessFile raf = new RandomAccessFile("IO\\files\\raf.txt", "rw");

		byte b = raf.readByte();
		System.out.println(b);
		System.out.println("当前指针位置" + raf.getFilePointer());
		char c = raf.readChar();
		System.out.println(c);
		System.out.println("当前指针位置" + raf.getFilePointer());
		String s = raf.readUTF();
		System.out.println(s);
		System.out.println("当前指针位置" + raf.getFilePointer());

		// 设置指针位置
		raf.seek(3);
		s = raf.readUTF();
		System.out.println(s);
		System.out.println("当前指针位置" + raf.getFilePointer());

		raf.close();
	}

}
