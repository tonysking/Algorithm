package com.company.didi;

import java.util.Scanner;

/**
 * 4
 * CHIA
 * CANT
 * GRAC
 * BBDE
 */
public class ChinaInArray {
    static String[] a;
    static char[][] chars;
    static int[][] visited;
    static int[][] step = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        a = new String[n];
        chars = new char[n][n];
        visited = new int[n][n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.next();
            for (int j = 0; j < n; j++) {
                chars[i][j] = a[i].charAt(j);
            }
        }

        System.out.println(getDiffChina(chars));

        /*for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(chars[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }*/
    }

    private static int res;
    private static int getDiffChina(char[][] chars) {
        res = 0;
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars.length; j++) {
                if(chars[i][j] == 'C') {
//                    dfs(chars, new StringBuilder(), i, j);
                    dfsPlus(chars, i, j, 0);
                }
            }
        }

        return res;
    }

    private static void dfs(char[][] chars, StringBuilder sb, int row, int col) {


        if(row < 0 || row > chars.length - 1 || col < 0 || col > chars.length - 1) {
            return;
        }

        if(visited[row][col] == 1) {
            return;
        }
        int len = sb.length();
        visited[row][col] = 1;
        if(sb.length() == 0 && chars[row][col] == 'C') {
            sb.append(chars[row][col]);
        }
        if(sb.length() == 1 && chars[row][col] == 'H') {
            sb.append(chars[row][col]);
        }
        if(sb.length() == 2 && chars[row][col] == 'I') {
            sb.append(chars[row][col]);
        }
        if(sb.length() == 3 && chars[row][col] == 'N') {
            sb.append(chars[row][col]);
        }
        if(sb.length() == 4 && chars[row][col] == 'A') {
            sb.append(chars[row][col]);
        }
        for (int i = 0; i < step.length; i++) {
            if(sb.length() == 5) {
                if(sb.toString().equals("CHINA")) {
                    res++;
                }
                return;
            }
            dfs(chars, sb, row + step[i][0], col + step[i][1]);
        }

        sb.setLength(len);
        visited[row][col] = 0;
    }


    // dfs改进
    private static char[] target = new char[]{'C', 'H', 'I', 'N', 'A'};
    private static void dfsPlus(char[][] chars, int row, int col, int index) {
        if(row < 0 || row > chars.length - 1 || col < 0 || col > chars.length - 1) {
            return;
        }

        if(chars[row][col] == target[index]) {
            for (int i = 0; i < step.length; i++) {
                if(index == 4) {
                    res++;
                    return;
                }
                dfsPlus(chars,row + step[i][0], col + step[i][1], index + 1);
            }
        }
    }
}
