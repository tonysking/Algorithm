package com.hust.bytedance;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 字节跳动2019夏令营笔试题第一轮
 * 编程1
 * 给定一个数组，求ai＋aj＋i-j的最大值（j＞i）要求时间复杂度＜n²
 */
public class MaxPoint {
    private static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        int[] a = {11, 6, 5, 18, 12};
        System.out.println(maxPoint(a, 5));


//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] ai = new int[1000];
//        int x;
//        for(int i = 0; i < n; i++){
//                x = sc.nextInt();
//                ai[i] = x;
//        }
//        System.out.println(maxPoint(ai, n));
    }

    public static int maxPoint(int[] a, int n) {
        if (n == 2) {
            return a[1] + a[0] - 1;
        }
        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            int preMax = 0;
            if (!map.containsKey(n - 1)) {
                preMax = maxPoint(a, n - 1);
                map.put(n - 1, preMax);
            } else {
                preMax = map.get(n - 1);
            }
            int cur = a[n - 1] + a[i] + i - n + 1;
            if (cur > preMax) {
                max = cur;
            } else {
                max = preMax;
            }
        }
        return max;
    }

}
