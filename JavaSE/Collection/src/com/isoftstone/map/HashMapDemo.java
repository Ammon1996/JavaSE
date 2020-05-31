package com.isoftstone.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 描述:
 * HashMap类常用方法
 * Map集合是以键值对的形式存储的 无序
 *
 * @author Ming
 * @create 2020-05-19 15:29
 */
public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<String, String>();
        //添加元素
        map.put("95001", "严君泽");
        map.put("95002", "刘世宇");
        map.put("95003", "李元浩");
        map.put("95004", "简自豪");
        map.put("95005", "史森明");
        System.out.println(map);

        // 判断map集合是否存在指定的键、指定的值、是否为空
        System.out.println(map.containsKey("95003"));
        System.out.println(map.containsValue("简自豪"));
        System.out.println(map.isEmpty());

        // 根据键获取值
        String value = map.get("95002");
        System.out.println(value);

        //获取所有的键
        Set<String> strings = map.keySet();
        System.out.println(strings);

        // 获取所有的值
        Collection<String> values = map.values();
        System.out.println(values);

        // 获取键值对集合
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry);
        }

        //map集合的长度
        System.out.println(map.size());

        // 根据键来删除键值对、删除所有
        map.remove("95003");
        System.out.println(map);
        map.clear();
        System.out.println(map);
    }

}