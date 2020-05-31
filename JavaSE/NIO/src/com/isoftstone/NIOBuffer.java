package com.isoftstone; /**
 * 描述:
 *
 * @author Ming
 * @create 2020-05-20 14:28
 */

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * 缓冲区(buffer):在java NIO中负责数据的存取，缓冲区就是数组，用于存储不同类型的缓冲区 ,Buffer是一个抽象类
 * 具体实现子类：ByteBuffer,CharBuffer,IntBuffer,ShortBuffer,LongBuffer,DoubleBuffer
 * <p>
 * 核心方法:put()和get()
 * <p>
 * 核心属性： capacity:容量，表示缓冲区中最大数据的存储容量
 * limit:界限，表示缓冲区中可以操作数据的大小（limit后数据不能进行读写）
 * position：位置，表示缓冲区中正在操作数据的位置 mark():标记 reset():恢复到mark的位置
 *
 * @author Ming
 * @time 2019年12月2日下午3:49:10 *
 */
public class NIOBuffer {
    String s = "hello world";

    @Test
    public void test1() {

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);// 分配一个指定大小的缓存区
        System.out.println(byteBuffer.capacity()); // 1024
        System.out.println(byteBuffer.limit()); // 1024
        System.out.println(byteBuffer.position()); // 0

        byteBuffer.put(s.getBytes()); // 存入数据
        System.out.println(byteBuffer.capacity()); // 1024
        System.out.println(byteBuffer.limit()); // 1024
        System.out.println(byteBuffer.position()); // 11

        byteBuffer.flip(); // 翻转缓冲区,限制设为当前位置，位置置为0,可以开始获取数据了
        System.out.println(byteBuffer.capacity()); // 1024
        System.out.println(byteBuffer.limit()); // 11
        System.out.println(byteBuffer.position()); // 0

        // 读取缓存区的数据
        byte[] bys = new byte[byteBuffer.limit()];
        byteBuffer.get(bys);
        System.out.println(new String(bys, 0, bys.length));
        System.out.println(byteBuffer.capacity()); // 1024
        System.out.println(byteBuffer.limit()); // 11
        System.out.println(byteBuffer.position()); // 11

        byteBuffer.rewind();// 倒带缓冲区，位置置为0，可以重新获取数据了
        System.out.println(byteBuffer.capacity()); // 1024
        System.out.println(byteBuffer.limit()); // 11
        System.out.println(byteBuffer.position()); // 0

        byteBuffer.clear(); // 清空缓存区
        System.out.println(byteBuffer.capacity()); // 1024
        System.out.println(byteBuffer.limit()); // 1024
        System.out.println(byteBuffer.position()); // 0
    }

    @Test
    public void test2() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put(s.getBytes());
        byteBuffer.flip();
        byte[] bys = new byte[byteBuffer.limit()];
        byteBuffer.get(bys, 0, 2);
        System.out.println(new String(bys, 0, bys.length)); // he
        System.out.println(byteBuffer.position()); // 2

        byteBuffer.mark(); // 标记当前位置
        byteBuffer.get(bys, 2, 3);
        System.out.println(new String(bys, 0, bys.length)); // hello
        System.out.println(byteBuffer.position()); // 5
        byteBuffer.reset(); // 恢复到mark位置
        System.out.println(byteBuffer.position()); // 2
    }

    @Test
    public void test3() {
        // 非直接缓冲区:通过allocate（）方法分配缓冲区，将缓冲区建立在JVM的内存中
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        System.out.println(byteBuffer);
        // 直接缓冲区:通过allocateDirect（）方法分配直接缓冲区，将缓冲区建立在物理内存中，可以提高效率
        ByteBuffer byteBuffer2 = ByteBuffer.allocateDirect(1024);
        System.out.println(byteBuffer2);
    }
}