package com.isoftstone;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 描述:Stream流
 * 生成Stream流的方式
 * Collection体系集合
 * Map体系集合 把Map转成Set集合，间接的生成流
 * 数组 通过Stream接口的静态方法of(T... values)生成流
 *
 * @author Ming
 * @create 2020-05-24 11:59
 */
public class StreamDemo {
    public static void main(String[] args) {
        //Collection体系生成流
        ArrayList list = new ArrayList();
        Stream stream1 = list.stream();

        // Map体系集和生成流
        HashMap<String, String> map = new HashMap<String, String>();
        Set<Map.Entry<String, String>> set = map.entrySet();
        Stream stream2 = set.stream();

        // 数组生成流
        String[] arr = {"hello", "world"};
        Stream<String> stream3 = Stream.of(arr);

        String[] array = {"张曼玉", "张国荣", "张家辉", "张家辉", "梁朝伟", "周润发", "张敏"};
        ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(array));
        // 使用stream流完成过滤操作,遍历输出
        arrayList.stream().filter(s -> s.startsWith("张")).filter(s -> s.length() == 3).forEach(s -> System.out.print(s + " "));
        System.out.println();

        // count 求流中的所有元素个数
        long count = arrayList.stream().count();
        System.out.println(count);

        // limit 截取前n个元素输出
        arrayList.stream().limit(5).forEach(s -> System.out.print(s + " "));
        System.out.println();

        // skip 跳过n个元素，将剩下的元素输出
        arrayList.stream().skip(2).forEach(s -> System.out.print(s + " "));
        System.out.println();

        // 跳过n个元素，截去剩下的前n个元素输出
        arrayList.stream().skip(2).limit(3).forEach(s -> System.out.print(s + " "));
        System.out.println();

        // distinct 去除重复元素
        arrayList.stream().distinct().forEach(s -> System.out.print(s + " "));
        System.out.println();

        // concat 合并两个流
        Stream<String> s1 = arrayList.stream().limit(3);
        Stream<String> s2 = arrayList.stream().skip(3);
        Stream.concat(s1, s2).forEach(s -> System.out.print(s + " "));
        System.out.println();

        // sort 自然排序
        arrayList.stream().sorted().forEach(s -> System.out.print(s + " "));
        System.out.println();

        // 指定排序规则
        arrayList.stream().sorted((str1, str2) -> {
            int num1 = str1.length() - str2.length();
            int num2 = num1 == 0 ? str1.compareTo(str2) : num1;
            return num2;
        }).forEach(s -> System.out.print(s + " "));
        System.out.println();

        // map 返回由给定函数应用于此流的元素的结果组成的流
        arrayList.stream().map(s -> s + "☆").forEach(s -> System.out.print(s + " "));
        System.out.println();

        //mapToInt 返回一个IntStream（原始int流）其中包含将给定函数应用于此流的元素的结果组成的流
        Stream.of("1", "2", "3", "4").mapToInt(s -> Integer.parseInt(s)).forEach(s -> System.out.print(s + " "));
        System.out.println();

        // IntStream 流中的sum方法返回流中所有元素的和
        int sum = Stream.of("1", "2", "3", "4").mapToInt(s -> Integer.parseInt(s)).sum();
        System.out.println(sum);

        // collect 将刘中的数据收集到集合中R collect(Collector collector) 把结果收集到集合中
        // 工具类Collectors提供了具体的收集方式
        // public static Collector toList() 把元素收集到List集合中
        // public static Collector toSet() 把元素收集到Set集合中
        // public static Collector toMap(Function keyMapper,Function valueMapper) // 把元素收集到Map集合 中
        List<String> collect = arrayList.stream().distinct().collect(Collectors.toList());
        System.out.println(collect);

        Set<String> set1 = arrayList.stream().distinct().collect(Collectors.toSet());
        System.out.println(set1);

        String[] strArray = {"张三,30", "李四,35", "王五,33", "赵六,25"};
        Map<String, Integer> map1 = Stream.of(strArray).collect(Collectors.toMap(s -> s.split(",")[0],
                s -> Integer.parseInt(s.split(",")[1])));

        System.out.println(map1);
    }
}