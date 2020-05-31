package com.isoftstone;

/**
 * 描述:
 *
 * @author Ming
 * @create 2020-05-21 10:37
 */

/**
 *  public final void join():等待该线程终止。
 *  只有等待调用该方法的线程结束，其他线程才能启动
 */
public class ThreadJoinDemo {
    public static void main(String[] args) {
        ThreadJoin tj = new ThreadJoin();
        ThreadJoin tj2 = new ThreadJoin();
        ThreadJoin tj3 = new ThreadJoin();

        tj.start();
        try {
            tj.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        tj2.start();
        tj3.start();
    }
}

class ThreadJoin extends Thread {
    @Override
    public void run() {
        for (int x = 0; x < 10; x++) {
            System.out.println(getName() + ": " + x);
        }
    }
}