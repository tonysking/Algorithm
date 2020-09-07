package com.company.huawei;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 6
 * 2 2
 * 2 1
 * 3 2
 * 5 2
 * 3 1
 * 7 2
 *
 * 3 4 6
 * 2
 * 15
 *
 * 100%
 */
public class MaxSuger {
    private static final int RED = 1;
    private static final int BLUE = 2;
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][2];
        int redIndex = 0;
        int blueIndex = 0;
        int[] red = new int[n];
        int[] blue = new int[n];
        Map<Integer, Integer> mapRed = new HashMap<>();
        Map<Integer, Integer> mapBlue = new HashMap<>();
        for (int i = 0; i < n; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
            if(a[i][1] == RED) {
                red[redIndex++] = a[i][0];
                mapRed.put(a[i][0], i);
            } else {
                blue[blueIndex++] = a[i][0];
                mapBlue.put(a[i][0], i);
            }
        }

        Arrays.sort(red);
        Arrays.sort(blue);

        int redMax = 0;
        if(redIndex >= 3) {
            for (int i = red.length - 1; i >= red.length - 3; i--) {
                redMax += red[i];
            }
        }


        int blueMax = 0;
        if(blueIndex >= 3) {
            for (int i = blue.length - 1; i >= blue.length - 3; i--) {
                blueMax += blue[i];
            }
        }

        if(redMax == 0 && blueMax == 0) {
            System.out.println("null");
        } else {
            if (redMax > blueMax) {
                for (int i = red.length - 3; i < red.length; i++) {
                    System.out.print(mapRed.get(red[i]) + 1 + " ");
                }
                System.out.println();
                System.out.println(RED);
                System.out.println(redMax);
            } else {
                for (int i = blue.length - 3; i < blue.length; i++) {
                    System.out.print(mapBlue.get(blue[i]) + 1 + " ");
                }
                System.out.println();
                System.out.println(BLUE);
                System.out.println(blueMax);
            }
        }




    }
}
