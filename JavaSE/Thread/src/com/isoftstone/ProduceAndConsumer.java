package com.isoftstone;

/**
 * 描述:
 * 生产者消费者实例
 *
 * @author Ming
 * @create 2020-05-21 11:36
 */
/*
 * Object类中提供了三个方法：wait():等待    notify():唤醒单个线程     notifyAll():唤醒所有线程
 */
public class ProduceAndConsumer {
    public static void main(String[] args) {
        Milk milk = new Milk();
        Thread produce_Thread = new Thread(new Producer(milk));
        Thread consumer_Thread = new Thread(new Consumer(milk));
        produce_Thread.start();
        consumer_Thread.start();
    }
}

// 消费资源类
class Consumer implements Runnable {
    Milk milk;

    public Consumer(Milk milk) {
        this.milk = milk;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (milk) {
                // 判断资源还有没有
                if (!milk.flag) {
                    //没有资源，暂停消费
                    try {
                        milk.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println(milk.number + "已经被消费");
                    //修改资源标记
                    milk.flag = false;
                    // 唤醒
                    milk.notify();
                }
            }
        }
    }
}

// 生产资源类
class Producer implements Runnable {
    Milk milk;
    int x = 0;

    public Producer(Milk milk) {
        this.milk = milk;
    }

    public void setMilk(Milk milk) {
        this.milk = milk;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (milk) {
                // 判断资源还有没有
                if (milk.flag) {
                    // 有资源，暂停生产
                    try {
                        milk.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    if (x % 2 == 0) {
                        // 生产资源
                        milk.number = 1;
                    } else {
                        // 生产资源
                        milk.number = 2;
                    }
                    //更改资源标记
                    milk.flag = true;

                    //唤醒、
                    milk.notify();
                    x++;
                }
            }
        }

    }
}

// 资源类
class Milk {
    int number;
    boolean flag;       // 资源有无的标志
}