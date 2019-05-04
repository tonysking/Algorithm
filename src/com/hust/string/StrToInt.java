package com.hust.string;

/**
 * 输入一个字符串,包括数字字母符号,可以为空
 * 如果是合法的数值表达则返回该数字，否则返回0
 */
public class StrToInt {
    public int StrToInt(String str) {
        // --- 边界
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] chas = str.toCharArray();
        if (!isValid(chas)) {
            return 0;
        }
        Boolean posi = chas[0] == '-' ? true : false; // 是否是负数
        int maxq = Integer.MAX_VALUE / 10; // 最大商
        // ---最大余数 ( 注意最大int:2147483647 最小int: -2147483648)
        int maxr = posi ? Integer.MAX_VALUE % 10 + 1 : Integer.MAX_VALUE % 10;
        int res = 0;
        int cur = 0;
        int i = chas[0] == '-' || chas[0] == '+' ? 1 : 0;
        for (; i < chas.length; i++) {
            cur = chas[i] - '0';
            // 超过界限
            if (res > maxq || (res == maxq && cur > maxr)) {
                return 0;
            }
            res = res * 10 + cur;
        }
        return posi ? -res : res;
    }

    private boolean isValid(char[] chas) {

        /*
            检查首字符
         */
        // 首字符非 - + 数字
        if (chas[0] != '-' && chas[0]!= '+' && (chas[0] < '0' || chas[0] > '9') ) {
            return false;
        }
        // 只有 - +
        if ((chas[0] == '-' || chas[0] == '+') && chas.length == 1) {
            return false;
        }
        /*
            检查后续字符
         */
        for (int i = 1; i < chas.length; i++) {
            if (chas[i] < '0' || chas[i] > '9') {
                return false;
            }
        }
        return true;

    }
}
