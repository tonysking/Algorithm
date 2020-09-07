package com.company.tencent;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*
6
6 5 4 3 2 1
5
6 5 3 2 1

6 5 3 2 1
 */
public class CommonLinked {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            Integer count = map.getOrDefault(num, 1);
            map.put(num, count + 1);
        }
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int num2 = sc.nextInt();
            if(map.containsKey(num2) && map.get(num2) > 0) {
                System.out.print(num2 + " ");
                map.put(num2, map.get(num2) - 1);
            }
        }
    }
}
