package com.hust.string;

/**
 * 翻转单词
 * student. a am I
 * I am a student.
 */
public class ReverseSentence {
    public String ReverseSentence(String str) {
        if (str == null) {
            return null;
        }
        //---
        if ("".equals(str.trim())) {
            return str;
        }
        String[] split = str.split(" ");
        StringBuilder sb = new StringBuilder();
        boolean isLast = false;
        for (int i = split.length-1; i > -1; i--) {
            if (i == 0) {
                isLast = true;
            }
            sb.append(split[i]);
            if (!isLast) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
