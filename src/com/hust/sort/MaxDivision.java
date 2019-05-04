package com.hust.sort;

public class MaxDivision {
    public int findMaxDivision(int[] A, int n) {
        if (A == null || n < 2 ) {
            return 0;
        }
        // 获取全局最大最小值
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, A[i]);
            max = Math.max(max, A[i]);
        }

        // 获取每个桶内的最大最小值
        boolean[] hasNum = new boolean[n + 1];
        int[] mins = new int[n + 1];
        int[] maxs = new int[n + 1];
        int bid = 0; // 桶号
        for (int i = 0; i < n; i++) {
            bid = bucket(A[i], n, min, max);
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], A[i]) : A[i];
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], A[i]) : A[i];
            hasNum[bid] = true;
        }

        // 计算相邻最大差值
        int res = 0;
        int lastMax = maxs[0]; // 前一个桶的最大值
        for (int i = 1; i <= n; i++) {
            if (hasNum[i]) {
                // 有空桶，所以不能直接 Math.max(res, mins[i] - maxs[i-1])
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;

    }

    private int bucket(long num, long n, long min, long max) {
        return (int) ((num - min) * n / (max - min));
    }
}
