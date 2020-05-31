package com.isoftstone.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 描述:
 * 客户端
 * A:创建客户端socket对象 B:获取输出流,写数据 C:释放资源
 *
 * @author Ming
 * @create 2020-05-22 11:22
 */
public class Client {
    public static void main(String[] args) throws IOException {
        // 创建客户端socket对象
        Socket socket = new Socket("127.0.0.1", 7979);

        //获取输出流,写数据
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello server".getBytes());

        // 获取输入流，读数据
        InputStream inputStream = socket.getInputStream();
        byte[] bys = new byte[1024];
        int len = inputStream.read(bys);
        System.out.println(new String(bys, 0, len));

        // 释放资源
        outputStream.close();
        inputStream.close();
        socket.close();
    }
}