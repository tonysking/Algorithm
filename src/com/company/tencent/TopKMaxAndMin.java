package com.company.tencent;

import java.util.*;

/**
 * 统计字符串出现前K多和前K少
 * 出现次数相同取小
 * abc < abd
 * abc < abcde
 */
/*
4 2
1
2
3
4

1 1
2 1
1 1
2 1
 */
public class TopKMaxAndMin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        String[] a = new String[n];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLine();
            Integer count = map.getOrDefault(a[i], 0);
            map.put(a[i], count + 1);
        }

        // 前K多
        PriorityQueue<String> maxk = new PriorityQueue<String>((s1, s2) -> {

            int count1 = map.get(s1);
            int count2 = map.get(s2);

            if(count1 != count2) {
                // 出现次数大的优先
                return count2 - count1;
            }
            return compareAndGetMin(s1, s2);
        });

        // 前K少
        PriorityQueue<String> mink = new PriorityQueue<String>((s1, s2) -> {

            int count1 = map.get(s1);
            int count2 = map.get(s2);

            if(count1 != count2) {
                // 出现次数小的优先
                return count1 - count2;
            }
            return compareAndGetMin(s1, s2);
        });


        for (int i = 0; i < n; i++) {
            maxk.offer(a[i]);
            mink.offer(a[i]);
        }

        // K多由大到小
        for (int i = 0; i < k; i++) {
            System.out.println(maxk.poll() + " " + map.get(a[i]));
        }

        // K少由小到大
        for (int i = 0; i < k; i++) {
            System.out.println(mink.poll() + " " + map.get(a[i]));
        }

    }

    // 出现次数相同时先取小
    private static int compareAndGetMin(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int i = 0;
        int len = Math.min(c1.length, c2.length);
        while (i < len) {
            if(c1[i] == c2[i]) {
                i++;
            } else {
                return c1[i] - c2[i];
            }
        }
        return c1.length - c2.length;
    }
}
