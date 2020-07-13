package com.leet.string;

/**
 * 415. 字符串相加
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {

        StringBuilder ans = new StringBuilder();

        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();

        int n1 = chars1.length;
        int n2 = chars2.length;

        int n = Math.max(n1, n2);

        int carry = 0;

        int add1, add2;
        for (int i = 0; i < n; i++) {
            add1 = i < n1 ? chars1[n1 - i - 1] - '0' : 0;
            add2 = i < n2 ? chars2[n2 - i - 1] - '0' : 0;

            carry += add1 + add2;
            // 注意（）和转换
            ans.append((char) (carry % 10 + '0'));
            carry /= 10;
        }

        if (carry > 0) {
            ans.append('1');
        }
        ans.reverse();
        return ans.toString();
    }

    public static void main(String[] args) {
        AddStrings res = new AddStrings();
        String s = res.addStrings("0", "0");
        System.out.println(s);
    }
}
