package com.hust.string;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 循环左移
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * S=”abcXYZdef”,循环左移3位，即“XYZdefabc”。
 */
public class LeftRotateString {
    public String LeftRotateString(String str,int n) {
        char[] chars = str.toCharArray();
        if (str == null || n < 0) {
            return null;
        }
        // ---
        if (n == 0 || str.length() == 0) {
            return str;
        }
        reverse(chars, 0, n - 1);
        reverse(chars, n, str.length()-1);
        reverse(chars, 0 ,str.length()-1);
        return new String(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        char tmp = 0;
        while (start < end) {
            tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            start++;
            end--;
        }
    }
}
