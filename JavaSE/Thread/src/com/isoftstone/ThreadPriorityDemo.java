package com.isoftstone;

/**
 * 描述:
 * 我们的线程没有设置优先级,肯定有默认优先级。
 * 那么，默认优先级是多少呢?
 * 如何获取线程对象的优先级?
 * public final int getPriority():返回线程对象的优先级
 * 如何设置线程对象的优先级呢?
 * public final void setPriority(int newPriority)：更改线程的优先级。
 * 注意：
 * 线程默认优先级是5。
 * 线程优先级的范围是：1-10。
 * 线程优先级高仅仅表示线程获取的 CPU时间片的几率高，但是要在次数比较多，或者多次运行的时候才能看到比较好的效果。
 * /
 *
 * @author Ming
 * @create 2020-05-21 10:51
 */
public class ThreadPriorityDemo {
    public static void main(String[] args) {
        ThreadPriority tp = new ThreadPriority("tp");
        ThreadPriority tp2 = new ThreadPriority("tp2");
        ThreadPriority tp3 = new ThreadPriority("tp3");

        tp.setPriority(1);
        tp2.setPriority(10);
        tp.start();
        tp2.start();
        tp3.start();
    }
}

class ThreadPriority extends Thread {
    public ThreadPriority(String name) {
        super(name);
    }

    public void run() {
        for (int x = 0; x < 10; x++) {
            System.out.println(getName() + ": " + x);
        }
    }
}