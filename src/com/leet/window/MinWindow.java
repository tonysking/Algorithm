package com.leet.window;

import java.util.HashMap;
import java.util.Map;

public class MinWindow {
    public String minWindow(String s, String t) {
        char[] chars = s.toCharArray();
        char[] tchars = t.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> cnt = new HashMap<>();
        for (int i = 0; i < tchars.length; i++) {
            map.put(tchars[i], map.getOrDefault(tchars[i], 0) + 1);
        }

        int ansL = -1, ansR = -1;
        int l = 0, r = 0;
        int minLength = Integer.MAX_VALUE;
        while (r < chars.length) {
            // cnt记录s中和t中字符相等的数量
            if (map.containsKey(chars[r])) {
                cnt.put(chars[r], cnt.getOrDefault(chars[r], 0) + 1);
            }
            r++;
            // 若cnt和map中字符相等, 获取能够相等的最小长度
            while (check(map, cnt) && l <= r) {
                // 更新最小长度
                if (r - l + 1 < minLength) {
                    ansL = l;
                    ansR = r;
                    minLength = r - l + 1;

                }
                // 左指针右移
                if (map.containsKey(chars[l])) {
                    cnt.put(chars[l], cnt.getOrDefault(chars[l], 0) - 1);
                }
                l++;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR + 1);
    }

    private boolean check(Map<Character, Integer> map, Map<Character, Integer> mapt) {
        boolean res = true;
        try {
            map.forEach((k, v) -> {
                if (mapt.getOrDefault(k, 0) < v) {
                    throw new RuntimeException();
                }
            });
        } catch (Exception e) {
            res = false;
        }
        return res;
    }
}
