package com.leet.dp;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == '1') {
                    maxSide = Math.max(maxSide, 1);
                    int currentMaxside = Math.min(row - i, column - j);
                    for (int k = 1; k < currentMaxside; k++) {
                        boolean flag = true;
                        if (matrix[i + k][j + k] == '0') {
                            break;
                        }
                        for (int m = 0; m < k; m++) {
                            if (matrix[i + k][j + m] == '0' || matrix[i + m][j + k] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            maxSide = Math.max(maxSide, k + 1);
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return maxSide * maxSide;
    }

    public int maximalSquareDP(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        // dp[i][j]表示以(i, j)为右下角的正方形的最长边长
        int[][] dp = new int[row][column];
        int maxSide = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                }
                maxSide = Math.max(maxSide, dp[i][j]);
            }
        }
        return maxSide * maxSide;
    }

    // 优化空间
    // 每填一行只关心上一行，不再关心上上一行，即 「从上到下、逐行填写」
    // 由此可得优化 dp 为 「只留最新的一行」，即 dp[column]
    public int maximalSquareDPPlus(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int[] dp = new int[column];
        int maxSide = 0;
        // 保存左上角的值
        int corner;
        for (int i = 0; i < row; i++) {
            corner = 0;
            for (int j = 0; j < column; j++) {
                // 注意上次的左上角是如何保存的
                int lastCorner = dp[j];
                if (matrix[i][j] == '0') {
                    dp[j] = 0;
                } else {
                    if (i == 0 || j == 0) {
                        dp[j] = 1;
                    } else {
                        // Math.min中的dp[j - 1]为当前行左边，dp[j]为上一行该列的值
                        // 还差左上角的值（即之前的dp[i - 1][j - 1], 在计算dp[j - 1]的时候会被覆盖，所以单独保存）
                        dp[j] = Math.min(Math.min(dp[j - 1], dp[j]), corner) + 1;
                    }
                }
                corner = lastCorner;
                maxSide = Math.max(maxSide, dp[j]);
            }
        }
        return maxSide * maxSide;
    }

    public static void main(String[] args) {
        MaximalSquare res = new MaximalSquare();
        char[][] e = {{'1', '0', '1', '0'},
                     {'1', '0', '1', '1'},
                     {'1', '0', '1', '1'},
                     {'1', '1', '1', '1'}};

        System.out.println("------最大正方形面积： " + res.maximalSquare(e));
        System.out.println("------最大正方形面积： " + res.maximalSquareDPPlus(e));
    }

}
