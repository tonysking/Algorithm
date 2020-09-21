package com.company.dianxin;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 读取N(1 << N << 1500)
 * 输出按从小到大得到的第N个丑数（只包含因子2， 3， 5）
 * 1为第一个丑数
 */
public class UglyNum {
    private static int[] isUglyNum;
    private static int[] isUglyNum3;
    public static void main(String[] args) {
//        System.out.println(isUglyNum(8));
        isUglyNum = new int[100000000];
        isUglyNum3 = new int[10000000];
        Arrays.fill(isUglyNum3, -1);
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        int res = 1;
        while (n > 0) {
            for (int i = 1; i < Integer.MAX_VALUE; i++) {
                if (isUglyNum3(i)) {
                    n--;
                    if(n == 0) {
                        res = i;
                        break;
                    }
                }
            }
        }
        System.out.println(res);
    }

    private static boolean isUglyNum3(int i) {
        if(i == 1 || i == 2 || i == 3 || i == 5) {
            return true;
        }
        if(i < 10000000 && isUglyNum3[i] != -1) {
            return isUglyNum3[i] == 1;
        }
        if(i % 2 == 0) {
            boolean isUgly2 = isUglyNum(i / 2);
            if (i < 10000000) {
                isUglyNum3[i] = isUgly2 ? 1 : 0;
            }
            return isUgly2;
        }
        if(i % 3 == 0) {
            boolean isUgly3 = isUglyNum(i / 3);
            if (i < 10000000) {
                isUglyNum3[i] = isUgly3 ? 1 : 0;
            }
            return isUgly3;
        }
        if(i % 5 == 0) {
            boolean isUgly5 = isUglyNum(i / 5);
            if (i < 10000000) {
                isUglyNum3[i] = isUgly5 ? 1 : 0;
            }
            return isUgly5;
        }

        return false;
    }

    private static boolean isUglyNum2(int i) {
        if(i == 1 || i == 2 || i == 3 || i == 5) {
            return true;
        }
        int index = i / 32;
        int idx = 1 >>> (i % 32);
        if((isUglyNum[index] & idx) == 1) {
            return true;
        }
        if(i % 2 == 0) {
            boolean isUgly2 = isUglyNum(i / 2);
            if(isUgly2) {
                isUglyNum[index] &= idx;
            }
            return isUgly2;
        }
        if(i % 3 == 0) {
            boolean isUgly3 = isUglyNum(i / 3);
            if(isUgly3) {
                isUglyNum[index] &= idx;
            }
            return isUgly3;
        }
        if(i % 5 == 0) {
            boolean isUgly5 = isUglyNum(i / 5);
            if(isUgly5) {
                isUglyNum[index] &= idx;
            }
            return isUgly5;
        }

        return false;
    }

    private static boolean isUglyNum(int i) {
        if(i == 1 || i == 2 || i == 3 || i == 5) {
            return true;
        }
        if(i % 2 == 0) {
            return isUglyNum(i / 2);
        }
        if(i % 3 == 0) {
            return isUglyNum(i / 3);
        }
        if(i % 5 == 0) {
            return isUglyNum(i / 5);
        }

        return false;
    }
}
