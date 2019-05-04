package com.hust.bigdata;

/**
 *  长度为m的bit类型数组
 */
public class BitArray {
    public static void main(String[] args) {
        // 1000大小的int数组可表示32000大小bit数组
        int[] arr = new int[1000];

        // eg: 将30000位置对应的位赋1
        int index = 30000;
        int intIndex = 30000 / 32; // 获取对应的整数下标
        int bitIndex = 30000 % 32; // 获取对应整数的对应位
        arr[intIndex] = (arr[intIndex] | 1 << bitIndex); // 位或赋值
    }
}
