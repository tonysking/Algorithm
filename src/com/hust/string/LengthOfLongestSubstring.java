package com.hust.string;

import java.util.HashMap;

/**
 * longest-substring-without-repeating-characters
 * 最长无重复字符字串
 */
public class LengthOfLongestSubstring {
    // 滑动窗口，每次向右滑动得到 【以当前字符结尾的】 最长无重复字串 的【开始位置】
    public int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0; // 窗口开始位置
        int max = 0; // 最大长度
        for (int i = 0; i < s.length(); i++) {
            char chas = s.charAt(i);
            // --- 窗口开始位置 必须是两者的【最大值】，否则若map[chas]在start的左边，会从map[chas]开始算起导致错误
            start = Math.max(start, map.containsKey(chas) ? map.get(chas)+1 : -1);
            max = Math.max(max, i - start + 1);
            map.put(chas, i); // 保存字符chas【最近一次】出现的位置
        }
        return max;
    }


    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        // --- 如遍历到最后一个b时 map[b] == 0, start == 2 ,则应从较大的start开始
        //                              b   a   c   a  b
        int maxLen = lengthOfLongestSubstring.lengthOfLongestSubstring("bacab");
        System.out.println(maxLen);
    }
}
