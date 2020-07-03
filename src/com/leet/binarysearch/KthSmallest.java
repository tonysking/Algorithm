package com.leet.binarysearch;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

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

    // 最小堆(归并)
    public int kthSmallestHeap(int[][] matrix, int k) {
        int n = matrix.length;
        // int[]{当前数字，行，列}
        Queue<int[]> q = new PriorityQueue<>(Comparator.comparing(a -> a[0]));

        // 将第一列放入堆中
        for (int i = 0; i < n; i++) {
            q.offer(new int[]{matrix[i][0], i ,0});
        }

        // 获得最小堆中的前k - 1个数
        for (int i = 0; i < k - 1; i++) {
            int[] min = q.poll();
            // 若当前最小值所在行还未取尽，将右边的数加入堆中
            if (min[2] != n - 1) {
                int minRow = min[1];
                int minCol = min[2];
                q.offer(new int[]{matrix[minRow][minCol + 1], minRow, minCol + 1});
            }
        }
        return q.poll()[0];
    }
}
