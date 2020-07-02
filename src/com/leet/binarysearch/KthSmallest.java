package com.leet.binarysearch;

import java.util.Arrays;

/**
 * 378. 有序矩阵中第K小的元素
 */
public class KthSmallest {
    // 直接排序
    public int kthSmallestF(int[][] matrix, int k) {
        int n = matrix.length;
        int[] all = new int[n * n];
        int e = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                all[e++] = matrix[i][j];
            }
        }
        Arrays.sort(all);
        return all[k - 1];
    }

    // 二分查找
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int l = matrix[0][0];
        int r = matrix[n - 1][n - 1];
        while (l < r) {
            // 注意+右边的括号
            int mid  = l + ((r - l) >> 1);
            if (check(matrix, mid, k)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean check(int[][] matrix, int value, int k) {
        int n = matrix.length;
        int i = n - 1;
        int j = 0;
        int num = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= value) {
                j++;
                // 则将当前所在[列]的不大于 mid 的数的数量（即 i+1）累加到答案中
                num += i + 1;
            } else {
                i--;
            }
        }
        return num >= k;
    }
}
