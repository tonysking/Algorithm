package com.company.dianxin;

import java.util.Scanner;

/**
 *挑选数字使和最大，要求挑选的值不能相邻
 */
/*
1,2,3,4,5
9
 */
public class MaxSumNotNear {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        String s = sc.nextLine();
        String[] a = s.split(",");
        int n = a.length;
        int[] anum = new int[n];
        for (int i = 0; i < n; i++) {
            anum[i] = Integer.parseInt(a[i]);
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = anum[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + anum[i - 1]);
        }
        System.out.println(dp[n]);

    }
}
