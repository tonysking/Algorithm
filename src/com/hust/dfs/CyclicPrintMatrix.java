package com.hust.dfs;

import java.util.ArrayList;

/*
    循环打印矩阵
    按照如下顺序打印出来：
    1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
    即
    1 2 3 4
    8 12 16 15
    14 13 9 5
    6 7 11 10
 */
public class CyclicPrintMatrix {
    private ArrayList<Integer> arrayList = new ArrayList<>();
    private int[][] a = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
    };

    private boolean[][] isPrint;
    private int[][] step = {
            {0,1},  //右
            {1,0},  //下
            {0,-1}, //左
            {-1,0}  //上
    };
    private int count = 0;

    public void setIsPrint(boolean[][] isPrint) {
        this.isPrint = isPrint;
    }
    //打印起始下标sr sc ，打印数组m，先前打印方向preStep
    public void cyclicPrint(int sr, int sc, int[][] m, int preStep){

        //数组长度
        int len = m.length;
        int len2 = m[0].length;
        //初次打印时设置打印标志
        if (isPrint == null){
            isPrint = new boolean[len][len2];
        }
        //若下标未越界且未打印过
        if (sr>-1 && sr < len && sc>-1 && sc < len2 && isPrint[sr][sc]==false) {
            isPrint[sr][sc] = true;
            count++;
            arrayList.add(m[sr][sc]);
            System.out.print(m[sr][sc]+"\t");
            if (count%len == 0){
                System.out.println();
            }
            //若先前打印方向为上，则先按上打印，再按默认顺序寻找
            if (preStep == 3){
                cyclicPrint(sr+step[3][0],sc+step[3][1],m,3);
            }
            for (int i = 0; i < step.length; i++) {
                cyclicPrint(sr+step[i][0],sc+step[i][1],m,i);
            }

        }
    }
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if (matrix.length!=0 && matrix[0].length!=0)
            cyclicPrint(0,0,matrix,0);
        return arrayList;
    }
}
