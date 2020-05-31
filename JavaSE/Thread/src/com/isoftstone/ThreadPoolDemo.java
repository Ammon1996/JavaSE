package com.isoftstone;

import java.util.concurrent.*;

/**
 * 描述:
 * 线程池的使用
 *
 * @author Ming
 * @create 2020-05-21 11:56
 */
/*
 * 线程池的好处：线程池里的每一个线程代码结束后，并不会死亡，而是再次回到线程池中成为空闲状态，等待下一个对象来使用。
 *
 * 如何实现线程的代码呢?
 * 		A:创建一个线程池对象，控制要创建几个线程对象。
 * 			Executors类中的一个方法创建一个可重用固定线程数的线程池：
 * 			public static ExecutorService newFixedThreadPool(int nThreads)
 * 		B:这种线程池的线程可以执行：
 * 			可以执行Runnable对象或者Callable对象代表的线程
 * 			做一个类实现Runnable接口。
 * 		C:调用如下方法即可
 * 			Future<?> submit(Runnable task)
 *			<T> Future<T> submit(Callable<T> task)
 *		D:我就要结束，可以吗?
 *			可以。
 *			shutdown()
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {

        // 创建线程池对象
        ExecutorService e = Executors.newFixedThreadPool(3);
        e.submit(new MyRunnable());
        e.submit(new MyRunnable());
        e.submit(new MyRunnable());
        // 关闭线程池
        e.shutdown();

        // 创建等待队列
        BlockingQueue<Runnable> bqueue = new ArrayBlockingQueue<Runnable>(20);
        // 创建线程池
        ThreadPoolExecutor pool = new ThreadPoolExecutor(6, 10, 500,
                TimeUnit.MILLISECONDS, bqueue);
        pool.execute(new MyRunnable());
        pool.execute(new MyRunnable());
        pool.execute(new MyRunnable());
        pool.shutdown();
    }
}

