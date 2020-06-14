package com.leet.array;

import java.util.*;

/**
 * 15. 三数之和
 */
public class ThreeSum {

    /**
     *  先排序
     *  三重循环中：
     *  枚举的三元组 (a,b,c) 满足 a≤b≤c, 减少了重复
     *  从小到大枚举 b，同时从大到小枚举 c，即第二重循环和第三重循环实际上是并列的关系。（O(N3) -> O(N2)）
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去重
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (sum == 0) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    left++;
                    right--;
                    // 去重
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }









    // 要求数组中任意3个数，该方法只能求连续3个
    public List<List<Integer>> threeSumContinuous(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        int n = nums.length;
        int[] sums = new int[n];
        sums[0] = nums[0];
        // sum -> i
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        map.put(sums[0], 0);
        for (int i = 1; i < n; i++) {
            sums[i] = sums[i - 1] + nums[i];
            Integer preSum = map.getOrDefault(sums[i], i);
            // 只能求出连续3个数之和为0的情况
            if (preSum != i && i - preSum == 3) {
                List<Integer> threeSum = new ArrayList<>(3);
                for (int j = preSum + 1; j <= i; j++) {
                    threeSum.add(nums[j]);
                }
                res.add(threeSum);
            }

        }
        return res;

    }
}
