package com.leet.array;

import sun.security.provider.Sun;

import java.util.HashMap;
import java.util.Map;

public class SubarraysDivByK {
    // 暴力：超时
    public int subarraysDivByK(int[] A, int K) {
        int num = 0;
        int[] sum = new int[A.length];
        int lastSum;
        for (int i = 0; i < A.length; i++) {
            lastSum = 0;
            for (int j = i; j < A.length; j++) {
                if (i == j) {
                    sum[j] = A[j];
                } else {
                    sum[j] = lastSum + A[j];
                }
                if (sum[j] % K == 0) {
                    num++;
                }
                lastSum = sum[j];
            }
        }
        return num;
    }

    // 前缀和
    public int subarraysDivByK2(int[] A, int K) {
        Map<Integer, Integer> record = new HashMap<>();
        record.put(0, 1);

        int ans = 0;
        int sum = 0;
        for (int a : A) {
            sum += a;
            // 注意 Java 取模: 当被除数为负数时取模结果为负数
            // 如: [-1,2,9] 2
            int mod = (sum % K + K) % K;
            Integer modNum = record.getOrDefault(mod, 0);
            ans += modNum;
            record.put(mod, modNum + 1);
        }

        return ans;
    }
}
