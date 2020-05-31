package com.isoftstone;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 描述:
 * 阻塞式IO
 *
 * @author Ming
 * @create 2020-05-20 14:16
 */
public class NIOBlock {
    // 1.网络通信客户端
    @Test
    public void client() throws IOException {
        // 获取通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8888));
        FileChannel fChannel = FileChannel.open(Paths.get("files\\girl.png"), StandardOpenOption.READ);
        // 分配指定大小的缓冲区
        ByteBuffer bb = ByteBuffer.allocate(1024);
        // 读取本地文件，并发送到客户端
        while (fChannel.read(bb) != -1) {
            // 将缓冲区转换为写模式
            bb.flip();
            socketChannel.write(bb);
            bb.clear();
        }
        // 当接收不到缓冲区的数据时，强制关闭通道(阻塞式体现在这里)
        socketChannel.shutdownOutput();
        // 接受服务器端的反馈
        int len = 0;
        while ((len = socketChannel.read(bb)) != -1) {
            bb.flip();
            System.out.println(new String(bb.array(), 0, len));
            bb.clear();
        }
        // 关闭通道
        socketChannel.close();
        fChannel.close();
    }

    // 2.服务端
    @Test
    public void server() throws IOException {
        // 获取通道
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        FileChannel fChannel = FileChannel.open(Paths.get("files\\girl2.png"), StandardOpenOption.WRITE,
                StandardOpenOption.CREATE);
        // 绑定连接
        ssChannel.bind(new InetSocketAddress(8888));
        // 获取客户端连接的通道
        SocketChannel accept = ssChannel.accept();
        // 分配指定大小的缓冲区
        ByteBuffer bb = ByteBuffer.allocate(1024);
        // 读取本地文件，并发送到客户端
        while (accept.read(bb) != -1) {
            // 将缓冲区转换为写模式
            bb.flip();
            fChannel.write(bb);
            bb.clear();
        }
        // 发送反馈给客户端
        bb.put("接收数据成功".getBytes());
        bb.flip();
        accept.write(bb);

        // 关闭通道
        ssChannel.close();
        fChannel.close();
    }
}