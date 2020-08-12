package com.sword;

public class Solution {
    public static int LastRemaining_Solution(int n, int m) {
        int[] arr = new int[n];
        int cur = -1;
        int count = 0;
        int num = n;
        while(num > 1) {
            cur = (cur + 1) % n;
            if(arr[cur] == -1) {
                continue;
            }
            count++;
            if(count == m){
                arr[cur]--;
                num--;
                count = 0;
            }
        }

        for(int i = 0; i < n; i++) {
            if(arr[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(LastRemaining_Solution(5,3));
    }
}
