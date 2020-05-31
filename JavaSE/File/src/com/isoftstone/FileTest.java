package com.isoftstone;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 描述:
 * File练习
 *
 * @author Ming
 * @create 2020-05-20 11:27
 */
/*
 * 判断当前目录下是否有后缀名为.jpg的文件，如果有，就输出此文件名称
 *
 * 分析：
 * 1:先获取所有的，然后遍历的时候，依次判断，如果满足条件就输出。
 * 		A:封装判断目录
 * 		B:获取该目录下所有文件或者文件夹的File数组
 * 		C:遍历该File数组，得到每一个File对象，然后判断
 * 		D:是否是文件
 * 			是：继续判断是否以.jpg结尾
 * 				是：就输出该文件名称
 * 				否：不搭理它
 * 			否：不搭理它
 *
 * 2:获取的时候就已经是满足条件的了，然后输出即可。
 * 		要想实现这个效果，就必须学习一个接口：文件名称过滤器
 *		public String[] list(FilenameFilter filter)
 * 		public File[] listFiles(FilenameFilter filter)
 */
public class FileTest {
    public static void main(String[] args) {
        File file = new File("File\\files");

        File[] fileArray = file.listFiles();
        for (File f : fileArray) {
            if (f.isFile()) {
                if (f.getName().endsWith(".jpg")) {
                    System.out.println(f.getName());
                }
            }
        }

        File file2 = new File("File\\files");
        String[] strArray = file2.list(new FilenameFilter() {

            @Override
            public boolean accept(File dir, String name) {
                File new_file = new File(dir, name);
                return new_file.isFile() && new_file.getName().endsWith(".jpg");
            }
        });
        for (String s : strArray) {
            System.out.println(s);
        }
    }
}