package com.isoftstone;

/**
 * 描述:
 * Exception的用法
 *
 * @author Ming
 * @create 2020-05-20 10:14
 */

public class ExceptionDemo {
    public static void main(String[] args) throws Exception {
        //异常处理
        try {
            int x = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("除数不能为0");
        } catch (Exception e) {

        }

        /**
         * throws   用在方法声明后面，跟的是异常类名    可以跟多个异常类名，用逗号隔开
         *          表示抛出异常，由该方法的调用者来处理  throws表示出现异常的一种可能性，并不一定会发生这些异常
         * throw    用在方法体内，跟的是异常对象名 只能抛出一个异常对象名
         *          表示抛出异常，由方法体内的语句处理   throw则是抛出了异常，执行throw则一定抛出了某种异常
         */
        try {
            int x = 10 / 0;
        } catch (ArithmeticException e) {
            throw new ArithmeticException();
        } finally {
            // finally 里面的语句必然会执行，除非在之前jvm退出了
        }

        /*
         * 面试题：
         * 1:final,finally和finalize的区别
         * final：最终的意思，可以修饰类，成员变量，成员方法
         * 		修饰类，类不能被继承
         * 		修饰变量，变量是常量
         * 		修饰方法，方法不能被重写
         * finally：是异常处理的一部分，用于释放资源。
         * 		一般来说，代码肯定会执行，特殊情况：在执行到finally之前jvm退出了
         * finalize：是Object类的一个方法，用于垃圾回收
         *
         * 2:如果catch里面有return语句，请问finally里面的代码还会执行吗?
         *   如果会，请问是在return前，还是return后。
         * 	   会。前。
         *
         * 	 准确的说，应该是在中间。
         *
         * 3:try...catch...finally的格式变形
         * 		A:try...catch...finally
         * 		B:try...catch
         * 		C:try...catch...catch...
         * 		D:try...catch...catch...finally
         * 		E:try...finally
         *
         */
    }
}