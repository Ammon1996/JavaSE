package com.isoftstone;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 描述:
 * Timer定时任务测试题
 * 定时删除某个文件夹
 *
 * @author Ming
 * @create 2020-05-21 12:15
 */
public class TimerTest {
    public static void main(String[] args) throws ParseException {
        Timer timer = new Timer();
        String time = "2020-05-21 12:37:00";
        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time);
        timer.schedule(new DeleteFolderTask(timer), date);
    }
}

class DeleteFolderTask extends TimerTask {
    Timer timer;

    DeleteFolderTask(Timer timer) {
        this.timer = timer;
    }

    @Override
    public void run() {
        File folder = new File("Timer\\files");
        deleteFolder(folder);
        timer.cancel();
    }

    // 递归删除文件夹
    public void deleteFolder(File folder) {
        File[] files = folder.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                System.out.println(file.getName() + "是否被删除：" + file.delete());
            } else {
                deleteFolder(file);
            }
        }
        System.out.println(folder.getName() + "是否被删除：" + folder.delete());
    }
}