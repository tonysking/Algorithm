package com.company.dianxin;

public class SumEquals8888 {
    public static void main(String[] args) {
        for (int i = 1; i <= 8888; i++) {
            sum8888(i);
        }
    }

    private static void sum8888(int abcd) {

        int[] nums = new int[4];
        int cur = abcd;
        for (int i = 3; i >= 0; i--) {
            nums[i] = cur % 10;
            cur /= 10;
        }

        int a = nums[0];
        int b = nums[1];
        int c = nums[2];
        int d = nums[3];

        int bcda = b * 1000 + c * 100 + d * 10 + a;
        if (abcd + bcda == 8888) {
            System.out.println(a + " " + b + " " + c + " " + d);
        }
    }
}
