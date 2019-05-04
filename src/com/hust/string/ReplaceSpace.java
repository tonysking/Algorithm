package com.hust.string;

/**
 * 将一个字符串中的每个空格替换成“%20”
 */
public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        String s = str.toString();
        String replace = s.replace(" ", "%20");
        return replace;
    }
}
