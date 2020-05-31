package com.isoftstone;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 描述:  动态代理：动态代理是在运行时动态生成的，即编译完成后没有实际的class文件，而是在运行时动态生成类字节码，并加载到JVM中
 * <p>
 * Proxy类中有一个方法可以创建动态代理对象
 * public static Object newProxyInstance(ClassLoaderloader,Class<?>[]interfaces,InvocationHandler h)
 * 三个参数，第一个定义代理类的类加载器，第二个代理类要实现的接口列表，第三个代理实例的调用处理程序实现的接口
 * 返回一个指定接口的代理类实例，该接口可以将方法调用指派到指定的调用处理程序。
 *
 * @author Ming
 * @create 2020-05-23 9:26
 */
public class DynamicProxy {
    public static void main(String[] args) {
        UserDao target = new UserDaoImpl(); // 构建目标对象
        UserDao proxy = (UserDao) new UserDaoProxy(target).getProxyInstance();  // 构建代理对象
        proxy.login();
        proxy.register();
    }
}

// 接口
interface UserDao {
    public void login();

    public void register();
}

// 目标对象UserDaoImpl
class UserDaoImpl implements UserDao {
    @Override
    public void login() {
        System.out.println("登录...");
    }

    @Override
    public void register() {
        System.out.println("注册...");
    }
}

//动态代理对象
class UserDaoProxy {
    private Object target; // 维护一个目标对象

    public UserDaoProxy(Object target) {
        this.target = target;
    }

    // 为目标对象生成代理对象
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("校验权限");
                Object obj = method.invoke(target, args);
                System.out.println("日志记录");
                return null;
            }
        });
    }
}