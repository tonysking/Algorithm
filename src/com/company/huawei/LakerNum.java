package com.company.huawei;

import java.util.Scanner;

/**
 * 4,5
 * SSHHH
 * SSHHH
 * HHSHH
 * HHHSS
 *
 * 3
 *
 * 80%
 */
public class LakerNum {
    static boolean[][] visited;
    static int [][] step = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int M;
    static int N;
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        String[] split = sc.nextLine().split(",");
        if(split.length == 2) {
            int m = Integer.parseInt(split[0]);
            int n = Integer.parseInt(split[1]);
            N = n;
            visited = new boolean[m][n];
            String[] a = new String[m];
            char[][] chars = new char[m][n];
            for (int i = 0; i < m; i++) {
                a[i] = sc.next();
                for (int j = 0; j < n; j++) {
                    chars[i][j] = a[i].charAt(j);
                }
            }
            int res = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && chars[i][j] == 'S') {
                        res += dfs(chars, i, j);
                    }
                }
            }
            System.out.println(res);
        }

    }

    private static int dfs(char[][] chars, int i, int j) {
        if(i >= 0 && i < chars.length && j >= 0 && j < N
                && !visited[i][j] && chars[i][j] == 'S') {
            visited[i][j] = true;
            for (int k = 0; k < step.length; k++) {
                dfs(chars, i + step[k][0], j + step[k][1]);
            }
            return 1;
        }
        return 0;
    }
}
