package com.isoftstone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SystemInDemo {
	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入一个字符串:");
		String s = bufferedReader.readLine();
		System.out.println(s);
	}
}
