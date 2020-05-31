package com.isoftstone;

/**
 * 描述:
 * ThreadGroup 线程组
 *
 * @author Ming
 * @create 2020-05-21 11:20
 */
public class ThreadGroupDemo {
    public static void main(String[] args) {

        Thread t1 = new Thread(new MyRunnable());
        Thread t2 = new Thread(new MyRunnable());
        System.out.println(t1.getThreadGroup().getName());
        System.out.println(t2.getThreadGroup().getName());

        // 创建线程组对象
        ThreadGroup group = new ThreadGroup("Group1");

        // 创建线程对象指定线程组
        Thread t3 = new Thread(group, new MyRunnable(), "线程1");
        Thread t4 = new Thread(group, new MyRunnable(), "线程2");

        System.out.println(t3.getThreadGroup().getName());
        System.out.println(t4.getThreadGroup().getName());
    }
}