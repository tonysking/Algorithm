package com.leet.array;

import org.junit.Assert;

/**
 * 268. 缺失数字
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        boolean hasN = false;
        boolean hasZero = false;
        boolean hasZeroIndex = false;
        for(int i = 0; i < n; i++) {
            if(Math.abs(nums[i]) == n) {
                hasN = true;
                continue;
            }
            nums[Math.abs(nums[i])] = -nums[Math.abs(nums[i])];

            // 0特殊处理
            if(!hasZero && nums[i] == 0) {
                hasZero = true;
            }
            if(!hasZeroIndex && nums[Math.abs(nums[i])] == 0) {
                hasZeroIndex = true;
            }
        }
        if(!hasN) {
            return n;
        }
        if(!hasZero) {
            return 0;
        }
        for(int i = 0; i < n; i++) {
            if(nums[i] > 0 || !hasZeroIndex && nums[i] == 0) {
                return i;
            }
        }
        return n - 1;
    }

    public static void main(String[] args) {
        MissingNumber res = new MissingNumber();
        int i = res.missingNumber(new int[]{2,0});
        int e = res.missingNumber(new int[]{3,0,1});
        int f = res.missingNumber(new int[]{2,0,3});
        Assert.assertEquals(1, i);
        Assert.assertEquals(2, e);
        Assert.assertEquals(1, f);
    }
}
