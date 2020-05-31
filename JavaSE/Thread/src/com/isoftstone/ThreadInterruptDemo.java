package com.isoftstone;

import java.util.Date;

/**
 * 描述:
 * <p>
 * public void interrupt():中断线程。 把线程的状态终止，并抛出一个InterruptedException
 * public static void sleep(long millis):线程休眠
 * @author Ming
 * @create 2020-05-21 10:26
 */
public class ThreadInterruptDemo {
    public static void main(String[] args) {
        ThreadInterrupt td = new ThreadInterrupt();

        td.start();
        try {
            td.sleep(3000);
            td.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class ThreadInterrupt extends Thread {
    @Override
    public void run() {
        System.out.println("开始执行：" + new Date());
        try {
            Thread.sleep(10000); // 休眠10秒
        } catch (InterruptedException e) {
            System.out.println("线程被终止");
        }
        System.out.println("结束执行：" + new Date());
    }
}