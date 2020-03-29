package com.hust.other;

/**
 * 整数中1出现的次数（从1到n整数中1出现的次数）
 * eg:1~13的整数中1出现的次数:有1、10、11、12、13因此共出现6次
 */
public class NumberOf1Between1AndN_Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int num = i; // ---直接用i进入循环 会使i的值结束while后都为0 成为死循环
            while (num != 0) {
                if (num % 10 == 1) {
                    count++;
                }
                num /= 10;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOf1Between1AndN_Solution s = new NumberOf1Between1AndN_Solution();
        int count = s.NumberOf1Between1AndN_Solution(13);
        System.out.println("暴力："+count);
    }
}
