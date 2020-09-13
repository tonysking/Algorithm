package com.company.huawei.paper;

import org.junit.Assert;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 205.同构字符串
 */
public class IsIsomorphic {
    public static boolean isIsomorphic(String s, String t) {
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        HashSet<Character> set = new HashSet<>();
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < chars1.length; i++) {
            if (map.containsKey(chars1[i])) {
                if (chars2[i] != map.get(chars1[i])) {
                    return false;
                }
            } else {
                // 需要判断被替换后的字符是否已经用过
                if(set.contains(chars2[i])) {
                    return false;
                }
                map.put(chars1[i], chars2[i]);
                set.add(chars2[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Assert.assertFalse(isIsomorphic("egg", "ddd"));
        Assert.assertFalse(isIsomorphic("foo", "bar"));
        Assert.assertTrue(isIsomorphic("paper", "title"));
    }
}
