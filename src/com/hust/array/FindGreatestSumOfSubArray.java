package com.hust.array;

/**
 * 连续子数组的最大和
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 */
public class FindGreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        int cur = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            cur += array[i];
            max = Math.max(max, cur);
            if (cur < 0) { // ---更新max之后再更新cur
                cur = 0;
            }
        }
        return max;
    }
}
