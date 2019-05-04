package com.hust.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)
 * 中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）
 */
public class FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        if (str == null) {
            return -1;
        }
        int first = -1;
        Map<Character,Boolean> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {

                map.put(c,true); // 重复出现为true
            } else {

                map.put(c,false);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!map.get(c)) {
                first = i;
                break;
            }
        }

        return first;
    }

    // 直接统计字符出现的次数--字符占用一个字节，故只需创建256大小的数组
    public int FirstNotRepeatingChar2(String str) {
        if (str == null || str.length()==0) {
            return -1;
        }
        int first = -1;
        int[] map = new int[256];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            map[c]++; // 计数
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map[c] == 1) {
                first = i;
                break;
            }
        }


        return first;
    }
}
