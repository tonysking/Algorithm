package com.hust.DP;
/**
 * 机器人到达右下角有多少路径
 * 只能向右或向下
 * 动态规划解法
 */
public class UniquePathsDP {
    // 空间O(m * n)
    public int uniquePaths(int m, int n) {

        int dp[][] = new int[m][n];

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }

        }
        return dp[m-1][n-1];
    }
    // 优化--空间O(min{m, n})
    public int uniquePathsBetter(int m, int n) {
        if (m < n) {
            return uniquePathsBetter(n, m);
        }
        int[] arr = new int[n];
        // 第一行都只有一种路径
        for (int i = 0; i < n; i++) {
            arr[i] = 1;
        }
        // 从第二行开始滚动更新
        for (int i = 1; i < m; i++) {
//            arr[0] = 1; // 由于第一列也都只有一种路径 所以此处滚动到下一行时不用更新arr[0]的数据
            for (int j = 1; j < n; j++) {

                arr[j] = arr[j-1] + arr[j];
            }
        }
        return arr[n-1];
    }
}
