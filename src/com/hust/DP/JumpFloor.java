package com.hust.DP;

public class JumpFloor {
    public int JumpFloor(int target) {
        if (target < 0) {
            return 0;
        }
        if (target == 1 || target == 2) {
            return target;
        }

        int[] method = new int[target+1];
        method[0] = 0;
        method[1] = 1;
        method[2] = 2;
        for (int i = 3; i <= target; i++) {
            method[i] = method[i-1] + method[i-2];
        }
        return method[target];
    }

    // 优化空间复杂度为O(1)
    public int JumpFloor2(int target) {
        if (target < 0) {
            return 0;
        }
        if (target == 1 || target == 2) {
            return target;
        }
        int one = 1;
        int two = 2;
        int res = 0;
        // one two res
        //      one two res
        //          ..........
        for (int i = 3; i <= target; i++) {
            res = one + two;
            one = two;
            two = res;

        }
        return res;
    }
}
