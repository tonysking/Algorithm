package com.hust.array;

import java.util.HashMap;

/**
 * not online
 * 未排序数组 累加和为给定值 的最长子数组长度
 */
public class MaxLenSubSumIsAim {
    public int maxLength(int[] a, int k) {
        if (a == null || a.length == 0) {
            return 0;
        }
        int sum = 0;
        int maxlen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if (map.containsKey(sum - k)) {
                maxlen = Math.max(i - map.get(sum-k), maxlen);
            } else {
                map.put(sum, i);
            }
        }
        return maxlen;
    }
}
