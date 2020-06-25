package com.leet.array;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 */
public class ThreeSumClosest {
    // 排序 + 双指针
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minSum = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = a + nums[l] + nums[r];
                if (Math.abs(sum - target) < minDiff) {
                    minDiff = Math.abs(sum - target);
                    minSum = sum;
                }
                if (sum >= target) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return minSum;
    }
}
