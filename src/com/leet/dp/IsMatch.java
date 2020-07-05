package com.leet.dp;

/**
 * 44. 通配符匹配
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 *
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 *
 */
public class IsMatch {
    //  dp[i][j] 表示字符串 s 的前 i 个字符和模式 p 的前 j 个字符是否能匹配。
    // 注：意的是，由于大部分语言中字符串的下标从 0 开始，因此 si​和 pj​分别对应着 s[i−1] 和 p[j−1]。
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            if (pChars[i - 1] == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (pChars[j - 1] == '*') {
                    // 使用 *（dp[i - 1][j]） 或 * 代表空字符串（dp[i][j - 1]）
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    if (sChars[i - 1] == pChars[j - 1] || pChars[j - 1] == '?') {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }
}
