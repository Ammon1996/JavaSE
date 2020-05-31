package com.isoftstone;

/**
 * 描述:
 * 死锁实例
 *
 * @author Ming
 * @create 2020-05-21 11:10
 */
public class DieLockDemo {
    public static void main(String[] args) {
        DieLock dl = new DieLock(true);
        DieLock dl2 = new DieLock(false);

        Thread t1 = new Thread(dl);
        Thread t2 = new Thread(dl2);

        t1.start();
        t2.start();
    }
}

class MyDieLock {
    // 两个锁对象
    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();
}

class DieLock implements Runnable {

    private boolean flag;

    DieLock(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag) {
            synchronized (MyDieLock.lock1) {
                System.out.println("lock1 is using AAA");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (MyDieLock.lock2) {
                    System.out.println("lock2 is using AAA");
                }
            }
        } else {
            synchronized (MyDieLock.lock2) {
                System.out.println("lock2 is using");
                synchronized (MyDieLock.lock1) {
                    System.out.println("lock1 is using");
                }
            }
        }

    }
}
