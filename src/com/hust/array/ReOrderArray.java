package com.hust.array;

/**
 * 调整数组顺序使奇数位于偶数前面
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {
    public void reOrderArray(int [] array) {
        int n = array.length;
        int[][] buc = new int[2][n];
        int o = 0; // 奇数下标
        int e = 0; // 偶数下标
        // 分别放入桶中
        for (int i = 0; i < n; i++) {
            if (array[i] % 2 == 1) {
                buc[0][o++] = array[i];
            } else {
                buc[1][e++] = array[i];
            }
        }

        printArray(buc[0]);
        printArray(buc[1]);
        // 拷贝到原数组
        int i = 0;
        while (i != o) {
            array[i] = buc[0][i++]; // ---注意两边用同一变量只能加一次，且i++在=前面会出错，最好单独写
        }
        int j = 0;
        while (j != e) {
            array[i++] = buc[1][j++];
        }
    }

    // 注：亦可用冒泡排序法，每次把相邻奇偶交换，时间复杂度较高


    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ReOrderArray reOrderArray = new ReOrderArray();
        int[] a = {1,2,3,4,5,6,7};
        reOrderArray.reOrderArray(a);
        printArray(a);

    }
}
