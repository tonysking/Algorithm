package com.leet.array;

public class MaxProduct {
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        // 不要纠结正负, 直接最大最小
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        max[0] = nums[0];
        min[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max[i] = Math.max(max[i - 1] * nums[i], Math.max(nums[i], min[i - 1] * nums[i]));
            min[i] = Math.min(min[i - 1] * nums[i], Math.min(nums[i], max[i - 1] * nums[i]));
            ans = Math.max(ans, max[i]);
        }
        ans = Math.max(ans, max[0]);
        return ans;
    }

    public static void main(String[] args) {
        MaxProduct res = new MaxProduct();
        int[] a = new int[]{-2, 3, -4};
        int[] b = new int[]{2, 3, -2, -4};
        int[] c = new int[]{-2};
        int maxProduct = res.maxProduct(a);
        int maxProductb = res.maxProduct(b);
        int maxProductc = res.maxProduct(c);
        System.out.println(maxProduct);
        System.out.println(maxProductb);
        System.out.println(maxProductc);
    }
}
