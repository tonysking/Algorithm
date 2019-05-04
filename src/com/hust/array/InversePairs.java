package com.hust.array;

/**
 * 逆序对
 * 注：测试部分采用了对数器
 */
public class InversePairs {
    public int InversePairs(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        return mergeSortInverse(array, 0, array.length - 1) % 1000000007;
    }

    private int mergeSortInverse(int[] array, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1); // 注意位运算优先级低于+-,需要加括号
        int left = mergeSortInverse(array, l, mid) % 1000000007;
        int right = mergeSortInverse(array, mid + 1, r) % 1000000007;
        return (mergeInverse(array, l, mid, r) + left + right) % 1000000007;
    }

    private int mergeInverse(int[] a, int l, int mid, int r) {
        int k = 0;
        int[] help = new int[r - l + 1]; // 辅助数组
        int res = 0; // 逆序对数
        int i = l;
        int j = mid + 1;

        while (i <= mid && j <= r) {
            if (a[i] <= a[j]) {
                help[k++] = a[i++];
            }
            if (a[i] > a[j]) {
                help[k++] = a[j++];
                res += mid - i + 1; // ---左边i位置数大于右边，则i之后的数都大于右边
                res = res % 1000000007;
            }

        }
        while (i <= mid) {
            help[k++] = a[i++];
        }
        while (j <= r) {
            help[k++] = a[j++];
        }
        // ---复制排序后的数组
        for (k = 0; k < help.length; k++) {
            a[l++] = help[k];
        }
        return res;
    }


    // 测试用
    public int InversePairs2(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        long res = 0;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[i]) {
                    res++;
                }
            }
        }
        return (int) (res % 1000000007);
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
    public static void main(String[] args) {


    }
}
