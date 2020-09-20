package com.leet.string;

import org.junit.Assert;

/**
 * 151. 翻转字符串里的单词
 */
public class ReverseWords {
    public String reverseWords(String s) {
        char[] chars = s.trim().toCharArray();
        int n = chars.length;
        StringBuilder sb = new StringBuilder();
        int start = 0;
        reverse(chars, 0, n - 1);
        int i = 0;
        while (i < n) {
            if(i == n - 1 || chars[i + 1] == ' ') {
                sb.append(reverse(chars, start, i));
                sb.append(' ');
                i++;
                while(i < n && chars[i] == ' ') {
                    i++;
                }
                start = i;
            } else {
                i++;
            }
        }
        return sb.toString().trim();
    }

    public String reverse(char[] chars, int start, int end) {
        int i = start;
        int j = end;
        while(start < end) {
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            start++;
            end--;
        }
        return new String(chars, i, j - i + 1);
    }

    public static void main(String[] args) {
        ReverseWords res = new ReverseWords();
        String words = res.reverseWords("the sky is  blue");
        System.out.println(words);

        Assert.assertEquals("example good a", res.reverseWords("a good  example"));

        String reverse = res.reverse(new char[]{'b', 'l', 'u', 'e'}, 0, 3);
        System.out.println(reverse);
    }
}
