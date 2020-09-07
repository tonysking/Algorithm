package com.company.tencent;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
/*
50 5
2 1 2
5 10 11 12 13 14
2 0 1
2 49 2
4 6 7 8 2

7
 */
public class NoticePeopleNum {

    private static int res;
    private static boolean[] hasFind;
    private static boolean[] hasFindIndex;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<HashSet<Integer>> sets = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            HashSet<Integer> set = new HashSet<>();
            for (int j = 0; j < x; j++) {
                set.add(sc.nextInt());
            }
            sets.add(set);
        }
        res = 1;
        hasFind = new boolean[m];
        hasFindIndex = new boolean[n + 1];
        hasFindIndex[0] = true;
        getNoticePeopleNum(sets, 0);
        System.out.println(res);
    }


    private static void getNoticePeopleNum(List<HashSet<Integer>> sets, int index) {
        for (int i = 0; i < sets.size(); i++) {
            if (!hasFind[i]) {
                HashSet<Integer> set = sets.get(i);
                if (set.contains(index)) {
                    hasFind[i] = true;
                    for(Integer ind : set) {
                        if (!hasFindIndex[ind]) {
                            hasFindIndex[ind] = true;
                            res ++;
                            getNoticePeopleNum(sets, ind);
                        }
                    }
                }
            }
        }
    }
}
