package com.isoftstone.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 描述:
 * 发送端 A:创建socket对象   B:数据打包     C:发送数据    D:释放资源
 *
 * @author Ming
 * @create 2020-05-22 11:10
 */
public class Send {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String data = null;

        // 创建socket对象
        DatagramSocket socket = new DatagramSocket();
        while ((data = bufferedReader.readLine()) != null) {
            // 数据打包
            byte[] bys = data.getBytes();
            DatagramPacket packet = new DatagramPacket(bys, bys.length,
                    InetAddress.getByName("127.0.0.1"), 7979);
            // 发送数据
            socket.send(packet);
        }
        // 释放资源
        socket.close();
    }
}