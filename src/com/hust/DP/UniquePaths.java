package com.hust.DP;

/**
 * 机器人到达右下角有多少路径
 * 只能向右或向下
 */
public class UniquePaths {
    private int step[][] = {{0,1},
                            {1,0}};
    private int count = 0;
    public int uniquePaths(int m, int n) {

        boolean path[][] = new boolean[m][n];
        move(0,0, m, n , path);
        return count;
    }

    private void move(int sr, int sc, int m, int n, boolean[][] path) {

        if (sr < m && sc < n && path[sr][sc] == false) {
            path[sr][sc] = true;
            if (sr == m-1 && sc == n-1) {
                count++;
            }

            for (int i = 0; i < 2; i++) {
                move(sr+step[i][0], sc+step[i][1], m, n, path);
            }
            path[sr][sc] = false;
        }
    }
}
