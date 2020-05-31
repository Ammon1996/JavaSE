package com.isoftstone;

/**
 * 描述:  方法引用 方法引用是Lambda的孪生兄弟
 * <p>
 * 方法引用符 :: 该符号为引用运算符，而它所在的表达式被称为方法引用
 *      引用类方法格式 类名::静态方法 范例 Integer::parseInt
 *      引用对象的实例方法格式 对象::成员方法
 *      引用类的实例方法 类名::成员方法
 *      引用构造器：类名::new
 *
 * @author Ming
 * @create 2020-05-23 11:15
 */
public class ReferenceDemo {
    public static void main(String[] args) {

        //lambda表达式实现
        useConverter(s -> Integer.parseInt(s));
        //引用类方法    
        useConverter(Integer::parseInt);

        //lambda表达式实现
        userPrintUpperCase(s -> System.out.println(s.toUpperCase()));
        // 引用对象实例方法
        PrintUpperCase printUpperCase = new PrintUpperCase();
        userPrintUpperCase(printUpperCase::toUpper);

        //lambda表达式实现
        useSubString((s, x, y) -> s.substring(x, y));
        // 引用类的实例方法
        useSubString(String::substring);

        // lambda表达是实现
        useStudentBuilder((name, age) -> new Student(name, age));
        // 引用构造
        useStudentBuilder(Student::new);
    }

    private static void useConverter(Converter c) {
        int number = c.convert("666");
        System.out.println(number);
    }

    private static void userPrintUpperCase(ToUpperCase upperCase) {
        upperCase.toUpper("Hello World");
    }

    private static void useSubString(mySubString my) {
        String s = my.subString("HelloWorld", 2, 5);
        System.out.println(s);
    }

    public static void useStudentBuilder(StudentBuilder sb) {
        Student student = sb.build("张三", 28);
        System.out.println(student.getName() + ":" + student.getAge());
    }
}

class PrintUpperCase {
    public void toUpper(String s) {
        String result = s.toUpperCase();
        System.out.println(result);
    }
}

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student() {
        super();
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
}

// 测试引用类方法的接口
interface Converter {
    int convert(String s);
}

// 测试引用对象实例方法的接口
interface ToUpperCase {
    void toUpper(String s);
}

// 测试引用类的实例方法的接口
interface mySubString {
    String subString(String s, int x, int y);
}

// 测试引用构造的接口
interface StudentBuilder {
    Student build(String name, int age);
}