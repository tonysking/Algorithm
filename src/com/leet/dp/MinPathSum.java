package com.leet.dp;

import org.junit.Assert;

/**
 * 64. 最小路径和
 */
public class MinPathSum {

    public int minPathSumDP(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];

        dp[1][1] = grid[0][0];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1) {
                    dp[i][j] = dp[i][j - 1] + grid[i - 1][j - 1];
                } else if (j == 1) {
                    dp[i][j] = dp[i - 1][j] + grid[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
                }
            }
        }


        return dp[m][n];
    }




    private int minPath = Integer.MAX_VALUE;
    private int m;
    private int n;
    private int[][] step = new int[][] {{0, 1}, {1, 0}};
    public int minPathSum(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        dfs(grid, 0, 0, 0);
        return minPath;
    }

    // 超时
    private void dfs(int[][] grid, int row, int col, int sum) {

        if(row >= 0 && row < m && col >= 0 && col < n) {
            sum += grid[row][col];
            if(row == m - 1 && col == n - 1) {
                minPath = Math.min(minPath, sum);
                return;
            }
            for(int i = 0; i < step.length; i++) {
                dfs(grid, row + step[i][0], col + step[i][1], sum);
            }
        }
    }

    public static void main(String[] args) {
        MinPathSum res = new MinPathSum();
        int[][] grid = new int[][] {{1, 3, 1},
                                    {1, 5, 1},
                                    {4, 2, 1}};
        Assert.assertEquals(7, res.minPathSum(grid));
        Assert.assertEquals(7, res.minPathSumDP(grid));
    }
}
