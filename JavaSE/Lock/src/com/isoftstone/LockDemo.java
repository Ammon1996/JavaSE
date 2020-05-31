package com.isoftstone;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述:
 *
 * @author Ming
 * @create 2020-05-21 11:04
 */
public class LockDemo {
    public static void main(String[] args) {
        MyLock myLock = new MyLock();
        Thread t1 = new Thread(myLock, "窗口1");
        Thread t2 = new Thread(myLock, "窗口2");
        Thread t3 = new Thread(myLock, "窗口3");

        t1.start();
        t2.start();
        t3.start();
    }

}

class MyLock implements Runnable {
    private static int tickets = 100;   //定义公共资源
    // 创建锁对象
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            // 加锁
            lock.lock();
            if (tickets > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "正在售卖第"
                        + (100 - (tickets--) + 1) + "张票");
            } else {
                System.out.println("票已售完！！！");
                System.exit(0);
            }
            // 释放锁
            lock.unlock();
        }
    }
}