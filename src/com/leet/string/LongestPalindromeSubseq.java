package com.leet.string;

public class LongestPalindromeSubseq {
  public int longestPalindromeSubseq(String s) {
    char[] chars = s.toCharArray();
    int[][] longestSub = new int[chars.length][chars.length];
    
    for (int i = chars.length - 1; i >= 0; i--) {
      // longestSub[i][i] = 1; // 或直接初始化， j = i + 1
      for (int j = i; j < chars.length; j++) {
        if (i == j) {
          longestSub[i][j] = 1;
          continue; // 防止==情况下面的语句越界
        }
        if (chars[i] == chars[j]) {
          longestSub[i][j] = longestSub[i + 1][j - 1] + 2;
        } else {
          longestSub[i][j] = Math.max(longestSub[i + 1][j], longestSub[i][j - 1]);
        }
      }
    }
    return longestSub[0][chars.length - 1];
  }

  public static void main(String[] args) {
    LongestPalindrome res = new LongestPalindrome();
    String s = res.longestPalindrome("bbbab");
    System.out.println(s);
  }
}
