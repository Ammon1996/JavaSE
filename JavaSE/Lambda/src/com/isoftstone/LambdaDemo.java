package com.isoftstone;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * 描述:
 * Lambda表达式的使用 Lambda表达式是函数式编程思想的体现
 * Lambda表达式格式：(形式参数) -> {代码块}
 * 形式参数：如果有多个参数，参数之间用逗号隔开；如果没有参数，留空即可
 * ->：由英文中画线和大于符号组成，固定写法。代表指向动作
 * 代码块：是我们具体要做的事情，也就是以前我们写的方法体内容
 * 组成Lambda表达式的三要素： 形式参数，箭头，代码块
 * 省略的规则
 * 参数类型可以省略。但是有多个参数的情况下，不能只省略一个
 * 如果参数有且仅有一个，那么小括号可以省略
 * 如果代码块的语句只有一条有return，可以省略大括号和分号，和return关键字
 * <p>
 * 使用Lambda必须要有接口，并且要求接口中有且仅有一个抽象方法
 * 必须有上下文环境，才能推导出Lambda对应的接口
 * 根据局部变量的赋值得知Lambda对应的接口  Runnable r = () -> System.out.println("Lambda表达式");
 * 根据调用方法的参数得知Lambda对应的接口  new Thread(() -> System.out.println("Lambda表达式")).start();
 * <p>
 * Lambda表达式和匿名内部类的区别【理解】
 * 所需类型不同 匿名内部类：可以是接口，也可以是抽象类，还可以是具体类 Lambda表达式：只能是接口
 * 使用限制不同 如果接口中有且仅有一个抽象方法，Lambda表达式，匿名内部类都可以使用, 如果接口中多于一个抽象方法，只能使用匿名内部类
 * 实现原理不同 匿名内部类：编译之后，产生一个单独的.class字节码文件 Lambda表达式：编译之后，没有一个单独的.class字节码文件。对应的字节码会在运行的时候动态生成
 *
 * @author Ming
 * @create 2020-05-23 10:44
 */
public class LambdaDemo {
    public static void main(String[] args) {
        // 针对匿名内部类的优化
        // 不使用lambda表达式
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        }).start();

        // 使用lambda表达式
        new Thread(() -> System.out.println("hello")).start();

        Person p1 = new Person("Curry", 21);
        Person p2 = new Person("Jerry", 23);
        Person p3 = new Person("Yummy", 22);
        ArrayList<Person> list = new ArrayList<Person>();
        list.add(p1);
        list.add(p2);
        list.add(p3);

        list.sort(new Comparator<Person>() {
            public int compare(Person p1, Person p2) {
                int num1 = p1.getAge() - p2.getAge();
                int num2 = num1 == 0 ? p1.getName().compareTo(p2.getName()) : num1;
                return num2;
            }
        });
        System.out.println(list);

        //带参数，带返回值，
        list.sort((Person o1, Person o2) -> {
            int num1 = o1.getAge() - o2.getAge();
            int num2 = num1 == 0 ? o1.getName().compareTo(o2.getName()) : num1;
            return num2;
        });
        System.out.println(list);
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public Person() {
        super();
        // TODO Auto-generated constructor stub
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
        return "Person [name=" + name + ", age=" + age + "]";
    }

}