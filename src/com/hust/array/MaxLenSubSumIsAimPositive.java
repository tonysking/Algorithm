package com.hust.array;
/**
 * not online
 * 未排序【正数】数组 累加和为给定值 的最长子数组长度
 */
public class MaxLenSubSumIsAimPositive {
    public static int getMaxLength(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0) {
            return 0;
        }
        // 构建从left~right的和sum
        int left = 0;
        int right = 0;
        int sum = arr[0];
        int len = 0;
        while (right < arr.length) {
            if (sum < k) { // 小于时right右移
                right++;
                // ---防止数组下标越界
                if (right == arr.length) {
                    break;
                }
                sum += arr[right];
            } else if (sum > k) { // 大于时left右移
                sum -= arr[left];
                left++;
            } else { // 等于时更新最大长度len, left右移
                len = Math.max(len, right - left + 1);
                sum -= arr[left];
                left++;
            }
        }
        return len;
    }



    public static void main(String[] args) {
        int[] arr = {8,6,1,2,1,1,1};
        int k = 3;
        int maxLength = MaxLenSubSumIsAimPositive.getMaxLength(arr, k);
        System.out.println(maxLength);
    }
}
