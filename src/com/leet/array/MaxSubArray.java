package com.leet.array;

public class MaxSubArray {
  public int maxSubArray(int[] nums) {
    // maxSum[i]代表【以nums[i]结尾的连续子数组的最大和】
    int[] maxSum = new int[nums.length];

    maxSum[0] = nums[0];
    int max = maxSum[0];

    for (int i = 1; i < nums.length; i++) {
      maxSum[i] = Math.max(nums[i], maxSum[i - 1] + nums[i]);
      if (maxSum[i] > max) {
        max = maxSum[i];
      }
    }
    return max;
  }

  // maxSum[i]只与前一个状态maxSum[i - 1]有关，故只保留前一个值即可,故可优化空间
  public int maxSubArray2(int[] nums) {

    int curMax = 0;
    int max = nums[0];

    for (int i = 0; i < nums.length; i++) {
      // maxSum[i] = Math.max(nums[i], maxSum[i - 1] + nums[i]);
      curMax = Math.max(nums[i], curMax + nums[i]);
      max = Math.max(max, curMax);
    }
    return max;
  }
}
