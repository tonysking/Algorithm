package com.leet.dp;

public class MaximalSquare_failed {

  // 记录向右和向下到达过的最大长度
  private static int rightL = 1;
  private static int downL = 1;
  private static int sideL = 1;

  public int maximalSquare(char[][] matrix) {

    rightL = 1;
    downL = 1;
    sideL = 1;

    if (matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }

    boolean[][] isVisit = new boolean[matrix.length][matrix[0].length];

    // 总的连通面积
    int square = 0;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (!isVisit[i][j]) {
          square = Math.max(dfs(i, j, matrix, isVisit, 1, 1, 1, 1), square);
        }
      }
    }

    System.out.println("总面积：" + square);
    System.out.println("向右最大深度：" + rightL);
    System.out.println("向下最大深度：" + downL);
    System.out.println("正方形边长最大深度：" + (sideL));

    // 取向下和向右到达过的长度的较小值作为边
    int side = Math.min(downL, rightL);

    if (side * side > square) {
      System.out.println("---该算法失败T^T---");
      if (sideL < side && sideL == 1) {
        return Math.min((sideL + 1) * (sideL + 1), square);
      }
      return Math.min((sideL) * (sideL), square);
    }

    return side * side;
  }

  private int dfs(int i, int j, char[][] matrix, boolean[][] isVisit,
                  int rightlevel, int downLevel, int leftlevel, int upLevel) {
    if (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length && !isVisit[i][j] && matrix[i][j] == '1') {
      isVisit[i][j] = true;

      int right = dfs(i, j + 1, matrix, isVisit, rightlevel + 1, downLevel, leftlevel, upLevel);
      int down = dfs(i + 1, j, matrix, isVisit, rightlevel, downLevel + 1, leftlevel, upLevel);
      int left = dfs(i, j - 1, matrix, isVisit, rightlevel, downLevel, leftlevel + 1, upLevel);
      int up = dfs(i - 1, j, matrix, isVisit, rightlevel, downLevel, leftlevel, upLevel + 1);

      if (rightlevel == downLevel &&
          downLevel == leftlevel) {
        sideL = Math.max(rightlevel, sideL);
      }
      rightL = Math.max(rightlevel, rightL);
      downL = Math.max(downLevel, downL);
      return right + down + left + up + 1;
    } else {
      return 0;
    }
  }

  public static void main(String[] args) {
    MaximalSquare_failed res = new MaximalSquare_failed();
    char[][] a = {{'1', '1', '0', '0', '0'},
                  {'1', '1', '0', '0', '0'},
                  {'0', '0', '1', '0', '0'},
                  {'0', '0', '0', '1', '1'}};
    char[][] b ={{'1'}};
    char[][] c ={{'1', '1'},
                  {'1', '1'}};

    char[][] e = {{'0', '0', '0', '1'},
                  {'1', '1', '0', '1'},
                  {'1', '1', '1', '1'},
                  {'0', '1', '1', '1'},
                  {'0', '1', '1', '1'}};

    char[][] g ={{'1', '1'}};

    // 4
    char[][] failed = {{'1', '0', '1', '0', '0'},
                       {'1', '0', '1', '1', '1'},
                       {'1', '1', '1', '1', '1'},
                       {'1', '0', '0', '1', '0'}};

    // 4
    char[][] failed2 = {{'1', '1', '0', '1'},
                        {'1', '1', '0', '1'},
                        {'1', '1', '1', '1'}};


//    System.out.println("------最大正方形面积： " + res.maximalSquare(a));
    System.out.println("------最大正方形面积： " + res.maximalSquare(failed2));
  }
}
