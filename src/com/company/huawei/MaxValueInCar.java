package com.company.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * 空间最大情况下总价值最大
 * 输入：
 * 空间
 * 箱子个数
 * 尺寸
 * 价值
 *
 * 9
 * 5
 * 2 2 4 6 3
 * 3 4 8 9 6
 *
 * 18
 * ( 2  4  3) 重量 9
 * ( 4  8  6) 价值 18
 *
 * 36%
 *
 * 思路：
 * 求上界，再做装满的01背包
 */
/*
9
5
2 2 4 6 3
3 4 8 9 6
 */
public class MaxValueInCar {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int[] w = new int[n];
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            v[i] = sc.nextInt();
        }
        k = 10;
        getMaxWeightDFS(w, k, n, 0, 0);
        System.out.println(n + "个物品放入容量为" + k + "的空间");
        System.out.println("能达到的最大重量：" + maxWeight);
//        System.out.println(getMaxWeight(w, k, n));
        System.out.println("装满时最大价值：" + getFullMaxValue(w, v, k, n));
        System.out.println("最大价值：" +getMaxValue(w, v, k, n));
    }

    private static int maxWeight = 0;
    private static void getMaxWeightDFS(int[] w, int k, int n, int index, int curW) {
        if(index == n) {
            if(curW <= k) {
                maxWeight = Math.max(curW, maxWeight);
            }
            return;
        }
        if(curW <= k) {
            getMaxWeightDFS(w, k, n, index + 1, curW + w[index]);
            getMaxWeightDFS(w, k, n, index + 1, curW);
        }
    }

    /*private static int getMaxWeight(int[] w, int k, int n) {
        int[] maxW = new int[k + 1];
        Arrays.fill(maxW, -1);
        maxW[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = w[i]; j <= k; j++) {
                if(maxW[j - w[i]] != -1) {
                    maxW[j] = Math.max(maxW[j - 1], maxW[j - w[i]] + w[i]);
                }
            }
        }

        return maxW[k];
    }*/

    // 装满的01背包
    private static int getFullMaxValue(int[] w, int[] v, int k, int n) {
        int[][] fullMax = new int[n + 1][k + 1];
        // 初始化为-1, 表示不可装满, 最大价值无意义
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                fullMax[i][j] = -1;
            }
        }
        // 初始化空间为0时, 无法装物品, 最大价值为0
        for (int i = 0; i <= n ; i++) {
            fullMax[i][0] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if(j >= w[i - 1] && fullMax[i - 1][j - w[i - 1]] != -1) {
                    fullMax[i][j] = Math.max(fullMax[i - 1][j], fullMax[i - 1][j - w[i - 1]] + v[i - 1]);
                } else {
                    fullMax[i][j] = fullMax[i - 1][j];
                }
            }
        }
        return fullMax[n][k];
    }

    // 普通01背包
    private static int getMaxValue(int[] w, int[] v, int k, int n) {

        int[][] maxV2 = new int[k + 1][n + 1];

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                if(i - w[j - 1] >= 0) {
                    // 当时------------------------------------------------------> 未写成j - 1
                    // maxV2[i][j] = Math.max(maxV2[i][j - 1], maxV2[i - w[j - 1]][j] + v[j - 1]);
                    maxV2[i][j] = Math.max(maxV2[i][j - 1], maxV2[i - w[j - 1]][j - 1] + v[j - 1]);
                } else {
                    maxV2[i][j] = maxV2[i][j - 1];
                }
            }
        }

        return maxV2[k][n];
    }
}
