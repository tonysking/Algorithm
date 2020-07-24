package com.leet.string;

import org.junit.Assert;

public class MyAtoi {

    private boolean isNegtive = false;
    private boolean isFirstNum = false;

    public int myAtoi(String str) {

        isNegtive = false;
        isFirstNum = false;

        char[] chars = str.trim().toCharArray();
        if (chars.length == 0) {
            return 0;
        }

        int res = 0;

        if (!isValid(chars[0])) {
            return 0;
        }

        if (isFirstNum) {
            res = chars[0] - '0';
        }

        for (int i = 1; i < chars.length; i++) {
            if (isNum(chars[i])) {
                if (res < Integer.MAX_VALUE / 10 ||
                res == Integer.MAX_VALUE / 10 && (chars[i] - '0' <= 7 || isNegtive && chars[i] - '0' <= 8)) {
                    res = res * 10 + chars[i] - '0';
                } else {
                    return isNegtive? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
            } else {
                break;
            }
        }

        if (isNegtive) {
            res = -res;
        }

        return res;
    }

    private boolean isValid(char c) {
        if (c == '-') {
            isNegtive = true;
            return true;
        }

        if (c == '+') {
            return true;
        }


        if (isNum(c)) {
            isFirstNum = true;
            return true;
        }
        return false;
    }


    private boolean isNum(char c) {
        int res = c - '0';
        if (res >= 0 && res <= 9) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MyAtoi res = new MyAtoi();
        Assert.assertEquals(42, res.myAtoi("42"));
        Assert.assertEquals(-2147483648, res.myAtoi("-91283472332"));
        Assert.assertEquals(2147483646, res.myAtoi("2147483646"));
    }

}
