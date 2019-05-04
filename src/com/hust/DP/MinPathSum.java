package com.hust.DP;

/**
 * 最小路径和
 * 只能向右或向下
 */
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] minSum = new int[row][col];

        minSum[0][0] = grid[0][0];
        // 第一列最小路径
        for (int i = 1; i < row; i++) {
            minSum[i][0] = minSum[i-1][0] + grid[i][0];
        }
        // 第一行最小路径
        for (int i = 1; i < col; i++) {
            minSum[0][i] = minSum[0][i - 1] + grid[0][i];
        }
        // 其他最小路径
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                // 最小路径 = 左边或上边的最小路径 + 当前路径值
                minSum[i][j] = Math.min(minSum[i][j-1], minSum[i-1][j]) + grid[i][j];
            }
        }
        return minSum[row-1][col-1];
    }
}
