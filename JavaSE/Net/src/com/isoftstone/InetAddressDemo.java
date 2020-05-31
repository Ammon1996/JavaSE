package com.isoftstone;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 描述:
 * InetAddress的用法
 *
 * @author Ming
 * @create 2020-05-22 10:39
 */
public class InetAddressDemo {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getByName("www.baidu.com");
        // 获取主机名
        String hostName = inetAddress.getHostName();
        String hostAddress = inetAddress.getHostAddress();
        System.out.println("主机名：" + hostName);
        System.out.println("主机地址：" + hostAddress);
    }
}