package com.company.string;

import java.util.Scanner;
// 动态规划 ---

/**
 * 美团2020
 * 字符串模式匹配
 * 链接：https://www.nowcoder.com/questionTerminal/2e2510b2e41e4d3b922416e51afc077b
 * https://leetcode-cn.com/problems/wildcard-matching/submissions/
 * 来源：牛客网
 * <p>
 * 给出两个字符串，分别是模式串P和目标串T，判断模式串和目标串是否匹配，匹配输出 1，不匹配输出 0。
 * 模式串中‘？’可以匹配目标串中的任何字符， ’*’可以匹配目标串中的任何长度的串，
 * 例如P=a?b，T=acb，则P 和 T 匹配。
 * <p>
 * "acdcb"
 * "a*c?b"
 * <p>
 * ""
 * "*"
 * <p>
 * "a"
 * "a*"
 * <p>
 * 超时demo:
 * "bbbbbbbabbaabbabbbbaaabbabbabaaabbababbbabbbabaaabaab"
 * "b*b*ab**ba*b**b***bba"
 */
public class StringMatchDP {
  public boolean isValid(char[] s, char[] e) {
    for (int i = 0; i < s.length; i++) {
      if (s[i] == '?' || s[i] == '*') {
        return false;
      }
    }
    return true;
  }

  public boolean isMatch(String str, String exp) {
    if (str == null || exp == null) {
      return false;
    }
    char[] s = str.toCharArray();
    char[] e = exp.toCharArray();
    boolean[][] dp = new boolean[s.length + 1][e.length + 1];

    dp[0][0] = true;
    for (int j = 1; j <= e.length; j++) {
      dp[0][j] = dp[0][j - 1] && e[j - 1] == '*';
    }

    for (int i = 1; i <= s.length; i++) {
      for (int j = 1; j <= e.length; j++) {
        if (e[j - 1] == '*') {
          // 	dp[i-1][j],表示*代表是空字符,例如ab,ab*
          //  dp[i][j-1],表示*代表非空任何字符,例如abcd,ab*
          dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
        } else if (s[i - 1] == e[j - 1] || e[j - 1] == '?') {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = false;
        }
      }
    }
    return dp[s.length][e.length];
  }


  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      String s = sc.nextLine();
      String e = sc.nextLine();
      System.out.println(new StringMatchDP().isMatch(s, e));
    }
  }
}
