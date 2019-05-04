package com.hust.sort.MySort;

import java.util.Arrays;
import java.util.Timer;

public class MyQuickSort {
    public static void quickSort(int[] a) {
        if (a == null || a.length < 2) {
            return;
        }
        quickSort(a, 0, a.length-1);
    }

    public static void quickSort(int[] a, int l, int r) {
        if (l < r) {
            int[] par = partion(a, l, r);
            quickSort(a, l, par[0]);
            quickSort(a, par[1], r);
        }
    }

    private static int[] partion(int[] a, int l, int r) {
        // 随机快排
//        swap(a, l + (int) (Math.random()*(r - l + 1)), r);
        int num = a[r];
        int less = l - 1;
        int more = r + 1;
        int cur = l;
        while (cur < more) {
            if (a[cur] < num) {
                swap(a, cur, ++less); // ---不能只写成less+1,忘记增加less自身的大小
                cur++;
            } else if (a[cur] == num) {
                cur++;
            } else {
                swap(a, cur, --more); // ---不能只写成more-1,忘记减少more自身的大小
            }
        }
        // 返回小于区域和大于区域的位置
        return new int[] {less, more};


    }
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }



    // 测试
    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

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

    // for test
    public static void main(String[] args) {
        int testTime = 60000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;

        long mySortTime = 0;
        long compareTime = 0;

        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            // 计算测试算法时间
            long start1 = System.currentTimeMillis();
            quickSort(arr1);
            long end1 = System.currentTimeMillis();
            mySortTime += end1 - start1;
            // 计算比对算法时间
            long start2 = System.currentTimeMillis();
            comparator(arr2);
            long end2 = System.currentTimeMillis();
            compareTime += end2 - start2;
            // 判断算法是否正确
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
        System.out.println("我的算法执行时间："+mySortTime+"ms");
        System.out.println("系统算法执行时间："+compareTime+"ms");


        System.out.println("-------------------------单次测试");
        // 单次测试
        int[] arr = generateRandomArray(maxSize, maxValue);
        System.out.println("原数组：");
        printArray(arr);
        int[] partion = partion(arr, 0, arr.length - 1);
        System.out.print("partion一次后数组：");
        System.out.println("小于区域："+partion[0]+"大于区域："+partion[1]);
        printArray(arr);
        quickSort(arr);
        System.out.println("排序后数组：");
        printArray(arr);

    }
}
