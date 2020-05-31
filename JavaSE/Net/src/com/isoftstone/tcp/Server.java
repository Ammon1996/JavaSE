package com.isoftstone.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 描述:
 * 服务端
 * TCP协议接收数据    A:创建服务器端socket对象    B:监听客户端连接，返回一个Socket对象  C:获取输入流，读数据 D:释放资源
 *
 * @author Ming
 * @create 2020-05-22 11:22
 */
public class Server {
    public static void main(String[] args) throws IOException {
        // 创建服务端socket对象
        ServerSocket socket = new ServerSocket(7979);

        // 监听客户端连接
        Socket s = socket.accept();

        // 获取输入流，读数据
        InputStream inputStream = s.getInputStream();
        byte[] bys = new byte[1024];
        int len = inputStream.read(bys);
        String data = new String(bys, 0, len);

        String ip = s.getInetAddress().getHostAddress();
        System.out.println(ip + ": " + data);

        // 获取输出流，写数据
        OutputStream outputStream = s.getOutputStream();
        outputStream.write("Hello Client".getBytes());

        // 释放资源
        socket.close();
        s.close();
        outputStream.close();
        inputStream.close();
    }
}