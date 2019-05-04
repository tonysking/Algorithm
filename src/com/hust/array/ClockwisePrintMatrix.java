package com.hust.array;

/**
 * not online
 * 顺时针打印矩阵元素
 */
public class ClockwisePrintMatrix {

    public void clockwisePrint(int[][] matrix) {
        int sR = 0;
        int sC = 0;
        int eR = matrix.length - 1;
        int eC = matrix[0].length - 1;
        while (sR <= eR && sC <= eC) {
            printEdge(matrix, sR++, sC++, eR--, eC--);
        }

    }

    public void printEdge(int[][] m, int sR, int sC, int eR, int eC) {
        if (sR == eR) { // 只有一行
            while (sC <= eC) {
                System.out.print(m[sR][sC++] + " ");
            }
        } else if (sC == eC) { // 只有一列
            while (sR <= eR) {
                System.out.print(m[sR++][sC] + " ");
            }
        } else {
            int curR = sR;
            int curC = sC;
            while (curC < eC) {
                System.out.print(m[sR][curC++] + " ");
            }
            while (curR < eR) {
                System.out.print(m[curR++][eC] + " ");
            }
            while (curC > sC) {
                System.out.print(m[eR][curC--] + " ");
            }
            while (curR > sR) {
                System.out.print(m[curR--][sC] + " ");
            }
        }
    }

    public static void main(String[] args) {
        ClockwisePrintMatrix c = new ClockwisePrintMatrix();
        int[][] a = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        c.clockwisePrint(a);

    }


}
