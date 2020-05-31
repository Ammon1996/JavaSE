package com.isoftstone;

/**
 * 描述:
 * public static void yield():暂停当前正在执行的线程对象，并执行其他线程。
 * 让多个线程的执行更和谐，但是不能靠它保证一人一次。
 * @author Ming
 * @create 2020-05-21 11:01
 */
public class ThreadYieldDemo {
    public static void main(String[] args) {
        ThreadYield ty = new ThreadYield();
        ThreadYield ty2 = new ThreadYield();
        ThreadYield ty3 = new ThreadYield();

        ty.start();
        ty2.start();
        ty3.start();
    }
}

class ThreadYield extends Thread {
    @Override
    public void run() {
        for (int x = 0; x < 10; x++) {
            System.out.println(getName() + ": " + x);
            Thread.yield();
        }
    }
}
