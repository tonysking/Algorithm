package com.hust.string;

/**
 * 翻转单词
 * student. a am I
 * I am a student.
 */
public class ReverseSentence2 {
    public String ReverseSentence(String str) {
        if(str == null || "".equals(str.trim())) {
            return str;
        }

        char[] chars = str.toCharArray();
        // 先整体反转
        reverse(chars, 0 ,chars.length-1);
        // 再每个单词翻转
        int l = -1;
        int r = -1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                if (i == 0 || chars[i-1] == ' ') { // 更新单词左边界
                    l = i;
                }
                if (i == chars.length -1 || chars[i+1] == ' '){ // 更新单词右边界
                    r = i;
                }
            }
            if (l != -1 && r != -1) {
                reverse(chars, l, r);
                l = -1;
                r = -1;
            }
        }
        return String.valueOf(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        char temp = 0;
        while (start < end) {
            temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        ReverseSentence2 reverseSentence2 = new ReverseSentence2();
        String res = reverseSentence2.ReverseSentence("student. a am I");
        System.out.println(res);
    }

}
