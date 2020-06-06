package com.leet.array;

import java.util.Arrays;

/**
 * 面试题29. 顺时针打印矩阵
 */
public class SpiralOrder {
    int[] res;
    int cur;
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int i = 0;
        int j = 0;
        res = new int[row * col];
        cur = 0;
        while (i < row && j < col) {
            printMatrix(matrix, i++, j++, row--, col--);
        }
        return res;
    }

    private void printMatrix(int[][] matrix, int i, int j, int row, int col) {
        if (cur == res.length) {
            return;
        }
        for (int k = j; k < col; k++) {
            res[cur++] = matrix[i][k];
            System.out.println(matrix[i][k]);
        }
        if (cur == res.length) {
            return;
        }
        for (int k = i + 1; k < row; k++) {
            res[cur++] = matrix[k][col - 1];
            System.out.println(matrix[k][col - 1]);
        }

        if (cur == res.length) {
            return;
        }
        for (int k = col - 2; k >= j; k--) {
            res[cur++] = matrix[row - 1][k];
            System.out.println(matrix[row - 1][k]);
        }
        if (cur == res.length) {
            return;
        }
        for (int k = row - 2; k > i; k--) {
            res[cur++] = matrix[k][j];
            System.out.println(matrix[k][j]);
        }
    }

    public static void main(String[] args) {
        SpiralOrder result = new SpiralOrder();
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] matrix2 = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        int[] spiralOrder = result.spiralOrder(matrix2);
        Arrays.stream(spiralOrder).forEach(System.out::println);

    }
}
