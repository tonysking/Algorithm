package com.hust.DP;

/**
 * 变态跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class JumpFloorII {
    public int JumpFloorII(int target) {
        if (target == 1 || target == 2) {
            return target;
        }
        int[] method = new int[target+1];
        method[0] = 0;
        method[1] = 1;
        method[2] = 2;
        for (int i = 3; i <= target; i++) {
            for (int j = 1; j < i; j++) {
                method[i] += method[j];
            }
            method[i]++;
        }
        return method[target];
    }

    /*
        由   f(n)=f(n-1)+f(n-2)+...+f(1)+1
             f(n-1)=    f(n-2)+f(n-3)+...+f(1)+1
        推导 f(n) = 2*f(n-1) = 2^n-1 f(1)
     */
    public int JumpFloorII2(int target) {
        if (target <= 0) {
            return 0;
        }
        return 1 << target-1;
    }

    public static void main(String[] args) {
        JumpFloorII jumpFloorII = new JumpFloorII();
        int methods = jumpFloorII.JumpFloorII(3);
        System.out.println(methods);
    }
}
