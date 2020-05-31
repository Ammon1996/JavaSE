package com.isoftstone;

import java.io.File;
import java.io.IOException;

/**
 * 描述:
 * File类常用操作
 *
 * @author Ming
 * @create 2020-05-20 10:31
 */
public class FileDemo {
    public static void main(String[] args) throws IOException {
        //构造方法
        File file1 = new File("D:\\IDEA_WorkSpace\\JavaSE\\File\\files\\file1.txt");      //磁盘绝对路径
        File file2 = new File("D:\\IDEA_WorkSpace\\JavaSE\\File\\files", "file1.txt");
        File file3 = new File("D:\\IDEA_WorkSpace\\JavaSE\\File\\files");
        File file4 = new File(file3, "file1.txt");

        //创建文件夹
        File file5 = new File("D:\\IDEA_WorkSpace\\JavaSE\\File\\files\\newDirectory");
        file5.mkdir();

        // 创建文件
        File file6 = new File("File\\files\\newDirectory\\newFile.txt");
        file6.createNewFile();

        // 创建多级文件夹
        File file7 = new File("File\\files\\directory1\\directory2");
        file7.mkdirs();

        // 删除文件夹，该文件夹必须是一个空的文件夹
        file7.delete();

        // 重命名功能 路径名相同就是重命名，不同就是改名并剪切
        File new_file = new File("File\\files\\new_file.txt");
        file1.renameTo(new_file);       // 重命名
        File new_file2 = new File("File\\files\\newDirectory\\new_file2.txt");
        new_file.renameTo(new_file2);   // 改名并剪切

        // File一些判断功能
        System.out.println(new_file2.isDirectory());
        System.out.println(new_file2.isFile());
        System.out.println(new_file2.exists());
        System.out.println(new_file2.canRead());
        System.out.println(new_file2.canWrite());
        System.out.println(new_file2.isHidden());

        // File一些获取功能
        System.out.println(new_file2.getAbsolutePath());    //绝对路径
        System.out.println(new_file2.getPath());    //相对路径
        System.out.println(new_file2.getName());    //文件名（包括后缀）
        System.out.println(new_file2.length());     //字节长度
        System.out.println(new_file2.lastModified());   //最后一次修改时间

        File files = new File("File\\files");
        String[] list = files.list();   //获取目标文件夹下所有文件夹和文件的名称
        for (String s : list) {
            System.out.println(s);
        }

        File[] files1 = files.listFiles();  //获取目标文件夹下的所有文件夹和文件File对象
        for (File file : files1) {
            System.out.println(file.getName());
        }
    }
}