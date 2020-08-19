package com.leet.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 349. 两个数组的交集
 */
public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        for(int i = 0; i < nums2.length; i++) {
            if(!set.contains(nums2[i])) {
                set.remove(nums2[i]);
            }
        }
        int[] res = new int[set.size()];
        int k = 0;
        for(Integer n : set) {
            res[k++] = n;
        }
//        int[] res = set.stream().mapToInt(n -> n.intValue()).toArray();
        return res;
    }
}
