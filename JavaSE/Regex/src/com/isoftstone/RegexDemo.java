package com.isoftstone;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 描述:
 * 正则表达式的相关方法
 *
 * @author Ming
 * @create 2020-05-19 11:14
 */
public class RegexDemo {
    public static void main(String[] args) {

        //正则表达式示例1
        String regex = "[1-9][0-9]{6,10}";  //第一位数1-9，后面的数0-9共6~10位，总共7-11位数
        String qq = "1050859950";
        System.out.println(qq.matches(regex));
        String id = "108889";
        System.out.println(id.matches(regex));
        String phone = "13164617417";
        System.out.println(phone.matches(regex));

        //正则表达式示例2
        String regex2 = "1[357]\\d{9}";     //第一位数为1，第二尾数为3,5,7中的一个，后面为9位数字
        String tel1 = "13164617417";
        System.out.println(tel1.matches(regex2));
        String tel2 = "18815083974";
        System.out.println(tel2.matches(regex2));

        //正则表达式示例3
        String regex3 = "\\d+";  //连续多个数字
        String s = "hello123IDEA";
        String s1 = s.replaceAll(regex3, "*");
        System.out.println(s1);

        // 正则表达式示例4
        String regex4 = "\\b\\w{3}\\b";     //三个字符的单词
        String sentence = "Hi Jay Where ara you from?";
        //将正则表达式变异成模式对象
        Pattern patter = Pattern.compile(regex4);
        //通过模式对象得到匹配对象
        Matcher matcher = patter.matcher(sentence);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}