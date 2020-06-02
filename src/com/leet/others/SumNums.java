package com.leet.others;

/**
 * 面试题64. 求1+2+…+n
 */
public class SumNums {
    // 逻辑运算符的短路
    public int sumNums(int n) {
        boolean flag =  n <= 0 || (n += sumNums(n - 1)) > 0;
        return n;
    }


    // 快速乘：加法和位运算模拟乘法
    int quickMulti(int A, int B) {
        int ans = 0;
        /* 手动循环
             boolean flag;
             flag = ((B & 1) > 0) && (ans += A) > 0;
             A <<= 1;
             B >>= 1;
         */
        for ( ; B > 0; B >>= 1) {
            if ((B & 1) > 0) {
                ans += A;
            }
            A <<= 1;
        }
        return ans;
    }

}
