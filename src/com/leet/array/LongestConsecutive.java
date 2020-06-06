package com.leet.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 */
public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        // 保存num并去重
        for(int num : nums) {
            set.add(num);
        }

        int longest = 0;
        int curLongert = 0;

        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i] - 1)) {
                int curNum = nums[i];
                curLongert = 1;
                while (set.contains(curNum + 1)) {
                    curLongert++;
                    curNum += 1;
                }
                longest = Math.max(longest, curLongert);
            }
        }
        return longest;

    }
}
