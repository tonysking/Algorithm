package com.hust.dfs;

/**
 * 岛屿数量
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
 * 一个岛被水包围，并且它是通过【水平方向或垂直方向】上相邻的陆地连接而成的。
 */
public class NumIslands {
    private int[][] path = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};// 右，下，左，上
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        boolean[][] flag = new boolean[grid.length][grid[0].length];
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && flag[i][j] == false)
                    res += dfsIslands(grid, i, j, flag);
            }
        }
        return res;
    }

    private int dfsIslands(char[][] grid, int row, int col, boolean[][] flag) {
        // ---注意边界条件是0 <= x <  .length
        if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == '1' && flag[row][col] == false) {
            flag[row][col] = true;
            for (int i = 0; i < path.length; i++) {
                dfsIslands(grid,row+path[i][0], col+path[i][1],flag);
            }
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        NumIslands n = new NumIslands();
        // 3
        char[][] a = {{'1', '1', '0', '0', '0'},
                    {'1', '1', '0', '0', '0'},
                    {'0', '0', '1', '0', '0'},
                    {'0', '0', '0', '1', '1'}};
        // 1
        char[][] fail = {{'1','1','1','1','0'},
                         {'1','1','0','1','0'},
                         {'1','1','0','0','0'},
                         {'0','0','0','0','0'}};

        int islands = n.numIslands(fail);
        System.out.println(islands);
    }
}
