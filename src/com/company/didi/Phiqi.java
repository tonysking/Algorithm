package com.company.didi;

import java.util.Scanner;
import java.util.Stack;

/**
 * 100%
 */
public class Phiqi {

    static int[][] step = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static long[][] a;
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        if(n == 1) {
            System.out.println(1);
        } else {
            a = new long[n][n];
            Stack<Long> stack = new Stack<>();
            getPhiqi(n, stack);
            getPhiqiArray(a, n, stack);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(a[i][j]);
                    System.out.print(" ");
                }
                System.out.println();
            }
        }
    }

    private static void getPhiqi(int n, Stack<Long> stack) {
        long i = 1;
        long j = 1;
        stack.push(i);
        stack.push(j);
        long cur = 0;
        for (int k = 0; k < n * n - 2; k++) {
            cur = i + j;
            i = j;
            j = cur;
            stack.push(cur);
            System.out.println(cur);
        }
    }

    private static void getPhiqiArray(long[][] a, int n, Stack<Long> stack) {
        int curRow = 0;
        int curCol = 0;
        int nextRow = 0;
        int nextCol = 0;
        int nextStep = 0;
        while (!stack.isEmpty()) {
            a[curRow][curCol] = stack.pop();

            nextRow = curRow + step[nextStep][0];
            nextCol = curCol + step[nextStep][1];
            if(nextCol >= n || nextRow >= n || nextCol < 0 || nextRow < 0 || a[nextRow][nextCol] > 0) {
                if(curCol >= n) {
                    nextRow = n - 1;
                }
                if(curRow >= n) {
                    nextCol = n - 1;
                }
                if(nextCol < 0) {
                    nextCol = 0;
                }
                if(nextRow < 0) {
                    nextRow = 0;
                }
                nextStep = (nextStep + 1) % 4;
                nextRow = curRow + step[nextStep][0];
                nextCol = curCol + step[nextStep][1];
            }
            curRow = nextRow;
            curCol = nextCol;
        }
    }
}
