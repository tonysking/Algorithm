package com.company.baidu;

/**
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 */
public class DuplicateNum {
    public int getDuplicateNum(int[] a) {
        int res = a[0];
        int count = 1;
        for (int i = 1; i < a.length; i++) {
            if(a[i] == res) {
                count++;
            } else {
                count--;
                if(count == 0) {
                    res = a[i];
                    count++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        DuplicateNum res = new DuplicateNum();
        int duplicateNum = res.getDuplicateNum(new int[]{1, 2, 1});
        System.out.println(duplicateNum);
    }
}
