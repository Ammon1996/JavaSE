package com.isoftstone.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 描述:
 * 接收端 A:创建socket对象   B:创建数据包   C:接收数据    D:解析数据  E:释放资源
 *
 * @author Ming
 * @create 2020-05-22 11:10
 */
public class Receive {
    public static void main(String[] args) throws IOException {
        // 创建Socket对象
        DatagramSocket socket = new DatagramSocket(7979);
        while (true) {
            //创建数据包
            byte[] bys = new byte[1024];
            DatagramPacket packet = new DatagramPacket(bys, bys.length);
            // 接收数据
            socket.receive(packet);
            // 解析数据
            InetAddress address = packet.getAddress();
            String data = new String(packet.getData(), 0, packet.getLength());
            System.out.println(address + ":" + data);
        }

    }
}