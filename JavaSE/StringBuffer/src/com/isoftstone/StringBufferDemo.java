package com.isoftstone;

/**
 * 描述:
 * StringBUffer类常用方法
 *
 * @author Ming
 * @create 2020-05-18 15:52
 */
public class StringBufferDemo {
    public static void main(String[] args) {
        // 构造方法
        StringBuffer stringBuffer = new StringBuffer();  //无参构造
        StringBuffer stringBuffer1 = new StringBuffer(1024);  // 指定容量
        StringBuffer stringBuffer2 = new StringBuffer("Hello IDEA"); //指定内容
        System.out.println(stringBuffer + "," + stringBuffer1 + "," + stringBuffer2);

        // 获取当前缓冲区的容量 (默认是16，当前容量等于默认容量+字符串长度)
        int capacity = stringBuffer.capacity();
        int capacity1 = stringBuffer1.capacity();
        int capacity2 = stringBuffer2.capacity();
        System.out.println(capacity + "," + capacity1 + "," + capacity2);

        // 获取缓冲区内容实际长度
        int length = stringBuffer.length();
        int length1 = stringBuffer1.length();
        int length2 = stringBuffer2.length();
        System.out.println(length + "," + length1 + "," + length2);

        //添加功能 返回值是StringBuffer类型,是当前对象的一个引用，便于链式编程
        stringBuffer.append("hello");//尾部添加
        System.out.println(stringBuffer);
        stringBuffer.insert(3, "ABC");     //指定位置添加
        System.out.println(stringBuffer);

        // 删除功能
        stringBuffer.delete(0, 3);  //指定删除起点终点（包左不包右）
        System.out.println(stringBuffer);
        stringBuffer.deleteCharAt(4);  //删除指定位置的字符
        System.out.println(stringBuffer);

        //替换功能
        stringBuffer2.replace(0, 5, "Hi");
        System.out.println(stringBuffer2);

        //翻转功能
        stringBuffer2.reverse();
        System.out.println(stringBuffer2);

        // 截取功能，本身没有改变
        String substring = stringBuffer2.substring(3);
        System.out.println(substring);
        String substring1 = stringBuffer2.substring(0, 3);
        System.out.println(substring1);
        System.out.println(stringBuffer2);
    }

}