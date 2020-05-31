package com.isoftstone;

/**
 * 描述：  静态代理: 静态代理在编译时就已经实现，编译完成后代理类是一个实际的class文件
 * 优点：  可以在不修改目标对象的前提下扩展目标对象的功能。
 * 缺点：  冗余。由于代理对象要实现与目标对象一致的接口，会产生过多的代理类。
 *        不易维护。一旦接口增加方法，目标对象与代理对象都要进行修改。
 *
 * @author Ming
 * @create 2020-05-23 9:48
 */
public class StaticProxy {
    public static void main(String[] args) {
        Dao target = new DaoImpl();
        DaoProxy proxy = new DaoProxy(target);
        proxy.login();
        proxy.register();
    }
}

// 接口
interface Dao {
    public void login();

    public void register();
}

// 目标对象DaoImpl
class DaoImpl implements Dao {
    @Override
    public void login() {
        System.out.println("登录...");
    }

    @Override
    public void register() {
        System.out.println("注册...");
    }
}

//静态代理对象,需要实现Dao接口
class DaoProxy implements Dao {
    private Dao target;

    public DaoProxy(Dao target) {
        this.target = target;
    }

    @Override
    public void login() {
        System.out.println("权限校验");
        target.login();
        System.out.println("日志记录");
    }

    @Override
    public void register() {
        System.out.println("权限校验");
        target.register();
        System.out.println("日志记录");
    }
}