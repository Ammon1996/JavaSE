package com.isoftstone;

/**
 * 描述:
 * 反射的学习
 *
 * @author Ming
 * @create 2020-05-22 11:41
 */

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射：就是通过class文件对象，去使用该文件中的成员变量，构造方法，成员方法。
 * 要想这样使用，首先你必须得到class文件对象，其实也就是得到Class类的对象。
 * Class类：
 * 成员变量	Field
 * 构造方法	Constructor
 * 成员方法	Method
 * 获取class文件对象的方式：
 * A:Object类的getClass()方法
 * B:数据类型的静态属性class
 * C:Class类中的静态方法
 * public static Class forName(String className)
 * 一般我们到底使用谁呢?
 * A:自己玩	任选一种，第二种比较方便
 * B:开发	第三种
 * 为什么呢?因为第三种是一个字符串，而不是一个具体的类名。这样我们就可以把这样的字符串配置到配置文件中。
 */
public class ReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        // 获取class对象的三种方法
        Class<? extends Person> class1 = new Person().getClass();
        Class<Person> class2 = Person.class;
        Class<?> class3 = Class.forName("com.isoftstone.Person");
        System.out.println(class1 == class2);
        System.out.println(class2 == class3);
        System.out.println();

        // 通过反射获取所有公共构造方法
        Constructor<?>[] constructors = class3.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println();

        // 通过反射获取所有构造方法
        Constructor<?>[] declaredConstructors = class3.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
        System.out.println();

        // 获取单个公共构造方法
        Constructor<?> constructor = class3.getConstructor();
        System.out.println(constructor);
        System.out.println();

        // 通过获取到的公共构造方法对象构造一个实例对象
        Object o = constructor.newInstance();
        System.out.println(o);
        System.out.println();

        // 获取单个私有构造方法
        Constructor<?> declaredConstructor = class3.getDeclaredConstructor(String.class, int.class);
        System.out.println(declaredConstructor);
        System.out.println();

        // 通过获取到的私有构造方法对象构造一个实例对象 会报java.lang.IllegalAccessException 非法访问异常 需要设置暴力访问
        declaredConstructor.setAccessible(true);       // 设置暴力访问
        Object o1 = declaredConstructor.newInstance("张三", 25);
        System.out.println(o1);
        System.out.println();

        // 获取公所有共成员变量
        Field[] fields = class3.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println();

        // 获取所有成员变量
        Field[] declaredFields = class3.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        System.out.println();

        // 获取单个公共成员变量
        Field addressField = class3.getField("address");

        // 获取单个成员变量
        Field nameField = class3.getDeclaredField("name");
        Field ageField = class3.getDeclaredField("age");

        // 使用成员变量给实例对象赋值
        nameField.setAccessible(true);
        nameField.set(o1, "李四");
        ageField.setAccessible(true);
        ageField.set(o1, 22);
        addressField.setAccessible(true);
        addressField.set(o1, "湖北武汉");
        System.out.println(o1);
        System.out.println();

        // 获取所有公共成员方法(包括从父类继承的方法)
        Method[] methods = class3.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println();

        // 获取本类中的所有成员方法
        Method[] declaredMethods = class3.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
        System.out.println();

        // 获取单个公共成员方法 （无参，无返回值类型）
        Method eat = class3.getMethod("eat");
        // 获取单个成员方法 （带参，带返回值）
        Method dance = class3.getMethod("dance", String.class);
        System.out.println(eat + "," + dance);

        // 获取单个非公共成员方法
        Method sleep = class3.getDeclaredMethod("sleep");
        System.out.println(sleep);

        // 使用成员方法
        eat.invoke(o1);
        Object obj = dance.invoke(o, "张三");
        System.out.println(obj);
        sleep.invoke(o1);

    }
}

class Person {
    private String name;
    int age;
    public String address;

    public Person() {
        super();
    }

    private Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    void sleep() {
        System.out.println("睡觉");
    }

    public void eat() {
        System.out.println("吃饭");
    }

    public String dance(String name) {
        return name + "正在跳舞";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", address="
                + address + "]";
    }

}
