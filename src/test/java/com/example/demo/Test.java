package com.example.demo;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class Test {
    private static String del(String s) {
        Test test=new Test();
        ThreadLocal threadLocal=new ThreadLocal();

        threadLocal.get();
        threadLocal.set("ff");
        //创建一个hashMap存储，存储字符串中的字符和其出现的次数
        HashMap<Character, Integer> map = new HashMap<>();
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (map.containsKey(ch[i])) {
                map.put(ch[i], map.get(ch[i]) + 1);
            } else {
                map.put(ch[i], 1);
            }
        }
        Collection<Integer> values = map.values();
        Integer max = Collections.max(values);
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < ch.length; i++) {
            if (map.get(ch[i]) != max) {
                str.append(ch[i]);
            }
        }
        return str.toString();
    }


    public static void main1(String[] args) {
        String s = "aBc12D9";
        // 3.1、输出字符串中字符和数字的个数。
        int letter = 0;
        int digit = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))
                letter++;
            else if (c >= '0' && c <= '9')
                digit++;
        }
        System.out.println("字符个数：" + letter + "  数字个数：" + digit);

        // 3.2、相连的数字不能分为2个，即12是作为一个数字统计，输出字符串中字符和数字的个数。
        letter = 0;
        digit = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))
                letter++;
            else if (isDigit(c) && !isDigit(s.charAt(i - 1)))
                digit++;
        }
        System.out.println("字符个数：" + letter + "  数字个数：" + digit);

        // 3.3、字符大小写不区分，统计字符的个数及出现次数。

        int[] counts = new int[26];
        for (char c : toLowerCase(s)) {
            if (Character.isLetter(c)) {
                counts[c - 'a']++;
            }
        }
        for (int i = 0; i < counts.length; i++) {
            System.out.println((char) ('a' + i) + " 出现了 " + counts[i] + " 次;");
        }

        // 3.4、统计出现次数最多的字符和数字。
        counts = new int[200];
        int max1 = 0;// 记录出现次数最多等字符的下标
        int max2 = 0;// 记录出现次数最多等数字的下标
        //一次遍历，记录出现的次数，同时更新出现次数最多的字符和数字
        for (char c : s.toCharArray()) {
            counts[c]++;
            if (isLetter(c) && counts[max1] < counts[c]) {
                max1 = c;
            } else if (isDigit(c) && counts[max2] < counts[c]) {
                max2 = c;
            }
        }
        System.out.println((char) (max1) + " 字符出现了 " + counts[max1] + " 次;");
        System.out.println((char) (max2) + " 数字出现了 " + counts[max2] + " 次;");

    }

    public static char[] toLowerCase(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 'A' && arr[i] < 'Z') {
                arr[i] = (char) (arr[i] + 'a' - 'A');
            }
        }
        return arr;
    }

    private static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private static boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

}
