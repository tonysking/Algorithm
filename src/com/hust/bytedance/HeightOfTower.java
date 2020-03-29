package com.hust.bytedance;

import java.util.Scanner;

/**
 * 字节跳动2019夏令营笔试题第二轮
 */
public class HeightOfTower {
    private static int maxHeight = 0;
    private static int Height = 0;
    private static int num = 0;

    public static void main(String[] args) {
//        Scanner sc =  new Scanner(System.in);
//        int wight = sc.nextInt();
//        int black = sc.nextInt();

        tower(1,1);
        System.out.println(maxHeight+" "+num);
    }
    public static void tower(int wight, int black) {

        if (wight > 0 || black > 0) {
            if (wight > 0){
                Height++; // 层数增加
                tower(wight-Height, black);
//                maxHeight = Math.max(maxHeight, Height);
                Height--;

            }

            if (black > 0) {
                Height++; // 层数增加
                tower(wight, black-Height);
                Height--;
            }
        } else {
            if (maxHeight == 0) {
                maxHeight = Height -1;
            } else {
                maxHeight = maxHeight;
                if (Height - 1 == maxHeight) {
                    num++;
                }
            }
//            maxHeight = maxHeight == 0 ? Height - 1 : maxHeight;
        }
    }
}
