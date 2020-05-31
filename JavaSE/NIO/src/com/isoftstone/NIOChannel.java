package com.isoftstone;

/**
 * 描述:
 *
 * @author Ming
 * @create 2020-05-20 14:28
 */

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 通道(Channel)：用于源节点与目标节点的连接，在java NIO 中负责缓冲区中的数据传输，
 * Channel本身不存储数据，因此需要缓冲区配合进行传输，通道就相当于铁轨，缓冲区就相当于火车
 * JDK 1.7中的NIO 针对各个通道提供了静态方法open()
 * 通道之间的数据传输 transferTo() transferFrom()
 * 分散与聚集:分散读取：将通道中的数据分散到多个缓冲区中去,聚集写入:将多个缓冲区的数据聚集到通道中去
 *
 * @author Ming
 * @time 2019年12月2日下午4:32:25
 */
public class NIOChannel {
    @Test
    // 1.利用通道跟缓冲区完成文件复制
    public void test() throws IOException {
        long startTime = System.currentTimeMillis();
        FileInputStream fis = null;
        FileOutputStream fos = null;
        FileChannel inChannel = null;
        FileChannel outChannel = null;

        try {
            fis = new FileInputStream(new File("files\\a.txt"));
            fos = new FileOutputStream(new File("files\\b.txt"));
            inChannel = fis.getChannel(); // 与文件输入流相关的通道，读
            outChannel = fos.getChannel(); // 与文件输入流相关的通道，写
            // 分配缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            //通过inChannel把源文件数据读到缓冲区，通过outChannel把缓冲区数据写到目标文件
            while (inChannel.read(buffer) != -1) {
                buffer.flip();
                outChannel.write(buffer);
                buffer.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fis.close();
            fos.close();
            inChannel.close();
            outChannel.close();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("完成文件复制耗时：" + (endTime - startTime));
    }

    @Test
    // 2.利用直接缓冲区完成文件的复制
    public void test2() throws IOException {
        long start = System.currentTimeMillis();
        // 获取通道
        // 读模式
        FileChannel inChannel = FileChannel.open(Paths.get("c.txt"), StandardOpenOption.READ);
        // 读写模式
        FileChannel outChannel = FileChannel.open(Paths.get("d.txt"), StandardOpenOption.WRITE, StandardOpenOption.READ,
                StandardOpenOption.CREATE);

        // 内存映射文件
        MappedByteBuffer inBuf = inChannel.map(MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outBuf = outChannel.map(MapMode.READ_WRITE, 0, inChannel.size());

        // 对缓冲区的数据进行读写操作
        byte[] by = new byte[inBuf.limit()];
        inBuf.get(by);
        outBuf.put(by);
        inChannel.close();
        outChannel.close();
        long end = System.currentTimeMillis();
        System.out.println("利用直接缓存区耗费时间：" + (end - start));
    }

    @Test
    // 3.通道间数据传输
    public void test3() throws IOException {
        FileChannel inChannel = FileChannel.open(Paths.get("e.txt"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("f.txt"), StandardOpenOption.WRITE, StandardOpenOption.READ,
                StandardOpenOption.CREATE);
        inChannel.transferTo(0, inChannel.size(), outChannel);
    }

    @Test
    // 4.分散和聚集
    public void test4() throws IOException {
        // 1.分散读取
        RandomAccessFile raf1 = new RandomAccessFile("g.txt", "rw");
        // 获取通道
        FileChannel channel1 = raf1.getChannel();
        // 分配两个指定大小的缓冲区
        ByteBuffer buf1 = ByteBuffer.allocate(100);
        ByteBuffer buf2 = ByteBuffer.allocate(1024);
        // 构建缓冲区数组
        ByteBuffer[] bufArr = {buf1, buf2};
        // 通道读取
        channel1.read(bufArr);
        // 切换缓冲区为写模式
        for (ByteBuffer byteBuffer : bufArr) {
            byteBuffer.flip();
        }
        System.out.println(new String(bufArr[0].array(), 0, bufArr[0].limit()));
        System.out.println("--------------------------");
        System.out.println(new String(bufArr[1].array(), 0, bufArr[1].limit()));

        // 聚集写入
        RandomAccessFile raf2 = new RandomAccessFile("h.txt", "rw");
        FileChannel channel2 = raf2.getChannel();
        channel2.write(bufArr);
    }

}
