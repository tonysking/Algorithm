package com.leet.array;

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) {
            int[] tmp = nums2;
            nums2 = nums1;
            nums1 = tmp;

        }
        int len1 = nums1.length;
        int len2 = nums2.length;

        // 奇偶
        boolean isEven = (len1 + len2) % 2 == 0;

        int mid = (len1 + len2) / 2;
        int l1 = 0, l2 = 0;
        int median = -1, medianLeft = -1;
        int k = 0;
        while (l1 + l2 <= mid && l1 < len1 && l2 < len2) {
            // medianLeft保存前一个结果，写到循环末尾会失败
            medianLeft = median;
            if (nums1[l1] <= nums2[l2]) {
                median = nums1[l1];
                l1++;
            } else {
                median = nums2[l2];
                l2++;
            }
            k++;
        }

        while (k++ <= mid) {
            medianLeft = median;
            if (l1 == len1) {
                median = nums2[l2++];
            } else if (l2 == len2) {
                median = nums1[l1++];
            }
        }

        return isEven ? (median + medianLeft) / 2.0 : median;
    }

    public static void main(String[] args) {
        FindMedianSortedArrays res = new FindMedianSortedArrays();
        int[] s1 = new int[]{1, 3};
        int[] s2 = new int[]{2};
        int[] s3 = new int[]{1, 2};
        int[] s4 = new int[]{3, 4};
        int[] s5 = new int[]{};
        int[] s6 = new int[]{2, 3};
        int[] s7 = new int[]{0, 0};
        int[] s8 = new int[]{0, 0};
        int[] s9 = new int[]{100001};
        int[] s10 = new int[]{100000};
        int[] s11 = new int[]{1, 2};
        int[] s12 = new int[]{-1, 3};
        double median = res.findMedianSortedArrays(s1, s2);
        double median2 = res.findMedianSortedArrays(s3, s4);
        double median3 = res.findMedianSortedArrays(s5, s6);
        double median4 = res.findMedianSortedArrays(s7, s8);
        double median5 = res.findMedianSortedArrays(s9, s10);
        double median6 = res.findMedianSortedArrays(s11, s12);
        System.out.println(median);
        System.out.println(median2);
        System.out.println(median3);
        System.out.println(median4);
        System.out.println(median5);
        System.out.println(median6);
    }
}
