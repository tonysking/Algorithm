package com.leet.array;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 */
public class Merge {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // num2 的 [srcPos, srcPos + n) 复制到 num1 的 [m 之后的位置
        System.arraycopy(nums2, 1, nums1, m, n);
        Arrays.sort(nums1);
    }

    // 空间O(1)
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        // two get pointers for nums1 and nums2
        int p1 = m - 1;
        int p2 = n - 1;
        // set pointer for nums1
        int p = m + n - 1;

        // while there are still elements to compare
        while ((p1 >= 0) && (p2 >= 0))
            // compare two elements from nums1 and nums2
            // and add the largest one in nums1
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];

        // add missing elements from nums2
        if(p2 >= 0) {
            System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
        }
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1,2,3,0,0,0};
        int[] num2 = new int[]{2,5,6};
        merge(num1, 3, num2, 3);

        Arrays.stream(num1).forEach(System.out::print);
    }
}
