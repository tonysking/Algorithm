package com.leet.dp;

import java.util.Arrays;

/**
 * 1300. 转变数组后最接近目标值的数组和
 * 返回一个整数 value ，使得将数组中所有大于 value 的值变成 value 后，数组的和最接近  target （最接近表示两者之差的绝对值最小）。
 *
 *  如果有多种使得和最接近 target 的方案，返回这些整数中的最小值。
 *
 *  value 的下界为 0(和为0),上界为数组 arr 中的最大值(和不变)
 */
public class FindBestValue {
    // 枚举 + 二分查找
    // 当枚举到 value = x时（arr[i] >= x）, 时数组的和变为:  arr[0]+...+arr[i−1]+x∗(n−i)
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;
        // 预处理出数组 arr 的前缀和，这样数组求和的时间复杂度即能降为 O(1)
        // 注：前缀和数组下标加1, 为了之后直接调prefix[index]（否则调prefix[index - 1]会越界）
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + arr[i - 1];
        }

        // value为0时, diff = target
        int ans = 0;
        int diff = target;
        int r = arr[n - 1];
        for (int i = 1; i <= r; i++) {
            // 注：找不到则返回 (-(insertion point) - 1)
            int index = Arrays.binarySearch(arr, i);
            if (index < 0) {
                index = -index - 1;
            }
            int cur = prefix[index] + i * (n - index);
            if (Math.abs(cur - target) < diff) {
                diff = Math.abs(cur - target);
                ans = i;
            }
        }
        return ans;

    }
}
