package com.company.tencent;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 删除第i位数字剩下的中位数
 */
/*
6
1 2 3 4 5 6

4
4
4
3
3
3
 */
public class MediumNumAfterDeletei {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        a[n] = Integer.MAX_VALUE;

        int[] c = copyArray(a);
        Arrays.sort(c);
        int mediumLow = c[n / 2];
        int mediumHigh = c[(n - 1)/ 2];
        for (int i = 0; i < n; i++) {
            if(a[i] < mediumLow) {
                System.out.println(mediumLow);
            } else {
                System.out.println(mediumHigh);
            }
        }

//        printMediumForce(a, n);
    }

    private static void printMediumForce(int[] a, int n) {
        for (int i = 0; i < n; i++) {
            int[] b = copyArray(a);
            swap(b, i, n);
            Arrays.sort(b, 0, n);
            System.out.println(b[(n - 1) / 2]);
        }
    }

    private static int[] copyArray(int[] a) {
        int n = a.length;
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = a[i];
        }
        return b;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
