package com.isoftstone;

/**
 * 描述:
 *
 * @author Ming
 * @create 2020-05-20 15:01
 */

/*
 * public final void setDaemon(boolean on):将该线程标记为守护线程或用户线程。
 * 守护线程是指为其他线程服务的线程。在JVM中，所有非守护线程都执行完毕后
 * 论有没有守护线程，虚拟机都会自动退出
 *
 */
public class ThreadDaemonDemo {
    public static void main(String[] args) {
        ThreadDaemon t1 = new ThreadDaemon();
        ThreadDaemon t2 = new ThreadDaemon();
        t1.setDaemon(true);
        t2.setDaemon(true);

        t1.start();
        t2.start();

        Thread.currentThread().setName("main");
        for (int x = 0; x < 5; x++) {
            System.out.println(Thread.currentThread().getName() + ": " + x);
        }
    }
}

class ThreadDaemon extends Thread {
    @Override
    public void run() {
        for (int x = 0; x < 100; x++) {
            System.out.println(getName() + ": " + x);
        }
    }
}
