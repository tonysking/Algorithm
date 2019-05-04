package com.hust.bit;

/**
 * 二进制中1的个数
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class NumberOf1 {
    // 循环次数等于 n 的位数
    public int NumberOf1(int n) {
        int res = 0;
        while (n != 0) { // --- 循环条件是 != 0
            res += n & 1 ;
            n >>>= 1;
        }
        return res;
    }

    // ---优化：循环次数等于 n中 1 的个数
    // 每次抹掉最右边的1，循环的次数即1的个数 eg: n:100 n-1:011 &后得：000
    public int NumberOf1_2(int n) {
        int res = 0;
        while (n != 0) { // --- 循环条件是 != 0
            n &= (n - 1);
            res ++;
        }
        return res;
    }
}
