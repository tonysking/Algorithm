package com.interview.num;

import org.junit.Assert;

import java.util.Arrays;

/**
 * bytedance
 * 31. 下一个排列
 */
public class NextMaxNum {
    public int nextMax(int num) {
        // 由高位到低位
        int[] nums = getNumArray(num);

        // 保存大于高位的最低位
        int[] map = new int[nums.length];

        int maxHigh = 0;

        boolean flag = false;
        // 从低位到高位遍历
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                // 低位大于高位
                if (nums[i] > nums[j]) {
                    // 保存最低位(即第一次出现大于高位j的低位i)
                    map[j] = map[j] == 0 ? i : map[j];
                    // 寻找最低的高位
                    maxHigh = Math.max(maxHigh, j);
                    flag = true;
                    break;
                }
            }
        }

        if(flag) {
            swap(nums, map[maxHigh], maxHigh);
            Arrays.sort(nums, maxHigh + 1, nums.length);
        } else {
            Arrays.sort(nums);
        }

        return getArrayNum(nums);
    }


    private int[] getNumArray(int num) {
        int n = 0;
        int cur = num;
        while(cur > 0) {
            cur /= 10;
            n++;
        }

        int[] nums = new int[n];
        int k = n - 1;
        cur = num;
        while(cur > 0) {
            nums[k--] = cur % 10;
            cur /= 10;
        }
        return nums;
    }

    private int getArrayNum(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = res * 10 + nums[i];
        }
        return res;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        NextMaxNum res = new NextMaxNum();
        Assert.assertEquals(res.nextMax(1234), 1243);
        Assert.assertEquals(res.nextMax(1243), 1324);
        Assert.assertEquals(res.nextMax(231), 312);
        Assert.assertEquals(res.nextMax(4202320), 4203022);
    }
}
