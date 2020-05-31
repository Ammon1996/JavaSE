package com.isoftstone;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 描述:
 * Timer定时器的使用
 *
 * @author Ming
 * @create 2020-05-21 12:09
 */
public class TimerDemo {
    public static void main(String[] args) {
        // 创建定时器对象
        Timer timer = new Timer();
        //延时三秒执行任务
        timer.schedule(new MyTimerTask(timer), 3000);

        // 延时3秒，然后每两秒都执行一次
        timer.schedule(new MyTimerTask(timer), 3000, 2000);
    }
}

class MyTimerTask extends TimerTask {
    private Timer timer;

    public MyTimerTask(Timer timer) {
        this.timer = timer;
    }

    public void run() {
        System.out.println("boom, 爆炸了！");
        //终止
        timer.cancel();
    }
}