package com.leet.dp;

public class ClimbStairs {
    public int climbStairs(int n) {
        if(n == 1 || n == 2) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public int climbStairs2(int n) {
        if(n == 1 || n == 2) {
            return n;
        }
        int[] climb = new int[n + 1];
        climb[1] = 1;
        climb[2] = 2;
        for (int i = 3; i <= n; i++) {
            climb[i] = climb[i - 1] + climb[i - 2];
        }
        return climb[n];
    }

    // 空间优化
    public int climbStairs3(int n) {
        if(n == 1 || n == 2) {
            return n;
        }
        int climb1 = 1;
        int climb2 = 2;
        int res = 0;
        for (int i = 3; i <= n; i++) {
            res = climb1 + climb2;
            climb1 = climb2;
            climb2 = res;
        }
        return res;
    }
}
