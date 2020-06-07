package com.leet.array;

import java.util.Arrays;

/**
 * 238. 除自身以外数组的乘积
 */
public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] l = new int[n];
        int[] r = new int[n];
        l[0] = 1;
        for (int i = 1; i < n; i++) {
            l[i] = l[i - 1] * nums[i - 1];
        }
        r[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            r[i] = r[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < n; i++) {
            res[i] = l[i] * r[i];
        }
        return res;
    }

    // 优化空间
    public int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        // 先把输出数组当作 L 数组来计算
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int r = 1;
        for (int i = n - 2; i >= 0; i--) {
            r = r * nums[i + 1];
            res[i] = res[i] * r;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        ProductExceptSelf res = new ProductExceptSelf();
        Arrays.stream(res.productExceptSelf(nums)).forEach(System.out::println);
        Arrays.stream(res.productExceptSelf2(nums)).forEach(System.out::println);
    }
}
