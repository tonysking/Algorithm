package com.leet.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 739. 每日温度
 * 单调栈（递减）
 */
public class DailyTemperatures {

    // 单调栈
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                Integer idx = stack.pop();
                res[idx] = i - idx;
            }
            stack.push(i);
        }
        return res;
    }



    // 反向遍历
    // 遍历到温度列表中的每个元素时都会更新数组 next 中的对应温度的元素值，
    // 对于任意 t，当 next[t] 不为无穷大时，令 j = next[t]，
    //  ------注：遍历找j的最小值
    // 则 j 是满足 T[j] == t 且 i < j 的最小下标。
    public int[] dailyTemperaturesF(int[] T) {
        int n = T.length;
        int[] next = new int[101];
        int[] ans = new int[n];
        Arrays.fill(next, Integer.MAX_VALUE);

        for (int i = n - 1; i >= 0; i--) {
            int warmerIndex = Integer.MAX_VALUE;
            for (int j = T[i] + 1; j <= 100; j++) {
                // 更新warmerIndex的最小值
                if (next[j] < warmerIndex) {
                    warmerIndex = next[j];
                }
            }
            if (warmerIndex < Integer.MAX_VALUE) {
                ans[i] = warmerIndex - i;
            }

            next[T[i]] = i;
        }

        return ans;
    }
}
