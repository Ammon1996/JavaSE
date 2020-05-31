package com.isoftstone;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 描述:
 * Thread的三种创建方式
 *
 * @author Ming
 * @create 2020-05-20 14:42
 */
public class ThreadDemo {
    public static void main(String[] args) {
        // 1、继承Thread类的方式
        // MyThread td = new MyThread("自定义的线程");     构造时直接设置线程名称
        MyThread td = new MyThread();
        td.setName("自定义的线程");       // 设置线程名称
        td.start();
        System.out.println(td.getName());       //获取线程名称
        System.out.println(Thread.currentThread());     //返回当前正在执行的线程对象

        //2、实现Runnable接口的方式
        MyRunnable myRunnable = new MyRunnable();
        Thread td2 = new Thread(myRunnable);
        td2.start();

        //3、实现Callable接口
        MyCallable myCallable = new MyCallable();
        FutureTask futureTask = new FutureTask(myCallable);
        Thread td3 = new Thread(futureTask);
        td3.start();

        //以匿名内部类的形式实现多线程
        new Thread() {
            @Override
            public void run() {
                System.out.println("子类形式使用匿名内部类实现多线程");
            }
        }.start();

        new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println("Runnable实现类形式使用匿名内部类实现多线程");
            }
        }).start();

        // 如果同时使用两种方式，最终执行的还是子类形式重写的按方法
        new Thread(new Runnable() {
            public void run() {
                System.out.println("Runnable实现类形式使用匿名内部类实现多线程");
            }
        }) {
            public void run() {
                System.out.println("子类形式使用匿名内部类实现多线程");
            }
        }.start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }
    }
}

class MyCallable implements Callable {
    @Override
    public Object call() throws Exception {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }
        return null;
    }
}